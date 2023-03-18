package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;


public class MoveServoToAngle extends CommandBase {
Claw m_claw;
double m_angle;
boolean finished = false;

  /** Creates a new MoveServo. */
  public MoveServoToAngle(Claw claw, double angle) {
    m_claw = claw;
    m_angle = angle;
    addRequirements(claw);
  }

  @Override
  public void initialize() {
    m_claw.servoSetAngle(m_angle);
    finished = true;
  }

  @Override
  public void execute() {
    // Read the value of the joystick axis that controls the servo angle.
    // Map the joystick value to a servo angle.
    // Set the angle of the servo.
   // m_claw.servoSetAngle(angle);
    // Triangle button is pressed, set the angle of the servo to m_angle
    // Triangle button is not pressed, set the angle of the servo to 0
  // m_claw.servoSetAngle(m_angle);
  
   // 
  }

  @Override
  public void end(boolean interrupted) {
    // This method is empty, as we don't need to do anything when the command ends.
  }

  @Override
  public boolean isFinished() {
    // This command never finishes on its own, so it will continue running until it is interrupted.
    return finished;
  }
}
