package fr.adresses.views;

import fr.adresses.MainApp;
import fr.adresses.objects.Alcool;
import fr.adresses.objects.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainOverviewController {

	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private TableView<Alcool> alcoolTable;
	@FXML
	private TableColumn<Alcool, String> alcoolNameColumn;
	@FXML
	private TableColumn<Alcool, Double> degreeColumn;

	@FXML
	private TableView<Alcool> selectedAlcoolTable;
	@FXML
	private TableColumn<Alcool, String> selectedAlcoolColumn;
	@FXML
	private TableColumn<Alcool, Double> quantityColumn;

	@FXML
	private CheckBox yesEatedCheckBox;
	@FXML
	private CheckBox noEatedCheckBox;
	
	private boolean eated = false;
	
	private MainApp mainApp;
	
	
	public MainOverviewController() {
    }
	
	@FXML
	private void handleYesEatedCheckBox() {
		if(yesEatedCheckBox.isSelected()) {
			noEatedCheckBox.setSelected(false);
		}
	}
	
	@FXML
	private void handleNoEatedCheckBox() {
		if(noEatedCheckBox.isSelected()) {
			yesEatedCheckBox.setSelected(false);
		}
	}
		
	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		
		alcoolNameColumn.setCellValueFactory(cellData -> cellData.getValue().alcoolNameProperty());
		degreeColumn.setCellValueFactory(cellData -> cellData.getValue().degreeProperty().asObject());
		
		selectedAlcoolColumn.setCellValueFactory(cellData -> cellData.getValue().alcoolNameProperty());
		quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
		
		personTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        alcoolTable.getSelectionModel().clearSelection();
		        selectedAlcoolTable.getSelectionModel().clearSelection();
		    }
		});
		
		alcoolTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        personTable.getSelectionModel().clearSelection();
		        selectedAlcoolTable.getSelectionModel().clearSelection();
		    }
		});
		
		selectedAlcoolTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        personTable.getSelectionModel().clearSelection();
		        alcoolTable.getSelectionModel().clearSelection();
		    }
		});
	}
	
	
	@FXML
	private void handleNew() {
	int newa=0;
		newa=mainApp.ShowNewOverview();
		switch(newa) {
		
		case 1:
			Person newPerson= new Person(	);
			if (mainApp.showPersonEditDialogOverview(newPerson)){
				mainApp.getPersonData().add(newPerson);
			}
			break;
			
		case 2:
			Alcool newAlcool = new Alcool();
			if (mainApp.showAlcoolEditDialogOverview(newAlcool)){
				mainApp.getAlcoolData().add(newAlcool);
			}
			break;
			
		}
	}
	
	@FXML
	private void handleEdit() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		Alcool selectedAlcool = alcoolTable.getSelectionModel().getSelectedItem();
		Alcool selectedSelectedAlcool = selectedAlcoolTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null && selectedAlcool==null && selectedSelectedAlcool == null) {
            mainApp.showPersonEditDialogOverview(selectedPerson);
        } else {
        	if(selectedPerson == null && selectedAlcool != null && selectedSelectedAlcool == null) {
        		mainApp.showAlcoolEditDialogOverview(selectedAlcool);
        	} else {
        		if(selectedPerson == null && selectedAlcool == null && selectedSelectedAlcool != null) {
        			mainApp.showQuantityEditQuantityOverview(selectedSelectedAlcool);
        		} else {
        			Alert alert = new Alert(AlertType.WARNING);
        		alert.initOwner(mainApp.getPrimaryStage());
        		alert.setTitle("No Selection");
        		alert.setHeaderText("No Item Selected");
        		alert.setContentText("Please select an item in the person and the alcool tables.");
        		alert.showAndWait();
        		}
        	}
        }
	}
	
	
	@FXML
	private void handleDelete() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		Alcool selectedAlcool = alcoolTable.getSelectionModel().getSelectedItem();
		Alcool selectedSelectedAlcool = selectedAlcoolTable.getSelectionModel().getSelectedItem();
		
		if (selectedPerson != null && selectedAlcool==null && selectedSelectedAlcool == null) {
			if(mainApp.showDeleteOverview(selectedPerson.getFirstName())) {
				personTable.getItems().remove(selectedPerson);
			}
        } else {
        	if(selectedPerson == null && selectedAlcool != null && selectedSelectedAlcool == null) {
        		if(mainApp.showDeleteOverview(selectedAlcool.getAlcoolName())) {
        			alcoolTable.getItems().remove(selectedAlcool);
        		}
        	} else {
        		if(selectedPerson == null && selectedAlcool == null && selectedSelectedAlcool != null) {
        			if(mainApp.showDeleteOverview(selectedSelectedAlcool.getAlcoolName())) {
        				selectedAlcoolTable.getItems().remove(selectedSelectedAlcool);
        			}
        		} else {
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.initOwner(mainApp.getPrimaryStage());
        			alert.setTitle("No Selection");
        			alert.setHeaderText("No Item Selected");
        			alert.setContentText("Please select an item in the tables.");
        			alert.showAndWait();
        		}
        	}
        }
	}
	
	
	@FXML
	private void handleAdd() {
		Alcool selectedAlcool = alcoolTable.getSelectionModel().getSelectedItem();
		if (selectedAlcool != null) {
			if(mainApp.showQuantityEditQuantityOverview(selectedAlcool)) {
				mainApp.getSelectedAlcoolData().add(selectedAlcool);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
    		alert.initOwner(mainApp.getPrimaryStage());
    		alert.setTitle("No Selection");
    		alert.setHeaderText("No Alcool Selected");
    		alert.setContentText("Please select an alcool in the table.");
    		alert.showAndWait();
    	}
	}
	
	private void setEaten() {
		if(yesEatedCheckBox.isSelected()) {
			eated = true;
		}
		if(noEatedCheckBox.isSelected()) {
			eated = false;
		}
	}
	
	
	@FXML
	private void handleGraphic() {
		String headerText = "";
    	String contentText = "";
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if(selectedPerson != null && selectedAlcoolTable != null && (yesEatedCheckBox.isSelected()==true || noEatedCheckBox.isSelected()==true)) {
			setEaten();
			mainApp.showGraphicOverview(selectedPerson, eated);
    	} else {
    		if(selectedPerson == null) {
    			headerText += "No Person Selected \n";
    			contentText += "Please select a person in the table. \n";
    		} 
    		if(selectedAlcoolTable == null) {
    			headerText += "No Alcool Selected \n";
    			contentText += "Please select an alcool in the table. \n";
    		}
    		if(yesEatedCheckBox.isSelected()==false && noEatedCheckBox.isSelected()==false) {
    			headerText += "Have you Eaten?";
    			contentText += "Please specify if you have eaten";
    		}
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.initOwner(mainApp.getPrimaryStage());
    	alert.setTitle("No Selection");
    	alert.setHeaderText(headerText);
    	alert.setContentText(contentText);
    	alert.showAndWait();
    	}
	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		personTable.setItems(mainApp.getPersonData());
		alcoolTable.setItems(mainApp.getAlcoolData());
		selectedAlcoolTable.setItems(mainApp.getSelectedAlcoolData());
	}


}
