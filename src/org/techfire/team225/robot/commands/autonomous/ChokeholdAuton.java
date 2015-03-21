package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAuton extends CommandGroup {
	private String name = "One side \"Chokehold\"";
	
	public ChokeholdAuton() {
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-380, 0).chainableSetTimeout(0.8));
		addSequential(new SetChokehold(true));
		addSequential(new WaitCommand(1.25));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1500, 0));
		addSequential(new SetChokehold(false));
		addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(90));
	}
	
	public String toString() {
		return name;
	}
}
