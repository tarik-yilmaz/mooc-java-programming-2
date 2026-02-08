package asteroids;
 
import javafx.scene.shape.Polygon;
 
// Projectile is a Character with a small square polygon (same as example)
public class Projectile extends Character {
 
    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }
}
 