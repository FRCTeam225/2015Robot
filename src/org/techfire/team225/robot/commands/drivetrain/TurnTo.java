package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class TurnTo extends CommandBase {

	public SimplePID pidTheta = new SimplePID(0.1, 0, 0);
	
	public TurnTo(double theta)
	{
		pidTheta.setTarget(theta);
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, -pidTheta.calculate(mecanumDrivetrain.getGyro()), 1, false);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(pidTheta.getError()) < 1;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
