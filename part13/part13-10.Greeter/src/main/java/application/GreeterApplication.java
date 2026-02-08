package application;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
 
public class GreeterApplication extends Application {
 
    @Override
    public void start(Stage window) throws Exception {
        
        // First view components
        Label instruction = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button startButton = new Button("Start");
        
        
        // Create layout and add components
        GridPane firstLayout = new GridPane();
        firstLayout.add(instruction, 0, 0);
        firstLayout.add(textField, 0, 1);
        firstLayout.add(startButton, 0, 2);
        
        // Create the view
        Scene firstView = new Scene(firstLayout);
        
        // Second view components
        Label greeting = new Label();
        StackPane secondLayout = new StackPane(greeting);
        Scene secondView = new Scene(secondLayout);
        
        // Action
        startButton.setOnAction(event -> {
            String userName = textField.getText().trim();
            if (!userName.isEmpty()) {
                greeting.setText("Welcome " + userName + "!");
                window.setScene(secondView);
            }
        });
        
        // Show first view
        window.setScene(firstView);
        window.show();
    }
 
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
