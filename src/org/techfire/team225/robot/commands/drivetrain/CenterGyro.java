package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class CenterGyro extends CommandBase {

	public CenterGyro() {
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		mecanumDrivetrain.gyro.reset();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {}

}
