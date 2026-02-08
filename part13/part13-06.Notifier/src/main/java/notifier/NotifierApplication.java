package notifier;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
 
public class NotifierApplication extends Application {
 
    @Override
    public void start(Stage window) throws Exception {
        
        TextField upperText = new TextField("Hello World!");
        Label lowerText = new Label();
        Button button = new Button("Update");
        
        button.setOnAction(event -> lowerText.setText(upperText.getText()));
        
        VBox componentGroup = new VBox();
        componentGroup.getChildren().addAll(upperText, button, lowerText);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
        
    }
    
    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
 
}
 