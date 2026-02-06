package hurraa;

import javafx.scene.media.AudioClip;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    // This program doesnt work without adding some dependencies in the maven file
    // Also I added another sound file because the provided one doesn't seem to work

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane pane = new BorderPane();  
        
        Button nappi = new Button("Hurraa!");
        pane.setCenter(nappi);

        AudioClip sound = new AudioClip("file:i_succeeded.mp3");
        
        nappi.setOnMouseClicked(event -> {
            sound.play();
        });
        
        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
