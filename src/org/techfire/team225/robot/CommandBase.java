package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.Arm;
import org.techfire.team225.robot.subsystems.MecanumDrivetrain;
import org.techfire.team225.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static MecanumDrivetrain mecanumDrivetrain;
	public static Vision vision;
	public static Arm arm;
	
	protected static void init() {
		mecanumDrivetrain = new MecanumDrivetrain();
		vision = new Vision();
		arm = new Arm();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
