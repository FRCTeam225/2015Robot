package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.commands.gripper.SetCangrabber;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ForwardCanburglarAuton extends CommandGroup {
	private String name = "Forward Canburglar Auton";
	
	public ForwardCanburglarAuton() {
		addSequential(new SetArm(Arm.forwardCanburglarPosition));
		addSequential(new CloseGripper());
		addSequential(new SetCangrabber(true));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(500));
		addSequential(new OpenGripper());
		addSequential(new SetArm(Arm.preContainerPosition));
		addSequential(new WaitCommand(1.5));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-700));
		addSequential(new TurnTo(180));
		addSequential(new SetArm(Arm.floorPosition));
	}
	
	public String toString() {
		return name;
	}
}
