package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;


public class Controller {
    @FXML
    private Button load;
    @FXML
    private Button max;
    @FXML
    private Button sum;
    @FXML
    private Button sort;

    private int summ;
    private int maxvalue;
    @FXML
    LineChart<String, Number> lineChart;

    XYChart.Series<String, Number> numberXYchart = new XYChart.Series<>();

    public void initialize() {
        numberXYchart.setName("Salary");
        numberXYchart.getData().add(new XYChart.Data<>("Gor", 1200));
        numberXYchart.getData().add(new XYChart.Data<>("Ara", 1800));
        numberXYchart.getData().add(new XYChart.Data<>("Aram", 1900));
        numberXYchart.getData().add(new XYChart.Data<>("Artur", 1100));
        numberXYchart.getData().add(new XYChart.Data<>("Bob", 1450));
        load.setOnAction(event -> {
            lineChart.getData().add(numberXYchart);

        });
        lineChart.getData().add(numberXYchart);

        for (XYChart.Data<String, Number> data : numberXYchart.getData()) {
            summ += data.getYValue().intValue();
        }
        for (XYChart.Data<String, Number> data : numberXYchart.getData()) {
            if (data.getYValue().intValue()>=maxvalue){
                maxvalue=data.getYValue().intValue();
            }
        }

            sum.setOnAction(event -> {


                System.out.println(summ);

            });

        max.setOnAction(event -> {
            System.out.println(maxvalue);
        });


         sort.setOnAction(event -> {
             
         });


        }
    }

