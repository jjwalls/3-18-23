package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GrabberSubsystem extends SubsystemBase {

  private final DoubleSolenoid grabberSolenoid;

  public GrabberSubsystem(int forwardChannel, int reverseChannel) {
    grabberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, forwardChannel, reverseChannel);
  }

  public void extend() {
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void toggle() {
    if (grabberSolenoid.get() == DoubleSolenoid.Value.kForward) {
      retract();
      SmartDashboard.putBoolean("Toggle Value", (grabberSolenoid.get() == DoubleSolenoid.Value.kForward));

    } else {
      extend();
    }
  }
}
