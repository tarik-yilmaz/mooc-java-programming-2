package application;

public class StandardSensor implements Sensor {
    private int value;

    public StandardSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {
      return true;
    }
    
    @Override
    public void setOn() {
        // Does practically nothing
    }

    @Override
    public void setOff() {
        // Does practically nothing
    }

    @Override
    public int read() {
        if (!isOn()) {
            throw new IllegalStateException();
        }

        return this.value;
    }
}
