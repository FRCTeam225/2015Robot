package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class DriveXDistance extends CommandBase {

	double dist;
	public DriveXDistance(double dist)
	{
		this.dist = dist;
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		mecanumDrivetrain.pidX.setTarget(dist);
		
	}

	@Override
	protected void execute() {
		// Drivetrain PID loop runs at this time
		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(mecanumDrivetrain.pidX.getError()) < 10;
	}

	@Override
	protected void end() {

	}

}
