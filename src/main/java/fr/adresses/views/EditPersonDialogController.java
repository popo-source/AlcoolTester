package fr.adresses.views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import fr.adresses.objects.Person;


public class EditPersonDialogController {


	private Stage personEditDialogStage;
	private boolean okClicked = false;
	
	private Person person;

	
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField weightField;
	
	
	@FXML
	private CheckBox womanCheckBox;
	@FXML
	private CheckBox manCheckBox;


	@FXML
	private void handleManSelection() {
		if(manCheckBox.isSelected()) {
			womanCheckBox.setSelected(false);
		}
	}
	
	@FXML
	private void handleWomanSelection() {
		if(womanCheckBox.isSelected()) {
			manCheckBox.setSelected(false);
		}
	}
	
	
	public EditPersonDialogController() {
	}
	
	
	public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        weightField.setText(Double.toString(person.getWeight()));
        if(person.getSex()=="man") {
        	manCheckBox.setSelected(true);
        } else {
        	if(person.getSex()=="woman") {
        		womanCheckBox.setSelected(true);
        	}
        	
        }
    }
	
	

	public void setPersonEditDialogStage(Stage personEditDialogStage) {
		this.personEditDialogStage = personEditDialogStage;
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	public String getCheckBoxSex() {
		String sex ="";
		if(womanCheckBox.isSelected() == true && manCheckBox.isSelected() == false) {
			sex = "woman";
		} else {
			if(womanCheckBox.isSelected() == false && manCheckBox.isSelected() == true) {
				sex = "man";
			}
		}
		return sex;
	}
	
	@FXML
	private void handleOk() {
		if(isInputValid()) {
			okClicked = true;
			person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setSex(getCheckBoxSex());
            person.setWeight(Double.parseDouble(weightField.getText()));
			personEditDialogStage.close();
		}
		
	}
	
	@FXML
	private void handleCancel() {
		personEditDialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (weightField.getText() == null || weightField.getText().length() == 0 || Double.parseDouble(weightField.getText()) <=0) {
			errorMessage += "No valid weight!\n";
		} else {
			try {
				Double.parseDouble(weightField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid weight (must be a double)!\n";
			}
		}
		if (womanCheckBox==null && manCheckBox==null) {
			errorMessage += "No sex validation!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(personEditDialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
}