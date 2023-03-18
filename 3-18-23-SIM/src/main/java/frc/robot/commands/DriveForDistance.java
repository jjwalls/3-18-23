// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.PIDConstants;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveForDistance extends PIDCommand {

  Drivetrain m_drive;
  double m_distance; 

  /** Creates a new DriveForDistance. */
  public DriveForDistance(Drivetrain drive, double distanceInInches, boolean reversed, double speed) {
    super(
        // The controller that the command will use
        new PIDController(PIDConstants.kP_drive, PIDConstants.kI_drive, PIDConstants.kD_drive),
        
        // This should return the measurement
        () -> drive.getEncoderValues()[0] * 2,
        // This should return the setpoint (can also be a constant)
        () -> (reversed ? -1 : 1) * (distanceInInches),
        // This uses the output
        output -> {
         // double turn = PIDConstants.kP_turn * (drive.getHeading());
          double leftSpeed = (output) * speed;
          double rightSpeed = (output) * speed;

          if(output >= 0.6 * speed)
          {
            drive.setMotors(0.6 * leftSpeed, -0.6 * rightSpeed);
            //System.out.println("normalized");
          }
          else if(output <= -0.6 * speed)
          {
            drive.setMotors(-0.6 * leftSpeed, 0.6 * rightSpeed);
            //System.out.println("normalized");
          }
          else
          {
            drive.setMotors(output * leftSpeed, -output * rightSpeed);
            //System.out.println("not normalized");
          }
        });
    
    m_drive = drive;
    m_distance = distanceInInches;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  @Override
  public void initialize(){
    m_drive.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(m_drive.getEncoderValues()[0]);
    return (m_drive.getEncoderValues()[0] <= (m_distance/2) + 3 && m_drive.getEncoderValues()[0] >= (m_distance/2) - 3);
  }
}
