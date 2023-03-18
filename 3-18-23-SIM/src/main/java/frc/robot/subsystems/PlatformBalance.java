// IMU = Inertial Measurement Unit
// For Analog Devices 16470

package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PlatformBalance extends SubsystemBase {
    // Objects
    private ADIS16470_IMU imu = new ADIS16470_IMU();

    private GenericEntry shuffle_angle;
    private GenericEntry shuffle_x;
    private GenericEntry shuffle_y;
    private GenericEntry shuffle_z;

    // Constructor
    public void IMU() {
        ShuffleboardTab tab = Shuffleboard.getTab("Sensors");

        shuffle_angle = tab.add("Angle", 0)
            .withPosition(0, 1)
            .getEntry();
        shuffle_x = tab.add("X Acceleration", 0)
            .withPosition(1, 1)
            .getEntry();
        shuffle_y = tab.add("Y Acceleration", 0)
            .withPosition(2, 1)
            .getEntry();
        shuffle_z = tab.add("Z Acceleration", 0)
            .withPosition(3, 1)
            .getEntry();
    }
    // Get Gyro (Degrees per Second)
    public double getGyroRate() {
        return imu.getRate();
    }

    // Periodic
    @Override
    public void periodic() {
        shuffle_angle.setDouble(imu.getAngle());
        shuffle_x.setDouble(imu.getAccelX());
        shuffle_y.setDouble(imu.getAccelY());
        shuffle_z.setDouble(imu.getAccelZ());
    }
}