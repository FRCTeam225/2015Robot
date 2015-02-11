package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class DriveYDistance extends CommandBase {

	double dist;
	public DriveYDistance(double dist)
	{
		this.dist = dist;
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		mecanumDrivetrain.pidY.setTarget(dist);
		
	}

	@Override
	protected void execute() {
		// Drivetrain PID loop runs at this time
		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(mecanumDrivetrain.pidY.getError()) < 10;
	}

	@Override
	protected void end() {

	}

}
