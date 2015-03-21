package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SetPostContainer extends CommandGroup {

	public SetPostContainer() {
		setTimeout(3.0);
		requires(CommandBase.arm);
		addSequential(new SetArm(Arm.postContainerPosition));
		addSequential(new WaitForArm());
		addSequential(new CloseGripper());
	}

	public void execute()
	{
		super.execute();
		CommandBase.arm.updatePID();
	}

	public boolean isFinished()
	{
		return isTimedOut() || super.isFinished();
	}
}
