package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawShiftLeft extends CommandBase
    {
        Claw m_Claw;
        double m_extendSpeed;
   public ClawShiftLeft(Claw Claw, double speed){
        m_Claw = Claw;
        m_extendSpeed = speed;
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      m_Claw.clawShiftLeft(m_extendSpeed);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_Claw.clawStop();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }  

}
