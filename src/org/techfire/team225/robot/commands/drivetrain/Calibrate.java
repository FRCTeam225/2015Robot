package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class Calibrate extends CommandBase {

	@Override
	protected void initialize() {		
	}

	@Override
	protected void execute() {
		while (true) {
			drivetrain.setMotorSpeeds(0, -1, 0, 1, false);
			try {
				wait(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			drivetrain.setMotorSpeeds(0, 1, 0, 1, false);
			try {
				wait(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			drivetrain.setMotorSpeeds(0, 0, 0, 1, false);
			try {
				wait(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
