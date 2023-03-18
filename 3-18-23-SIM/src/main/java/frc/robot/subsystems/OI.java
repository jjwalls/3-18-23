// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OI extends SubsystemBase {

  public enum AxisType
  {
    LeftTrigger, RightTrigger, LeftStickX, RightStickX, LeftStickY, RightStickY
  }

  public PS4Controller m_pilotController;
  public Joystick m_coPilotController;

  /** Creates a new OI. */
  public OI() {
    m_pilotController = new PS4Controller(0);
    m_coPilotController = new Joystick(1);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(getAxis(AxisType.RightStickX));
  }
  

  public double getAxis (AxisType type) {
    switch (type)
    {
      case RightStickX:
        return m_pilotController.getRightX();
      case RightStickY:
        return m_pilotController.getRightY();
      case LeftStickY:
        return m_pilotController.getLeftY();
    }

    return 0;
  }


}
