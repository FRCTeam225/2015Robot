package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class SetArm extends CommandBase {

	int target;
	
	public SetArm(int target) {
		this.target = target;
	}
	
	@Override
	protected void initialize() {
		System.out.println("Set arm to "+target);
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
