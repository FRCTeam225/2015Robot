package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

import edu.wpi.first.wpilibj.Timer;


public class ProfiledTurn extends CommandBase
{

    class PathPoint
    {
        double t = 0;
        double pos = 0;
        double vel = 0;
        double acc = 0;
        double theta = 0;
        public String toString()
        {
            return t+","+pos+","+vel+","+acc;
        }
    }

    double target, vcruise, maxAccel;
    double startT = 0;
    double tToCruise, dRamping, dCruising, tCruising;
    double errorSum = 0;
    double lastT = 0;
    boolean reverse = false;
    
    int stable = 0;
    
    public ProfiledTurn(double target, double vcruise, double maxAccel)
    {
    	requires(drivetrain);
    	if ( target < 0 )
    	{
    		reverse = true;
    		this.target = -target;
    	}
    	else
    		this.target = target;
        this.vcruise = vcruise;
        this.maxAccel = maxAccel;
    }

    public void initialize()
    {
        tToCruise = vcruise/maxAccel;
        dRamping = (0.5)*maxAccel*Math.pow(tToCruise,2);
        dCruising = target-(dRamping*2);

        if (dCruising < 0) {
            // I am overshooting target by accelerating to vcruise
            tToCruise = Math.sqrt(2 * maxAccel * (target / 2)) / maxAccel;
            if (tToCruise < 0)
                tToCruise = -tToCruise;
            dCruising = 0;
            dRamping = target/2;
            vcruise = maxAccel * tToCruise; // how fast do we get to?
        }
        tCruising = dCruising / vcruise;
        startT = Timer.getFPGATimestamp();
        lastT = 0;
        errorSum = 0;
        System.out.println("ProfiledTurn to "+target+": Starting");
    }

    public void execute()
    {
    	double t = Timer.getFPGATimestamp()-startT;
    	double dT = t-lastT;
    	lastT = t;
    	PathPoint p = calcAt(t);
        double velconst = 103;
        double pConst = 0.054;
        double pow;
        double error;
        
        if ( reverse )
        {
        	error = (-p.pos)-drivetrain.getGyro();
        	pow = ((error*pConst) - (p.vel/velconst));
        }
        else
        {
        	error = (p.pos-drivetrain.getGyro());
        	pow = (error*pConst) +  (p.vel/velconst);
        }
        errorSum += error*dT;
        pow += (errorSum*0.015);
        System.out.println("ProfiledTurn to "+target+": err("+error+") tar("+p.pos+") at "+drivetrain.getGyro()+" sum("+errorSum+") dt("+dT+","+startT+","+lastT+")");
        drivetrain.setMotorSpeeds(0, 0, -pow, 1, false);
    }

    public PathPoint calcAt(double t)
    {
        if ( t > ((tToCruise*2)+tCruising) )
        {
        	t = ((tToCruise*2)+tCruising);
        }
        PathPoint point = new PathPoint();


        if ( t <= tToCruise )
        {
            point.t = t;
            point.vel = maxAccel * t;
            point.pos = (0.5) * maxAccel * Math.pow(t, 2);

            point.acc = maxAccel;
        }
        else if ( t < (tToCruise+tCruising) )
        {
            double i = t-tToCruise;
            point.t = t;
            point.pos = dRamping + (vcruise * i);
            point.vel = vcruise;
            point.acc = 0;
        }
        else if ( t <= ((tToCruise*2)+tCruising) )
        {
            double i = t-tToCruise-tCruising;
            point.t = t;
            point.pos = (dCruising + dRamping) + (vcruise * i) + (0.5) * -maxAccel * Math.pow(i, 2);
            point.vel = vcruise + ((-maxAccel) * i);
            point.acc = -maxAccel;
        }
        if ( t == ((tToCruise*2)+tCruising) )
        {
        	point.acc = 0;
        	point.vel = 0;
        }
        return point;

    }
    
    public String toString()
    {
        return "Path: T"+((tToCruise*2)+tCruising);
    }

	@Override
	protected boolean isFinished() {
		if ( Math.abs(drivetrain.getGyro()-(reverse?-target:target)) < 1.5 )
			stable++;
		else stable = 0;
		
		return stable > 4;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
		System.out.println("ProfiledTurn to "+target+": End "+drivetrain.getGyro());
		
	}
}