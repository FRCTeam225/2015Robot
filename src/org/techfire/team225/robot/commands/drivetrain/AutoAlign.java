package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoAlign extends CommandGroup {

	public AutoAlign() {
		addSequential(new DriveToBin());
		addSequential(new SetArm(Arm.floorPosition + 200));
		addSequential(new WaitForArm());
	}
}
