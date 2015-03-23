package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class SetArmTilt extends CommandBase {

	boolean tilt = false;
	
	public SetArmTilt(boolean tilt) {
		this.tilt = tilt;
	}
	
	@Override
	protected void initialize() {
		//arm.setArmTilt(tilt);
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
