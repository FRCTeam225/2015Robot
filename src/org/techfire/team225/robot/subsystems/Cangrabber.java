package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Cangrabber extends Subsystem {

	Solenoid cangrabberSolenoid;
	
	public Cangrabber() {
		cangrabberSolenoid = new Solenoid(ConstantsProvider.get("FORWARD_CANGRABBER_SOLENOID"));
	}
	
	public void SetCangrab(boolean set) {
		cangrabberSolenoid.set(set);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
