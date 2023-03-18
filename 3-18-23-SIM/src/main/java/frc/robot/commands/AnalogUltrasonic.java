package frc.robot.commands;
import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogUltrasonic {
    private AnalogInput analogInput;
    private double scale;

    public AnalogUltrasonic(int channel, double scale) {
        analogInput = new AnalogInput(channel);
        this.scale = scale;
    }

    public double getDistance() {
        double voltage = analogInput.getVoltage();
        return voltage * scale;
    }
}

