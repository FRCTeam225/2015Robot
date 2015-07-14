package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.ProfiledDriveDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ProfiledSideStack extends CommandGroup {

	
	double turnAngle = 33.5;
	double returnAngle = -1;
	
	public ProfiledSideStack() {
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.6));
		addSequential(new SetArm(Arm.firstPosition-100));
		addSequential(new WaitCommand(0.2));
		addSequential(profiledDriveFaster(-1, 0));
		//addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(turnAngle+0.7));
		addSequential(new SetArm(Arm.firstPosition+50));
		//addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(profiledDriveFaster(6.30, turnAngle+1.5));
		//addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(returnAngle+1.5));
		
		
		//addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		//addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(profiledDrive(0.5, returnAngle+1.2));
		//addSequential(new WaitCommand(0.5));
		addSequential(new CloseGripper());
		
		
		addSequential(new WaitCommand(0.3));
		//addSequential(profiledTurn(15).chainableSetTimeout(0.5));
		////addSequential(profiledTurn(-15).chainableSetTimeout(0.5));
		//addSequential(profiledTurn(-7.5).chainableSetTimeout(0.5));
		//addSequential(new WaitCommand(0.5));
		
		//addSequential(new TurnTo(-12).chainableSetTimeout(0.5));
		//addSequential(new TurnTo(-7).chainableSetTimeout(0.5));
		//addSequential(new SetArm(Arm.firstPosition-100));
		//addSequential(new WaitCommand(0.2));
		//addSequential(new ResetEncoders());
		//addSequential(profiledDrive(-1.3387, -7));
		//addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(turnAngle+9.4));
		addSequential(new SetArm(Arm.firstPosition+50));
		
		addSequential(new ResetEncoders());
		addSequential(profiledDriveFaster(4, turnAngle+8)); // 1185
		//addSequential(new WaitCommand(0.5));
		addSequential(new TurnTo(returnAngle+5.1));
		//addSequential(new WaitCommand(0.5));
		addSequential(new SetArm(Arm.firstPosition-130));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitForArm());
		//addSequential(new WaitCommand(0.5));
		addSequential(new ResetEncoders());
		addSequential(profiledDrive(1, returnAngle+3));
		//addSequential(new WaitCommand(0.5));
		addSequential(new CloseGripper());
		addSequential(new WaitCommand(0.4));
		addSequential(new SetArm(Arm.floorPosition+80));
		addSequential(new TurnTo(turnAngle+45));
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new ResetEncoders());
		addSequential(profiledDriveZippy(8.0325, turnAngle+45));
		addSequential(new OpenGripper());
		addSequential(new ResetEncoders());
		addSequential(profiledDriveZippy(-0.89, turnAngle+45));
	
	}
	
	ProfiledDriveDistance profiledDrive(double distance, double theta)
	{
		return new ProfiledDriveDistance(distance, 9, 5.2, theta);
	}
	
	ProfiledDriveDistance profiledDriveFaster(double distance, double theta)
	{
		return new ProfiledDriveDistance(distance, 9.8, 5.5, theta);
	}
	
	
	ProfiledDriveDistance profiledDriveZippy(double distance, double theta)
	{
		return new ProfiledDriveDistance(distance, 10, 6, theta);
	}

}
