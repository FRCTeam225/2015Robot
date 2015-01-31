package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class TiltArm extends CommandBase {

	boolean tilt;
	
	public TiltArm(boolean tilt) {
		this.tilt = tilt;
	}
	@Override
	protected void initialize() {
		arm.toggleArm(tilt);
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
