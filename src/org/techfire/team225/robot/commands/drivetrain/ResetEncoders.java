package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class ResetEncoders extends CommandBase {

	@Override
	protected void initialize() {
		drivetrain.resetForwardEncoders();
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}
}
