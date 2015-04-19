package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.chokehold.SetChokehold;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChokeholdAutonArmUp extends CommandGroup {
	private String name = "One side \"Chokehold\", with the arm raised";
	
	public ChokeholdAutonArmUp() {
		addSequential(new ResetEncoders());
		addSequential(new SetChokehold(1.0, 1.0));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-250, 0));		
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1300, 0));
		addSequential(new SetChokehold(-0.5, -0.5));
	}
	
	public String toString() {
		return name;
	}
}
