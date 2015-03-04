package org.techfire.team225.robot.commands.drivetrain;

import org.techfire.team225.robot.CommandBase;

public class WaitForBin extends CommandBase {

  public WaitForBin()
  {
    requires(arm);
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return drivetrain.atBin();
  }

  @Override
  protected void end() {
  }

}
