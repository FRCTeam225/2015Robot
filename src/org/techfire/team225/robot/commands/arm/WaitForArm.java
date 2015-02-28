package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class WaitForArm extends CommandBase {

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		
		return Math.abs(arm.getError()) < 30;
	}

	@Override
	protected void end() {		
	}

}
