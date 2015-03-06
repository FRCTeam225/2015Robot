package org.techfire.team225.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoNothing extends CommandGroup {
	private String name = "Do Nothing";
	
	public DoNothing() {}
	
	public String toString() {
		return name;
	}
}
