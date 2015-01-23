package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OmniDrivetrain extends Subsystem {
	
	Victor[] victorLeft = new Victor[2];
	Victor[] victorRight = new Victor[2];
	Victor victorFront;
	Victor victorBack;
	
	public OmniDrivetrain() {
		victorLeft[0] = new Victor(PortMap.LEFT_FORWARD_MOTOR);
		victorLeft[1] = new Victor(PortMap.LEFT_BACK_MOTOR);
		victorRight[0] = new Victor(PortMap.RIGHT_FORWARD_MOTOR);
		victorRight[1] = new Victor(PortMap.RIGHT_BACK_MOTOR);
		victorFront = new Victor(PortMap.FRONT_MOTOR);
		victorBack = new Victor(PortMap.BACK_MOTOR);
	}
	
	public void setMotorSpeeds(double ySpeed, double xSpeed, double rotation) {

		
		double rate = 1;
		if (Math.abs(rotation) > 0.1)
		{
			for (Victor v : victorLeft) {
				v.set(-rotation*rate);
			}
			for (Victor v : victorRight) {
				v.set(-rotation*rate);
			}
			
			victorFront.set(-rotation*rate);
			victorBack.set(-rotation*rate);
		}
		else
		{
			for (Victor v : victorLeft) {
				v.set(ySpeed*rate);
			}
			for (Victor v : victorRight) {
				v.set(-ySpeed*rate);
			}
			victorFront.set(-xSpeed*rate);
			victorBack.set(xSpeed*rate);
		}
	}
	
	public void setLeftRight(double l, double r)
	{
		for ( Victor v : victorLeft )
			v.set(l);
		for ( Victor v : victorRight )
			v.set(r);
	}

	@Override
	protected void initDefaultCommand()  {
		setDefaultCommand(new JoystickDrive());
	}
}
