package uva.poo.practica1Test;
import uva.poo.practica1.AnclajeParkingPoint;
import uva.poo.practica1.CityBikeParkingPoint;
import uva.poo.practica1.CityBikeSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CityBikeParkingPointTest {

	
	// Tests del constructor
	@Test
	public void testInicializarSinArgumentos() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		
		assertEquals(0,cbp.getPosicionGPS()[0],0);
		assertEquals(0,cbp.getPosicionGPS()[1],0);	
	}
	
	@Test
	public void testInicializarIndicandoPosicionGPS() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(3,4);
		
		assertEquals(cbp.getPosicionGPS()[0], 3,0);
		assertEquals(cbp.getPosicionGPS()[1], 4,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInicializarIndicandoPosicionGPSNegativa() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(-3,-4.5);
	}
	
	@Test
	public void testIncializarConPosicionGPSyCantidadDeAnclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(5,3,4);
		
		assertEquals(cbp.getCantidadAnclajes(),5);
		assertEquals(cbp.getPosicionGPS()[0], 3,0);
		assertEquals(cbp.getPosicionGPS()[1], 4,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIncializarConPosicionGPSNegativayCantidadDeAnclajes() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(5,-3,-4);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIncializarConPosicionGPSyCantidadDeAnclajesEn0() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(0,3,4);
	}

	// Test metodo getIdPuntoAparcamiento
	@Test
	public void testGetIdPuntoAparcamiento() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		
		// Si no tiene identificador falla
		assertNotNull(cbp.getIdPuntoAparcamiento());
	}
	
	// Tests setCantidadAnclajes
	@Test
	public void testSetCantidadAnclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		
		assertEquals(1,cbp.getCantidadAnclajes());
		
		cbp.setCantidadAnclajes(4);
		
		assertEquals(cbp.getCantidadAnclajes(),4);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testSetCantidadAnclajesCon0Anclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.setCantidadAnclajes(0);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testSetCantidadAnclajesConMenosDe0Anclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.setCantidadAnclajes(-2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDistanciaAPuntoAparcamientoNull() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		CityBikeParkingPoint cbp2= null;
		cbp.distanciaAPuntoAparcamiento(cbp2);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLatitudMenorLimite() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.distanciaAPosicionGPS(-91, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLatitudMayorLimite() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.distanciaAPosicionGPS(91, 0);
		}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLongitudMenorLimite() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.distanciaAPosicionGPS(0, -181);
		}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLongitudMayorLimite() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.distanciaAPosicionGPS(0, 181);
		}
	
	// Tests metodo getCantidadAnclajes
	@Test
	public void testGetCantidadAnclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.setCantidadAnclajes(4);
		
		assertEquals(4,cbp.getCantidadAnclajes());
	}
	
	// Test metodo getListaAnclajes
	@Test
	public void testGetListaAnclajes() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(2,3,5);
		AnclajeParkingPoint[] listaAnclajes=cbp.getListaAnclajes();
		listaAnclajes[0].setReservado(true);
		
		
		assertTrue(listaAnclajes[0].isReservado());
		assertFalse(listaAnclajes[1].isReservado());
	}
	
	// Test metodo getCantidadAnclajesOcupados
	@Test
	public void testGetCantidadAnclajesOcupadosVaciosYReserservados() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(4,3,5);
		AnclajeParkingPoint[] listaAnclajes=cbp.getListaAnclajes();
		listaAnclajes[0].setOcupado(true);
		listaAnclajes[1].setOcupado(true);
		listaAnclajes[2].setVacio(true);
		listaAnclajes[3].setReservado(true);
		
		assertEquals(cbp.getCantidadAnclajesOcupados(),2);
	}
	
	// Test metodo getCantidadAnclajesReservados
	@Test
	public void testGetCantidadAnclajesReservados() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(4,3,5);
		AnclajeParkingPoint[] listaAnclajes=cbp.getListaAnclajes();
		listaAnclajes[0].setOcupado(true);
		listaAnclajes[1].setOcupado(true);
		listaAnclajes[2].setVacio(true);
		listaAnclajes[3].setReservado(true);
		
		assertEquals(cbp.getCantidadAnclajesReservados(),1);
	}
	
	// Test metodo getCantidadAnclajesVacios
	@Test
	public void testGetCantidadAnclajesVacios() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(4,3,5);
		AnclajeParkingPoint[] listaAnclajes=cbp.getListaAnclajes();
		listaAnclajes[0].setOcupado(true);
		listaAnclajes[1].setOcupado(true);
		listaAnclajes[2].setVacio(true);
		listaAnclajes[3].setReservado(true);

		assertEquals(cbp.getCantidadAnclajesVacios(),1);
	}
	
	// Test metodo getPosicionGPS
	@Test
	public void testGetPosicionGPS() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(3,7.5);
		
		assertEquals(cbp.getPosicionGPS()[0],3.0,0);
		assertEquals(cbp.getPosicionGPS()[1],7.5,0);
	}
	
	// Test metodo setPosicionGPS
	@Test
	public void testSetPosicionGPS() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.setPosicionGPS(3, 7.5);
		
		assertEquals(cbp.getPosicionGPS()[0],3.0,0);
		assertEquals(cbp.getPosicionGPS()[1],7.5,0);
	}
	
	// Test metodo getPosicionGMS
	@Test
	public void testGetPosicionGMS() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint();
		cbp.setPosicionGPS(3242.4234, 654.89134);
		String posicionGMSLatitud="3242º 25' 24.24''";
		String posicionGMSLongitud="654º 53' 28.824''";
		
		assertEquals(cbp.getPosicionGMS()[0], posicionGMSLatitud);
		assertEquals(cbp.getPosicionGMS()[1], posicionGMSLongitud);
	}
	
	// Test metodo distanciaAPosicionGPS
	@Test
	public void testDistanciaAPosicionGPS() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(4,8);
		
		double distanciaEsperada=248.02380226345218;
		assertEquals(cbp.distanciaAPosicionGPS(5.0,6.0),distanciaEsperada,0.0001);
	}
	
	// Test metodo distanciaAPuntoAparcamiento
	@Test
	public void testDistanciaAPuntoAparcamiento() {
		CityBikeParkingPoint cbp=new CityBikeParkingPoint(4,8);
		CityBikeParkingPoint otro=new CityBikeParkingPoint(5,6);
		
		double distanciaEsperada=248.02380226345218;
		assertEquals(cbp.distanciaAPuntoAparcamiento(otro),distanciaEsperada,0.0001);
	}
	
	
	

	
	
	
}
