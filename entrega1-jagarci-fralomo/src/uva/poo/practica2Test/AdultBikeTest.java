package uva.poo.practica2Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uva.poo.practica2.AdultBike;
import uva.poo.practica2.BateriaBike;
import uva.poo.practica2.Bike;
import uva.poo.practica2.ElectricBike;

public class AdultBikeTest {

	private AdultBike bici;
	
	@Before
	public void setUp() throws Exception {
		bici=new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
	}

	@Test
	public void testSetTalla() {
		bici.setTalla("S");
		assertEquals(bici.getTalla(), "S");
		bici.setTalla("M");
		assertEquals(bici.getTalla(),"M");
		bici.setTalla("L");
		assertEquals(bici.getTalla(),"L");
		bici.setTalla("XL");
		assertEquals(bici.getTalla(), "XL");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetTallaInvalida() {
		bici.setTalla("Z");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetTallaInvalidaMinuscula() {
		bici.setTalla("z");
	}
	
	@Test
	public void testGetTalla() {
		AdultBike biciAdulto=new AdultBike("Orbea" , "oregon", "S", 12, 20 ,2);
		assertEquals("S",biciAdulto.getTalla());
	}
	
	@Test 
	public void testGetDepositToPay() {
		double fianza=10;
		assertEquals(fianza, bici.getDepositToPay(fianza) ,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetDepositToPayNegativo() {
		double fianza=-10;
		bici.getDepositToPay(fianza);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetDepositToPayCero() {
		double fianza=0;
		bici.getDepositToPay(fianza);
	}
	
	@Test
	public void testEqualsMismasCaracteristicas() {
		AdultBike otraBici=new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		assertNotNull(otraBici);
		assertFalse(bici.equals(otraBici));
	}
	
	@Test
	public void testEqualsDistintasCaracteristicas() {
		AdultBike otraBici=new AdultBike("Orbea" , "free" ,"M", 23, 12, 4);
		assertNotNull(otraBici);
		assertFalse(bici.equals(otraBici));
	}
	
	public void testEqualsMismoIdentificador() {
		AdultBike otraBici=(AdultBike) bici.clone();
		assertNotNull(otraBici);
		assertTrue(bici.equals(otraBici));
	}
	
	public void testEqualsDistintoTipo() {
		BateriaBike bateria=new BateriaBike(48, 57);
		ElectricBike biciElectrica= new ElectricBike("Orbea", "Arriba", "M", 10,48,3 ,bateria, 8);
		assertNotNull(biciElectrica);
		assertFalse(bici.equals(biciElectrica));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEqualsOtraBici() {
		AdultBike otraBici=null;
		bici.equals(otraBici);
	}
	
	@Test
	public void testClone() {
		AdultBike biciAdulto=(AdultBike) bici.clone();
		assertEquals(bici.getIdentificador(),biciAdulto.getIdentificador());
		assertEquals(bici.getMarca(), biciAdulto.getMarca());
		assertEquals(bici.getNumPinones(), biciAdulto.getNumPinones());
		assertEquals(bici.getPeso(), biciAdulto.getPeso(), 0);
		assertEquals(bici.getTalla(), biciAdulto.getTalla());
		assertEquals(bici.getModelo(), biciAdulto.getModelo());
		assertEquals(bici.getNumPlatos(), biciAdulto.getNumPlatos());
	}

	
	

}
