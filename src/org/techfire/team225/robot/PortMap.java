package org.techfire.team225.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class PortMap {
	
	// drivetrain
    public static int LEFT_FORWARD_MOTOR = 3; // PWM
    public static int LEFT_BACK_MOTOR = 1; // PWM
    public static int RIGHT_FORWARD_MOTOR = 4; // PWM
    public static int RIGHT_BACK_MOTOR = 2; // PWM
    
    // arm
    public static int ARM_FORWARD = 6; // PWM
    public static int ARM_BACK = 7; // PWM
    
    // encoders
    public static int ENCODER_RIGHT_BACK_A = 2; // DIO
    public static int ENCODER_RIGHT_BACK_B = 3; // DIO
    public static int ENCODER_LEFT_BACK_A = 4; // DIO
    public static int ENCODER_LEFT_BACK_B = 5; // DIO
    public static int ENCODER_RIGHT_FORWARD_A = 8; // DIO
    public static int ENCODER_RIGHT_FORWARD_B = 9; // DIO
    public static int ENCODER_LEFT_FORWARD_A = 6; // DIO
    public static int ENCODER_LEFT_FORWARD_B = 7; // DIO
    
    // arm
    public static int ARM_MOTOR_1 = 6; // PWM
    public static int ARM_MOTOR_2 = 7; // PWM
    public static int ARM_POT = 1; // Analog
    
    // sensors
    public static int PHOTO_SENSOR_LEFT = 1; // DIO
    public static int PHOTO_SENSOR_RIGHT = 0; // DIO
    public static int GYRO = 0; // Analog
}
