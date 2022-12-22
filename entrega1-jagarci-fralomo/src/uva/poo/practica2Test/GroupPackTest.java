package uva.poo.practica2Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uva.poo.practica2.*;

public class GroupPackTest {
	
	private GroupPack packGrupo;

	@Before
	public void setUp() throws Exception {
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			pos++;
		}
		packGrupo=new GroupPack(listaBicis);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testConstructorGroupPackMenosDe10() {
		Bike[] listaBicis=new Bike[7];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		Pack packGrupo1=new GroupPack(listaBicis);
	}
	
	@Test
	public void testQuitaBike() {
		boolean estaEnPack=false;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		int pos=0;
		for (int i=0; i<5; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<6; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis[pos]=electrica;
		Pack packGrupo1=new GroupPack(listaBicis);
		packGrupo1.quitaBike(electrica);
		listaBicis=packGrupo1.getListaBicis();
		for (int i=0; i<listaBicis.length; i++) {
			if (listaBicis[i].equals(electrica)) {
				estaEnPack=true;
			}
		}
		assertFalse(estaEnPack);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testQuitaBikeCon10Bicis() {
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[10];
		int pos=0;
		for (int i=0; i<6; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis[pos]=electrica;
		Pack packGrupo1=new GroupPack(listaBicis);
		packGrupo1.quitaBike(electrica);
	}
	
	@Test
	public void testGetDepositToPay() {
		double fianzaInicial=10;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		double deposito=0;
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			deposito+=adulto.getDepositToPay(fianzaInicial);
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			deposito+=infantil.getDepositToPay(fianzaInicial);
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			deposito+=electrica.getDepositToPay(fianzaInicial);
			pos++;
		}
		deposito=deposito*0.8;
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(deposito, packGrupo1.getDepositToPay(fianzaInicial), 0.01);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetDepositToPayDepositoNegativo() {
		double fianzaInicial=-10;
		packGrupo.getDepositToPay(fianzaInicial);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetListaBicisListaNull() {
		Bike[] listaBicis=null;
		packGrupo.setListaBicis(listaBicis);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testSetListaBicisIgualesEnLista() {
		Bike[] listaBicis=new Bike[13];
		BateriaBike bateria=new BateriaBike(48, 13);
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis[pos]=electrica;
		pos++;
		listaBicis[pos]=electrica.clone();
		packGrupo.setListaBicis(listaBicis);
	}
	
	@Test
	public void testSetListaBicis() {
		boolean listaAplicada=true;
		Bike[] listaBicis=new Bike[11];
		String[] identificadores=new String[11];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			identificadores[pos]=adulto.getIdentificador();
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			identificadores[pos]=infantil.getIdentificador();
			listaBicis[pos]=infantil;
			pos++;
		}
		packGrupo.setListaBicis(listaBicis);
		for (int i=0; i<11; i++) {
			if (!packGrupo.getListaBicis()[i].getIdentificador().equals(identificadores[i])) {
				listaAplicada=false;
			}
		}
		assertTrue(listaAplicada);
	}
	
	@Test
	public void testGetListaBicis() {
		Bike[] listaBicis=new Bike[11];
		boolean mismosIdentificadores=true;
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		packGrupo.setListaBicis(listaBicis);
		Bike[] listaBicisRecibida=packGrupo.getListaBicis();
		for (int i=0; i<listaBicisRecibida.length; i++) {
			if (!listaBicis[i].equals(listaBicisRecibida[i])) {
				mismosIdentificadores=false;
			}
		}
		assertTrue(mismosIdentificadores);
	}
	
	@Test
	public void testAddBike() {
		Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		packGrupo.addBike(adulto);
		assertNotNull(adulto);
		assertTrue(packGrupo.estaEnLista(adulto));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddBikeBiciNull() {
		Bike adulto= null;
		packGrupo.addBike(adulto);
	}
	
	@Test
	public void testGetCantidadBicis() {
		int tamano=packGrupo.getListaBicis().length;
		assertEquals(tamano, packGrupo.getCantidadBicis());
	}
	
	@Test (expected=IllegalStateException.class)
	public void testGetBiciSinEstarEnPack() {
		Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		packGrupo.getBici(adulto.getIdentificador());
	}
	
	@Test
	public void testGetBici() {
		Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		packGrupo.addBike(adulto);
		assertEquals(adulto, packGrupo.getBici(adulto.getIdentificador()));
	}
	
	@Test
	public void testGetCantidadBicisElectricas() {
		int contadorBicisElectricas=0;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[13];
		int pos=0;
		for (int i=0; i<8; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			contadorBicisElectricas++;
			pos++;
		}
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(contadorBicisElectricas, packGrupo1.getCantidadBicisElectricas());
		assertNotEquals(packGrupo1.getCantidadBicisAdultos(), packGrupo1.getCantidadBicisElectricas());
	}
	
	@Test
	public void testGetCantidadBicisAdulto() {
		int contadorBicisAdulto=0;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			contadorBicisAdulto++;
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			pos++;
		}
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(contadorBicisAdulto, packGrupo1.getCantidadBicisAdultos());
	}
	
	@Test
	public void testGetCantidadBicisInfantiles() {
		int contadorBicisInfantiles=0;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
			
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			contadorBicisInfantiles++;
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			pos++;
		}
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(contadorBicisInfantiles, packGrupo1.getCantidadBicisInfantiles());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEstaEnListaBiciNull() {
		Bike infantil= null;
		packGrupo.estaEnLista(infantil);
	}
	
	@Test
	public void testEstaEnLista() {
		Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
		packGrupo.addBike(infantil);
		assertTrue(packGrupo.estaEnLista(infantil));
	}
	
	@Test
	public void testSumaDepositos() {
		double fianzaInicial=10;
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		double deposito=0;
		int posicion=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[posicion]=adulto;
			deposito+=adulto.getDepositToPay(fianzaInicial);
			posicion++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[posicion]=infantil;
			deposito+=infantil.getDepositToPay(fianzaInicial);
			posicion++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[posicion]=electrica;
			deposito+=electrica.getDepositToPay(fianzaInicial);
			posicion++;
		}
		deposito=deposito*0.8;
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(deposito, packGrupo1.getDepositToPay(fianzaInicial), 0.01);
	}
	
	@Test
	public void testEquals() {
		BateriaBike bateria=new BateriaBike(48, 13);
		Bike[] listaBicis=new Bike[12];
		int pos=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis[pos]=adulto;
			pos++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis[pos]=infantil;
			pos++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis[pos]=electrica;
			pos++;
		}
		GroupPack otro=new GroupPack(listaBicis);
		assertFalse(packGrupo.equals(otro));
	}
	
	
	
	
	
	
	

}
