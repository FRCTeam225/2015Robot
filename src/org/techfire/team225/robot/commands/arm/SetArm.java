package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class SetArm extends CommandBase {

	int target;
	
	public SetArm() {
		this.target = 0;
	}
	
	public SetArm(int target) {
		this.target = target;
	}
	
	@Override
	protected void initialize() {
		arm.setTarget(target);
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
