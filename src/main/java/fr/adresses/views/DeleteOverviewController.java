package fr.adresses.views;


import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DeleteOverviewController {
	private boolean okClicked=false;
	private Stage dialogStage;
	
	@FXML
	private void handleOk(){
		okClicked=true;
		dialogStage.close();
		
	}
	
	@FXML
	private void handleNo(){
		dialogStage.close();
		
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void selectedObject (Object object) {
		
		
	}
}
