package test.fr.adresses.objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.fr.adresses.objects.Alcool;

public class AlcoolTest {

	private Alcool randomAlcool;
	
	@Before
	public void initTest() {
		randomAlcool = new Alcool("beer", 5.0);
		randomAlcool.setQuantity(100.0);
	}
	
	@Test
	public void testAlcoolProperties() {
		String name = "beer";
		double degree = 5;
		double quantity = 100;
		
		assertEquals(name, randomAlcool.alcoolNameProperty().get());
		assertEquals(degree , randomAlcool.degreeProperty().get(), 0);
		assertEquals(quantity, randomAlcool.quantityProperty().get(), 0);
	}

	@Test
	public void testAlcoolGetters() {
		String name = "beer";
		double degree = 5;
		double quantity = 100;
		
		assertEquals(name, randomAlcool.getAlcoolName());
		assertEquals(degree, randomAlcool.getDegree(), 0);
		assertEquals(quantity, randomAlcool.getQuantity(), 0);
	}

	@Test
	public void testAlcoolSetters() {
		Alcool beer = new Alcool();
		
		beer.setAlcoolName("beer");
		beer.setDegree(5);
		beer.setQuantity(100);
		
		assertEquals("beer", beer.getAlcoolName());
		assertEquals(5, beer.getDegree(), 0);
		assertEquals(100, beer.getQuantity(), 0);
	}
}
