// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static final int XBOX_CONTROLLER_PORT = 0;

  public static class PIDConstants {
    public static final double kP_drive = 0.03;
    public static final double kI_drive = 0.0001;
    public static final double kD_drive = 0.003;
    public static final double kP_turn = 0.03;
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class ClawConstants{
    //public static final int forwardChannel = 1;
    //public static final int reverseChannel = 0;
    public static final double maxCurrent = 5;
  }
  public static class EncoderConstants{
    public static final double wheelDiameterInInches = 6;
    public static final double wheelCircumferenceInInches = wheelDiameterInInches * Math.PI;
    public static final double EncoderTicks = 4096;

    public static double EncoderTicksToInchesTravelled(double encoderValue){
      return wheelCircumferenceInInches / encoderValue;
    }
  }
}
