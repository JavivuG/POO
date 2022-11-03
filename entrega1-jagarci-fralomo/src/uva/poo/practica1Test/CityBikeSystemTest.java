package uva.poo.practica1Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uva.poo.practica1.CityBikeSystem;

public class CityBikeSystemTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testInicializarSinArgumentos() {
		CityBikeSystem cbs = new CityBikeSystem();
		assertEquals(cbs.getFianza(), 0, 0.1);
		assertEquals(cbs.getCantidadPuntosAparcamiento(), 1, 0.1);
	}

}
