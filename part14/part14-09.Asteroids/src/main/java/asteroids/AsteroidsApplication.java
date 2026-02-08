package asteroids;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
 
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class AsteroidsApplication extends Application {
 
    // Window size (used also for screen wrapping in Character.move())
    public static int WIDTH = 600;
    public static int HEIGHT = 400;
 
    @Override
    public void start(Stage stage) throws Exception {
 
        // 1) Create game window (Pane ignores child layout positions)
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
 
        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
 
        // Points display (top-left)
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        AtomicInteger points = new AtomicInteger();
 
        // 2) Create ship (center of the window)
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(ship.getCharacter());
 
        // 3) Create multiple asteroids
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
 
        // Projectiles start empty
        List<Projectile> projectiles = new ArrayList<>();
 
        // 4) Smooth keyboard handling: track pressed keys in a map
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
 
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
 
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
 
        // 5) Game loop (~60 fps)
        new AnimationTimer() {
 
            @Override
            public void handle(long now) {
 
                // Turning the ship
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
 
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
 
                // Accelerating the ship
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
 
                // Shooting projectiles (limit to 3 projectiles at once)
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY()
                    );
 
                    // Projectile direction = ship direction
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
 
                    // Give projectile speed: accelerate a bit, normalize and multiply by 3
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
 
                    pane.getChildren().add(projectile.getCharacter());
                }
 
                // Move all characters
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
 
                // Collision: ship vs asteroid -> stop the game
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
 
                // Collision: projectile vs asteroid -> mark both dead
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
 
                    // Add points when projectile hit something
                    if (!projectile.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });
 
                // Remove dead projectiles from UI and list
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
 
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));
 
                // Remove dead asteroids from UI and list
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
 
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
 
                // Continuous adding of asteroids (0.5% chance per frame)
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
 
                    // Add only if it does not collide with the ship immediately
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
    // The exercise asks you to return how many parts are completed.
    // This implementation contains all parts (1-4).
    public static int partsCompleted() {
        return 4;
    }
}
 