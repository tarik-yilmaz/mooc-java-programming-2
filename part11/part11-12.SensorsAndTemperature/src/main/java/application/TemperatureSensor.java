package application;

import java.util.Random;


public class TemperatureSensor implements Sensor {
    private int value;
    private boolean onOff; 

    public TemperatureSensor() {
        this.onOff = false; // its off
    }

    @Override
    public boolean isOn() {
        if (this.onOff) {
            return true;
        }
        return false;
    }

    @Override
    public void setOn() {
        this.onOff = true;
    }

    @Override
    public void setOff() {
        this.onOff = false;
    }

    @Override
    public int read() {
        if (!isOn()) {
            throw new IllegalStateException();
        }

        Random rand = new Random();
       
        return  rand.nextInt(61) - 30;
    }
}
