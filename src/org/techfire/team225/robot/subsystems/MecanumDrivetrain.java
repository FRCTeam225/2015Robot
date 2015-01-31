package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.MecanumDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrivetrain extends Subsystem {
	
	public Gyro gyro = new Gyro(PortMap.GYRO);
	public DigitalInput photoLeft = new DigitalInput(PortMap.PHOTO_SENSOR_LEFT);
    public DigitalInput photoRight = new DigitalInput(PortMap.PHOTO_SENSOR_RIGHT);
    
    public Encoder encoderL = new Encoder(PortMap.ENCODER_LEFT_A, PortMap.ENCODER_LEFT_B);
    public Encoder encoderR = new Encoder(PortMap.ENCODER_RIGHT_A, PortMap.ENCODER_RIGHT_B);
    public Encoder encoderF = new Encoder(PortMap.ENCODER_FOLLOW_A, PortMap.ENCODER_FOLLOW_B);
    
	Victor[] victorLeft = new Victor[2];
	Victor[] victorRight = new Victor[2];
	
	public MecanumDrivetrain() {
		victorLeft[0] = new Victor(PortMap.LEFT_FORWARD_MOTOR);
		victorLeft[1] = new Victor(PortMap.LEFT_BACK_MOTOR);
		victorRight[0] = new Victor(PortMap.RIGHT_FORWARD_MOTOR);
		victorRight[1] = new Victor(PortMap.RIGHT_BACK_MOTOR);
	}
	
	public void setMotorSpeeds(double xIn, double yIn, double rotation, boolean fieldCentric) {
		double x;
		double y;
		
		if (fieldCentric) {
			double gyroAngle = gyro.getAngle();
			gyroAngle = Math.toRadians(gyroAngle);
			x = xIn * Math.cos(gyroAngle) - yIn * Math.sin(gyroAngle);
			y = xIn * Math.sin(gyroAngle) + yIn * Math.cos(gyroAngle);
		} else {
			x = xIn;
			y = yIn;
		}
		
		victorLeft[0].set(x + y + rotation);
        victorRight[0].set(-(-x + y - rotation));
        victorLeft[1].set(-x + y + rotation);
        victorRight[1].set(-(x + y - rotation));
	}
	
	public boolean getRightEye() {
		return photoRight.get();
	}
	
	public boolean getLeftEye() {
		return photoLeft.get();
	}
	
	public int getLeftEncoder() {
		return encoderL.get();
	}
	
	public int getRightEncoder() {
		return -encoderR.get();
	}
	
	public int getFollowEncoder() {
		return encoderF.get();
	}

	@Override
	protected void initDefaultCommand()  {
		setDefaultCommand(new MecanumDrive());
	}
}
