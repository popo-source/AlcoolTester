package fr.adresses.views;


import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.stage.Stage;


public class graphicOverviewController{
	
	
	private Stage dialogStage;
	
	@FXML
	private LineChart<Number, Number> chart;
	
	@FXML
	private NumberAxis xAxis;
	
	@FXML
	private NumberAxis yAxis;
	
	@FXML
	private void handleOk() {
		dialogStage.close();
	}
	
	public void initGraph(XYChart.Series<Number, Number> serie){		
		this.chart.getData().add(serie);
		
	}
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
}
