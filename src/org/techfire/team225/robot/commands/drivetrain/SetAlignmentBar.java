package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class SetAlignmentBar extends CommandBase {

	boolean set = false;
	
	public SetAlignmentBar(boolean set) {
		this.set = set;
	}
	
	@Override
	protected void initialize() {
		drivetrain.setAlignmentBar(set);
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
