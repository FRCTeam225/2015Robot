package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem {

	public DigitalInput photoLeft = new DigitalInput(PortMap.PHOTO_SENSOR_LEFT);
    public DigitalInput photoRight = new DigitalInput(PortMap.PHOTO_SENSOR_RIGHT);
    
    public boolean getLeftEye() {
    	return photoLeft.get();
    }
    
    public boolean getRightEye() {
    	return photoRight.get();
    }
	
	@Override
	protected void initDefaultCommand() {}

}
