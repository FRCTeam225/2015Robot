package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.ConstantsProvider;
import org.techfire.team225.robot.OI;

public class ArmControl extends CommandBase {
	
	public ArmControl() {
		requires(arm);
	}
	int top;
	int floor;
	
	@Override
	protected void initialize() {
		top = ConstantsProvider.get("TOP_POSITION");
		floor = ConstantsProvider.get("FLOOR_POSITION");
	}

	@Override
	protected void execute() {
		
		double throttle = OI.getArmThrottle();
		if (Math.abs(throttle) > 0.04 ) {
			arm.setMotorSpeed(throttle);
		}
		else {
			arm.setMotorSpeed(0);
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
