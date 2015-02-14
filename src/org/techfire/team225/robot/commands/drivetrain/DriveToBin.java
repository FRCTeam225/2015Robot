package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class DriveToBin extends CommandBase {

	public DriveToBin()
	{
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		mecanumDrivetrain.setMotorSpeeds(0, -0.4, 0, false);
		
	}

	@Override
	protected boolean isFinished() {
		return mecanumDrivetrain.atBin();
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
		
	}

}
