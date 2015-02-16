package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class SlowDriveYDistance extends CommandBase {

	double dist;
	public SimplePID pidY = new SimplePID(0.04, 0.001, 0);
	public SimplePID pidTheta = new SimplePID(0.1, 0, 0);
	
	public SlowDriveYDistance(double dist, double theta)
	{
		pidY.setTarget(dist);
		pidTheta.setTarget(theta);
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		mecanumDrivetrain.setMotorSpeeds(0, -pidY.calculate(mecanumDrivetrain.getAverageForwardEncoders()) * 0.25, -pidTheta.calculate(mecanumDrivetrain.getGyro()), 1, false);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(pidY.getError()) < 10;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
