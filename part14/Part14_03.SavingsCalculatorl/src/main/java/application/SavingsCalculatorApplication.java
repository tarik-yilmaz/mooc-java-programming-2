package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    private XYChart.Series<Number, Number> savingsSeries;
    private XYChart.Series<Number, Number> savingsWithInterestSeries;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setAnimated(false);
        chart.setCreateSymbols(false);
        
        savingsSeries = new XYChart.Series<>();
        savingsSeries.setName("Savings");
        
        savingsWithInterestSeries = new XYChart.Series<>();
        savingsWithInterestSeries.setName("Savings with interest");
        
        chart.getData().addAll(savingsSeries, savingsWithInterestSeries);

        
        // Sliders
        Slider monthlySlider = new Slider(25, 250, 25);
        monthlySlider.setShowTickLabels(true);
        monthlySlider.setShowTickMarks(true);
        monthlySlider.setMajorTickUnit(25);
        monthlySlider.setMinorTickCount(0);
        monthlySlider.setSnapToTicks(true);
        monthlySlider.setBlockIncrement(25);
        
        Label monthlyValueLabel = new Label(String.format("%.0f", monthlySlider.getValue()));
        
        
        BorderPane monthlyRow = new BorderPane();
        monthlyRow.setLeft(new Label("Monthly savings"));
        monthlyRow.setCenter(monthlySlider);
        monthlyRow.setRight(monthlyValueLabel);
        
        
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        interestSlider.setMajorTickUnit(1);
        interestSlider.setMinorTickCount(0);
        interestSlider.setSnapToTicks(true);
        interestSlider.setBlockIncrement(1);
        
        Label interestValueLabel = new Label(String.format("%.1f", interestSlider.getValue()));

        BorderPane interestRow = new BorderPane();
        interestRow.setLeft(new Label("Yearly interest rate"));
        interestRow.setCenter(interestSlider);
        interestRow.setRight(interestValueLabel);

        VBox topControls = new VBox();
        topControls.getChildren().addAll(monthlyRow, interestRow);
        
        
        // Layout
        BorderPane window = new BorderPane();
        window.setTop(topControls);
        window.setCenter(chart);
        
        // Business logic
        Runnable update = () -> {
            double monthly = monthlySlider.getValue();
            double rate = interestSlider.getValue();

            monthlyValueLabel.setText(String.format("%.0f", monthly));
            interestValueLabel.setText(String.format("%.1f", rate));

            updateChart(monthly, rate);
        };
        
        monthlySlider.valueProperty().addListener((obs, oldV, newV) -> update.run());
        interestSlider.valueProperty().addListener((obs, oldV, newV) -> update.run());
        
        // Draw
        update.run();
        
        // Show
        Scene scene = new Scene(window, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Savings calculator");
        stage.show();
    }
    
    private void updateChart(double monthlySavings, double yearlyInterestRate) {
        savingsSeries.getData().clear();
        savingsWithInterestSeries.getData().clear();

        double yearlyContribution = monthlySavings * 12.0;

        // Year 0 is always 0
        savingsSeries.getData().add(new XYChart.Data<>(0, 0));
        savingsWithInterestSeries.getData().add(new XYChart.Data<>(0, 0));

        // Savings without interest: linear growth
        for (int year = 1; year <= 30; year++) {
            double amount = yearlyContribution * year;
            savingsSeries.getData().add(new XYChart.Data<>(year, amount));
        }

        // Savings with interest: compound yearly, interest applied after deposits of that year
        double balance = 0.0;
        double factor = 1.0 + (yearlyInterestRate / 100.0);

        for (int year = 1; year <= 30; year++) {
            balance = (balance + yearlyContribution) * factor;
            savingsWithInterestSeries.getData().add(new XYChart.Data<>(year, balance));
        }
    }
    
    
    public static void main(String[] args) {
            launch(SavingsCalculatorApplication.class);
    }
}
