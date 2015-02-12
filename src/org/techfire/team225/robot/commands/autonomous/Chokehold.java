package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.ToggleWings;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Chokehold extends CommandGroup {
	private String name = "\"Chokehold\"";
	public Chokehold() {
		addSequential(new ToggleWings());
		addSequential(new SetArm(Arm.preContainerPosition));
		addSequential(new DriveYDistance(-2000, 0));
		addSequential(new WaitForArm());
		addSequential(new SetArm(Arm.postContainerPosition));
		addSequential(new DriveYDistance(2500, 0));
	}
	
	public String toString() {
		return name;
	}
}
