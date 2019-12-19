package fr.adresses.utilitary;


import fr.adresses.MainApp;
import fr.adresses.objects.Alcool;
import fr.adresses.objects.Person;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;


public class LineChartsValues {
	
	private Person person;
	private double M;//Gewicht in Kg
	private double C;//Diffusion Konstante
	private boolean eat = true;
	private ObservableList<Alcool> selectedAlcoolData;
	private XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
	
	public void setMainApp(MainApp mainApp) {
		this.selectedAlcoolData = mainApp.getSelectedAlcoolData();
	}
	
	public double getEthanolVolume(){
		Alcool[] alcool = new Alcool[selectedAlcoolData.size()];
		alcool = selectedAlcoolData.toArray(alcool);
		double alcoolVolume = 0;
		for(int i=0; i<alcool.length;i++) {
			alcoolVolume += ((alcool[i].getDegree()/100) * (alcool[i].getQuantity()*10));
		}
		return alcoolVolume;
	}
	
	public LineChartsValues(Person person) {
		this.person = person;
		this.M = person.getWeight();
		if(person.getSex().toString()=="woman") {
			this.C = 0.6;
		} else {
			this.C = 0.7;
		}
	}
	
	public void setEat(boolean eat) {
		this.eat = eat;
	}
	
	public int eated() {
		int eated = 0;
		if(eat) {
			eated = 15;
		} else {
			eated = 10;
		}
		return eated;
	}
	
	public Double getAlcoolValue() {
		double A= (getEthanolVolume()*0.789)/(M*C);
		return A;
	}
	
	public double getZeroValue(){
		double t;
		t = (getAlcoolValue()*60)/(eated()*0.01);
		return t/60;
	}
	
	public XYChart.Series<Number, Number> getGraph() {
		series1.setName(person.getFirstName().toString());
		double start;
		series1.getData().add(new XYChart.Data<>(0, 0));
		
		if(eat) {
			series1.getData().add(new XYChart.Data<>(1, getAlcoolValue()));
			start = 1;
		} else {
			series1.getData().add(new XYChart.Data<>(0.5, getAlcoolValue()));
			start = 0.5;
		}
		
		series1.getData().add(new XYChart.Data<>((start+getZeroValue()), 0));
		return series1;
	}
}