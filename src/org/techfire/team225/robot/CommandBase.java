package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.MecanumDrivetrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static MecanumDrivetrain mecanumDrivetrain;
	
	protected static void init() {
		mecanumDrivetrain = new MecanumDrivetrain();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
