package application;

import java.util.ArrayList;
import java.util.List;

import application.Sensor;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s : sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if (!this.isOn() || sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        int sum = 0;

        for (Sensor s : sensors) {
            sum += s.read();
        }

        int avg = sum / sensors.size();
        this.readings.add(avg);

        return avg;
    }

    public List<Integer> readings() {
        return new ArrayList<>(this.readings);
    }
}
