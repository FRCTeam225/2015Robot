package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;
import org.techfire.team225.robot.commands.chokehold.ChokeholdControl;
import org.techfire.team225.robot.commands.drivetrain.FireDrive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chokehold extends Subsystem {

	/*Victor rightMotor = new Victor(ConstantsProvider.get("CHOKEHOLD_MOTOR_RIGHT"));
	Victor leftMotor = new Victor(ConstantsProvider.get("CHOKEHOLD_MOTOR_LEFT"));
	Solenoid retainerSolenoid = new Solenoid(ConstantsProvider.get("CHOKEHOLD_RETAINER_SOLENOID"));
	
	public void setRightMotor(double speed) {
		rightMotor.set(-speed);
	}
	
	public void setLeftMotor(double speed) {
		leftMotor.set(speed);
	}
	
	public void setRetainer(boolean set) {
		retainerSolenoid.set(set);
	}*/
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ChokeholdControl());
	}

}
