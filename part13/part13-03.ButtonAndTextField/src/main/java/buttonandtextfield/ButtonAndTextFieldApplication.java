package buttonandtextfield;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
 
 
public class ButtonAndTextFieldApplication extends Application {
 
 
    @Override
    public void start(Stage window) {
        
        
        Button buttonComponent = new Button("My first button!");
        TextField textComponent = new TextField("My first text!");
        
        FlowPane componentGroup = new FlowPane();
        
        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
                            
    }
    
    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
 
}
