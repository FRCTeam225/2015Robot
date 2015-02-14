package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class PIDArmControl extends CommandBase {
	
	public PIDArmControl() {
		requires(arm);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		arm.updatePID();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

}
