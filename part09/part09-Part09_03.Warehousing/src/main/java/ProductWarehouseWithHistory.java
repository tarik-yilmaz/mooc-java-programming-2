public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        
        this.history = new ChangeHistory();

        super.addToWarehouse(initialBalance);

        this.history.add(super.getBalance());
    }

    public String history() {
        return this.history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }

        super.addToWarehouse(amount);

        this.history.add(super.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }

        double taken = super.takeFromWarehouse(amount);

        this.history.add(super.getBalance());

        return taken;
    }

    public void printAnalysis() {
        System.out.println("Product: " + getName());
        System.out.println("History: " + history());
        System.out.println("Largest amount of product: " + history.maxValue());
        System.out.println("Smallest amount of product: " + history.minValue());
        System.out.println("Average: " + history.average());
    }
}
