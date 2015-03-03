package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;

public class SetChokehold extends CommandBase {

	boolean set;
	
	public SetChokehold(boolean set) {
		this.set = set;
	}
	
	@Override
	protected void initialize() {
		chokehold.set(set);
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
