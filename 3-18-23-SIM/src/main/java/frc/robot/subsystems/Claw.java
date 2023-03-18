package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//needs new port numbers
public class Claw extends SubsystemBase {
    private CANSparkMax m_ClawLeft = new CANSparkMax(6, MotorType.kBrushless);
    private CANSparkMax m_ClawRight = new CANSparkMax(8, MotorType.kBrushless);
    private Servo m_servo = new Servo(0);
   // private Encoder m_Encoder = new Encoder(0,1);
    public Claw() {
      m_ClawLeft.getEncoder().setPosition(0);
      m_ClawRight.getEncoder().setPosition(0);
    }

  @Override
  public void periodic() {
    // This method will be[] called once per scheduler run
    if(getEncoders()[0] <= 0){
      if(m_ClawLeft.get() < 0)
        m_ClawLeft.set(0);
    }

    if(getEncoders()[1] <= 0){
      if(m_ClawRight.get() < 0)
        m_ClawRight.set(0);
    }
  }
  public void clawClose(double speed){
    m_ClawLeft.set(-speed);
    m_ClawRight.set(-speed);
    }

   public void clawOpen(double speed){
     m_ClawLeft.set(speed);
     m_ClawRight.set(speed);
    }
    
    public void clawShiftRight(double speed){
        m_ClawLeft.set(speed);
        m_ClawRight.set(-speed);
       }

    public void clawShiftLeft(double speed){
        m_ClawLeft.set(-speed);
        m_ClawRight.set(speed);
       }

    public void clawStop(){
        m_ClawLeft.set(0);
        m_ClawRight.set(0);
    }
    public double[] getEncoders(){
      return new double[] {m_ClawLeft.getEncoder().getPosition(), m_ClawRight.getEncoder().getPosition()};
    }
    public double[] getCurrents(){
      return new double[] {m_ClawLeft.getOutputCurrent(), m_ClawRight.getOutputCurrent()};
    }
    public void servoSetAngle(double angle){
     m_servo.setAngle(angle);
    }
    public void servoSetSpeed(double speed){
   m_servo.setSpeed(speed);
    }
    public double servoGetAngle() {
      return m_servo.getAngle();
    }
    public void servoStop() {
      m_servo.set(0); // Set the servo to a neutral position
    }
    //public void moveServo(double angle) {
    //  m_servo.setAngle(angle);
    //}

}
