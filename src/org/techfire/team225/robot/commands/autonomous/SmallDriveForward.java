package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmallDriveForward extends CommandGroup {
	private String name = "Tiny Drive Forward, for testing and tuning";
	
	public SmallDriveForward() {
		addSequential(new CenterGyro());
		addSequential(new ResetEncoders());
		addSequential(new SmallDriveYDistance(200, 0));
	}
	
	public String toString() {
		return name;
	}
}
