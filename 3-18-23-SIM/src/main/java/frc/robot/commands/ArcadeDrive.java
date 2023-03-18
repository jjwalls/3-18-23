// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.OI.AxisType;

public class ArcadeDrive extends CommandBase {
  Drivetrain m_drivetrain;
  OI m_oi;
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Drivetrain drivetrain, OI oi) {
    m_drivetrain = drivetrain;
    m_oi = oi;
    addRequirements(drivetrain, oi);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = m_oi.getAxis(AxisType.RightStickX);
    double y = m_oi.getAxis(AxisType.LeftStickY);
    // Apply deadband to joystick inputs
    if (Math.abs(x) < 0.05) {
      x = 0;
    }
    if (Math.abs(y) < 0.05) {
      y = 0;
    }
    m_drivetrain.setMotorsXY(x, y);
    //m_drivetrain.setMotorsXY(m_oi.getAxis(AxisType.LeftStickX), m_oi.getAxis(AxisType.LeftStickY));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
