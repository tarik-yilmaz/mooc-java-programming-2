TestMyCode
TMC
Organization MOOC
Course mooc-java-programming-ii
Exercise part14-Part14_02.FinnishParties
Submission #30280543
Submission 30280543
All tests successful

Got 1 out of 1 point (14-02).
Submitted at 16:42 06.02.2026
Took 23 seconds to process.
Download as zip
View suggested solution
Test Results
Stdout
Stderr
Files

src/main/java/application/PartiesApplication.java
package application;
 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class PartiesApplication extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
        
        // Create axis and title
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Relative support of the parties");
        
        // Read data
        List<String> lines = Files.readAllLines(Paths.get("partiesdata.tsv"));
        if (lines.isEmpty()) {
            stage.setScene(new Scene(chart, 600, 400));
            stage.show();
            return;
        }
        
        // Read header from file
        String[] header = lines.get(0).split("\t");
        int[] years = new int[header.length - 1];
        
        for (int i = 1; i < header.length; i++) {
            years[i - 1] = Integer.parseInt(header[i]);
        }
        
        // Read rest file rows
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            
            String[] parts =  line.split("\t");
            String party = parts[0];
            
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(party);
            
            // Parse values
            for (int j = 1; j < parts.length && (j - 1) < years.length; j++) {
                String valueString = parts[j];
                
                if (valueString.equals("-")) {
                    continue;
                }
                
                double value = Double.valueOf(valueString);
                int year = years[j - 1];
                
                series.getData().add(new XYChart.Data<>(year, value));
            }
            
            chart.getData().add(series);
        }
        
        Scene scene = new Scene(chart, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
 
}
