package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	Solenoid gripperSolenoidLeft;
	Solenoid gripperSolenoidRight;

	public Gripper() {
		gripperSolenoidLeft = new Solenoid(PortMap.get("GRIPPER_SOLENOID_LEFT"));
		gripperSolenoidRight = new Solenoid(PortMap.get("GRIPPER_SOLENOID_RIGHT"));
	}
	
	/**
	 * 0 = open;
	 * 1 = half;
	 * 2 = closed;
	 * @param set
	 */
	public void setGripper(int set) {
		switch (set) {
			case 0: // open
				gripperSolenoidLeft.set(false);
				gripperSolenoidRight.set(false);
				break;
			case 1: // half
				gripperSolenoidLeft.set(false);
				gripperSolenoidRight.set(true);
				break;
			case 2: // close
				gripperSolenoidLeft.set(true);
				gripperSolenoidRight.set(true);
				break;
			default:
				break;
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
