import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> itemsPrice;
    private Map<String, Integer> itemsStock;

    public Warehouse() {
        this.itemsPrice = new HashMap<>();
        this.itemsStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        itemsPrice.putIfAbsent(product, price);
        itemsStock.putIfAbsent(product, stock);
    }

    public int price(String product) {
        if (itemsPrice.containsKey(product)) {
            return itemsPrice.get(product);
        }
        else {
            return -99;
        }
    }

    public int stock(String product) {
        if (itemsStock.containsKey(product)) {
            return itemsStock.get(product);
        }
        else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (!itemsStock.containsKey(product)) {
            return false;
        }

        if (itemsStock.get(product) > 0) {
            itemsStock.replace(product, itemsStock.get(product) - 1);
            
            if (itemsStock.get(product) >= 0) {
                return true;
            }
        }

        return false;
    }

    public Set<String> products() {
        return itemsPrice.keySet();
    }
}
