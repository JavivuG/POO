package uva.poo.practica1Test;
import uva.poo.practica1.AnclajeParkingPoint;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test de la clase AnclajeParkingPoint
 * @author jagarci
 * @author fralomo
 *
 */
public class AnclajeParkingPointTest {
	
	

	// Tests del constructor
	@Test
	public void testConstructorAnclaje() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		assertTrue(a.isOcupado());
		assertFalse(a.isReservado());
		assertFalse(a.isVacio());
	}
	
	// Tests del constructor de copia
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorAnclajeDadoAnclajeNull() {
		AnclajeParkingPoint a=null;
		AnclajeParkingPoint b = new AnclajeParkingPoint(a);
	}
	
	@Test
	public void testConstructorAnclajeDadoAnclajeValido() {
		AnclajeParkingPoint copia= new AnclajeParkingPoint();
		AnclajeParkingPoint b = new AnclajeParkingPoint(copia);
		
		assertNotNull(copia);
		assertTrue(copia.isOcupado());
		assertFalse(copia.isReservado());
		assertFalse(copia.isVacio());
	}
	
	@Test
	public void testConstructorAnclajeDadoAnclajeCambiandoEstados() {
		AnclajeParkingPoint a= new AnclajeParkingPoint();
		AnclajeParkingPoint b = new AnclajeParkingPoint(a);
		
		a.setOcupado(false);
		a.setReservado(true);
		a.setVacio(false);
		
		assertNotEquals(a.isOcupado(), b.isOcupado());
		assertNotEquals(a.isReservado(),b.isReservado());
		assertEquals(a.isVacio(), b.isVacio());
	}
	
	// Test metodo setReservado
	@Test
	public void testEstaReservado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setReservado(true);
		
		assertTrue(a.isReservado());
	}
	
	@Test 
	public void testEstaReservadoNoTieneOtrosEstados() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setReservado(true);
		
		assertFalse(a.isVacio());
		assertFalse(a.isOcupado());
	}
	
	// Test metodo setOcupado
	@Test
	public void testEstaOcupado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setOcupado(true);
		
		assertTrue(a.isOcupado());
	}
	
	@Test 
	public void testEstaOcupadoNoTieneOtrosEstados() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setOcupado(true);
		
		assertFalse(a.isVacio());
		assertFalse(a.isReservado());
	}
	
	// Test metodo setVacio
	@Test
	public void testEstaVacio() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setVacio(true);
		
		assertTrue(a.isVacio());
	}
	
	@Test 
	public void testEstaVacioNoTieneOtrosEstados() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setVacio(true);
		
		assertFalse(a.isOcupado());
		assertFalse(a.isReservado());
	}
	
	// Test metodo isReservado
	@Test
	public void testIsReservado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setReservado(true);
		
		assertTrue(a.isReservado());
	}
	
	// Test metodo isVacio
	@Test
	public void testIsVacio() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setVacio(true);
		
		assertTrue(a.isVacio());
	}
	
	// Test metodo isOcupado
	@Test
	public void testIsOcupado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setOcupado(true);
		
		assertTrue(a.isOcupado());
	}
	
	// Tests metodo getEstado
	@Test
	public void testGetEstadoAnclajeOcupado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setOcupado(true);
		
		assertEquals("Ocupado", a.getEstado());
	}
	
	@Test
	public void testGetEstadoAnclajeReservado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setReservado(true);
		
		assertEquals("Reservado", a.getEstado());
	}
	
	@Test
	public void testGetEstadoAnclajeVacio() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setVacio(true);
		
		assertEquals("Vacio", a.getEstado());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testGetEstadoAnclajeSinEstado() {
		AnclajeParkingPoint a=new AnclajeParkingPoint();
		a.setVacio(false);
		a.setReservado(false);
		a.setOcupado(false);
		a.getEstado();

	}
		
}

