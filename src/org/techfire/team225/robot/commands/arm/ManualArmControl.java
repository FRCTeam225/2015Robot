package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class ManualArmControl extends CommandBase {

	boolean up;
	public ManualArmControl(boolean up) {
		requires(arm);
		this.up = up;
	}
	
	@Override
	protected void initialize() {
		arm.disablePID();
	}

	@Override
	protected void execute() {
		double throttle;
		if (up) {
			throttle = 0.75;
		} else {
			throttle = -0.75;
		}
		arm.setMotorSpeed(throttle);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		arm.setMotorSpeed(0);
		arm.setTarget(arm.getPosition());
		arm.enablePID();
	}

}
