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
		targetAngle = mecanumDrivetrain.gyro.getAngle();
	}

	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();
		/*if ( Math.abs(rotationThrottle) > 0.1 )
		{
			targetAngle = mecanumDrivetrain.gyro.getAngle();
		}
		else
		{
			rotationThrottle = (mecanumDrivetrain.gyro.getAngle()-targetAngle)*-0.01;
		}*/
		mecanumDrivetrain.setMotorSpeeds(-xThrottle, yThrottle, -rotationThrottle, true);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, true);
	}
}
