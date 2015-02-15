package org.techfire.team225.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class PracticeRobotConstants {
	
	// drivetrain
    public static int LEFT_FORWARD_MOTOR = 2; // PWM
    public static int LEFT_BACK_MOTOR = 3; // PWM
    public static int RIGHT_FORWARD_MOTOR = 0; // PWM
    public static int RIGHT_BACK_MOTOR = 1; // PWM
    
    // drivetrain power
    public static int LEFT_FORWARD_MOTOR_POWER = 0; // PDP
    public static int LEFT_BACK_MOTOR_POWER = 1; // PDP
    public static int RIGHT_FORWARD_MOTOR_POWER = 4; // PDP
    public static int RIGHT_BACK_MOTOR_POWER = 2; // PDP
    
    // arm
    public static int ARM_FORWARD_MOTOR = 4; // PWM
    public static int ARM_BACK_MOTOR = 5; // PWM
    public static int ARM_POT = 1; // Analog
    public static int WINGS_SOLENOID = 0; // PCM
    public static int FLOOR_POSITION = 2065;
    public static int FIRST_POSITION = 2450;
    public static int POST_CONTAINER_POSITION = 2465;
    public static int PRE_CONTAINER_POSITION = 3030;
    public static int TOP_POSITION = 3200;
    
    // gripper
    public static int GRIPPER_SOLENOID_LEFT = 4; // PCM  
    public static int GRIPPER_SOLENOID_RIGHT = 5; // PCM
    
    // arm power
    public static int ARM_FORWARD_MOTOR_POWER = 6; // PDP
    public static int ARM_BACK_MOTOR_POWER = 7; // PDP
    
    // encoders
    public static int ENCODER_RIGHT_A = 0; // DIO
    public static int ENCODER_RIGHT_B = 1; // DIO
    public static int ENCODER_LEFT_A = 2; // DIO
    public static int ENCODER_LEFT_B = 3; // DIO
    public static int ENCODER_FOLLOW_A = 4; // DIO
    public static int ENCODER_FOLLOW_B = 5; // DIO
        
    // sensors
    public static int PHOTO_SENSOR_LEFT = 7; // DIO
    public static int PHOTO_SENSOR_RIGHT  = 6; // DIO
    public static int GYRO = 0; // Analog
    
    // compressor
    public static int COMPRESSOR_POWER = 0; // PDP
}
