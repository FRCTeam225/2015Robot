package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class DriveToBin extends CommandBase {

	public DriveToBin()
	{
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		drivetrain.setMotorSpeeds(0, -0.4, 0, 1, false);
		
	}

	@Override
	protected boolean isFinished() {
		return drivetrain.atBin();
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 1, false);
		
	}

}
