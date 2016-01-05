package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonDouble extends ChokeholdAuton {
	private String name = "Two side \"Chokehold\"";
	
	public ChokeholdAutonDouble() {
		super();
		addSequential(new TurnTo(90));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(2570, 90));
		addSequential(new TurnTo(0));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-2200, 0).chainableSetTimeout(5.0));
		addSequential(new SetChokehold(1.0, 1.0));
		addSequential(new WaitCommand(1.0));
		addSequential(new ResetEncoders());
		addSequential(new SmallDriveYDistance(300, 0).chainableSetTimeout(2.0));
		addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(700, 0));
		addSequential(new SetChokehold(-0.5, 0.5));
	}
	
	public String toString() {
		return name;
	}
}
