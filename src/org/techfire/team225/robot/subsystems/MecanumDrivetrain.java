
package org.techfire.team225.robot.subsystems;

import org.techfire.team225.robot.PortMap;
import org.techfire.team225.robot.commands.drivetrain.MecanumDrive;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrivetrain extends Subsystem {

	
	public DigitalInput photoLeft;
    public DigitalInput photoRight;
    public DigitalInput photoBin;
    
    public BuiltInAccelerometer accelerometer;
    
    public Encoder encoderL;
    public Encoder encoderR;
    public Encoder encoderF;
    
    //GyroProvider gyro;
    Gyro gyro;
    
	Victor[] victorLeft = new Victor[2];
	Victor[] victorRight = new Victor[2];
	
	boolean pidEnabled = false;
	
	public MecanumDrivetrain() {
		 photoLeft = new DigitalInput(6);
	     photoRight = new DigitalInput(7);
	     photoBin = new DigitalInput(8);
	    
	     accelerometer  = new BuiltInAccelerometer();
	    
	     encoderL = new Encoder(PortMap.get("ENCODER_LEFT_A"), PortMap.get("ENCODER_LEFT_B"));
	     encoderR = new Encoder(PortMap.get("ENCODER_RIGHT_A"), PortMap.get("ENCODER_RIGHT_B"));
	     encoderF = new Encoder(PortMap.get("ENCODER_FOLLOW_A"), PortMap.get("ENCODER_FOLLOW_B"));
		
		
		
		victorLeft[0] = new Victor(PortMap.get("LEFT_FORWARD_MOTOR"));
		victorLeft[1] = new Victor(PortMap.get("LEFT_BACK_MOTOR"));
		victorRight[0] = new Victor(PortMap.get("RIGHT_FORWARD_MOTOR"));
		victorRight[1] = new Victor(PortMap.get("RIGHT_BACK_MOTOR"));
		
		//gyro = new GyroProvider();
		gyro = new Gyro(PortMap.get("GYRO"));
	}
	
	public boolean atBin()
	{
		return photoBin.get();
	}
	
	public void setMotorSpeeds(double xIn, double yIn, double rotation, double driveScale, boolean fieldCentric) {
		double x;
		double y;
		
		double gyroAngle = getGyro();
		
		if (fieldCentric) {
			gyroAngle = Math.toRadians(gyroAngle);
			x = xIn * Math.cos(gyroAngle) - yIn * Math.sin(gyroAngle);
			y = xIn * Math.sin(gyroAngle) + yIn * Math.cos(gyroAngle);
		} else {
			x = xIn;
			y = yIn;
		}
		
		victorLeft[0].set((x + y + rotation) * driveScale);
        victorRight[0].set(-(-x + y - rotation) * driveScale);
        victorLeft[1].set((-x + y + rotation) * driveScale);
        victorRight[1].set(-(x + y - rotation) * driveScale);
	}
	
	public void setPIDEnabled(boolean state)
	{
		this.pidEnabled = state;
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
	
	public int getAverageForwardEncoders() {
		return (encoderL.get() - encoderR.get())/2;
	}
	
	public void resetForwardEncoders() {
		encoderL.reset();
		encoderR.reset();
	}
	
	public void resetFollowerEncoder() {
		encoderF.reset();
	}
	
	public int getFollowEncoder() {
		return encoderF.get();
	}
	
	public double getGyro() {
		return gyro.getAngle();
	}
	
	public void resetAngle() {
		gyro.reset();
	}
	
	public double getAccelerometerY() {
		return accelerometer.getY();
	}

	@Override
	protected void initDefaultCommand()  {
		setDefaultCommand(new MecanumDrive());
	}
}
