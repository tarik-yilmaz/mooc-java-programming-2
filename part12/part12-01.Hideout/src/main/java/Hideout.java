import java.util.ArrayList;
import java.util.List;

public class Hideout<T> {

    private T hidden;

    public Hideout() {
        this.hidden = null;
    }

    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }

    public T takeFromHideout() {
        T temp = this.hidden;
        this.hidden = null;
        
        return temp;
    }

    public boolean isInHideout() {
        if (this.hidden != null) {
            return true;
        }

        return false;
    }
}
