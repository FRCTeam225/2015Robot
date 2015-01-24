package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.CommandBase;

import edu.wpi.first.wpilibj.DigitalInput;

public class Strafe extends CommandBase {

	private DigitalInput photoLeft = mecanumDrivetrain.photoLeft;
	private DigitalInput photoRight = mecanumDrivetrain.photoRight;
	
	private boolean isFinished = false;
	
	public Strafe() {
		requires(mecanumDrivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		if (!photoLeft.get() || !photoRight.get()) {
			mecanumDrivetrain.setMotorSpeeds(1, 0, 0, false);
		} else if (photoLeft.get() && photoRight.get()){
			mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
	}

}
