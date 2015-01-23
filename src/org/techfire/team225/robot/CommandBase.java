package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.MecanumDrivetrain;
import org.techfire.team225.robot.subsystems.OmniDrivetrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static OmniDrivetrain omniDrivetrain;
	public static MecanumDrivetrain mecanumDrivetrain;
	
	protected static void init() {
		omniDrivetrain = new OmniDrivetrain();
		mecanumDrivetrain = new MecanumDrivetrain();
	}


	@Override
	protected void interrupted() {
		end();
	}
}
