package org.techfire.team225.robot.commands.chokehold;

import org.techfire.team225.robot.CommandBase;

public class SetChokehold extends CommandBase {

	double rightSpeed, leftSpeed;
	boolean set;
	
	public SetChokehold(boolean set) {
		requires(chokehold);
		this.set = set;
	}
	
	public SetChokehold(double rightSpeed, double leftSpeed) {
		requires(chokehold);
		this.rightSpeed = rightSpeed;
		this.leftSpeed = rightSpeed;
	}
	
	@Override
	protected void initialize() {
		/*if (rightSpeed < 0 && leftSpeed < 0) {
			chokehold.setRetainer(true);
			rightSpeed = 0;
			leftSpeed = 0;
		} else {
			chokehold.setRetainer(false);
		}
		
		chokehold.setRightMotor(rightSpeed);
		chokehold.setLeftMotor(leftSpeed);*/
		chokehold.set(set);
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
