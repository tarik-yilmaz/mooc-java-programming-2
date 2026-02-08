package application;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class JokeApplication extends Application {
    
    @Override
    public void start(Stage window) {
        
        // Main layout and menu
        BorderPane layout = new BorderPane();
 
        HBox menu = new HBox();
        menu.setSpacing(10);
        menu.setPadding(new Insets(20, 20, 20, 20));
        
        // Buttons
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        
        // Add buttons to menu
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(menu);
        
        // Subviews
        StackPane jokeView = createView("What do you call a bear with no teeth?");
        StackPane answerView = createView("A gummy bear.");
        StackPane explanationView = createView("Because without teeth, a bear can only chew gummy candy.");
        
        // Button action
        jokeButton.setOnAction(event -> layout.setCenter(jokeView));
        answerButton.setOnAction(event -> layout.setCenter(answerView));
        explanationButton.setOnAction(event -> layout.setCenter(explanationView));
        
        // Default view
        layout.setCenter(jokeView);
        
        // Show
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    
    private StackPane createView(String text) {
        StackPane view = new StackPane();
        view.setPrefSize(300, 180);
        view.setAlignment(Pos.CENTER);
        view.getChildren().add(new Label(text));
        return view;
    }
    
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
