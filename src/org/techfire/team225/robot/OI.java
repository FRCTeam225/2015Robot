package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.drivetrain.CenterGyro;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	public static Joystick driver = new Joystick(0);
	public static Joystick operator = new Joystick(1);
	
	public static void init() {
		new JoystickButton(driver, 10).whenPressed(new CenterGyro());
		
	}
	
	public static boolean getDriverPreciseMode() {
		return driver.getRawButton(8);
	}
	
	public static double getDriverStrafeThrottle() {
		return driver.getRawAxis(0);
	}
	
	public static double getDriverForwardThrottle() {
		return driver.getRawAxis(1);
	}
	
	public static double getDriverRotation() {
		return driver.getRawAxis(4);
	}
	
	public static double getDriverDPadRightLeft() {
		return 0;
	}
}

