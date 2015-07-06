package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.ConstantsProvider;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteHolder extends Subsystem {

	Solenoid activationSolenoid;
	
	public ToteHolder() {
		activationSolenoid = new Solenoid(ConstantsProvider.get("TOTE_HOLDER_SOLENOID"));
	}
	
	public void setHolder(boolean state) {
		activationSolenoid.set(state);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
