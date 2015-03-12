package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonDouble extends ChokeholdAuton {
	private String name = "Two side \"Chokehold\"";
	
	public ChokeholdAutonDouble() {
		super();
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(2800, 90));
		addSequential(new TurnTo(0));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-1850, 0).chainableSetTimeout(5.0));
		addSequential(new WaitCommand(0.25));
		addSequential(new SetChokehold(true));
		addSequential(new WaitCommand(0.7));
		addSequential(new TurnTo(8).chainableSetTimeout(0.7));
		addSequential(new TurnTo(-8).chainableSetTimeout(0.7));
		addSequential(new TurnTo(0).chainableSetTimeout(0.7));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1500, 0));
		addSequential(new SetChokehold(false));
		addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(90));
	}
}
