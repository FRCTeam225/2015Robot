
package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.autonomous.StrafeAndStackFlipped;
import org.techfire.team225.robot.commands.autonomous.StrafeAndStackNormal;
import org.techfire.team225.robot.subsystems.MecanumDrivetrain;

import redis.clients.jedis.Jedis;
import edu.wpi.first.wpilibj.Gyro;
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
	
	public static Jedis jedis;
	Gyro gyro;
	PowerDistributionPanel pdp;
    Command autonomousCommand;
    CommandGroup[] autonomi;
    int selected = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	CommandBase.init();
    	OI.init();
    	pdp = new PowerDistributionPanel();
    	gyro = CommandBase.mecanumDrivetrain.gyro;
    	gyro.initGyro();
    	gyro.reset();
    	autonomi = new CommandGroup[] {
        		new StrafeAndStackNormal(),
        		new StrafeAndStackFlipped()
        };
    	
    	try {
    		jedis = new Jedis("localhost");
        	jedis.del("autonomi");
        	for (int i = 0; i < autonomi.length; i++) {
            	jedis.rpush("autonomi", autonomi[i].toString());
        	}
    	} catch ( Exception e ) {
    		System.err.println("Jedis init error");
    	}
    	

    }
	
	public void disabledPeriodic() {
		writeJedis();
	}

    public void autonomousInit() {
    	int i = 0;
    	try {
    		i = Integer.parseInt(jedis.get("currentAuto"));
    	} catch (Exception e){
    		
    	}
    	autonomousCommand = autonomi[i];
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
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
    	MecanumDrivetrain mecanumDrivetrain = CommandBase.mecanumDrivetrain;
    	try
    	{
	    	jedis.set("Gyro", "" + gyro.getAngle());
	        jedis.set("PhotosensorLeft", 
	        		"" + !mecanumDrivetrain.photoLeft.get());
	        jedis.set("PhotosensorRight", 
	        		"" + !mecanumDrivetrain.photoRight.get());
	        
	        // encoders
	        Integer[] encoderArray = mecanumDrivetrain.getEncoders();
	        jedis.set("EncoderFrontLeft", "" + encoderArray[0]);
	        jedis.set("EncoderFrontRight", "" + encoderArray[1]);
	        jedis.set("EncoderBackLeft", "" + encoderArray[2]);
	        jedis.set("EncoderBackRight", "" + encoderArray[3]);
	        
	        // pdp totals
	        jedis.set("Voltage", "" + pdp.getVoltage());
	        jedis.set("Temperature", "" + pdp.getTemperature());
	        jedis.set("TotalCurrent", "" + pdp.getTotalCurrent());
	        jedis.set("TotalPower", "" + pdp.getTotalPower());
	        jedis.set("TotalEnergy", "" + pdp.getTotalEnergy());
	        
	        // pdp individual components
	        double currentFL = pdp.getCurrent(PortMap.LEFT_FORWARD_MOTOR_POWER);
	        double currentFR = pdp.getCurrent(PortMap.RIGHT_FORWARD_MOTOR_POWER);
	        double currentBL = pdp.getCurrent(PortMap.LEFT_BACK_MOTOR_POWER);
	        double currentBR = pdp.getCurrent(PortMap.RIGHT_BACK_MOTOR_POWER);
	        jedis.set("FrontLeftMotorCurrent", "" + pdp.getCurrent(PortMap.LEFT_FORWARD_MOTOR_POWER));
	        jedis.set("FrontRightMotorCurrent", "" + pdp.getCurrent(PortMap.RIGHT_FORWARD_MOTOR_POWER));
	        jedis.set("BackLeftMotorCurrent", "" + pdp.getCurrent(PortMap.LEFT_BACK_MOTOR_POWER));
	        jedis.set("BackRightMotorCurrent", "" + pdp.getCurrent(PortMap.RIGHT_BACK_MOTOR_POWER));
	        jedis.set("DrivetrainTotalCurrent", "" + (currentFL + currentFR + currentBL + currentBR));
	        
	        double armCurrent1 = pdp.getCurrent(PortMap.ARM_FORWARD_MOTOR_POWER);
	        double armCurrent2 = pdp.getCurrent(PortMap.ARM_BACK_MOTOR_POWER);
	        jedis.set("ArmMotorOneCurrent", "" + armCurrent1);
	        jedis.set("ArmMotorTwoCurrent", "" + armCurrent2);
	        jedis.set("ArmTotalCurrent", "" + armCurrent1 + armCurrent2);
	        
	        jedis.set("ArmPosition", String.valueOf(CommandBase.arm.getPosition()));
    	} catch( Exception e ) {
    		System.out.println("Redis error");
    	}
    }
}
