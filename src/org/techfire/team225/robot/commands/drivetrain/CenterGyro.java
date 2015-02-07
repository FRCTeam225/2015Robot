package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class CenterGyro extends CommandBase {

	@Override
	protected void initialize() {
		mecanumDrivetrain.resetAngle();
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
