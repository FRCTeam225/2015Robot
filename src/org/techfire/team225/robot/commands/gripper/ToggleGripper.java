package org.techfire.team225.robot.commands.gripper;

import org.techfire.team225.robot.CommandBase;

public class ToggleGripper extends CommandBase {
	
	int v;
	
	public ToggleGripper(int v) {
		this.v = v;
	}
	
	@Override
	protected void initialize() {
		if (v == 1) {
			gripper.toggleGripper();
		} else {
			gripper.singleToggle();
		}
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
