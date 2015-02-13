package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;

public class ManualArmControl extends CommandBase {

	double throttle;
	
	public ManualArmControl(double throttle) {
		requires(arm);
		this.throttle = throttle;
	}
	
	@Override
	protected void initialize() {
		arm.disablePID();
	}

	@Override
	protected void execute() {
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
