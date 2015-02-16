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

public class StrafeAndStack extends CommandGroup{
	private String name = "Strafe & Stack";
	
	public StrafeAndStack() {
		// init
		addSequential(new ResetEncoders());
		addSequential(new CenterGyro());
		
		// first tote
		addSequential(new HalfGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new WaitForArm());
		
		addSequential(new StrafeUntilSee());
		
		// second tote
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-250, 0));
		addSequential(new SetArm(Arm.firstPosition - 50));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-150, 0));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(100,0));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition));
		
		addSequential(new StrafeUntilSee());
		
		// third tote
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-250, 0));
		addSequential(new SetArm(Arm.firstPosition - 50));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-150, 0));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(100,0));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition));
		
		// pull totes into scoring area
		addSequential(new SetArm(Arm.floorPosition + 200));
		addSequential(new DriveYDistance(-400,0));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new OpenGripper());
		addSequential(new WaitForArm());	
	}

	public String toString() {
		return name;
	}
}
