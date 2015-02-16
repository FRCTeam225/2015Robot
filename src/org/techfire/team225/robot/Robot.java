package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.arm.PIDArmControl;
import org.techfire.team225.robot.commands.autonomous.Chokehold;
import org.techfire.team225.robot.commands.autonomous.StrafeAndStack;
import org.techfire.team225.robot.commands.drivetrain.Calibrate;
import org.techfire.team225.robot.subsystems.Drivetrain;


//import redis.clients.jedis.Jedis;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//public static Jedis jedis;
	PowerDistributionPanel pdp;
    Command autonomousCommand;
    CommandGroup[] autonomi;
    int selected = 0;

    public Robot()
    {
    	PortMap.init();
    	CommandBase.init();
    	OI.init();
    	Constants.init();
    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    	pdp = new PowerDistributionPanel();
    	CommandBase.drivetrain.resetAngle();
    	autonomi = new CommandGroup[] {
        		new StrafeAndStack(),
        		new Chokehold()
        };
    	/*
    	try {
    		jedis = new Jedis("localhost");
        	jedis.del("autonomi");
        	for (int i = 0; i < autonomi.length; i++) {
            	jedis.rpush("autonomi", autonomi[i].toString());
        	}
    	} catch ( Exception e ) {
    		System.err.println("Jedis init error");
    	}*/
    }
	
	public void disabledPeriodic() {
		writeJedis();
	}
	
    public void autonomousInit() {
    	/*int i = 0;
    	try {
    		i = Integer.parseInt(jedis.get("currentAuto"));
    	} catch (Exception e){
    		
    	}*/
    	autonomousCommand = new Calibrate();//autonomi[i];
    	new PIDArmControl().start();
    	CommandBase.arm.setTarget(CommandBase.arm.getPosition());
    	CommandBase.drivetrain.resetAngle();
    	autonomousCommand.start();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        writeJedis();
    }

    public void teleopInit() {
    	Command c;
    	if ( (c = CommandBase.arm.getCurrentCommand()) != null )
    		c.cancel();
    	
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	// System.out.println("Current Gs on the Y axis" + CommandBase.mecanumDrivetrain.getAccelerometerY());
        writeJedis();
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void writeJedis() {
    	Drivetrain mecanumDrivetrain = CommandBase.drivetrain;
    	/*try
    	{
    		
    		jedis.set("atBin", (mecanumDrivetrain.atBin()?"yes":"no"));
    		
	    	jedis.set("Gyro", String.format("%2.3f", mecanumDrivetrain.getGyro()));
	        jedis.set("PhotosensorLeft", 
	        		"" + mecanumDrivetrain.getLeftEye());
	        jedis.set("PhotosensorRight", 
	        		"" + mecanumDrivetrain.getRightEye());
	        
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
	        
	        // pdp individual components
	        double currentFL = pdp.getCurrent(PortMap.get("LEFT_FORWARD_MOTOR_POWER"));
	        double currentFR = pdp.getCurrent(PortMap.get("RIGHT_FORWARD_MOTOR_POWER"));
	        double currentBL = pdp.getCurrent(PortMap.get("LEFT_BACK_MOTOR_POWER"));
	        double currentBR = pdp.getCurrent(PortMap.get("RIGHT_BACK_MOTOR_POWER"));
	        jedis.set("FrontLeftMotorCurrent", "" + pdp.getCurrent(PortMap.get("LEFT_FORWARD_MOTOR_POWER")));
	        jedis.set("FrontRightMotorCurrent", "" + pdp.getCurrent(PortMap.get("RIGHT_FORWARD_MOTOR_POWER")));
	        jedis.set("BackLeftMotorCurrent", "" + pdp.getCurrent(PortMap.get("LEFT_BACK_MOTOR_POWER")));
	        jedis.set("BackRightMotorCurrent", "" + pdp.getCurrent(PortMap.get("RIGHT_BACK_MOTOR_POWER")));
	        jedis.set("DrivetrainTotalCurrent", "" + (currentFL + currentFR + currentBL + currentBR));
	        
	        double armCurrent1 = pdp.getCurrent(PortMap.get("ARM_FORWARD_MOTOR_POWER"));
	        double armCurrent2 = pdp.getCurrent(PortMap.get("ARM_BACK_MOTOR_POWER"));
	        jedis.set("ArmMotorOneCurrent", "" + armCurrent1);
	        jedis.set("ArmMotorTwoCurrent", "" + armCurrent2);
	        jedis.set("ArmTotalCurrent", "" + (armCurrent1 + armCurrent2));
	        
	        jedis.set("ArmPosition", String.valueOf(CommandBase.arm.getPosition()));
    	} catch( Exception e ) {
    		e.printStackTrace();
    		System.err.println("Redis error");
    	}*/
    }
}
