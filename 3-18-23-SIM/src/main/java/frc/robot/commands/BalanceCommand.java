package frc.robot.commands;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class BalanceCommand extends CommandBase {
    private static final double kP = 0.03; // Proportional constant for PID controller
    private static final double kI = 0.001; // Integral constant for PID controller
    private static final double kD = 0.05; // Derivative constant for PID controller
    private static final double kToleranceDegrees = 1.0; // Tolerance for stopping the robot
    private static final double kMaxOutput = 1.0; // Maximum output value for the PID controller
    
    private ADIS16470_IMU imu;
    private double setpoint;
    private double integral;
    Drivetrain m_drive;
    
    public BalanceCommand(Drivetrain Drive) {
        imu = new ADIS16470_IMU();
        m_drive = Drive;
        setpoint = imu.getAngle();
        integral = 0;
        addRequirements(Drive);
    }
    
    @Override
    public void initialize() {
        imu.reset();
    }
    
    @Override
    public void execute() {
        double error = setpoint - imu.getAngle();
        integral += error;
        double derivative = imu.getRate();
        double output = kP * error + kI * integral + kD * derivative;
        
        // Clamp output value to the range [-kMaxOutput, kMaxOutput]
        output = Math.max(-kMaxOutput, Math.min(output, kMaxOutput));
        
        m_drive.setMotors(output, -output);
    }
    
    @Override
    public boolean isFinished() {
        return Math.abs(setpoint - imu.getAngle()) <= kToleranceDegrees;
    }
    
    @Override
    public void end(boolean interrupted){
        m_drive.setMotors(0, 0);
    }
    
}
