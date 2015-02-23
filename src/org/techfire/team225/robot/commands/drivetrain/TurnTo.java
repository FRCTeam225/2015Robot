package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class TurnTo extends CommandBase {

	public SimplePID pidTheta = new SimplePID(0.011, 0, 0);
	
	public TurnTo(double theta)
	{
		pidTheta.setTarget(theta);
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		drivetrain.setMotorSpeeds(0, 0, -pidTheta.calculate(drivetrain.getGyro()), 1, false);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(pidTheta.getError()) < 1;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
