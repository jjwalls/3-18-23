// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PlayCubeOneThenTwo extends SequentialCommandGroup {
  public PlayCubeOneThenTwo(Drivetrain drive, double forwardDistance, double backwardDistance, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new SlidingArmExtend(null, .6).withTimeout(2),//Extend Arm
    new ClawOpen(null, .1).withTimeout(2),//Open Claw
    new SlidingArmRetract(null, .4).withTimeout(2),//Retract Arm
    new DriveForDistance(drive, backwardDistance, true, .25).withTimeout(2),
    new MoveIntake(null, .5).withTimeout(2),
    new StopIntake(null).withTimeout(2),
    new ClawClose(null, .1).withTimeout(2),//Close Claw
    new DriveForDistance(drive, forwardDistance, false, .25).withTimeout(2),
    new SlidingArmExtend(null, .6).withTimeout(2),//Extend Arm
    new ClawOpen(null, .1).withTimeout(2),//Open Claw
    new SlidingArmRetract(null, .4).withTimeout(2)//Retract Arm
    ); 
  }}
