package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	Solenoid gripperSolenoidLeft;
	Solenoid gripperSolenoidRight;

	public Gripper() {
		gripperSolenoidLeft = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_LEFT"));
		gripperSolenoidRight = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_RIGHT"));
	}
	
	public void setGripper(boolean left, boolean right) {
		gripperSolenoidLeft.set(left);
		gripperSolenoidRight.set(right);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}
