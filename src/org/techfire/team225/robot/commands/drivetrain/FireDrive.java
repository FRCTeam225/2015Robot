package org.techfire.team225.robot.commands.drivetrain;

import java.io.FileWriter;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class FireDrive extends CommandBase {

	double targetAngle = 0;
	FileWriter writer;
	public FireDrive() {
		requires(drivetrain);
	}
		
	@Override
	protected void initialize() {
		targetAngle = drivetrain.getGyro();
	}

	// CODE RELEASE NOTE: This was used during the season and allows the mecanum drive
	// to behave like a true omnidirectional drive for driving purposes. That is, FireDrive
	// makes the robot move in all directions with the same speed, instead of the 
	// traditional behavior for mecanum: full speed forwards and 50% strafe. However, with
	// our ever changing strategy we decided to remove FireDrive in the offseason in favor 
	// of maximum speed, so it is commented out here.
	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); 
		double xThrottle = OI.getDriverStrafeThrottle(); 
		double rotationThrottle = OI.getDriverRotation();
		
		// gyro correction, holds the robot at the angle the driver wants it to be at
		/*			if (Math.abs(rotationThrottle) > 0.1)
					{
						targetAngle = drivetrain.getGyro();
					}
					else
					{
						rotationThrottle = (drivetrain.getGyro() - targetAngle) * -0.02;
					}
		*/
		
		//if (OI.driver.getRawButton(10)) {
			drivetrain.setMotorSpeeds(-xThrottle, yThrottle, -rotationThrottle, 1, false);
		/*} else {
			// joystick check
			if (Math.abs(yThrottle) < 0.1)
				yThrottle = 0;
			if (Math.abs(xThrottle) < 0.1)
				xThrottle = 0;
			if (Math.abs(rotationThrottle) < 0.1)
				rotationThrottle = 0;
			
			// omni-directional mecanum scaling
			double scale = 0.5 + (Math.abs(xThrottle) * 0.5);
			*/
			
			/*drivetrain.setMotorSpeeds(-xThrottle, yThrottle, -rotationThrottle, scale, false);
		}*/
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0, 0, false);
	}
	
	public void reset() {
		initialize();
	}
}

