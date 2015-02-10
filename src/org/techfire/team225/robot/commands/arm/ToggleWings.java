package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class ToggleWings extends CommandBase {

	static boolean toggle = false;
	
	@Override
	protected void initialize() {
		toggle = !toggle;
		arm.toggleWings(toggle);
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
