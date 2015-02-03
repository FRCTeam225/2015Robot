package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	DoubleSolenoid gripperSolenoid;
	
	public Gripper() {
		gripperSolenoid = new DoubleSolenoid(PortMap.GRIPPER_SOLENOID_A, PortMap.GRIPPER_SOLENOID_B);
	}
	
	public void open() {
		gripperSolenoid.set(Value.kForward);
	}
	
	public void close() {
		gripperSolenoid.set(Value.kReverse);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
