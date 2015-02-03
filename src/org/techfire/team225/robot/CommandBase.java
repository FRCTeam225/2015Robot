package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.Arm;
import org.techfire.team225.robot.subsystems.Gripper;
import org.techfire.team225.robot.subsystems.MecanumDrivetrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static MecanumDrivetrain mecanumDrivetrain;
	public static Arm arm;
	public static Gripper gripper;
	
	protected static void init() {
		mecanumDrivetrain = new MecanumDrivetrain();
		arm = new Arm();
		gripper = new Gripper();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
