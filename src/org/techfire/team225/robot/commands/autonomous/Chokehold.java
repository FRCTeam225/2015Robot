package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.SetWings;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SlowDriveYDistance;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Chokehold extends CommandGroup {
	private String name = "\"Chokehold\"";
	public Chokehold() {
		addSequential(new SetWings(true));
		addSequential(new SetArm(Arm.preContainerPosition));
		addSequential(new ResetEncoders());
		addSequential(new SlowDriveYDistance(-850, 0));
		addSequential(new WaitForArm());
		addSequential(new SetArm(Arm.postContainerPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addParallel(new ListenForBumpAndSetArm());
		addSequential(new SlowDriveYDistance(2460, 0));
		addSequential(new SetArm(Arm.topPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(100, 0));
		addSequential(new SetWings(false));
	}
	
	public String toString() {
		return name;
	}
}
