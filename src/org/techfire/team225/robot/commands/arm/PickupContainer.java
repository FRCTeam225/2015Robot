package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PickupContainer extends CommandGroup {

	public PickupContainer() {
		setTimeout(3.0);
		requires(CommandBase.arm);
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.pickupContainerPosition));
		addSequential(new WaitForArm());
		addSequential(new WaitCommand(0.3));
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
