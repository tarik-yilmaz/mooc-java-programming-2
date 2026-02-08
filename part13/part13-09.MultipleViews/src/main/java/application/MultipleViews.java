package application;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class MultipleViews extends Application {
 
    @Override
    public void start(Stage window) {
 
        // First view
        BorderPane firstView = new BorderPane();
        firstView.setTop(new Label("First view!"));
        Button firstViewButton = new Button("To the second view!");
        firstView.setCenter(firstViewButton);
        Scene first = new Scene(firstView);
 
        // Second view
        VBox secondView = new VBox();
        Button secondViewButton = new Button("To the third view!");
        secondView.getChildren().addAll(secondViewButton, new Label("Second view!"));
        Scene second = new Scene(secondView);
 
        // Third view
        GridPane thirdView = new GridPane();
        thirdView.add(new Label("Third view!"), 0, 0);
        Button thirdViewButton = new Button("To the first view!");
        thirdView.add(thirdViewButton, 1, 1);
        Scene third = new Scene(thirdView);
 
        
        firstViewButton.setOnAction(event -> window.setScene(second));
        secondViewButton.setOnAction(event -> window.setScene(third));
        thirdViewButton.setOnAction(event -> window.setScene(first));
 
        window.setScene(first);
        window.show();
    }
 
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
