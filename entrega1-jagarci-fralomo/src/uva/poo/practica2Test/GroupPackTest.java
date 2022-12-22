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
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
		}
		packGrupo=new GroupPack(listaBicis);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testConstructorGroupPackMenosDe10() {
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		Pack packGrupo1=new GroupPack(listaBicis);
	}
	
	@Test
	public void testQuitaBike() {
		boolean estaEnPack=false;
		BateriaBike bateria=new BateriaBike(48, 13);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<5; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<6; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis.add(electrica);
		Pack packGrupo1=new GroupPack(listaBicis);
		packGrupo1.quitaBike(electrica);
		listaBicis=packGrupo1.getListaBicis();
		for (int i=0; i<listaBicis.size(); i++) {
			if (listaBicis.get(i).equals(electrica)) {
				estaEnPack=true;
			}
		}
		assertFalse(estaEnPack);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testQuitaBikeCon10Bicis() {
		BateriaBike bateria=new BateriaBike(48, 13);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<6; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis.add(electrica);
		Pack packGrupo1=new GroupPack(listaBicis);
		packGrupo1.quitaBike(electrica);
	}
	
	@Test
	public void testGetDepositToPay() {
		double fianzaInicial=10;
		BateriaBike bateria=new BateriaBike(48, 13);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		double deposito=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
			deposito+=adulto.getDepositToPay(fianzaInicial);
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
			deposito+=infantil.getDepositToPay(fianzaInicial);
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
			deposito+=electrica.getDepositToPay(fianzaInicial);
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
		ArrayList<Bike> listaBicis=null;
		packGrupo.setListaBicis(listaBicis);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetListaBicisVacia() {
		ArrayList<Bike> listaBicis=new ArrayList<>();
		packGrupo.setListaBicis(listaBicis);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testSetListaBicisIgualesEnLista() {
		ArrayList<Bike> listaBicis=new ArrayList<>();
		BateriaBike bateria=new BateriaBike(48, 13);
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		listaBicis.add(electrica);
		listaBicis.add(electrica.clone());
		packGrupo.setListaBicis(listaBicis);
	}
	
	@Test
	public void testSetListaBicis() {
		boolean listaAplicada=true;
		ArrayList<Bike> listaBicis=new ArrayList<>();
		ArrayList<String> identificadores=new ArrayList<>();
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			identificadores.add(adulto.getIdentificador());
			listaBicis.add(adulto);
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			identificadores.add(infantil.getIdentificador());
			listaBicis.add(infantil);
		}
		packGrupo.setListaBicis(listaBicis);
		for (int i=0; i<11; i++) {
			if (!packGrupo.getListaBicis().get(i).getIdentificador().equals(identificadores.get(i))) {
				listaAplicada=false;
			}
		}
		assertTrue(listaAplicada);
	}
	
	@Test
	public void testGetListaBicis() {
		ArrayList<Bike> listaBicis=new ArrayList<>();
		boolean mismosIdentificadores=true;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
		}
		for (int i=0; i<7; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		packGrupo.setListaBicis(listaBicis);
		ArrayList<Bike> listaBicisRecibida=packGrupo.getListaBicis();
		for (int i=0; i<listaBicisRecibida.size(); i++) {
			if (!listaBicis.get(i).equals(listaBicisRecibida.get(i))) {
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
		int tamano=packGrupo.getListaBicis().size();
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
		ArrayList<Bike> listaBicis=new ArrayList<>();

		for (int i=0; i<8; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
			contadorBicisElectricas++;
		}
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(contadorBicisElectricas, packGrupo1.getCantidadBicisElectricas());
		assertNotEquals(packGrupo1.getCantidadBicisAdultos(), packGrupo1.getCantidadBicisElectricas());
	}
	
	@Test
	public void testGetCantidadBicisAdulto() {
		int contadorBicisAdulto=0;
		BateriaBike bateria=new BateriaBike(48, 13);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
			contadorBicisAdulto++;
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
		}
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(contadorBicisAdulto, packGrupo1.getCantidadBicisAdultos());
	}
	
	@Test
	public void testGetCantidadBicisInfantiles() {
		int contadorBicisInfantiles=0;
		BateriaBike bateria=new BateriaBike(48, 13);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
			
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
			contadorBicisInfantiles++;
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
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
		ArrayList<Bike> listaBicis=new ArrayList<>();
		double deposito=0;
		for (int i=0; i<4; i++) {
			Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
			listaBicis.add(adulto);
			deposito+=adulto.getDepositToPay(fianzaInicial);
		}
		for (int i=0; i<3; i++) {
			Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
			listaBicis.add(infantil);
			deposito+=infantil.getDepositToPay(fianzaInicial);
		}
		for (int i=0; i<5; i++) {
			Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
			listaBicis.add(electrica);
			deposito+=electrica.getDepositToPay(fianzaInicial);
		}
		deposito=deposito*0.8;
		Pack packGrupo1=new GroupPack(listaBicis);
		assertEquals(deposito, packGrupo.getDepositToPay(fianzaInicial), 0.01);
	}
	
	
	
	
	
	
	

}
