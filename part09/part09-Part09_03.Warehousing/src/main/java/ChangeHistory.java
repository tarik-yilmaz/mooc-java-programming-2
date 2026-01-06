import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> object;

    public ChangeHistory() {
        object = new ArrayList<>();
    }

    public void add(double status) {
        object.add(status);
    }

    public double maxValue() {
        if (object.isEmpty()) {
            return 0.0;
        }
        
        double max = object.get(0);
        
        for (double o : object) {
            if (max < o) {
                max = o;
            }
        }
        return max;
    }

    public double minValue() {
        if (object.isEmpty()) {
            return 0.0;
        }
        
        double min = object.get(0);
        
        for (double o : object) {
            if (min > o) {
                min = o;
            }
        }
        return min;
    }

    public double average() {
        if (object.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (double o : object) {
            sum += o;
        }

        return sum / object.size();
    }

    public void clear() {
        object.clear();
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
