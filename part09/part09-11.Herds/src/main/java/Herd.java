import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {

    private List<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable o : organisms) {
            o.move(dx, dy);
        }
    }

    public void addToHerd(Movable movable) {
        organisms.add(movable);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Movable o : organisms) {
            string.append(o).append("\n");
        }
        return string.toString();
    }
}
