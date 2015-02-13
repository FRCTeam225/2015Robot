package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class HoldArm extends CommandBase {

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		double throttle = OI.driver.getRawAxis(2)-OI.driver.getRawAxis(3);
		if (throttle != 0) {
			new ManualArmControl(throttle);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {		
	}

}
