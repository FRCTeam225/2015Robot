package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class TurnTo extends CommandBase {

	double theta;
	public TurnTo(double theta)
	{
		this.theta = theta;
	}
	
	@Override
	protected void initialize() {
		mecanumDrivetrain.pidTheta.setTarget(theta);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(mecanumDrivetrain.pidTheta.getError()) < 1;
	}

	@Override
	protected void end() {

	}

}
