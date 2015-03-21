package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackward extends CommandGroup {
	private String name = "Drive Backward";
	
	public DriveBackward() {
		addSequential(new CenterGyro());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-1000, 0));
	}
	
	public String toString() {
		return name;
	}
}
