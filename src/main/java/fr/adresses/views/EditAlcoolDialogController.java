package fr.adresses.views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import fr.adresses.objects.Alcool;

public class EditAlcoolDialogController {
	
	private Stage dialogStage;
	private boolean okClicked = false;
	private Alcool alcool;

    @FXML
    private TextField alcoolNameField;
    @FXML
    private TextField degreeLabelField;

    public EditAlcoolDialogController() {
    }   

    public void setAlcool(Alcool alcool) {
        this.alcool = alcool;
        alcoolNameField.setText(alcool.getAlcoolName());
        degreeLabelField.setText(Double.toString(alcool.getDegree()));
    }
    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
            alcool.setAlcoolName(alcoolNameField.getText());
            alcool.setDegree(Double.parseDouble(degreeLabelField.getText()));
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
    
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (alcoolNameField.getText() == null || alcoolNameField.getText().length() == 0) {
            errorMessage += "No valid alcool name!\n";
        }
        if (degreeLabelField.getText() == null || degreeLabelField.getText().length() == 0 || Double.parseDouble(degreeLabelField.getText()) <=0) {
            errorMessage += "No valid degree!\n";
        } else {
			try {
				Double.parseDouble(degreeLabelField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Degree (must be a double)!\n";
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

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}