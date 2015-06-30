package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.chokehold.ReleaseRetainer;
import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAuton extends CommandGroup {
	private String name = "One side \"Chokehold\"";
	
	public ChokeholdAuton() {
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new SetChokehold(1.0, 1.0));
		addSequential(new ResetEncoders());
		addSequential(new SmallDriveYDistance(-125, 0).chainableSetTimeout(0.4));
		addSequential(new WaitCommand(0.15)); // works at 0.3
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1400, 0)); // 1300 for on the field, set to smaller for practice field
		addSequential(new SetChokehold(-0.5, -0.5));
	}
	
	public String toString() {
		return name;
	}
}
