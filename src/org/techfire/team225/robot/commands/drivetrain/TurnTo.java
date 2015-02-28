package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class TurnTo extends CommandBase {

	public SimplePID pidTheta = new SimplePID(0.025, 0.0001, 0);
	
	public TurnTo(double theta)
	{
		this(theta, 1.0);
	}
	
	public TurnTo(double theta, double maxSpeed)
	{
		pidTheta.setTarget(theta);
		pidTheta.setOutputConstraints(maxSpeed, -maxSpeed);
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
		return Math.abs(pidTheta.getError()) < 5;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
