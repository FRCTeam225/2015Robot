package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.SimplePID;
import org.techfire.team225.robot.commands.arm.ArmControl;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	Victor victorForward = new Victor(PortMap.get("ARM_FORWARD_MOTOR"));
	Victor victorBack = new Victor(PortMap.get("ARM_BACK_MOTOR"));
	AnalogInput pot = new AnalogInput(PortMap.get("ARM_POT"));
	Solenoid wingsSolenoid = new Solenoid(PortMap.get("WINGS_SOLENOID"));
	public boolean potOverride = false;
	
	public static int floorPosition;
	public static int firstPosition;
	public static int preContainerPosition;
	public static int postContainerPosition;
	public static int topPosition;

	public Arm() {
		floorPosition = PortMap.get("FLOOR_POSITION");
		firstPosition = PortMap.get("FIRST_POSITION");
		preContainerPosition = PortMap.get("PRE_CONTAINER_POSITION");
		postContainerPosition = PortMap.get("POST_CONTAINER_POSITION");
		topPosition = PortMap.get("TOP_POSITION");
	}
	
	
	SimplePID pid = new SimplePID(0.006, 0, 0);
	
	public int getPosition()
	{
		return pot.getValue();
	}
	
	public void setTarget(int position)
	{
		pid.setTarget(position);
	}
	
	public double getError() {
		return pid.getError();
	}
	
	public void setMotorSpeed(double speed) {
		if (potOverride) {
			if (speed > 0) {
				victorForward.set(speed);
				victorBack.set(-speed);
			} else if (speed < 0) {
				victorForward.set(speed);
				victorBack.set(-speed);
			}
		// the arm will overshoot the set pot value by about 10 to 20
		} else if (getPosition() >= floorPosition && speed > 0) {
			victorForward.set(speed * 0.75);
			victorBack.set(-speed * 0.75);
		} else if (getPosition() <= topPosition && speed < 0) {
			victorForward.set(speed);
			victorBack.set(-speed);
		} else {
			victorForward.set(0);
			victorBack.set(0);
		}
	}
	
	public void setWings(boolean set) {
		wingsSolenoid.set(set);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmControl());
	}

	
	public void updatePID()
	{
		double calc = pid.calculate(getPosition());
		setMotorSpeed(-calc);
		System.out.println("PID Output is "+calc);
		System.out.println("Position is "+getPosition());
		System.out.println("Error is "+pid.getError());
		System.out.println("Target is "+pid.getTarget());
	}
}
