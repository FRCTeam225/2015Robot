package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.drivetrain.ListenForBump;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ListenForBumpAndSetArm extends CommandGroup {
	
	public ListenForBumpAndSetArm() {
		addSequential(new ListenForBump());
		addSequential(new SetArm(Arm.postContainerPosition + 300));
	}
}
