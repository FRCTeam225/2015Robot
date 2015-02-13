package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.drivetrain.DriveXDistance;
import org.techfire.team225.robot.commands.drivetrain.StrafeUntilSee;
import org.techfire.team225.robot.commands.gripper.HalfGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StrafeAndStackNormal extends CommandGroup{
	private String name = "Strafe & Stack - normal";
	public StrafeAndStackNormal() {
		addSequential(new HalfGripper());
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new StrafeUntilSee());
		addSequential(new SetArm(Arm.firstPosition - 150));
		addSequential(new OpenGripper());
		addSequential(new SetArm(Arm.floorPosition));
	}

	public String toString() {
		return name;
	}
}
