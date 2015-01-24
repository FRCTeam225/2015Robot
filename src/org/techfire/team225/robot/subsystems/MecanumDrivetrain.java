package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.MecanumDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrivetrain extends Subsystem {
	
	Victor[] victorLeft = new Victor[2];
	Victor[] victorRight = new Victor[2];
	
	public MecanumDrivetrain() {
		victorLeft[0] = new Victor(PortMap.LEFT_FORWARD_MOTOR);
		victorLeft[1] = new Victor(PortMap.LEFT_BACK_MOTOR);
		victorRight[0] = new Victor(PortMap.RIGHT_FORWARD_MOTOR);
		victorRight[1] = new Victor(PortMap.RIGHT_BACK_MOTOR);
	}
	
	public void setMotorSpeeds(double[] diagonal1_3, double[] diagonal2_4, double rotation) {

		if (Math.abs(rotation) > 0.1) {
			victorRight[0].set(rotation); // I
			victorLeft[0].set(rotation); // II
			victorLeft[1].set(rotation); // III
			victorRight[1].set(rotation); // IV
		} else {
			victorRight[0].set(diagonal1_3[0]); // I
			victorLeft[0].set(-diagonal2_4[0]); // II
			victorLeft[1].set(-diagonal1_3[1]); // III
			victorRight[1].set(diagonal2_4[1]); // IV
		}
	}

	@Override
	protected void initDefaultCommand()  {
		setDefaultCommand(new MecanumDrive());
	}
}
