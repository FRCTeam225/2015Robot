package org.techfire.team225.robot.commands.arm;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LegalTilt extends CommandGroup {

	public LegalTilt(boolean tilt) {
		setTimeout(3.0);
		requires(CommandBase.arm);
		if (tilt) {
			addSequential(new SetArm(Arm.tiltPosition));
		} else {
			addSequential(new SetArm(Arm.topPosition));
		}
		addSequential(new WaitForArm());
		addSequential(new SetArmTilt(tilt));
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
