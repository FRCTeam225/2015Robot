package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class ArmControl extends CommandBase {
	
	public ArmControl() {
		requires(arm);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		double throttle = OI.driver.getRawAxis(2)- OI.driver.getRawAxis(3);
		System.out.println("throttle is "+throttle);
		arm.setMotorSpeed(throttle);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

}
