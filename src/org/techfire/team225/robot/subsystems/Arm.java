package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.arm.ManualArmControl;

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
	public int firstPosition = 2400;
	public int floorPosition = 2270;
	public int preContainerPosition = 3100;
	public int postContainerPosition = 3200;
	
	PIDOutput outputGroup = new PIDOutput() {
		public void pidWrite(double output)
		{
			setMotorSpeed(output);
		}
	};
	
	public Arm()
	{
	}
	
	
	PIDController pid = new PIDController(0.2, 0, 0, pot, outputGroup);
	
	public void enablePID()
	{
		pid.enable();
	}
	
	public void disablePID()
	{
		pid.disable();
	}
	
	public int getPosition()
	{
		return pot.getValue();
	}
	
	public void setTarget(int position)
	{
		pid.setSetpoint(position);
	}
	
	public double getError() {
		return pid.getError();
	}
	
	public void setMotorSpeed(double speed) {
		if (potOverride) {
			if (speed > 0) {
				victorForward.set(speed * 0.75);
				victorBack.set(-speed * 0.75);
			} else if (speed < 0) {
				victorForward.set(speed);
				victorBack.set(-speed);
			}
		// the arm will overshoot the set pot value by about 10 to 20
		} else if (getPosition() >= 2275 && speed > 0) {
			victorForward.set(speed * 0.75);
			victorBack.set(-speed * 0.75);
		} else if (getPosition() <= 3420 && speed < 0) {
			victorForward.set(speed);
			victorBack.set(-speed);
		} else {
			victorForward.set(0);
			victorBack.set(0);
		}
	}
	
	public void toggleWings(boolean toggle) {
		wingsSolenoid.set(toggle);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualArmControl());
	}

}
