package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.drivetrain.TurnToNoStable;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideStackOldNewLoop extends CommandGroup {
	String name = new String("Side Stack old, with new loop");
	
	double turnAngle = 32.5;
	double returnAngle = 7.25;
	
	public SideStackOldNewLoop() {
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.6));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(new DriveYDistance(-275, 0));
		addSequential(new TurnToNoStable(turnAngle));
		addSequential(new SetArm(Arm.firstPosition));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1230, turnAngle));
		addSequential(new TurnTo(returnAngle));
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
		addSequential(new TurnTo(-12).chainableSetTimeout(0.5));
		addSequential(new TurnTo(-7).chainableSetTimeout(0.5));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-300));
		addSequential(new TurnToNoStable(turnAngle+3.5));
		addSequential(new SetArm(Arm.firstPosition+50));
		
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(1200, turnAngle+3));
		addSequential(new TurnTo(returnAngle-2));
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
		addSequential(new SetArm(Arm.floorPosition+50));
		addSequential(new WaitForArm());
		addSequential(new TurnTo(turnAngle+45, 0.75));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new DriveYDistance(1700));
		addSequential(new OpenGripper());
		addSequential(new ResetEncoders());
		addSequential(new DriveYDistance(-200));
	}
	
	public String toString() {
		return name;
	}
}
