// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.SlidingArm;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PlayOneCube extends SequentialCommandGroup {
  public PlayOneCube(Drivetrain drive, Intake intake,Claw claw,SlidingArm slidingArm) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new ExtendIntakeAndCloseClaw(intake, claw),
    new SlidingArmExtend(slidingArm, .75).withTimeout(2.8),//Extend Arm
    new ClawClose(claw, .1).withTimeout(1),//Open Claw
    new SlidingArmRetract(slidingArm, .4).withTimeout(3),//Retract Arm
    new DriveForDistance(drive, 200, false, -0.2)
    ); 
  }}

