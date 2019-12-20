package fr.adresses;

import java.io.IOException;

import fr.adresses.objects.Alcool;
import fr.adresses.objects.Person;
import fr.adresses.utilitary.LineChartsValues;
import fr.adresses.views.DeleteOverviewController;
import fr.adresses.views.EditAlcoolDialogController;
import fr.adresses.views.EditPersonDialogController;
import fr.adresses.views.EditQuantityDialogController;
import fr.adresses.views.MainOverviewController;
import fr.adresses.views.graphicOverviewController;
import fr.adresses.views.NewOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	private ObservableList<Alcool> alcoolData = FXCollections.observableArrayList();
	private ObservableList<Alcool> selectedAlcoolData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {

		personData.add(new Person("Paul", "Hauser", "man", 80.0));
        personData.add(new Person("Lucas", "Gigondan", "man", 66.0));
        personData.add(new Person("Gil", "Flassch--Trauth", "man", 65.0));
        
        alcoolData.add(new Alcool("Jagermeister", 35.0));
        alcoolData.add(new Alcool("Heineken", 5.0));
        alcoolData.add(new Alcool("B52", 25.0));
        alcoolData.add(new Alcool("Wine", 12.0));
        alcoolData.add(new Alcool("Whisky", 40.0));
        alcoolData.add(new Alcool("Vodka", 40.0));
        alcoolData.add(new Alcool("Pastis", 45.0));
        alcoolData.add(new Alcool("Malibu", 18.0));
        alcoolData.add(new Alcool("Pasoa", 17.0));
        alcoolData.add(new Alcool("Manzana", 20.0));
        
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AlcoolApp");
        
        initRootLayout();
        showMainOverview();
        
        this.primaryStage.show();
	}
	
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMainOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("MainOverview.fxml"));
			AnchorPane mainOverview = (AnchorPane) loader.load();
			
			MainOverviewController controller = loader.getController();
			controller.setMainApp(this);
			
			rootLayout.setCenter(mainOverview);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void showGraphicOverview(Person person, boolean eaten) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("GraphicOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

            Stage graphicStage = new Stage();
            graphicStage.setTitle(person.getFirstName());
            graphicStage.initModality(Modality.WINDOW_MODAL);
            graphicStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            graphicStage.setScene(scene);

            LineChartsValues values = new LineChartsValues(person);
            values.setMainApp(this);
            values.setEat(eaten);
            
            graphicOverviewController controller = loader.getController();
            controller.setDialogStage(graphicStage);
            controller.initGraph(values.getGraph());
            
    		graphicStage.showAndWait();
    		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean showPersonEditDialogOverview(Person person) {
	    try {
	        FXMLLoader loaderPerson = new FXMLLoader();
	        loaderPerson.setLocation(MainApp.class.getResource("EditPersonDialog.fxml"));
	        AnchorPane personOverview = (AnchorPane) loaderPerson.load();

	        Stage PersonEditdialogStage = new Stage();
            PersonEditdialogStage.setTitle("Person");
            PersonEditdialogStage.initModality(Modality.WINDOW_MODAL);
            PersonEditdialogStage.initOwner(primaryStage);
            Scene scene = new Scene(personOverview);
            PersonEditdialogStage.setScene(scene);
	        
	        EditPersonDialogController controllerPerson = loaderPerson.getController();
	        controllerPerson.setPerson(person);
	        controllerPerson.setPersonEditDialogStage(PersonEditdialogStage);
	        
	        PersonEditdialogStage.showAndWait();
	        
            return controllerPerson.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public boolean showAlcoolEditDialogOverview(Alcool alcool) {
	    try {
	        FXMLLoader loaderAlcool = new FXMLLoader();
	        loaderAlcool.setLocation(MainApp.class.getResource("EditAlcoolDialog.fxml"));
	        AnchorPane alcoolOverview = (AnchorPane) loaderAlcool.load();
	        
	        Stage AlcoolEditdialogStage = new Stage();
            AlcoolEditdialogStage.setTitle("Alcool");
            AlcoolEditdialogStage.initModality(Modality.WINDOW_MODAL);
            AlcoolEditdialogStage.initOwner(primaryStage);
            Scene scene = new Scene(alcoolOverview);
            AlcoolEditdialogStage.setScene(scene);

	        
	        EditAlcoolDialogController controllerAlcool = loaderAlcool.getController();
	        controllerAlcool.setAlcool(alcool);
	        controllerAlcool.setDialogStage(AlcoolEditdialogStage);
	        
	        AlcoolEditdialogStage.showAndWait();
	        
            return controllerAlcool.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean showQuantityEditQuantityOverview(Alcool alcool) {
	    try {
	        FXMLLoader loaderQuantity = new FXMLLoader();
	        loaderQuantity.setLocation(MainApp.class.getResource("EditQuantityDialog.fxml"));
	        AnchorPane quantityOverview = (AnchorPane) loaderQuantity.load();

	        Stage QuantitydialogStage = new Stage();
            QuantitydialogStage.setTitle("Quantity");
            QuantitydialogStage.initModality(Modality.WINDOW_MODAL);
            QuantitydialogStage.initOwner(primaryStage);
            Scene scene = new Scene(quantityOverview);
            QuantitydialogStage.setScene(scene);
	        
	        EditQuantityDialogController controllerQuantity = loaderQuantity.getController();
	        controllerQuantity.setAlcool(alcool);
	        controllerQuantity.setDialogStage(QuantitydialogStage);
	        
	        QuantitydialogStage.showAndWait();
	        
	        return controllerQuantity.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public boolean showDeleteOverview(String name) {
	    try {
	        FXMLLoader loaderDelete = new FXMLLoader();
	        loaderDelete.setLocation(MainApp.class.getResource("DeleteOverview.fxml"));
	        AnchorPane deleteOverview = (AnchorPane) loaderDelete.load();

	        Stage DeletedialogStage = new Stage();
            DeletedialogStage.setTitle("Delete "+name+" ?");
            DeletedialogStage.initModality(Modality.WINDOW_MODAL);
            DeletedialogStage.initOwner(primaryStage);
            Scene scene = new Scene(deleteOverview);
            DeletedialogStage.setScene(scene);
	        
	        DeleteOverviewController controllerDelete = loaderDelete.getController();
	        controllerDelete.setDialogStage(DeletedialogStage);
	        
	        DeletedialogStage.showAndWait();
	        
	        return controllerDelete.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public int ShowNewOverview() {
		try {
			FXMLLoader loaderNew = new FXMLLoader();
			loaderNew.setLocation(MainApp.class.getResource("NewOverview.fxml"));
			AnchorPane newOverview = (AnchorPane) loaderNew.load();
	     
			Stage newDialogStage = new Stage();
			newDialogStage.setTitle("New");
			newDialogStage.initModality(Modality.WINDOW_MODAL);
			newDialogStage.initOwner(primaryStage);
			Scene scene = new Scene(newOverview);
			newDialogStage.setScene(scene);
	        
			NewOverviewController controllerNew = loaderNew.getController();
			controllerNew.setDialogStage(newDialogStage);
			newDialogStage.showAndWait();
	        
	        return controllerNew.whatIsClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return 0;
		
	}
}
	
	public ObservableList<Person> getPersonData() {
        return personData;
    }
	
	public ObservableList<Alcool>getAlcoolData(){
		return alcoolData;
	}
	
	public ObservableList<Alcool>getSelectedAlcoolData(){
		return selectedAlcoolData;
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
