package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.cangrabber.SetCangrabber;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.OldTurnTo;
import org.techfire.team225.robot.commands.drivetrain.ProfiledDriveDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ForwardCanburglarAuton extends CommandGroup {
	private String name = "Forward Canburglar Auton";
	
	public ForwardCanburglarAuton() {
		addSequential(new SetArm(Arm.forwardCanburglarPosition));
		//addSequential(new WaitCommand(1));
		addSequential(new CloseGripper());
		//addSequential(new WaitCommand(1));
		addSequential(new SetCangrabber(true));
		addSequential(new ResetEncoders());
		//addSequential(new DriveYDistance(600));
		addSequential(new ProfiledDriveDistance(3.25, 8, 4, 0).chainableSetTimeout(2.5));
		/*addSequential(new ResetEncoders());
		addSequential(new WaitCommand(0.25));
		addSequential(new SmallDriveYDistance(100));*/
		//addSequential(new WaitCommand(1));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.topPosition));
		addSequential(new WaitCommand(1));
		addSequential(new ResetEncoders());
		//addSequential(new DriveYDistance(-750, 0, 0.5));
		addSequential(new ProfiledDriveDistance(-5.0, 8, 3, 0));
		addSequential(new OldTurnTo(160, 0.45));
		addSequential(new WaitCommand(0.75));
		addSequential(new ResetEncoders());
		//addSequential(new DriveYDistance(200, 140, 0.5));
		//addSequential(new ProfiledDriveDistance(1, 8, 4, 140));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitCommand(1));
		addSequential(new CloseGripper());
		addSequential(new WaitForArm());
		//addSequential(new WaitCommand(1));
		addSequential(new SetCangrabber(false));
		//addSequential(new WaitCommand(1));
		addSequential(new OpenGripper());
	}
	
	public String toString() {
		return name;
	}
}
