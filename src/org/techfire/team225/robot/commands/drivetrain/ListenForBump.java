package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.commands.autonomous.ListenForBumpAndSetArm;

public class ListenForBump extends CommandBase {
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		while (!ListenForBumpAndSetArm.wasBumped) {
			if (mecanumDrivetrain.getAccelerometerY() > 0.5) {
				ListenForBumpAndSetArm.wasBumped = true;
			}
		}		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {		
	}
}
