package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideStack extends CommandGroup {
String name = new String("Side Stack");
	
	
	double turnAngle = 32.5;
	
	public SideStack() {
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new WaitCommand(0.2));
		addSequential(new DriveYDistance(-275));
		addSequential(new WaitCommand(1));
		addSequential(new TurnTo(turnAngle));
		addSequential(new WaitCommand(1));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1140));
		addSequential(new WaitCommand(1));
		addSequential(new TurnTo(5));
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitCommand(1));
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new WaitCommand(1));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(300));
		addSequential(new WaitCommand(1));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(1));
		addSequential(new TurnTo(15).chainableSetTimeout(0.5));
		addSequential(new TurnTo(-15).chainableSetTimeout(0.5));
		addSequential(new TurnTo(0).chainableSetTimeout(0.5));
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-300));
		addSequential(new WaitCommand(1));
		addSequential(new TurnTo(turnAngle));
		addSequential(new SetArm(Arm.firstPosition+50));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1175));
		addSequential(new WaitCommand(1));
		addSequential(new TurnTo(4));
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitCommand(1));
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new WaitCommand(1));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(150));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(140, turnAngle));
		addSequential(new WaitCommand(1));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.floorPosition+100));
		addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(turnAngle+90));
		addSequential(new DriveYDistance(1200));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new OpenGripper());
	}
	
	public String toString() {
		return name;
	}
}
