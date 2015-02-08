package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class MecanumDrive extends CommandBase {

	public MecanumDrive() {
		requires(mecanumDrivetrain);
	}
	
	double targetAngle = 0;
	
	@Override
	protected void initialize() {
		targetAngle = mecanumDrivetrain.getGyro();
	}

	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();
		// gyro correction, holds the robot at the angle the driver wants it to be at
		if ( Math.abs(rotationThrottle) > 0.1 )
		{
			targetAngle = mecanumDrivetrain.getGyro();
		}
		else
		{
			rotationThrottle = (mecanumDrivetrain.getGyro()-targetAngle)*-0.01;
		}
		mecanumDrivetrain.setMotorSpeeds(-xThrottle, yThrottle, -rotationThrottle, false);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
	}
}
