package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class JoystickDrive extends CommandBase {

	private double velocityX = 0;
	private double velocityY = 0;
	private double rotationalVelocity = 0;
	
	private double accelerationX = 0;
	private double accelerationY = 0;
	private double rotationAcceleration = 0;
	
	private double accelerationC = 0.00005;
	private double accelerationMin = 0.02;
	
	private double preciseScalar = 0.5;
	
	public double X = 0;
	
	public JoystickDrive() {
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();		
		
		/*accelerationY = updateAcceleration(accelerationY, yThrottle);
		velocityY = updateVelocity(accelerationY, velocityY, yThrottle);
		
		accelerationX = updateAcceleration(accelerationX, xThrottle);
		velocityX = updateVelocity(accelerationX, velocityX, xThrottle);
		
		rotationAcceleration = updateAcceleration(rotationAcceleration, rotationThrottle);
		rotationalVelocity = updateVelocity(
				rotationAcceleration, rotationalVelocity, rotationThrottle);
		
		/* if (OI.getDriverPreciseMode()) {
			velocityY *= preciseScalar;
			velocityX *= preciseScalar;
			rotationThrottle *= preciseScalar;
		} */
		
		double l = yThrottle-rotationThrottle;
		double r = yThrottle+rotationThrottle;
		drivetrain.setLeftRight(l,-r);
		//drivetrain.setMotorSpeeds(yThrottle, xThrottle, rotationThrottle);
	}
	
	private double updateAcceleration(double acceleration, double target) {
		if (target > 0) {
			if (acceleration < 0) {
				acceleration = 0;
			} else {
				acceleration += accelerationC;
				if (acceleration < accelerationMin) {
					acceleration = accelerationMin;
				}
			}
			
		} else if (target < 0) {
			if (acceleration > 0) {
				acceleration = 0;
			} else {
				acceleration -= accelerationC;
				if (acceleration > -accelerationMin) {
					acceleration = -accelerationMin;
				}
			}
		} else {
			acceleration = 0;
		}
		return acceleration;
	}
	
	private double updateVelocity(double acceleration, double velocity, double target) {
		if (target > 0) {
			if (velocity < 0) {
				velocity = 0;
			} else {
				velocity += acceleration;
				if (velocity > target) {
					velocity = target;
				}
			}
			
		} else if (target < 0) {
			if (velocity > 0) {
				velocity = 0;
			} else {
				velocity += acceleration;
				if (velocity < target) {
					velocity = target;
				}
			}
		} else {
			velocity = 0;
		}
		return velocity;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0);
	}
	
}
