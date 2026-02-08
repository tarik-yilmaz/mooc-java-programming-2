
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof LicensePlate)) {
            return false;
        }

        LicensePlate other = (LicensePlate) object;

        return this.liNumber.equals(other.liNumber) &&
               this.country.equals(other.country);
    }

    @Override
    public int hashCode() {
        if (this.liNumber == null) {
            return this.country.hashCode();
        }

        return this.liNumber.hashCode();
    }



}
