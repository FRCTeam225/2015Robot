package org.techfire.team225.robot;

//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
//import redis.clients.jedis.Jedis;

/**
 * A class for accessing redis, through the jedis library,
 *  primarily for integration with RIOview.
 * 
 * @author Adam
 */
public class JedisProvider {
	
	//private static Jedis jedis;
	//private static PowerDistributionPanel pdp;
	
	public static void init() {
		/*try {
			jedis = new Jedis("localhost");
		} catch (Exception e) {
			System.err.println("Jedis init error");
			e.printStackTrace();
		}
		
		pdp = new PowerDistributionPanel();*/
	}
	
	public static void autonomousInit(Command[] autonomi) {
		/*try {
        	jedis.del("autonomi");
        	for (int i = 0; i < autonomi.length; i++) {
            	jedis.rpush("autonomi", autonomi[i].toString());
        	}
    	} catch ( Exception e ) {
    		System.err.println("Jedis autonmous init error");
    		e.printStackTrace();
    	}*/
	}
	
	public static void updateAutonomous(int selected) {
		//jedis.set("currentAuto", "" + selected);
	}
	
	public static int checkAutonomous(int selected) {
		/*int jedisSelected = Integer.parseInt(jedis.get("currentAuto"));
		if (jedisSelected != selected) {
			return jedisSelected;
		} else {
			return selected;
		}*/
		return 0;
	}
	
	public static int getSelectedAutonomous() {
		/*try {
			return Integer.parseInt(jedis.get("currentAuto"));
		} catch (Exception e) {
			System.err.println("Jedis autonomous get error");
			e.printStackTrace();
			return 0;
		}*/
		return 0;
	}
	
	public static void write() {
    	/*Drivetrain mecanumDrivetrain = CommandBase.drivetrain;
    	try
    	{
    		// sensors
	    	jedis.set("Gyro", String.format("%2.3f", mecanumDrivetrain.getGyro()));
	        jedis.set("PhotosensorLeft", "" + mecanumDrivetrain.getLeftEye());
	        jedis.set("PhotosensorRight", "" + mecanumDrivetrain.getRightEye());
	        
	        // encoders
	        jedis.set("EncoderLeft", "" + mecanumDrivetrain.getLeftEncoder());
	        jedis.set("EncoderRight", "" + mecanumDrivetrain.getRightEncoder());
	        jedis.set("EncoderFollow", "" + mecanumDrivetrain.getFollowEncoder());
	        jedis.set("EncoderAvg", String.valueOf(mecanumDrivetrain.getAverageForwardEncoders()));
	        
	        // pdp totals
	        jedis.set("Voltage", String.format("%2.3f", pdp.getVoltage()));
	        jedis.set("Temperature", String.format("%2.3f", pdp.getTemperature()));
	        jedis.set("TotalCurrent", "" + pdp.getTotalCurrent());
	        jedis.set("TotalPower", "" + pdp.getTotalPower());
	        jedis.set("TotalEnergy", "" + pdp.getTotalEnergy());
	        
	        //drivetrain
	        double currentFL = pdp.getCurrent(ConstantsProvider.get("LEFT_FORWARD_MOTOR_POWER"));
	        double currentFR = pdp.getCurrent(ConstantsProvider.get("RIGHT_FORWARD_MOTOR_POWER"));
	        double currentBL = pdp.getCurrent(ConstantsProvider.get("LEFT_BACK_MOTOR_POWER"));
	        double currentBR = pdp.getCurrent(ConstantsProvider.get("RIGHT_BACK_MOTOR_POWER"));
	        jedis.set("FrontLeftMotorCurrent", "" + pdp.getCurrent(ConstantsProvider.get("LEFT_FORWARD_MOTOR_POWER")));
	        jedis.set("FrontRightMotorCurrent", "" + pdp.getCurrent(ConstantsProvider.get("RIGHT_FORWARD_MOTOR_POWER")));
	        jedis.set("BackLeftMotorCurrent", "" + pdp.getCurrent(ConstantsProvider.get("LEFT_BACK_MOTOR_POWER")));
	        jedis.set("BackRightMotorCurrent", "" + pdp.getCurrent(ConstantsProvider.get("RIGHT_BACK_MOTOR_POWER")));
	        jedis.set("DrivetrainTotalCurrent", "" + (currentFL + currentFR + currentBL + currentBR));
	        
	        //arm
	        double armCurrent1 = pdp.getCurrent(ConstantsProvider.get("ARM_FORWARD_MOTOR_POWER"));
	        double armCurrent2 = pdp.getCurrent(ConstantsProvider.get("ARM_BACK_MOTOR_POWER"));
	        jedis.set("ArmMotorOneCurrent", "" + armCurrent1);
	        jedis.set("ArmMotorTwoCurrent", "" + armCurrent2);
	        jedis.set("ArmTotalCurrent", "" + (armCurrent1 + armCurrent2));
	        jedis.set("ArmPosition", String.valueOf(CommandBase.arm.getPosition()));
    	} catch( Exception e ) {
    		System.err.println("Jedis write error");
    		e.printStackTrace();
    	}*/
    }
}
