package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class OverridePot extends CommandBase {

	static boolean override = false;
	
	@Override
	protected void initialize() {
		override = !override;
		arm.potOverride = override;
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
