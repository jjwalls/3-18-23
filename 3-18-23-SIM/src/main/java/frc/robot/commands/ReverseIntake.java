package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ReverseIntake extends CommandBase
{
    Intake m_Intake;
    double m_speed;
    public ReverseIntake(Intake intake, double speed){
        m_Intake = intake;
        m_speed = speed;
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_Intake.rollerBackward(m_speed);

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_Intake.rollerStop();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }  

}

