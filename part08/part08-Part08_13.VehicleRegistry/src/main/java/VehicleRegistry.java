import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> owners;
    
    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (owners.containsKey(licensePlate)) {
            return false;
        }

        owners.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return owners.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!owners.containsKey(licensePlate)) {
            return false;
        }
        owners.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate l : owners.keySet()) {
            System.out.println(l);
        }
    }

    public void printOwners() {
        ArrayList<String> printed = new ArrayList<>();

        for (String o : owners.values()) {
            if (printed.contains(o)) {
                continue;
            }
            System.out.println(o);
            printed.add(o);
        }
    }
}
