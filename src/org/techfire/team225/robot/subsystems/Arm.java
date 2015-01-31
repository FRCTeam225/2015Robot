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

	Victor victorForward = new Victor(PortMap.ARM_FORWARD_MOTOR);
	Victor victorBack = new Victor(PortMap.ARM_BACK_MOTOR);
	AnalogInput pot = new AnalogInput(PortMap.ARM_POT);
	Solenoid armSolenoid = new Solenoid(PortMap.ARM_SOLENOID);
	
	PIDOutput outputGroup = new PIDOutput() {
		public void pidWrite(double output)
		{
			setMotorSpeed(output);
		}
	};
	
	public Arm()
	{
	}
	
	
	PIDController pid = new PIDController(0, 0, 0, pot, outputGroup);
	
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
	
	public void setMotorSpeed(double speed) {
		if (getPosition() >= 1420 && speed > 0) {
			victorForward.set(speed);
			victorBack.set(-speed);
		} else if (getPosition() <= 2402 && speed < 0) {
			victorForward.set(speed);
			victorBack.set(-speed);
		} else {
			victorForward.set(0);
			victorBack.set(0);
		}
	}
	
	public void toggleArm(boolean tilt) {
		armSolenoid.set(tilt);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualArmControl());
	}

}
