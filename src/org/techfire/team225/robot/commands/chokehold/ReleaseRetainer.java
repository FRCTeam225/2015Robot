package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;

public class ReleaseRetainer extends CommandBase {

	public ReleaseRetainer() {
		requires(chokehold);
	}
	
	@Override
	protected void initialize() {
		chokehold.setRetainer(false);
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
