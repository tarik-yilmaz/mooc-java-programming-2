package application;
 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
 
public class PracticeView {
 
    private Dictionary dictionary;
    private String word;
 
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
 
    public Parent getView() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
 
        Label wordInstruction = new Label();
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label feedback = new Label("");
 
        setNewWord(wordInstruction); // initial text
 
        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
 
        checkButton.setOnAction(event -> {
            if (this.dictionary.isEmpty() || this.word == null) {
                feedback.setText("Incorrect!");
                return;
            }
 
            String answer = translationField.getText().trim();
            String correct = this.dictionary.get(this.word);
 
            if (correct != null && correct.equals(answer)) {
                feedback.setText("Correct!");
                setNewWord(wordInstruction);
                translationField.clear();
            } else {
                if (correct == null) {
                    feedback.setText("Incorrect!");
                } else {
                    feedback.setText("Incorrect! The correct translation is: " + correct);
                }
            }
        });
 
        return layout;
    }
 
    private void setNewWord(Label wordInstruction) {
        this.word = this.dictionary.getRandomWord();
        if (this.word == null) {
            wordInstruction.setText("Translate the word ''");
        } else {
            wordInstruction.setText("Translate the word '" + this.word + "'");
        }
    }
}
