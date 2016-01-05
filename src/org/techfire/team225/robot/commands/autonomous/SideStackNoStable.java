package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.OldTurnTo;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnToNoStable;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideStackNoStable extends CommandGroup {
	String name = new String("Side Stack no stable");
	
	double turnAngle = 35.5;
	double returnAngle = 6.25;
	
	public SideStackNoStable() {
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.6));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(new DriveYDistance(-275, 0));
		addSequential(new TurnToNoStable(turnAngle));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1320, turnAngle));
		addSequential(new OldTurnTo(returnAngle-2));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(300, returnAngle-2));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.3));
		addSequential(new OldTurnTo(-12).chainableSetTimeout(0.5));
		addSequential(new OldTurnTo(-7).chainableSetTimeout(0.5));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-300));
		addSequential(new TurnToNoStable(turnAngle+3.5));
		addSequential(new SetArm(Arm.firstPosition+50));
		
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1480, turnAngle+3));
		addSequential(new OldTurnTo(returnAngle-4));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(300, returnAngle));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition+80));
		addSequential(new WaitForArm());
		addSequential(new OldTurnTo(turnAngle+45, 0.75));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new DriveYDistance(1800));
		addSequential(new OpenGripper());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-200));
	}
	
	public String toString() {
		return name;
	}
}
