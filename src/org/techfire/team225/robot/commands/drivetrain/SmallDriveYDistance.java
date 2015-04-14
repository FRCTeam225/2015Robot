package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

import edu.wpi.first.wpilibj.Timer;

public class SmallDriveYDistance extends DriveYDistance {

	public SmallDriveYDistance(double dist, double theta, double maxSpeed)
	{
		super(dist, theta, maxSpeed);
	}
	
	
	public SmallDriveYDistance(double dist, double theta)
	{
		super(dist, theta);
	}
	
	public SmallDriveYDistance(double dist) {
		super(dist);
	}

	@Override
	protected boolean isFinished() {
		return (Math.abs(pidY.getError()) < 30)|| isTimedOut();
	}
}
