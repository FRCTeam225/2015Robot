package org.techfire.team225.robot.commands.arm;

public class Unhook extends SetArm {
	
	@Override
	protected void initialize() {
		target = arm.getPosition() - 120;
		super.initialize();
	}
}
