package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SetFloor extends CommandGroup {

	public SetFloor() {
		setTimeout(3.0);
		requires(CommandBase.arm);
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
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
