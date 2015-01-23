package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class DriveRightUntilSee extends CommandBase {

	private DigitalInput photoLeft = Robot.photoLeft;
	private DigitalInput photoRight = Robot.photoRight;
	
	private boolean isFinished = false;
	private boolean isFirstDone = false;
	private boolean isSecondDone = false;
	
	public DriveRightUntilSee() {
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
		
		if (isSecondDone) {
			if (!photoLeft.get() || !photoRight.get()) {
				drivetrain.setMotorSpeeds(0, -0.25, 0);
			} else {
				drivetrain.setMotorSpeeds(0, 0, 0);
				isFinished = true;
			}
		} else if (isFirstDone) {
			if (!photoLeft.get() || !photoRight.get()) {
				drivetrain.setMotorSpeeds(0, -0.5, 0);
			} else {
				isSecondDone = true;
				try {
					wait(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (!photoLeft.get() || !photoRight.get()) {
			drivetrain.setMotorSpeeds(0, 0.75, 0);
		} else if (photoLeft.get() && photoRight.get()){
			isFirstDone = true;
			try {
				wait(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		drivetrain.setMotorSpeeds(0, 0, 0);
	}

}
