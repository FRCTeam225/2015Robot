package org.techfire.team225.robot;

import org.techfire.team225.robot.commands.arm.PIDArmControl;
import org.techfire.team225.robot.commands.autonomous.Chokehold;
import org.techfire.team225.robot.commands.autonomous.StrafeAndStack;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
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
	
    Command autonomousCommand;
    Command[] autonomi;
    int selected = 0;
    
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
        		new StrafeAndStack(),
        		new Chokehold()
        };
    	
    	JedisProvider.autonomousInit(autonomi);
    	
    	CommandBase.drivetrain.resetAngle();

    }
	
	public void disabledPeriodic() {
		JedisProvider.write();
	}
	
    public void autonomousInit() {
    	autonomousCommand = autonomi[JedisProvider.getSelectedAutonomous()];
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
        JedisProvider.write();
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
        JedisProvider.write();
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
