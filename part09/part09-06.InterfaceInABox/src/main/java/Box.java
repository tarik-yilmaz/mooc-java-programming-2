import java.util.ArrayList;

public class Box implements Packable {
    
    private double maxCapacity;
    private int itemCounter;
    private ArrayList<Packable> items;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<>();
        this.itemCounter = 0;
    }


    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.maxCapacity) {
            this.items.add(item);
            itemCounter++;
        }
    }

    @Override
    public double weight() {
        double weight = 0;

        for (Packable i : items) {
            weight += i.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.itemCounter + " items" + ", total weight " + this.weight() + " kg";
    }





}
