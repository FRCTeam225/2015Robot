package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class ManualArmControl extends CommandBase {

	public ManualArmControl() {
		requires(arm);
	}
	
	@Override
	protected void initialize() {
		arm.disablePID();
	}

	@Override
	protected void execute() {
		double throttle = OI.getArmThrottle();
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
