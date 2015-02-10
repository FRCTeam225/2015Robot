package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.ToggleWings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Chokehold extends CommandGroup {
	private String name = "\"Chokehold\"";
	public Chokehold() {
		addParallel(new ToggleWings());
	}
	
	public String toString() {
		return name;
	}
}
