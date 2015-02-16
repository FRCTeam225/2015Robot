package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.Arm;
import org.techfire.team225.robot.subsystems.Gripper;
import org.techfire.team225.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static Drivetrain drivetrain;
	public static Arm arm;
	public static Gripper gripper;
	
	protected static void init() {
		drivetrain = new Drivetrain();
		arm = new Arm();
		gripper = new Gripper();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
