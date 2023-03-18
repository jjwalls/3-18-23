package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SlidingArm;

public class SlidingArmExtend extends CommandBase
{
    SlidingArm m_SlidingArm;
    double m_extendSpeed;

    public SlidingArmExtend(SlidingArm SlidingArm, double speed){
      m_SlidingArm = SlidingArm;
      m_extendSpeed = speed;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
     // m_SlidingArm.getEncoderPosition();
      m_SlidingArm.slidingArmForward(m_extendSpeed);
     // SmartDashboard.putNumber("Encoder Value: ",m_SlidingArm.getEncoderPosition());

    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_SlidingArm.slidingArmStop();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }  

}
