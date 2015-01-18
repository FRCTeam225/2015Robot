package org.techfire.team225.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	public static Joystick driver = new Joystick(0);
	public static Joystick operator = new Joystick(1);
	
	public static double getDriverStrafeThrottle() {
		return driver.getRawAxis(1);
	}
	
	public static double getDriverForwardThrottle() {
		return driver.getRawAxis(2);
	}
	
	public static double getDriverTurn() {
		return driver.getRawAxis(3);
	}
}

