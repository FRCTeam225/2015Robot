package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;
import org.techfire.team225.robot.SimplePID;

public class StableMode extends CommandBase {
	
	public SimplePID pidY = new SimplePID(0.0012, 0.0015, 0); // I = 0.0015
	public SimplePID pidTheta = new SimplePID(0.05, 0, 0);
	
	public StableMode() {
		
		pidY.setOutputConstraints(0.5, -0.5);
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		int absolutePosition = arm.getPosition() - 1560;
		drivetrain.resetForwardEncoders((int) (Math.sin(absolutePosition/783.439) * 729.0));
		System.out.println("Stable mode enabled");
		pidTheta.setTarget(drivetrain.getGyro());
	}

	@Override
	protected void execute() {
		int absolutePosition = arm.getPosition() - 1560;
		pidY.setTarget(Math.sin(absolutePosition/783.439) * 729.0); // y = 729sin(x/783.439)
		double pidSpeed =  -pidY.calculate(drivetrain.getAverageForwardEncoders());
		drivetrain.setMotorSpeeds(0, pidSpeed, -pidTheta.calculate(drivetrain.getGyro()), 1, false);
		System.out.println("Target is: " + pidY.getTarget());
        System.out.println("Location is: " + CommandBase.drivetrain.getAverageForwardEncoders());
        System.out.println("Error is: " + pidY.getError());
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(OI.getDriverForwardThrottle()) > 0.2;
	}

	@Override
	protected void end() {	
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
		System.out.println("Stable mode disabled");
	}

}
