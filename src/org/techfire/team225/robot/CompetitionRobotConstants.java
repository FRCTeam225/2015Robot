package org.techfire.team225.robot;

public class CompetitionRobotConstants {
	
	// drivetrain
    public static int LEFT_FORWARD_MOTOR = 2; // PWM
    public static int LEFT_BACK_MOTOR = 3; // PWM
    public static int RIGHT_FORWARD_MOTOR = 0; // PWM
    public static int RIGHT_BACK_MOTOR = 1; // PWM
    
    // drivetrain power
    public static int LEFT_FORWARD_MOTOR_POWER = 12; // PDP
    public static int LEFT_BACK_MOTOR_POWER = 13; // PDP
    public static int RIGHT_FORWARD_MOTOR_POWER = 3; // PDP
    public static int RIGHT_BACK_MOTOR_POWER = 2; // PDP
    
    // arm
    public static int ARM_FORWARD_MOTOR = 4; // PWM
    public static int ARM_BACK_MOTOR = 5; // PWM
    public static int ARM_POT = 1; // Analog
    public static int WINGS_SOLENOID = 2; // PCM
    
    // gripper
    public static int GRIPPER_SOLENOID_LEFT = 1; // PCM  
    public static int GRIPPER_SOLENOID_RIGHT = 0; // PCM
    
    // arm power
    public static int ARM_FORWARD_MOTOR_POWER = 14; // PDP
    public static int ARM_BACK_MOTOR_POWER = 15; // PDP
    
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
