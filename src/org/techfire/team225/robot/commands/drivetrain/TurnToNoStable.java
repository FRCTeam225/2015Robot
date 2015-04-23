package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class TurnToNoStable extends CommandBase {

	public SimplePID pidTheta = new SimplePID(0.03, 0.00015, 0);
	int loopsStable = 0;
	public TurnToNoStable(double theta)
	{
		this(theta, 1.0);
	}
	
	public TurnToNoStable(double theta, double maxSpeed)
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
		System.out.println("Target is: " + pidTheta.getTarget());
        System.out.println("Location is: " + CommandBase.drivetrain.getGyro());
        System.out.println("Error is: " + pidTheta.getError());
	}

	@Override
	protected boolean isFinished() {
		return pidTheta.getError() < 5 || isTimedOut();
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
