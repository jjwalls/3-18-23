// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.Pigeon2;
//import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drivetrain extends SubsystemBase {
  //TalonSRX m_Right = new TalonSRX(0); 
  //TalonSRX m_Left = new TalonSRX(1);

  //remember to update these to 4 and 2  !!
  CANSparkMax m_Right_Front = new CANSparkMax(2, MotorType.kBrushless); 
  CANSparkMax m_Right_Rear = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax m_Left_Front = new CANSparkMax(4, MotorType.kBrushless);
  CANSparkMax m_Left_Rear = new CANSparkMax(3, MotorType.kBrushless);

  Pigeon2 m_IMU = new Pigeon2(0);

  RelativeEncoder m_rightEncoder = m_Right_Front.getEncoder();
  RelativeEncoder m_leftEncoder = m_Left_Front.getEncoder();
  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_rightEncoder.setPosition(0);
    m_leftEncoder.setPosition(0);

    m_Left_Rear.follow(m_Left_Front);
    m_Right_Rear.follow(m_Right_Front);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double lSpeed, double rSpeed){
    m_Right_Front.set(lSpeed);
    m_Left_Front.set(rSpeed);
    //  m_Left.set(TalonSRXControlMode.PercentOutput, speed);
    //
    //this.m_Left.setInverted(true);
  }

  public void setMotorsXY(double x, double y){
    m_Right_Front.set(x+y);
    m_Left_Front.set(x-y);
  }

  public double[] getEncoderValues(){
    return new double[]{m_rightEncoder.getPosition(), m_leftEncoder.getPosition()};
  }
  public void resetEncoders(){
    m_rightEncoder.setPosition(0);
    m_leftEncoder.setPosition(0);
  }
}