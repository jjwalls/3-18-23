// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final Drivetrain m_drivetrain = new Drivetrain();
  private final OI m_oi = new OI();
  private final Intake m_Intake = new Intake();
  private final CommandPS4Controller m_pilotController = new CommandPS4Controller(0);
  private final CommandPS4Controller m_copilotContoller = new CommandPS4Controller(1);
  private final SlidingArm m_SlidingArm= new SlidingArm();
  private final Claw m_Claw = new Claw();

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, m_oi));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    //Co Pilot Bindings
    //Claw Bindings
    Trigger c_L1 = m_copilotContoller.L1();
    Trigger c_L2 = m_copilotContoller.L2();
    Trigger c_R2 = m_copilotContoller.R2();
    Trigger c_R1 = m_copilotContoller.R1();
    //Servo Bindings
    Trigger c_dpadright = m_copilotContoller.pov(90);
    Trigger c_dpadleft = m_copilotContoller.pov(270);
    //Intake Bindings
    Trigger c_circle = m_copilotContoller.circle();
    Trigger c_x = m_copilotContoller.cross();
    Trigger c_triangle = m_copilotContoller.triangle();
    //Sliding Arm Bindings
    Trigger c_dpadup = m_copilotContoller.pov(0);
    Trigger c_dpaddown = m_copilotContoller.pov(180);
    
    //Pilot Bindings
    //Extend and Retract Bindings
    Trigger p_square = m_pilotController.square();
    Trigger p_circle = m_pilotController.circle();
    Trigger p_cross = m_pilotController.cross();
    
    
    
    
    while (m_copilotContoller.getLeftY() != 0){
      if (m_copilotContoller.getLeftY() > 0)
        new SlidingArmExtend(m_SlidingArm, 0.1);
       else if (m_copilotContoller.getLeftY() < 0)
        new SlidingArmRetract(m_SlidingArm, 0.1);
    }

    //Co Pilot Control -------------------------
    //Claw Buttons
    c_L1.whileTrue(new ClawShiftLeft(m_Claw, 0.2));
    c_L2.whileTrue(new ClawOpen(m_Claw, 0.2));
    c_R2.whileTrue(new ClawClose(m_Claw, 0.2));
    c_R1.whileTrue(new ClawShiftRight(m_Claw, 0.2));
    //Servo Buttons
    c_dpadright.whileTrue(new MoveServoToAngle(m_Claw, 30));
    c_dpadleft.whileTrue(new MoveServoToAngle(m_Claw, 0));
    //Intake Buttons
    c_x.whileTrue(new ReverseIntake(m_Intake, .75));
    c_circle.whileTrue(new MoveIntake(m_Intake, .75));
    //c_triangle.onTrue(new PickupCube(m_drivetrain, 0, 0, 0, m_Intake));
    //Sliding Arm Buttons
    c_dpadup.whileTrue(new SlidingArmExtend(m_SlidingArm, 0.6));
    c_dpaddown.whileTrue(new SlidingArmRetract(m_SlidingArm, 0.7));

  

    //Pilot Control -------------------------
    //Extend and Retract Buttons
    p_square.whileTrue(new ExtendIntake(m_Intake,1));
    p_circle.whileTrue(new RetractIntake(m_Intake, 1));
    p_cross.whileTrue(new DriveForDistance(m_drivetrain, 5.0, false, 0.5));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
      return new PlayOneCube(m_drivetrain,m_Intake,m_Claw,m_SlidingArm);
  }
}
