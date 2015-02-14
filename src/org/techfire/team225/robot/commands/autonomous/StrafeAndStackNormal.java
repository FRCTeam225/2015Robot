package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.CenterGyro;
import org.techfire.team225.robot.commands.drivetrain.DriveToBin;
import org.techfire.team225.robot.commands.drivetrain.DriveXDistance;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.StrafeUntilSee;
import org.techfire.team225.robot.commands.drivetrain.WaitForArmAndHoldPosition;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.HalfGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StrafeAndStackNormal extends CommandGroup{
	private String name = "Strafe & Stack - normal";
	public StrafeAndStackNormal() {
		addSequential(new ResetEncoders());
		addSequential(new CenterGyro());
		
		addSequential(new HalfGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new WaitForArm());
		addSequential(new StrafeUntilSee(true));
		addSequential(new DriveToBin());
		addSequential(new SetArm(Arm.firstPosition - 50));
		addSequential(new WaitForArmAndHoldPosition());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(150,0));
		
		
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new DriveYDistance(30,0));
		addSequential(new StrafeUntilSee(true));
		addSequential(new DriveToBin());
		addSequential(new SetArm(Arm.firstPosition - 50));
		addSequential(new WaitForArmAndHoldPosition());
		addSequential(new OpenGripper());
		
		// backup and grab stack
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-50,0));
		
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new DriveYDistance(20,0));
		
		addSequential(new CloseGripper());
		addSequential(new SetArm(Arm.floorPosition+ 50));
		addSequential(new DriveYDistance(-150,0));
		addSequential(new SetArm(Arm.floorPosition));
		
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		
		
		
	}

	public String toString() {
		return name;
	}
}
