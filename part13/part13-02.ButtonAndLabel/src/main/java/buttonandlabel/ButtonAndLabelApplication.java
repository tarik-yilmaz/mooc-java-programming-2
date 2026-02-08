package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class ButtonAndLabelApplication extends Application {


    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("My first button!");
        
        Label textComponent = new Label("My first text!");
        FlowPane componentGroup = new FlowPane();
        
        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
                            
    }
    
    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
