package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MatModel matModel = new MatModel();
        VBox vBox = new VBox();
        LineChart chartVictims = new LineChart(new NumberAxis(), new NumberAxis());
        chartVictims.getData().add(new XYChart.Series<>("Жертвы", FXCollections.observableArrayList(new XYChart.Data<Object, Object>(matModel.t, matModel.victim))));
        chartVictims.getData().add(new XYChart.Series<>("Хищники", FXCollections.observableArrayList(new XYChart.Data<Object, Object>(matModel.t, matModel.predator))));

        for(int i =0;i<25;i++){
            matModel.process();
            ((XYChart.Series) chartVictims.getData().get(0)).getData().addAll(new XYChart.Data<Object, Object>(matModel.t, matModel.victim));
            ((XYChart.Series) chartVictims.getData().get(1)).getData().addAll(new XYChart.Data<Object, Object>(matModel.t, matModel.predator));
        }
        vBox.getChildren().addAll(chartVictims);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
