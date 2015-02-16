package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

import edu.wpi.first.wpilibj.Timer;

public class SlowStrafeUntilSee extends CommandBase {

	boolean invertDirection = false;
	public SimplePID pidTheta = new SimplePID(0.1, 0, 0);
	
	int stage = 0;
	boolean done = false;
	int loopsStable = 0;
	Timer timeout = new Timer();
	
	
	public SlowStrafeUntilSee() {
		requires(drivetrain);
		pidTheta.setTarget(0);
	}
	
	public SlowStrafeUntilSee(boolean invertDirection)
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
				double speed = (invertDirection? 1.5:-1.5);
				if ( drivetrain.getLeftEye() && !invertDirection )
					speed = -1.5;
				else if ( drivetrain.getRightEye() && invertDirection)
					speed = 1.5;
				drivetrain.setMotorSpeeds(speed, 0, -pidTheta.calculate(drivetrain.getGyro()), 1, false);
				if ( drivetrain.getLeftEye() && drivetrain.getRightEye() )
				{
					timeout.reset();
					timeout.start();
					stage++;
				}
				break;
			case 1: 
				drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
				if ( drivetrain.getLeftEye() && drivetrain.getRightEye() )
					loopsStable++;
				else
					loopsStable = 0;
				if ( loopsStable > 100 )
					done = true;
				
				if ( timeout.get() > 0.4 )
					stage++;
				break;
			case 2:
				speed = (invertDirection? -0.85:0.85);
				if ( drivetrain.getLeftEye() && !invertDirection )
					speed = 0.85;
				else if ( drivetrain.getRightEye() && invertDirection)
					speed = -0.85;
				drivetrain.setMotorSpeeds(speed, 0, -pidTheta.calculate(drivetrain.getGyro()), 1, false);
				if ( drivetrain.getLeftEye() && drivetrain.getRightEye() )
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
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
	}

}
