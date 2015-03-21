package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonArmUp extends CommandGroup {
	private String name = "One side \"Chokehold\", with the arm raised";
	
	public ChokeholdAutonArmUp() {
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-350, 0).chainableSetTimeout(0.7));
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
