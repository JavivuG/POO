package uva.poo.practica1Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;
import uva.poo.practica1.CityBikeParkingPoint;
import uva.poo.practica1.CityBikeSystem;

/**
 * Test de la clase CityBikeSystemTest
 * @author jagarci
 * @author fralomo
 *
 */
public class CityBikeSystemTest {
	
	CityBikeSystem cbs;
	
	//Tests Válidos:
	@Test
	public void testInicializarSinArgumentos() {
		cbs = new CityBikeSystem();
		assertEquals(cbs.getFianza(), 0, 0.1);
		assertEquals(cbs.getCantidadPuntosAparcamiento(), 1);
	}
	@Test
	public void testInicializarConAtributos() {
		cbs = new CityBikeSystem(2.5, 4);
		assertEquals(cbs.getFianza(), 2.5, 0.1);
		assertEquals(cbs.getCantidadPuntosAparcamiento(), 4);
	}
	
	@Test
	public void testInicializarCopiandoOtro() {
		cbs = new CityBikeSystem(2.5, 4);
		CityBikeSystem cbs2 = new CityBikeSystem(cbs);
		assertEquals(cbs2.getFianza(), 2.5, 0.1);
		assertEquals(cbs2.getCantidadPuntosAparcamiento(), 4);
	}
	
	@Test
	public void testSetGetFianza() {
		cbs = new CityBikeSystem();
		cbs.setFianza(2.5);
		assertEquals(2.5, cbs.getFianza(), 0.1);
	}
	
	@Test
	public void testSetGetCantidadPuntosAparcamiento() {
		cbs = new CityBikeSystem();
		cbs.setCantidadPuntosAparcamiento(3);
		assertEquals(3, cbs.getCantidadPuntosAparcamiento());
	}
	
	@Test
	public void testSetGetListaPuntosAparcamiento() {
		cbs=new CityBikeSystem(2.5, 3);
		CityBikeSystem cbs2 = new CityBikeSystem(2.5, 5);
		cbs.setListaPuntosAparcamiento(cbs2.getListaPuntosAparcamiento());
		assertEquals(cbs.getListaPuntosAparcamiento(), cbs2.getListaPuntosAparcamiento());
		assertEquals(cbs.getListaPuntosAparcamiento().size(), cbs2.getListaPuntosAparcamiento().size());
	}
	
	@Test
	public void testAddRemoveCityBikeParkingPoint() {
		cbs= new CityBikeSystem(2.5, 2);
		CityBikeParkingPoint cbpp= new CityBikeParkingPoint();
		
		cbs.addCityBikeParkingPoint(cbpp);
		assertEquals(cbs.getCantidadPuntosAparcamiento(), 3);
		assertEquals(cbs.getListaPuntosAparcamiento().get(2), cbpp);
		assertTrue(cbs.estaEnListaPuntosAparcamiento(cbpp.getIdPuntoAparcamiento()));
		
		cbs.removeCityBikeParkingPoint(cbpp);
		assertEquals(cbs.getCantidadPuntosAparcamiento(), 2);
		assertFalse(cbs.estaEnListaPuntosAparcamiento(cbpp.getIdPuntoAparcamiento()));
	}
	
	@Test
	public void testGetPuntosAparcamientoBicisDisponibles() {
		cbs= new CityBikeSystem(2.5, 2);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		for (int i= 0 ; i<listaPuntosAparcamiento.get(0).getListaAnclajes().length ; i++) {
			listaPuntosAparcamiento.get(0).getListaAnclajes()[i].setOcupado(true);
		}
		for (int i= 0 ; i<listaPuntosAparcamiento.get(1).getListaAnclajes().length ; i++) {
			listaPuntosAparcamiento.get(1).getListaAnclajes()[i].setVacio(true);
		}
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		assertTrue(cbs.getPuntosAparcamientoBicisDisponibles().contains(cbs.getListaPuntosAparcamiento().get(0)));
		assertFalse(cbs.getPuntosAparcamientoBicisDisponibles().contains(cbs.getListaPuntosAparcamiento().get(1)));
	}
	
	@Test
	public void testGetPuntosAparcamientoAnclajesVacios() {
		cbs= new CityBikeSystem(2.5, 2);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		for (int i= 0 ; i<listaPuntosAparcamiento.get(0).getListaAnclajes().length ; i++) {
			listaPuntosAparcamiento.get(0).getListaAnclajes()[i].setOcupado(true);
		}
		for (int i= 0 ; i<listaPuntosAparcamiento.get(1).getListaAnclajes().length ; i++) {
			listaPuntosAparcamiento.get(1).getListaAnclajes()[i].setVacio(true);
		}
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		
		assertTrue(cbs.getPuntosAparcamientoAnclajesVacios().contains(cbs.getListaPuntosAparcamiento().get(1)));
		assertFalse(cbs.getPuntosAparcamientoAnclajesVacios().contains(cbs.getListaPuntosAparcamiento().get(0)));
	}
	
	@Test
	public void testGetPuntosAparcamientoCercanos() {
		cbs= new CityBikeSystem(2.5, 2);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		listaPuntosAparcamiento.get(0).setPosicionGPS(0.5, 0.5);
		listaPuntosAparcamiento.get(1).setPosicionGPS(2, 2);
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		
		assertTrue(cbs.getPuntosAparcamientoCercanos(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(0)));
		assertFalse(cbs.getPuntosAparcamientoCercanos(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(1)));
	}
	
	@Test
	public void testGetPuntosAparcamientoCercanosVacios() {
		cbs= new CityBikeSystem(2.5, 3);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		listaPuntosAparcamiento.get(0).setPosicionGPS(0.5, 0.5);
		listaPuntosAparcamiento.get(1).setPosicionGPS(0.5, 0.5);
		listaPuntosAparcamiento.get(2).setPosicionGPS(2, 2);
		
		listaPuntosAparcamiento.get(0).getListaAnclajes()[0].setVacio(true);
		listaPuntosAparcamiento.get(2).getListaAnclajes()[0].setVacio(true);
		
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		
		assertTrue(cbs.getPuntosAparcamientoCercanosVacios(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(0)));
		assertFalse(cbs.getPuntosAparcamientoCercanosVacios(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(1)));
		assertFalse(cbs.getPuntosAparcamientoCercanosVacios(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(2)));
	}
	
	@Test
	public void testGetPuntosAparcamientoCercanosOcupados() {
		cbs= new CityBikeSystem(2.5, 3);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		listaPuntosAparcamiento.get(0).setPosicionGPS(0.5, 0.5);
		listaPuntosAparcamiento.get(1).setPosicionGPS(0.5, 0.5);
		listaPuntosAparcamiento.get(2).setPosicionGPS(2, 2);
		
		
		listaPuntosAparcamiento.get(1).getListaAnclajes()[0].setVacio(true);
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		
		assertTrue(cbs.getPuntosAparcamientoCercanosOcupados(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(0)));
		assertFalse(cbs.getPuntosAparcamientoCercanosOcupados(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(1)));
		assertFalse(cbs.getPuntosAparcamientoCercanosOcupados(coords ,100).contains(cbs.getListaPuntosAparcamiento().get(2)));
	}
	
	@Test
	public void testGetDatosPuntoAparcamiento() {
		cbs= new CityBikeSystem(2.5, 1);
		
		 
		assertEquals(cbs.getDatosPuntoAparcamiento(cbs.getListaPuntosAparcamiento().get(0).getIdPuntoAparcamiento()), cbs.getListaPuntosAparcamiento().get(0).toString());
	}
	
	@Test
	public void testToString() {
		cbs= new CityBikeSystem(2.5, 1);
		String fianza="Valor de fianza: "+ cbs.getFianza() +"\n";
		String cantidadPuntosAparcamiento="Cantidad de puntos de Aparcamiento: "+ cbs.getCantidadPuntosAparcamiento()+ "\n";
		 
		assertEquals(cbs.toString(), fianza+cantidadPuntosAparcamiento);
	}
	
	@Test
	public void testAlquilarDevolverBici() {
		cbs= new CityBikeSystem(2.5, 1);
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		//listaPuntosAparcamiento.get(0).getListaAnclajes()[0].setOcupado(true);
		
		
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		cbs.alquilarBici(tarjeta, listaPuntosAparcamiento.get(0).getListaAnclajes()[0]);
		
		assertEquals(tarjeta.getSaldoActual(), 2.5, 0.1);
		assertTrue(listaPuntosAparcamiento.get(0).getListaAnclajes()[0].isVacio());
		
		cbs.devolverBici(tarjeta, listaPuntosAparcamiento.get(0).getListaAnclajes()[0]);
		
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.1);
		assertTrue(listaPuntosAparcamiento.get(0).getListaAnclajes()[0].isOcupado());
	}
	
	@Test
	public void testReservarBici() {
		cbs= new CityBikeSystem(2.5, 1);
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=cbs.getListaPuntosAparcamiento();
		
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
		cbs.reservarBici(tarjeta, listaPuntosAparcamiento.get(0).getListaAnclajes()[0]);
		
		assertEquals(tarjeta.getSaldoActual(), 2.5, 0.1);
		assertTrue(listaPuntosAparcamiento.get(0).getListaAnclajes()[0].isReservado());
	}
	
	//Test no válidos
	@Test (expected=IllegalArgumentException.class)
	public void testInicializarConFianzaNegativa() {
		cbs = new CityBikeSystem(-1, 4);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testInicializarCon0Aparcamientos() {
		cbs = new CityBikeSystem(1, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testInicializarConCopiaNull() {
		cbs = new CityBikeSystem(null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetFianzaNegativa() {
		cbs = new CityBikeSystem();
		cbs.setFianza(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetCantidadAparcamientosMenor1() {
		cbs = new CityBikeSystem();
		cbs.setCantidadPuntosAparcamiento(0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetListaPuntosAparcamientoNull() {
		cbs = new CityBikeSystem();
		cbs.setListaPuntosAparcamiento(null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetListaPuntosAparcamientoVacia() {
		cbs = new CityBikeSystem();
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento= new ArrayList<CityBikeParkingPoint>();
		cbs.setListaPuntosAparcamiento(listaPuntosAparcamiento);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddCityBikeParkingPointNull() {
		cbs = new CityBikeSystem();
		cbs.addCityBikeParkingPoint(null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRemoveCityBikeParkingPointCuandoHay1OMenos() {
		cbs = new CityBikeSystem();
		cbs.removeCityBikeParkingPoint(cbs.getListaPuntosAparcamiento().get(0).getIdPuntoAparcamiento());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRemoveCityBikeParkingPointQueNoEstaEnLista() {
		cbs = new CityBikeSystem(0, 2);
		cbs.removeCityBikeParkingPoint("id_inventado");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRemoveCityBikeParkingPointNull() {
		cbs = new CityBikeSystem(0, 2);
		CityBikeParkingPoint cbpp= new CityBikeParkingPoint();
		cbpp= null;
		cbs.removeCityBikeParkingPoint(cbpp);
	}
	
	@Test
	public void testIndexPuntoAparcamientoNoEstaEnLista() {
		cbs = new CityBikeSystem();
		
		assertEquals(cbs.indexPuntoAparcamiento("id_inventado"), -1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testIndexPuntoAparcamientoNull() {
		cbs = new CityBikeSystem();
		CityBikeParkingPoint cbpp= new CityBikeParkingPoint();
		cbpp= null;
		cbs.indexPuntoAparcamiento(cbpp);
	}
	
	@Test
	public void testNoEstaEnListaPuntosAparcamiento() {
		cbs = new CityBikeSystem();
		
		assertFalse(cbs.estaEnListaPuntosAparcamiento("id_inventado"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEstaEnListaPuntosAparcamientoNull() {
		cbs = new CityBikeSystem();
		CityBikeParkingPoint cbpp= new CityBikeParkingPoint();
		cbpp= null;
		cbs.estaEnListaPuntosAparcamiento(cbpp);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosRadio0() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanos(coords, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLatitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= -91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanos(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLatitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanos(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLongitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= -181;
		cbs.getPuntosAparcamientoCercanos(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosLongitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 181;
		cbs.getPuntosAparcamientoCercanos(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosVaciosRadio0() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosVacios(coords, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosVaciosLatitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= -91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosVacios(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosVaciosLatitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosVacios(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosVaciosLongitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= -181;
		cbs.getPuntosAparcamientoCercanosVacios(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosVaciosLongitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 181;
		cbs.getPuntosAparcamientoCercanosVacios(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosOcupadosRadio0() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosOcupados(coords, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosOcupadosLatitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= -91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosOcupados(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosOcupadosLatitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 91;
		coords[1]= 0;
		cbs.getPuntosAparcamientoCercanosOcupados(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosOcupadosLongitudMenorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= -181;
		cbs.getPuntosAparcamientoCercanosOcupados(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPuntosAparcamientoCercanosOcupadosLongitudMayorLimite() {
		cbs = new CityBikeSystem();
		double[] coords= new double[2];
		coords[0]= 0;
		coords[1]= 181;
		cbs.getPuntosAparcamientoCercanosOcupados(coords, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetDatosPuntoAparcamientoNoEstaEnLista() {
		cbs = new CityBikeSystem();
		cbs.getDatosPuntoAparcamiento("id_inventado");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAlquilarBiciTarjetaNull() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= null;
		cbs.alquilarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testAlquilarBiciAnclajeVacio() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setVacio(true);
		cbs.alquilarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testAlquilarBiciAnclajeReservado() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setReservado(true);
		cbs.alquilarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testAlquilarBiciTarjetaSaldoInsuficiente() {
		cbs = new CityBikeSystem(2, 1);
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",1);
		cbs.alquilarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDevolverBiciTarjetaNull() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= null;
		cbs.devolverBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testDevolverBiciAnclajeOcupado() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setOcupado(true);
		cbs.devolverBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testDevolverBiciAnclajeReservado() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setReservado(true);
		cbs.devolverBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testReservarBiciTarjetaNull() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= null;
		cbs.reservarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testReservarBiciAnclajeVacio() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setVacio(true);
		cbs.reservarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testReservarBiciAnclajeReservado() {
		cbs = new CityBikeSystem();
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0].setReservado(true);
		cbs.reservarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testReservarBiciTarjetaSaldoInsuficiente() {
		cbs = new CityBikeSystem(2, 1);
		TarjetaMonedero tarjeta= new TarjetaMonedero("A156Bv09_1zXo894",1);
		cbs.reservarBici(tarjeta, cbs.getListaPuntosAparcamiento().get(0).getListaAnclajes()[0]);
	}
	
	
	
	
	
	
}
