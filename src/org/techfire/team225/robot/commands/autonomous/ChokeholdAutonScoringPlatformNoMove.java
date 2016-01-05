package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonScoringPlatformNoMove extends CommandGroup {
	private String name = "One side \"Chokehold\", starting on the scoring platform and no move";
	
	public ChokeholdAutonScoringPlatformNoMove() {
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new SetChokehold(1.0, 1.0));
		addSequential(new ResetEncoders());
		addSequential(new SmallDriveYDistance(-150, 0).chainableSetTimeout(0.4));
		addSequential(new WaitCommand(0.25));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1300, 0));
		addSequential(new SetChokehold(-0.5, -0.5));
	}
	
	public String toString() {
		return name;
	}
}
