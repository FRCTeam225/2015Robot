package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.arm.SetWings;
import org.techfire.team225.robot.commands.arm.OverridePot;
import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.ContainerHold;
import org.techfire.team225.robot.commands.gripper.HalfGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.commands.gripper.OpenHalfGripper;

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
		// driver
		new JoystickButton(driver, 8).whenPressed(new CenterGyro());
		new JoystickButton(driver, 7).whenPressed(new OverridePot());
		
		// operator
		new JoystickButton(operator, 6).whenPressed(new SetWings(true));
		new JoystickButton(operator, 5).whenPressed(new SetWings(false));
		new JoystickButton(operator, 1).whenPressed(new OpenGripper());
		new JoystickButton(operator, 4).whenPressed(new CloseGripper());
		new JoystickButton(operator, 3).whenPressed(new HalfGripper());
		new JoystickButton(operator, 2).whenPressed(new OpenHalfGripper());
		new JoystickButton(operator, 9).whenPressed(new ContainerHold(false));
		new JoystickButton(operator, 10).whenPressed(new ContainerHold(true));
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
	
	public static double getArmThrottle() {
		return operator.getRawAxis(1);
	}
}

