package org.techfire.team225.robot.commands.automation;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoStack extends CommandGroup {

	public AutoStack() {
		setTimeout(4.0);
		addSequential(new SetArm(Arm.secondPosition-130));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitForArm());
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.secondPosition));
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
