package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static Drivetrain drivetrain;
	
	protected static void init() {
		drivetrain = new Drivetrain();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
