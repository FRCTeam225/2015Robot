package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

public class DriveXDistance extends CommandBase {

	public SimplePID pidX = new SimplePID(0.08, 0.01, 0);
	public SimplePID pidTheta = new SimplePID(0.1, 0, 0);
	
	public DriveXDistance(double dist, double theta)
	{
		pidX.setTarget(dist);
		pidTheta.setTarget(theta);
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {

		
	}

	@Override
	protected void execute() {
		mecanumDrivetrain.setMotorSpeeds(-pidX.calculate(mecanumDrivetrain.getFollowEncoder()), 0, -pidTheta.calculate(mecanumDrivetrain.getGyro()), 1, false);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(pidX.getError()) < 10;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, 0, false);
	}

}
