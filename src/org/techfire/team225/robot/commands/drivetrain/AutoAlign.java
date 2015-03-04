package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoAlign extends CommandGroup {

	public AutoAlign() {
		setTimeout(5.0);
		requires(arm);
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForBin());
		addSequential(new SetArm(Arm.floorPosition + 200));
		addSequential(new WaitForArm());
	}

	public void execute()
	{
		super.execute();
		arm.updatePID();
	}

	public boolean isFinished()
	{
		return isTimedOut() || super.isFinished();
	}
	
}
