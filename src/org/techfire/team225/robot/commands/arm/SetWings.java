package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class SetWings extends CommandBase {

	boolean set = false;
	
	public SetWings(boolean set) {
		this.set = set;
	}
	
	@Override
	protected void initialize() {
		arm.setWings(set);
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
