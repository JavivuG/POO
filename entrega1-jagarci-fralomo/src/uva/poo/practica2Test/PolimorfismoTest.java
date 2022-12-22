package uva.poo.practica2Test;

import static org.junit.Assert.*;
import uva.poo.practica2.*;	

import org.junit.Before;
import org.junit.Test;

public class PolimorfismoTest {
	
	private Resource r;
	
	@Before
	public void setUp() throws Exception {
		r=new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
	}

	@Test
	public void fianzaAdultBike() {
		double fianza=10;
		double fianzaModificada=r.getDepositToPay(fianza);
		assertEquals(fianza, fianzaModificada, 0);
	}
	
	@Test
	public void fianzaChildBike() {
		double fianza=10;
		double fianzaModificada=r.getDepositToPay(fianza);
		assertEquals(fianza*0.85, fianzaModificada, 0.01);
	}
	
	@Test
	public void fianzaElectricBike24Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(24, 13);
		double fianzaModificada=r.getDepositToPay(fianza);
		assertEquals(fianza, fianzaModificada, 0);
	}
	
	@Test
	public void fianzaElectricBike36Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(36, 13);
		double fianzaModificada=r.getDepositToPay(fianza);
		assertEquals(fianza*1.1, fianzaModificada, 0);
	}
	
	@Test
	public void fianzaElectricBike48Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(48, 13);
		double fianzaModificada=r.getDepositToPay(fianza);
		assertEquals(fianza*1.2, fianzaModificada, 0);
	}

}
