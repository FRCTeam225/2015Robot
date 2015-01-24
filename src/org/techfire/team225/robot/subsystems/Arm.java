package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.ManualArmControl;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	Victor victorForward = new Victor(PortMap.ARM_FORWARD);
	Victor victorBack = new Victor(PortMap.ARM_BACK);
	AnalogInput pot = new AnalogInput(PortMap.ARM_POT);
	PIDOutput outputGroup = new PIDOutput() {
		public void pidWrite(double output)
		{
			setMotorSpeed(output);
		}
	};
	
	
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
		victorForward.set(speed);
		victorBack.set(-speed);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualArmControl());
	}

}
