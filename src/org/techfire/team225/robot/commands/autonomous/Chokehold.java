package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.SetWings;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Chokehold extends CommandGroup {
	private String name = "\"Chokehold\"";
	public Chokehold() {
		addSequential(new SetWings(true));
		addSequential(new SetArm(Arm.postContainerPosition));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-900, 0, 0.8));
		addSequential(new WaitForArm());
		addSequential(new SetArm(Arm.topPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		//addSequential(new DriveYDistance(850, 0,0.8));
		//addSequential(new SetArm(Arm.postContainerPosition + 300));
		addSequential(new DriveYDistance(2460, 0));
		addSequential(new SetArm(Arm.postContainerPosition));
		addSequential(new WaitForArm());
		//addSequential(new ResetEncoders());
		//addSequential(new DriveYDistance(100, 0));
		addSequential(new SetWings(false));
	}
	
	public String toString() {
		return name;
	}
}
