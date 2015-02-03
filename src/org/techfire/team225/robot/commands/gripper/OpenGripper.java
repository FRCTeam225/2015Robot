package org.techfire.team225.robot.commands.gripper;

import org.techfire.team225.robot.CommandBase;

public class OpenGripper extends CommandBase {
	
	@Override
	protected void initialize() {
		gripper.open();
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
