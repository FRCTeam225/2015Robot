package org.techfire.team225.robot;


import org.techfire.team225.SimpleTableServer;
import org.techfire.team225.robot.commands.arm.PIDArmControl;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAuton;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonArmUp;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDouble;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDoubleArmUp;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDoubleArmUpW_GetOutTheWay;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDoubleW_GetOutTheWay;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonScoringPlatform;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonScoringPlatformNoMove;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonScoringPlatformW_GetOutTheWay;
import org.techfire.team225.robot.commands.autonomous.DoNothing;
import org.techfire.team225.robot.commands.autonomous.DriveBackward;
import org.techfire.team225.robot.commands.autonomous.DriveForward;
import org.techfire.team225.robot.commands.autonomous.PullCan;
import org.techfire.team225.robot.commands.autonomous.SideStack;
import org.techfire.team225.robot.commands.autonomous.SideStackNoStable;
import org.techfire.team225.robot.commands.autonomous.SideStackOldNewLoop;
import org.techfire.team225.robot.commands.autonomous.StraightStack;
import org.techfire.team225.robot.commands.autonomous.StraightStackNoSense;
import org.techfire.team225.robot.commands.autonomous.StraightStackOneCan;
import org.techfire.team225.robot.commands.drivetrain.ProfiledDriveDistance;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
    Command autonomousCommand;
    Command[] autonomi;
    public int selected = 0;
    boolean sendDebugData = true;
    boolean sendExtendedDebugData = false;
    
    SimpleTableServer piTable;
    DebugSenderThread debugSender;
    
    DigitalInput resetButton;
    
    //boolean armPIDenabled = false;
    
    public Robot()
    {

    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	ConstantsProvider.init();
    	CommandBase.init();
    	OI.init();
    	JedisProvider.init();

    	autonomi = new Command[] {
    			new DoNothing(),
    			new SideStack(),
    			new SideStackOldNewLoop(),
    			new SideStackNoStable(),
        		new StraightStack(),
        		new StraightStackNoSense(),
        		new StraightStackOneCan(),
        		new ChokeholdAuton(),
        		new ChokeholdAutonScoringPlatform(),
        		new ChokeholdAutonScoringPlatformNoMove(),
        		new ChokeholdAutonScoringPlatformW_GetOutTheWay(),
        		new ChokeholdAutonArmUp(),
        		new ChokeholdAutonDouble(),
        		new ChokeholdAutonDoubleArmUp(),
        		new ChokeholdAutonDoubleW_GetOutTheWay(),
        		new ChokeholdAutonDoubleArmUpW_GetOutTheWay(),
        		new PullCan(),
        		new DriveForward(),
        		new DriveBackward(),
        		new ProfiledDriveDistance(5, 8, 4, 0)
        };
    	
    	JedisProvider.autonomousInit(autonomi);
    	
    	CommandBase.drivetrain.resetAngle();
    	resetButton = new DigitalInput(ConstantsProvider.get("RESET_BUTTON"));
    	
    	try {
    		piTable = new SimpleTableServer();
        	debugSender = new DebugSenderThread();
        	debugSender.start();
    	} catch (Exception e) {
    		System.out.println("Pi Table init failed");
    	}
    	    	
    	System.out.println("ROBOT READY!");
    	System.out.println("~");
    }
	
	public void disabledPeriodic() {
		JedisProvider.write();
		SmartDashboard.putDouble("Gyro", CommandBase.drivetrain.getGyro());
	    	
		if (OI.driver.getRawButton(4) && selected < autonomi.length - 1) {
			selected++;
			
			try { 
				piTable.put("selectedAutonomous", selected);
			} catch ( Exception e ) {
				
			}
			
			JedisProvider.updateAutonomous(selected);
			System.out.println("Selected autonomous is: " + autonomi[selected]);
			System.out.println("~");
	    	SmartDashboard.putString("SelectedAutonomous", "" + autonomi[selected]);
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(3) && selected > 0) {
			selected--;
			
			try { 
				piTable.put("selectedAutonomous", selected);
			} catch ( Exception e ) {
				
			}
			
			JedisProvider.updateAutonomous(selected);
			System.out.println("Selected autonomous is: " + autonomi[selected]);
			System.out.println("~");
	    	SmartDashboard.putString("SelectedAutonomous", "" + autonomi[selected]);
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(1) ) {
			CommandBase.drivetrain.recalGyro();
			System.out.println("GYRO RESET!");
			System.out.println("GYRO: " + String.format("%2.3f", CommandBase.drivetrain.getGyro()));
			System.out.println("~");
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(2)) {
			CommandBase.drivetrain.resetForwardEncoders();
			System.out.println("ENCODERS RESET!");
			System.out.println("ENCODERS: " + CommandBase.drivetrain.getAverageForwardEncoders());
			System.out.println("~");
			Timer.delay(0.5);
		}
		//selected = JedisProvider.checkAutonomous(selected);
		
		/*System.out.print("DT: "+CommandBase.drivetrain.getAverageForwardEncoders()+", ");
        System.out.print("A: "+CommandBase.drivetrain.getGyro()+", ");
        System.out.println("Arm: "+CommandBase.arm.getPosition());*/
	}
	
    public void autonomousInit() {
    	sendDebugData = false;
    	autonomousCommand = autonomi[selected];
    	new PIDArmControl().start();
    	//armPIDenabled = true;
    	CommandBase.arm.setTarget(CommandBase.arm.getPosition());
    	CommandBase.drivetrain.resetAngle();
    	CommandBase.drivetrain.resetForwardEncoders();
    	autonomousCommand.start();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        CommandBase.arm.updatePID();
        JedisProvider.write();
        SmartDashboard.putDouble("Gyro", CommandBase.drivetrain.getGyro());
    }
    
    public void resetSubsystem(Subsystem s)
    {
    	Command c;
    	if ( (c = CommandBase.arm.getCurrentCommand()) != null )
    		c.cancel();
    }

    public void teleopInit() {
    	System.out.println("TeleopInit");
    	
    	sendDebugData = false;
    	
    	CommandBase.drivetrain.resetAngle();
    	resetSubsystem(CommandBase.drivetrain);
    	resetSubsystem(CommandBase.arm);
    	CommandBase.gripper.setGripper(false, false);
    	//if (!armPIDenabled) {
    		//new PIDArmControl().start();
    	//}
    	
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
    	sendDebugData = true;
    	
		selected = autonomi.length-1;
		System.out.println("Selected autonomous is: " + autonomi[selected]);
    	System.out.println("~");
    	SmartDashboard.putString("SelectedAutonomous", "" + autonomi[selected]);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        JedisProvider.write();
        Scheduler.getInstance().run();
        
        //CommandBase.arm.updatePID();
        System.out.println(CommandBase.drivetrain.getFeetDistance());
       /* System.out.print("DT: "+CommandBase.drivetrain.getAverageForwardEncoders()+", ");
        System.out.print("DTL: "+CommandBase.drivetrain.getRightEncoder()+", ");
        System.out.print("A: "+CommandBase.drivetrain.getGyro()+", ");
        System.out.println("Arm: "+CommandBase.arm.getPosition());*/
    }
    
    public void testInit()
    {
    	sendDebugData = true;
    	sendExtendedDebugData = true;
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public class DebugSenderThread extends Thread {
    	
    	public void run()
    	{
    		String autolist = "";
    		for ( int i = 0; i < autonomi.length; i++ )
    		{
    			autolist += autonomi[i].toString();
    			if ( i != autonomi.length-1 )
    				autolist += ",";
    		}
    		
    		while (true)
    		{
	    		try {
	    			if ( !resetButton.get() )
	    				CommandBase.drivetrain.recalGyro();
	    				
	    			if ( sendDebugData || sendExtendedDebugData )
	    			{
	    				piTable.put("Gyro", String.valueOf(CommandBase.drivetrain.getGyro()));
	    				
	    				piTable.put("autonomi", autolist);
	    				//selected = Integer.parseInt(piTable.get("currentAuto"));
	    				if ( sendExtendedDebugData )
	    				{
	    					// TODO: add other debug lines here
	    				}
	    			}
	    			Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}
    }
}
