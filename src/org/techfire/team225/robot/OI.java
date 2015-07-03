package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.arm.LegalTilt;
import org.techfire.team225.robot.commands.arm.OverridePot;
import org.techfire.team225.robot.commands.arm.PickupContainer;
import org.techfire.team225.robot.commands.arm.SetArmTilt;
import org.techfire.team225.robot.commands.arm.SetPostContainer;
import org.techfire.team225.robot.commands.arm.SetPreContainer;
import org.techfire.team225.robot.commands.automation.AutoLift;
import org.techfire.team225.robot.commands.automation.AutoPullOut;
import org.techfire.team225.robot.commands.automation.AutoLiftHigh;
import org.techfire.team225.robot.commands.automation.AutoStack;
import org.techfire.team225.robot.commands.cangrabber.SetCangrabber;
import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.drivetrain.StableMode;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.HalfGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.commands.gripper.AlternateHalfGripper;
import org.techfire.team225.robot.commands.toteholder.SetToteHolder;

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
		new JoystickButton(driver, 9).whenPressed(new StableMode());
		
		// operator
		new JoystickButton(operator, 6).whenPressed(new SetPreContainer());
		new JoystickButton(operator, 5).whenPressed(new SetPostContainer());
		//new JoystickButton(operator, 6).whenPressed(new SetCangrabber(true));
		//new JoystickButton(operator, 5).whenPressed(new SetCangrabber(false));
		new JoystickButton(operator, 1).whenPressed(new OpenGripper());
		new JoystickButton(operator, 4).whenPressed(new CloseGripper());
		new JoystickButton(operator, 3).whenPressed(new HalfGripper());
		new JoystickButton(operator, 2).whenPressed(new AlternateHalfGripper());
		//new JoystickButton(operator, 9).whenPressed(new LegalTilt(false));
		new JoystickButton(operator, 10).whenPressed(new PickupContainer());
		//new JoystickButton(operator, 10).whenPressed(new LegalTilt(true));
		//new AxisButton(operator, 3, -0.5).whenPressed(new AutoStack());
		new JoystickButton(operator, 9).whenPressed(new AutoStack());
		new AxisButton(operator, 6, 0.5).whenPressed(new SetCangrabber(true));
		new AxisButton(operator, 6, -0.5).whenPressed(new SetCangrabber(false));
		new AxisButton(operator, 2, 0.5).whenPressed(new SetToteHolder(false));
		new AxisButton(operator, 3, 0.5).whenPressed(new SetToteHolder(true));
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