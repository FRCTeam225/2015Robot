package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.OI;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class MecanumDrive extends CommandBase {

	public MecanumDrive() {
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		double yThrottle = OI.getDriverForwardThrottle(); // forward and backwards
		double xThrottle = OI.getDriverStrafeThrottle(); // side to side
		double rotationThrottle = OI.getDriverRotation();
		
        
		double[] diagonal1_3 = {0, 0};
		double[] diagonal2_4 = {0, 0};
		
		double x = xThrottle;
        double y = yThrottle;
        // Negate y for the joystick.
        y = -y;
        // Compenstate for gyro angle.
        /*double rotated[] = rotateVector(x, y, gyroAngle);
        xIn = rotated[0];
        yIn = rotated[1];*/
        
        diagonal1_3[1] = x + y + rotationThrottle;
        diagonal2_4[1] = -x + y - rotationThrottle;
        diagonal1_3[0] = -x + y + rotationThrottle;
        diagonal2_4[0] = x + y - rotationThrottle;
        
        /*if (x > 0.1) {
        	for (double i : diagonal1_3) {
        		i = -x;
        	}
        	for (double i : diagonal2_4) {
        		i = x;
        	}
        } else if (x < -0.1) {
        	for (double i : diagonal1_3) {
        		i = x;
        	}
        	for (double i : diagonal2_4) {
        		i = -x;
        	}
        }*/
		
		/*double distFromCenter = Math.sqrt(Math.pow(yThrottle, 2) 
				+ Math.pow(xThrottle, 2)) ; // Pythagorean Theorem! :D
		
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
			
		}*/
		
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
