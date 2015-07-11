package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.CommandBase;
import org.techfire.team225.robot.ConstantsProvider;
import org.techfire.team225.robot.SimplePID;
import org.techfire.team225.robot.commands.arm.ArmControl;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	Victor victorForward = new Victor(ConstantsProvider.get("ARM_FORWARD_MOTOR"));
	Victor victorBack = new Victor(ConstantsProvider.get("ARM_BACK_MOTOR"));
	AnalogInput pot = new AnalogInput(ConstantsProvider.get("ARM_POT"));
	public boolean potOverride = false;
		
	public static int floorPosition;
	public static int firstPosition;
	public static int secondPosition;
	public static int topPosition;
	public static int postContainerPosition;
	public static int preContainerPosition;
	public static int pickupContainerPosition;
	public static int forwardCanburglarPosition;

	public Arm() {
		floorPosition = ConstantsProvider.get("FLOOR_POSITION");
		firstPosition = ConstantsProvider.get("FIRST_POSITION");
		secondPosition = ConstantsProvider.get("SECOND_POSITION");
		topPosition = ConstantsProvider.get("TOP_POSITION");
		postContainerPosition = ConstantsProvider.get("POST_CONTAINER_POSITION");
		preContainerPosition = ConstantsProvider.get("PRE_CONTAINER_POSITION");
		pickupContainerPosition = ConstantsProvider.get("PICKUP_CONTAINER_POSITION");
		forwardCanburglarPosition = ConstantsProvider.get("FORWARD_CANBURGLAR_POSITION");
		
		//victorForward.setSafetyEnabled(true);
		//victorBack.setSafetyEnabled(true);
	}
	
	
	private SimplePID pid = new SimplePID(0.008, 0, 0);
	
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
			victorForward.set(speed); // formerly restricted to 75% speed
			victorBack.set(-speed); // formerly restricted to 75% speed
		} else if (getPosition() <= topPosition && speed < 0) {
			victorForward.set(speed);
			victorBack.set(-speed);
		} else {
			victorForward.set(0);
			victorBack.set(0);
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmControl());
	}
	
	public void updatePID()
	{
		double calc = pid.calculate(getPosition());
		setMotorSpeed(-calc);
		/*System.out.println("PID Output is "+calc);
		System.out.println("Position is "+getPosition());
		System.out.println("Error is "+pid.getError());
		System.out.println("Target is "+pid.getTarget());*/
	}
}
