package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

import edu.wpi.first.wpilibj.Timer;

public class StrafeUntilSee extends CommandBase {

	boolean invertDirection = false;
	public SimplePID pidTheta = new SimplePID(0.1, 0, 0);
	
	int stage = 0;
	boolean done = false;
	int loopsStable = 0;
	Timer timeout = new Timer();
	
	
	public StrafeUntilSee() {
		requires(mecanumDrivetrain);
		pidTheta.setTarget(0);
	}
	
	public StrafeUntilSee(boolean invertDirection)
	{
		this();
		this.invertDirection = invertDirection;
	}
	
	@Override
	protected void initialize() {
		done = false;
		stage = 0;
	}
	
	@Override
	protected void execute() {
		switch ( stage )
		{
			case 0:
				double speed = (invertDirection? 1.0:-1.0);
				if ( mecanumDrivetrain.getLeftEye() && !invertDirection )
					speed = -1.0;
				else if ( mecanumDrivetrain.getRightEye() && invertDirection)
					speed = 1.0;
				mecanumDrivetrain.setMotorSpeeds(speed, 0, -pidTheta.calculate(mecanumDrivetrain.getGyro()), false);
				if ( mecanumDrivetrain.getLeftEye() && mecanumDrivetrain.getRightEye() )
				{
					timeout.reset();
					timeout.start();
					stage++;
				}
				break;
			case 1: 
				mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
				if ( mecanumDrivetrain.getLeftEye() && mecanumDrivetrain.getRightEye() )
					loopsStable++;
				else
					loopsStable = 0;
				if ( loopsStable > 100 )
					done = true;
				
				if ( timeout.get() > 0.4 )
					stage++;
				break;
			case 2:
				speed = (invertDirection? -0.9:0.9);
				if ( mecanumDrivetrain.getLeftEye() && !invertDirection )
					speed = 0.9;
				else if ( mecanumDrivetrain.getRightEye() && invertDirection)
					speed = -0.9;
				mecanumDrivetrain.setMotorSpeeds(speed, 0, -pidTheta.calculate(mecanumDrivetrain.getGyro()), false);
				if ( mecanumDrivetrain.getLeftEye() && mecanumDrivetrain.getRightEye() )
				{
					done = true;
					stage++;
				}
				break;
		}

	}

	@Override
	protected boolean isFinished() {
		return done;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
	}

}
