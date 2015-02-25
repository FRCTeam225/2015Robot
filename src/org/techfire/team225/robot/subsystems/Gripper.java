package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	Solenoid gripperSolenoidLeft;
	Solenoid gripperSolenoidRight;
	Solenoid containerSolenoid;

	public Gripper() {
		gripperSolenoidLeft = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_LEFT"));
		gripperSolenoidRight = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_RIGHT"));
		containerSolenoid = new Solenoid(ConstantsProvider.get("CONTAINER_SOLENOID"));
	}
	
	public void setGripper(boolean left, boolean right) {
		gripperSolenoidLeft.set(left);
		gripperSolenoidRight.set(right);
	}
	
	public void setContainerHold(boolean set) {
		containerSolenoid.set(set);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
