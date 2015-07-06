package org.techfire.team225.robot.commands.toteholder;

import org.techfire.team225.robot.CommandBase;

public class SetToteHolder extends CommandBase {

	boolean state;
	
	public SetToteHolder(boolean state) {
		this.state = state;
	}
	
	@Override
	protected void initialize() {
		toteHolder.setHolder(state);
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
