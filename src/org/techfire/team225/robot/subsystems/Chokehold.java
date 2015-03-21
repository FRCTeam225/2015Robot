package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chokehold extends Subsystem {

	Solenoid actuationSolenoid = new Solenoid(ConstantsProvider.get("CHOKEHOLD_SOLENOID"));
	
	public void set(boolean set) {
		actuationSolenoid.set(set);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
