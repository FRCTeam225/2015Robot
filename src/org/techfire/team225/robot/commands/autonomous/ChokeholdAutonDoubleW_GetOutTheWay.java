package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonDoubleW_GetOutTheWay extends ChokeholdAuton {
	private String name = "Two side \"Chokehold\" w/ Get Out the Way!";
	
	public ChokeholdAutonDoubleW_GetOutTheWay() {
		super();
		addSequential(new TurnTo(90));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(2650, 90));
		addSequential(new TurnTo(0));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-2200, 0).chainableSetTimeout(5.0));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(380, 0));
		addSequential(new WaitCommand(0.25));
		addSequential(new SetChokehold(1.0, 1.0));
		addSequential(new WaitCommand(0.7));
		addSequential(new TurnTo(8).chainableSetTimeout(0.7));
		addSequential(new TurnTo(-8).chainableSetTimeout(0.7));
		addSequential(new TurnTo(0).chainableSetTimeout(0.7));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1500, 0));
		addSequential(new SetChokehold(-0.5, 0.5));
		addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(120));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(500, 120));
	}
	
	public String toString() {
		return name;
	}
}
