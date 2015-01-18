package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	Victor[] victorLeft;
	Victor[] victorRight;
	Victor victorFront;
	Victor victorBack;
	
	public Drivetrain() {
		victorLeft[0] = new Victor(PortMap.LEFT_FORWARD_MOTOR);
		victorLeft[1] = new Victor(PortMap.LEFT_BACK_MOTOR);
		victorRight[0] = new Victor(PortMap.RIGHT_FORWARD_MOTOR);
		victorRight[1] = new Victor(PortMap.RIGHT_BACK_MOTOR);
		victorFront = new Victor(PortMap.FRONT_MOTOR);
		victorBack = new Victor(PortMap.BACK_MOTOR);
	}
	
	public void setMotorSpeeds(double ySpeed, double xSpeed, double rotation) {
		if (Math.abs(rotation) > 0.1) {
			victorFront.set(0);
			victorBack.set(0);
			
			for (Victor v : victorLeft) {
				v.set(ySpeed);
			}
			for (Victor v : victorRight) {
				v.set(ySpeed);
			}
		} else {
			for (Victor v : victorLeft) {
				v.set(ySpeed);
			}
			for (Victor v : victorRight) {
				v.set(-ySpeed);
			}
			victorFront.set(xSpeed);
			victorBack.set(-xSpeed);
		}
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}
}
