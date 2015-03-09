package org.techfire.team225.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class PracticeRobotConstants extends CompetitionRobotConstants {
	
	// drivetrain power
    public static int LEFT_FORWARD_MOTOR_POWER = 12; // PDP
    public static int LEFT_BACK_MOTOR_POWER = 13; // PDP
    public static int RIGHT_FORWARD_MOTOR_POWER = 3; // PDP
    public static int RIGHT_BACK_MOTOR_POWER = 2; // PDP
    
	// arm
    public static int FLOOR_POSITION = 1975;
    
    // arm power
    public static int ARM_FORWARD_MOTOR_POWER = 14; // PDP
    public static int ARM_BACK_MOTOR_POWER = 15; // PDP
}
