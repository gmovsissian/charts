package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class Controller {
    @FXML
    private Button load;
    @FXML
    private Button max;
    @FXML
    private Button sum;
    @FXML
    private Button sort;
    @FXML
    private Button clear;

    private int summ;
    private int maxvalue;
    @FXML
    LineChart<String, Number> lineChart;
    @FXML
            Boolean isclicked=false;

    XYChart.Series<String, Number> numberXYchart = new XYChart.Series<>();
    XYChart.Series<String, Number> numberSeries = new XYChart.Series<>();

    public void initialize() {


load.setOnAction(event -> { numberXYchart.setName("Salary");
    numberXYchart.getData().add(new XYChart.Data<>("Gor", 1200));
    numberXYchart.getData().add(new XYChart.Data<>("Ara", 1800));
    numberXYchart.getData().add(new XYChart.Data<>("Aram", 1900));
    numberXYchart.getData().add(new XYChart.Data<>("Artur", 1100));
    numberXYchart.getData().add(new XYChart.Data<>("Bob", 1450));
    numberXYchart.setName("Salary");
    lineChart.getData().add(numberXYchart);
    isclicked=true;
    checkbutton();
});




        sum.setOnAction(event -> {

            for (XYChart.Data<String, Number> data : numberXYchart.getData()) {
                summ += data.getYValue().intValue();
            }
            System.out.println(summ);

        });

        max.setOnAction(event -> {
            for (XYChart.Data<String, Number> data : numberXYchart.getData()) {
                if (data.getYValue().intValue() >= maxvalue) {
                    maxvalue = data.getYValue().intValue();
                }
            }
            System.out.println(maxvalue);
            clear.setOnAction(event1 -> {
                lineChart.getData().remove(numberXYchart);
                lineChart.getData().remove(numberSeries);
                isclicked=false;
                checkbutton();
                load.setDisable(false);
                sort.setDisable(false);

            });
            sort.setOnAction(event1 -> {
                sortm();
                isclicked=true;
                checkbutton();
            });
        });
    }

    public void sortm() {

        numberSeries.getData().add(new XYChart.Data<>("Gor", 1200));
        numberSeries.getData().add(new XYChart.Data<>("Ara", 1800));
        numberSeries.getData().add(new XYChart.Data<>("Aram", 1900));
        numberSeries.getData().add(new XYChart.Data<>("Artur", 1100));
        numberSeries.getData().add(new XYChart.Data<>("Bob", 1450));
        lineChart.getData().add(numberSeries);

        Collections.sort(numberSeries.getData(), new Comparator<XYChart.Data<String, Number>>() {
            @Override
            public int compare(XYChart.Data<String, Number> o1, XYChart.Data<String, Number> o2) {
                Number yvalue1 = o1.getYValue();
                Number yvalue2 = o2.getYValue();
                return new BigDecimal(yvalue1.toString()).compareTo(new BigDecimal(yvalue2.toString()));

            }
        });


    }
    public void checkbutton(){
if (isclicked=true){
    load.setDisable(true);
    sort.setDisable(true);
}else {
    load.setDisable(false);
    sort.setDisable(false);
}
    }
}

