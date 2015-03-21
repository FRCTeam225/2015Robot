package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PullCan extends CommandGroup {
	private String name = "Pull Can";
	
	public PullCan() {
		addSequential(new CenterGyro());
		addSequential(new CloseGripper());
		addSequential(new SetArm(Arm.firstPosition + 300));
		addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-1000, 0));
	}
	
	public String toString() {
		return name;
	}
}
