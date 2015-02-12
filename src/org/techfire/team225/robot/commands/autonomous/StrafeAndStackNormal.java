package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.drivetrain.DriveXDistance;
import org.techfire.team225.robot.commands.drivetrain.StrafeUntilSee;
import org.techfire.team225.robot.commands.gripper.HalfGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StrafeAndStackNormal extends CommandGroup{
	private String name = "Strafe & Stack - normal";
	public StrafeAndStackNormal() {
		addSequential(new HalfGripper());
		addSequential(new SetArm(300));
		addSequential(new DriveXDistance(600, 0));
		addSequential(new SetArm(200));
	}

	public String toString() {
		return name;
	}
}
