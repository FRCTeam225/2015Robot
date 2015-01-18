package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class JoystickDrive extends CommandBase {

	public JoystickDrive() {
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		double forwardThrottle = OI.getDriverForwardThrottle();
		double strafeThrottle = OI.getDriverStrafeThrottle();
		double turn = OI.getDriverTurn();
		
		drivetrain.setMotorSpeeds(forwardThrottle, strafeThrottle, turn);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0);
	}
	
}
