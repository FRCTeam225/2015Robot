package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class MecanumDrive extends CommandBase {

	public MecanumDrive() {
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();
		
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
