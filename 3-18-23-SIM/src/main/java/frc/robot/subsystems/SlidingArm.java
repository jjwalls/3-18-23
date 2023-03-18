package frc.robot.subsystems;
//import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SlidingArm extends SubsystemBase {
   /* 
   TalonSRX -> CANSparkMax; 2 motors -> 1; encoder -> relative encoder

   private TalonSRX m_SlidingArmLeft = new TalonSRX(5);
    private TalonSRX m_SlidingArmRight = new TalonSRX(6);
    private Encoder m_Encoder = new Encoder(0,1);
  */
  private CANSparkMax m_SlidingArm = new CANSparkMax(5, MotorType.kBrushless);
    private final RelativeEncoder m_Encoder = m_SlidingArm.getEncoder();
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
}  // added position of arms as a parameter for preset methods
  public void slidingArmForward(double speed, int position){
   // m_SlidingArmLeft.set(TalonSRXControlMode.PercentOutput, speed);
   // m_SlidingArmRight.set(TalonSRXControlMode.PercentOutput, -speed);
   
   m_SlidingArm.set(speed);
   // added encoder check if sliding arm has reached the desired preset
    if (m_Encoder.getPosition() >= position)
      slidingArmStop();
    }

    //manual
    public void slidingArmForward(double speed){
      m_SlidingArm.set(speed);
    }

   public void slidingArmReverse(double speed, int position){
    // m_SlidingArmLeft.set(TalonSRXControlMode.PercentOutput, -speed);
    // m_SlidingArmRight.set(TalonSRXControlMode.PercentOutput, speed);
    m_SlidingArm.set(-speed);
    if (m_Encoder.getPosition() <= position)
      slidingArmStop();
    }

    //manual
    public void slidingArmReverse(double speed){
      m_SlidingArm.set(-speed);
    }
    public void slidingArmStop(){
        //m_SlidingArmLeft.set(TalonSRXControlMode.PercentOutput, 0);
       // m_SlidingArmRight.set(TalonSRXControlMode.PercentOutput, 0);
       m_SlidingArm.set(0);
    }
    // float encoder return value -> double relative encoder return value
    public double getencoder(){
        return m_Encoder.getPosition();
        
    }

}

