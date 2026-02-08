package application;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class ShanghaiApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");
        
        XYChart.Series dataNodes = new XYChart.Series();
        dataNodes.getData().add(new XYChart.Data(2007, 73));
        dataNodes.getData().add(new XYChart.Data(2008, 68));
        dataNodes.getData().add(new XYChart.Data(2009, 72));
        dataNodes.getData().add(new XYChart.Data(2010, 72));
        dataNodes.getData().add(new XYChart.Data(2011, 74));
        dataNodes.getData().add(new XYChart.Data(2012, 73));
        dataNodes.getData().add(new XYChart.Data(2013, 76));
        dataNodes.getData().add(new XYChart.Data(2014, 73));
        dataNodes.getData().add(new XYChart.Data(2015, 67));
        dataNodes.getData().add(new XYChart.Data(2016, 56));
        dataNodes.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(dataNodes);
        
        Scene view = new Scene(lineChart, 600, 500);
        stage.setScene(view);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
 
}