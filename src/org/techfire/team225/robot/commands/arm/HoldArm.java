package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class HoldArm extends CommandBase {

	public HoldArm() {
		requires(arm);
	}
	@Override
	protected void initialize() {
		arm.enablePID();
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

}
