package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class CenterGyro extends CommandBase {

	public CenterGyro() {
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		mecanumDrivetrain.gyro.reset();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

}
