package org.techfire.team225.robot;


import org.techfire.team225.robot.commands.arm.PIDArmControl;
import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAuton;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonArmUp;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDouble;
import org.techfire.team225.robot.commands.autonomous.ChokeholdAutonDoubleArmUp;
import org.techfire.team225.robot.commands.autonomous.DoNothing;
import org.techfire.team225.robot.commands.autonomous.DriveBackward;
import org.techfire.team225.robot.commands.autonomous.DriveForward;
import org.techfire.team225.robot.commands.autonomous.PullCan;
import org.techfire.team225.robot.commands.autonomous.StraightStack;
import org.techfire.team225.robot.commands.autonomous.StraightStackOneCan;
import org.techfire.team225.robot.subsystems.Arm;

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
    //boolean armPIDenabled = false;
    
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
        		new StraightStack(),
        		new StraightStackOneCan(),
        		new ChokeholdAuton(),
        		new ChokeholdAutonArmUp(),
        		new ChokeholdAutonDouble(),
        		new ChokeholdAutonDoubleArmUp(),
        		new PullCan(),
        		new DriveForward(),
        		new DriveBackward()
        };
    	
    	JedisProvider.autonomousInit(autonomi);
    	
    	CommandBase.drivetrain.resetAngle();
    	
    	System.out.println("ROBOT READY!");
    	System.out.println("~");
    }
	
	public void disabledPeriodic() {
		JedisProvider.write();
		 SmartDashboard.putDouble("Gyro", CommandBase.drivetrain.getGyro());
		if (OI.driver.getRawButton(4) && selected < autonomi.length - 1) {
			selected++;
			JedisProvider.updateAutonomous(selected);
			System.out.println("Selected autonomous is: " + autonomi[selected]);
			System.out.println("~");
	    	SmartDashboard.putString("SelectedAutonomous", "" + autonomi[selected]);
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(3) && selected > 0) {
			selected--;
			JedisProvider.updateAutonomous(selected);
			System.out.println("Selected autonomous is: " + autonomi[selected]);
			System.out.println("~");
	    	SmartDashboard.putString("SelectedAutonomous", "" + autonomi[selected]);
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(1)) {
			CommandBase.drivetrain.resetAngle();
			System.out.println("GYRO RESET!");
			System.out.println("GYRO: " + String.format("%2.3f", CommandBase.drivetrain.getGyro()));
			System.out.println("~");
			Timer.delay(0.5);
		} else if (OI.driver.getRawButton(2)) {
			CommandBase.drivetrain.resetAngle();
			System.out.println("ENCODERS RESET!");
			System.out.println("ENCODERS: " + CommandBase.drivetrain.getAverageForwardEncoders());
			System.out.println("~");
			Timer.delay(0.5);
		}
		//selected = JedisProvider.checkAutonomous(selected);
		
		System.out.print("DT: "+CommandBase.drivetrain.getAverageForwardEncoders()+", ");
        System.out.print("A: "+CommandBase.drivetrain.getGyro()+", ");
        System.out.println("Arm: "+CommandBase.arm.getPosition());
	}
	
    public void autonomousInit() {
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
    	CommandBase.drivetrain.resetAngle();
    	resetSubsystem(CommandBase.drivetrain);
    	resetSubsystem(CommandBase.arm);
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
		selected = 0;
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

        
        System.out.print("DT: "+CommandBase.drivetrain.getAverageForwardEncoders()+", ");
        System.out.print("DTL: "+CommandBase.drivetrain.getRightEncoder()+", ");
        System.out.print("A: "+CommandBase.drivetrain.getGyro()+", ");
        System.out.println("Arm: "+CommandBase.arm.getPosition());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
