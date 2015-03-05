package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.SimplePID;

import edu.wpi.first.wpilibj.Timer;

public class DriveYDistance extends CommandBase {

	double dist;
	public SimplePID pidY = new SimplePID(0.0012,0.0015, 0);
	public SimplePID pidTheta = new SimplePID(0.05, 0, 0);
	Timer t = new Timer();
	boolean needsAngle = false;
	
	public DriveYDistance(double dist, double theta, double maxSpeed)
	{
		pidY.setTarget(dist);
		pidTheta.setTarget(theta);
		pidY.setOutputConstraints(maxSpeed, -maxSpeed);
		requires(drivetrain);
	}
	
	public DriveYDistance(double dist, double theta)
	{
		this(dist, theta, 1);
	}
	
	public DriveYDistance(double dist) {
		this(dist, 0, 1);
		needsAngle = true;
	}
	
	@Override
	protected void initialize() {
		if (needsAngle) {
			pidTheta.setTarget(drivetrain.getGyro());
		}
		t.reset();
		t.start();
	}

	@Override
	protected void execute() {
		double pidSpeed =  -pidY.calculate(drivetrain.getAverageForwardEncoders());
		/*if ( t.get() > 1 )
			t.stop();
		else
			pidSpeed *= t.get();*/
		
		drivetrain.setMotorSpeeds(0, pidSpeed, -pidTheta.calculate(drivetrain.getGyro()), 1, false);
		System.out.println("Target is: " + pidY.getTarget());
        System.out.println("Location is: " + CommandBase.drivetrain.getAverageForwardEncoders());
        System.out.println("Error is: " + pidY.getError());
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(pidY.getError()) < 50;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);

	}

}
