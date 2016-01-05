package org.techfire.team225.robot.commands.autonomous;

import org.techfire.team225.robot.commands.arm.SetArm;
import org.techfire.team225.robot.commands.arm.WaitForArm;
import org.techfire.team225.robot.commands.drivetrain.DriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.OldTurnTo;
import org.techfire.team225.robot.commands.drivetrain.ProfiledDriveDistance;
import org.techfire.team225.robot.commands.drivetrain.ResetEncoders;
import org.techfire.team225.robot.commands.drivetrain.SmallDriveYDistance;
import org.techfire.team225.robot.commands.drivetrain.TurnTo;
import org.techfire.team225.robot.commands.gripper.CloseGripper;
import org.techfire.team225.robot.commands.gripper.OpenGripper;
import org.techfire.team225.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

@SuppressWarnings("unused")
public class ForwardCanburglarAuton extends CommandGroup {
	private String name = "Forward Canburglar Auton";
	
	// CODE RELEASE NOTE: The forward cangrabber system (those little "wings" that flung out
	// from our gripper at IRI) has been removed from the code so that the code best reflects
	// the final robot that we ended the season with. The code for that system was as simple
	// as one might except, consisting of a subsystem and one command that set the wings to
	// open or closed. However, I have left this autonomous program here in case anybody is
	// interested in the autonomous we ran at IRI.
	public ForwardCanburglarAuton() {
		/*addSequential(new SetArm(Arm.forwardCanburglarPosition));
		addSequential(new CloseGripper());
		addSequential(new SetCangrabber(true));
		addSequential(new ResetEncoders());
		addSequential(new ProfiledDriveDistance(3.25, 8, 4, 0).chainableSetTimeout(2.5));
		addSequential(new WaitForArm());
		addSequential(new OpenGripper());
		addSequential(new WaitCommand(1));
		addSequential(new SetArm(Arm.topPosition));
		addSequential(new WaitCommand(1));
		addSequential(new ResetEncoders());
		addSequential(new ProfiledDriveDistance(-5.0, 8, 3, 0));
		addSequential(new OldTurnTo(160, 0.45));
		addSequential(new WaitCommand(0.75));
		addSequential(new ResetEncoders());
		addSequential(new SetArm(Arm.floorPosition));
		addSequential(new WaitCommand(1));
		addSequential(new CloseGripper());
		addSequential(new WaitForArm());
		addSequential(new SetCangrabber(false));
		addSequential(new OpenGripper());*/
	}
	
	public String toString() {
		return name;
	}
}
