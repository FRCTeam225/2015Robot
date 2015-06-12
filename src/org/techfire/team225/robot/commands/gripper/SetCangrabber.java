package org.techfire.team225.robot.commands.gripper;

import org.techfire.team225.robot.CommandBase;

public class SetCangrabber extends CommandBase {

	boolean set = false;
	
	public SetCangrabber(boolean set) {
		this.set = set;
	}
	
	@Override
	protected void initialize() {
		gripper.SetCangrab(set);;
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
