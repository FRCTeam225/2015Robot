package org.techfire.team225.robot;

import org.techfire.team225.robot.subsystems.Arm;
import org.techfire.team225.robot.subsystems.Cangrabber;
import org.techfire.team225.robot.subsystems.Chokehold;
import org.techfire.team225.robot.subsystems.Gripper;
import org.techfire.team225.robot.subsystems.Drivetrain;
import org.techfire.team225.robot.subsystems.ToteHolder;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static Drivetrain drivetrain;
	public static Arm arm;
	public static Gripper gripper;
	public static Chokehold chokehold;
	public static ToteHolder toteHolder;
	public static Cangrabber cangrabber;
	
	protected static void init() {
		drivetrain = new Drivetrain();
		arm = new Arm();
		gripper = new Gripper();
		chokehold = new Chokehold();
		toteHolder = new ToteHolder();
	}

	
	public Command chainableSetTimeout(double t)
	{
		super.setTimeout(t);
		return this;
	}

	@Override
	protected void interrupted() {
		end();
	}
}