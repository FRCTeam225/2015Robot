package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.SimplePID;
import org.techfire.team225.robot.commands.arm.WaitForArm;

public class WaitForArmAndHoldPosition extends WaitForArm {
	
	public SimplePID pidY = new SimplePID(0.04, 0.001, 0);
	
	public WaitForArmAndHoldPosition()
	{
		requires(drivetrain);
	}
	
	public void initialize()
	{
		pidY.setTarget(drivetrain.getAverageForwardEncoders());
	}
	
	public void execute()
	{
		super.execute();
		drivetrain.setMotorSpeeds(0, -pidY.calculate(drivetrain.getAverageForwardEncoders()), 0, 1, false);	
	}

}
