package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class ChokeholdControl extends CommandBase {

	double chokeholdSpeed;
	
	public ChokeholdControl() {
		requires(chokehold);
	}
		
	@Override
	protected void initialize() {
		chokeholdSpeed = 0;
	}

	@Override
	protected void execute() {
		if (OI.driver.getRawButton(6)) {
			chokeholdSpeed = 1.0;
			chokehold.setRetainer(false);
		} else if (OI.driver.getRawButton(5)) {
			chokehold.setRetainer(true);
		} else {
			chokeholdSpeed = 0;
			chokehold.setRetainer(true);
		}
		
		chokehold.setLeftMotor(chokeholdSpeed);
		chokehold.setRightMotor(chokeholdSpeed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
	}
}
