package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	Solenoid gripperSolenoidLeft;
	Solenoid gripperSolenoidRight;
	DoubleSolenoid punchSolenoid;
	
	boolean gripperStatusLeft;
	boolean gripperStatusRight;
	boolean punchStatus;
	
	public Gripper() {
		gripperSolenoidLeft = new Solenoid(PortMap.GRIPPER_SOLENOID_LEFT);
		gripperSolenoidRight = new Solenoid(PortMap.GRIPPER_SOLENOID_RIGHT);
		punchSolenoid = new DoubleSolenoid(PortMap.PUNCH_SOLENOID_A, PortMap.PUNCH_SOLENOID_B);
	}
	
	public void toggleGripper() {
		gripperStatusLeft = !gripperStatusLeft;
		gripperStatusRight = gripperStatusLeft;
		
		gripperSolenoidLeft.set(gripperStatusLeft);
		gripperSolenoidRight.set(gripperStatusLeft);
	}
	
	public void singleToggle() {
		gripperStatusRight = !gripperStatusRight;
		
		gripperSolenoidRight.set(gripperStatusRight);
	}
	
	public void togglePunch() {
		Value v;
		punchStatus = !punchStatus;
		if (punchStatus) {
			v = Value.kForward;
		} else {
			v = Value.kReverse;
		}
		
		punchSolenoid.set(v);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
