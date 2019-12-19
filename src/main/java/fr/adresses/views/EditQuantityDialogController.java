package fr.adresses.views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import fr.adresses.objects.Alcool;


public class EditQuantityDialogController {
	
	private Stage dialogStage;
	private Alcool alcool;
	private boolean okClicked = false;
	
	@FXML
	private TextField quantityField;

	public EditQuantityDialogController() {
	}
	
	public void setAlcool(Alcool alcool) {
		this.alcool = alcool;
		quantityField.setText(Double.toString(alcool.getQuantity()));
	}
	
	@FXML
	private void handleOk() {
		if(isInputValid()) {
			alcool.setQuantity(Double.parseDouble(quantityField.getText()));
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (quantityField.getText() == null || quantityField.getText().length() == 0 || Double.parseDouble(quantityField.getText()) <= 0) {
			errorMessage += "No valid quantity!\n";
		} else {
			try {
				Integer.parseInt(quantityField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid quantity (must be a double: format = xxx.xxx)!\n";
			}
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
}