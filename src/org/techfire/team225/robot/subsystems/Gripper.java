package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	Solenoid gripperSolenoidLeft;
	Solenoid gripperSolenoidRight;
	Solenoid forwardCangrabberSolenoid;
	String state = "open";

	public Gripper() {
		gripperSolenoidLeft = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_LEFT"));
		gripperSolenoidRight = new Solenoid(ConstantsProvider.get("GRIPPER_SOLENOID_RIGHT"));
		forwardCangrabberSolenoid = new Solenoid(ConstantsProvider.get("FORWARD_CANGRABBER_SOLENOID"));
	}
	
	public void setGripper(boolean left, boolean right) {
		gripperSolenoidLeft.set(left);
		gripperSolenoidRight.set(right);
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void SetCangrab(boolean set) {
		forwardCangrabberSolenoid.set(set);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
