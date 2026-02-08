package smiley;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
 
public class SmileyApplication extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
        
        // Canvas
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        // Background color 
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Smiley color
        painter.setFill(Color.BLACK);
        
        // Eyes
        painter.fillRect(100, 80, 50, 50);
        painter.fillRect(250, 80, 50, 50);
        
        // Mouth corners
        painter.fillRect(80, 200, 50, 50);
        painter.fillRect(270, 200, 50, 50);
        
        // Mouth
        painter.fillRect(130, 250, 140, 50);
        
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        
        Scene view = new Scene(layout);
        stage.setScene(view);
        stage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
 
}