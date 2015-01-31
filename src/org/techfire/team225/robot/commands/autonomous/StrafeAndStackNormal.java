package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.drivetrain.StrafeUntilSee;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StrafeAndStackNormal extends CommandGroup{
	private String name = "Strafe & Stack - normal";
	public StrafeAndStackNormal() {
		addSequential(new StrafeUntilSee(1));
	}

	public String toString() {
		return name;
	}
}
