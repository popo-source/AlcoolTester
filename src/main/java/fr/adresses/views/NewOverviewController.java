package fr.adresses.views;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class NewOverviewController {
	private int clickOption=0;
	private Stage DialogStage;

	@FXML
	private void handleNewPerson() {
		clickOption=1;
		DialogStage.close();
		
	}
	@FXML
	private void handleNewAlcool() {
		clickOption=2;
		
		DialogStage.close();	
	}
	
	@FXML
	private void handleNewCancel() {
		DialogStage.close();	
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.DialogStage = dialogStage;
	}
	
	public int whatIsClicked(){
		return clickOption;
	}
}
