package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class StrafeUntilSee extends CommandBase {
	
	private boolean isFinished = false;
	private double speed;
	
	public StrafeUntilSee(double  speed) {
		requires(mecanumDrivetrain);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		if (!mecanumDrivetrain.getLeftEye() || !mecanumDrivetrain.getRightEye()) {
			mecanumDrivetrain.setMotorSpeeds(speed, 0, 0, false);
		} else if (mecanumDrivetrain.getLeftEye() && mecanumDrivetrain.getRightEye()){
			mecanumDrivetrain.setMotorSpeeds(0, 0, 0, false);
			isFinished = true;
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
