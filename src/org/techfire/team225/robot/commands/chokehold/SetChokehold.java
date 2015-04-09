package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;

public class SetChokehold extends CommandBase {

	double rightSpeed, leftSpeed;
	
	public SetChokehold(double rightSpeed, double leftSpeed) {
		this.rightSpeed = rightSpeed;
		this.leftSpeed = rightSpeed;
	}
	
	@Override
	protected void initialize() {
		chokehold.setRightMotor(rightSpeed);
		chokehold.setLeftMotor(leftSpeed);
	}

	@Override
	protected void execute() {		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {		
	}

}
