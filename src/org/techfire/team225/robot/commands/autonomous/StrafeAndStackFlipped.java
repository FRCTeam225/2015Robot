package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.drivetrain.StrafeUntilSee;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StrafeAndStackFlipped extends CommandGroup{
	private String name = "Strafe & Stack - from side closer to driver";
	public StrafeAndStackFlipped() {
		
	}
	
	public String toString() {
		return name;
	}
}
