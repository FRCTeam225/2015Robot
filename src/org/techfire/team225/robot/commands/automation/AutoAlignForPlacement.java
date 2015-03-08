package org.techfire.team225.robot.commands.automation;

import org.techfire.team225.robot.CommandBase;

public class AutoAlignForPlacement extends CommandBase {

	
	public AutoAlignForPlacement()
	{
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		drivetrain.setMotorSpeeds(0, 0.3, 0, 1, false);
	}

	@Override
	protected boolean isFinished() {
		return !drivetrain.getLeftEye();
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
	}

}
