package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class ChokeholdControl extends CommandBase {

	public ChokeholdControl() {
		requires(chokehold);
	}
		
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		chokehold.setLeftMotor(OI.getChokeholdThrottle());
		chokehold.setRightMotor(OI.getChokeholdThrottle());
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
