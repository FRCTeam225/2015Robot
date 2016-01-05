package org.techfire.team225.robot.commands.drivetrain;

public class ProfiledTwoAngleDrive extends ProfiledDriveDistance {

	double theta2;
	double triggerPercent;
	
	public ProfiledTwoAngleDrive(double target, double vcruise,
			double maxAccel, double theta, double theta2, double triggerPercent) {
		super(target, vcruise, maxAccel, theta);
		this.theta2 = theta2;
		this.triggerPercent = triggerPercent;
	}
	
	public PathPoint calcAt(double t)
	{
		PathPoint p = super.calcAt(t);
		double percent = t/((tToCruise*2.0)+tCruising);
		if ( percent >= triggerPercent )
			p.theta = theta2;
		return p;
	}
}
