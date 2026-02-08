package textstatistics;
 
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
 
public class TextStatisticsApplication extends Application {
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        
        // We set Labels as variables
        Label letterCount = new Label("Letters: 0");
        Label wordCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        
        
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(letterCount, wordCount, longestWord);
        
        
        TextArea textSpace = new TextArea();
        
        textSpace.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letterCount.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        }); 
        
        layout.setCenter(textSpace);
        layout.setBottom(hBox);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
 
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
 
}
