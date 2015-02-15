package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.SimplePID;
import org.techfire.team225.robot.commands.arm.WaitForArm;

public class WaitForArmAndHoldPosition extends WaitForArm {
	
	public SimplePID pidY = new SimplePID(0.04, 0.001, 0);
	
	public WaitForArmAndHoldPosition()
	{
		requires(mecanumDrivetrain);
	}
	
	public void initialize()
	{
		pidY.setTarget(mecanumDrivetrain.getAverageForwardEncoders());
	}
	
	public void execute()
	{
		super.execute();
		mecanumDrivetrain.setMotorSpeeds(0, -pidY.calculate(mecanumDrivetrain.getAverageForwardEncoders()), 0, 1, false);	
	}

}
