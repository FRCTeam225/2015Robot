package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

public class MecanumDrive extends CommandBase {

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();
		
		double[] diagonal1_3 = {0, 0};
		double[] diagonal2_4 = {0, 0};
		
		double distFromCenter = Math.sqrt(Math.pow(Math.abs(yThrottle), 2) 
				+ Math.pow(Math.abs(xThrottle), 2)) ; // Pythagorean Theorem! :D
		
		if ((yThrottle > 0 && xThrottle > 0) || (yThrottle < 0 && xThrottle < 0)) {
			if (yThrottle > 0) { // I
				for (double s : diagonal2_4) {
					s = distFromCenter;
				}
			} else if (yThrottle < 0) { // III
				for (double s : diagonal2_4) {
					s = -distFromCenter;
				}
			}
			
			
		} else if ((yThrottle < 0 && xThrottle > 0) || (yThrottle > 0 && xThrottle < 0)) {
			if (yThrottle > 0) { // II
				for (double s : diagonal2_4) {
					s = distFromCenter;
				}
			} else if (yThrottle < 0) { // IV
				for (double s : diagonal2_4) {
					s = -distFromCenter;
				}
			}
			
		}
		
		mecanumDrivetrain.setMotorSpeeds(diagonal1_3, diagonal2_4, rotationThrottle);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		double[] diagonal1_3 = {0, 0};
		double[] diagonal2_4 = {0, 0};
		mecanumDrivetrain.setMotorSpeeds(diagonal1_3, diagonal2_4, 0);
	}
}
