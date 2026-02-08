package borderpane;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
 
public class BorderPaneApplication extends Application {
 
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        
        layout.setTop(new Label("NORTH"));
        layout.setRight(new Label("EAST"));
        layout.setLeft(new Label("WEST"));
        layout.setBottom(new Label("SOUTH"));
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    
    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }
 
}
 