package uva.poo.practica2Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import uva.poo.practica2.*;	

import org.junit.Before;
import org.junit.Test;

public class PolimorfismoTest {


	@Test
	public void fianzaAdultBike() {
		double fianza=10;
		Resource adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		double fianzaModificada=adulto.getDepositToPay(fianza);
		assertEquals(fianza, fianzaModificada, 0);
	}
	
	@Test
	public void fianzaChildBike() {
		double fianza=10;
		Resource infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
		double fianzaModificada=infantil.getDepositToPay(fianza);
		assertEquals(fianza*0.85, fianzaModificada, 0.01);
	}
	
	@Test
	public void fianzaElectricBike24Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(24, 13);
		Resource electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		double fianzaModificada=electrica.getDepositToPay(fianza);
		assertEquals(fianza*1.24, fianzaModificada, 0.01);
	}
	
	@Test
	public void fianzaElectricBike36Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(36, 13);
		Resource electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		double fianzaModificada=electrica.getDepositToPay(fianza);
		assertEquals(fianza*1.36, fianzaModificada, 0.01);
	}
	
	@Test
	public void fianzaElectricBike48Voltios() {
		double fianza=10;
		BateriaBike bateria=new BateriaBike(48, 13);
		Resource electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12 ,3 ,bateria, 8);
		double fianzaModificada=electrica.getDepositToPay(fianza);
		assertEquals(fianza*1.48, fianzaModificada, 0.01);
	}
	
	@Test
	public void fianzaPackFamiliar() {
		double fianzaInicial=10;
		BateriaBike bateria=new BateriaBike(36, 13);
		Bike adulto= new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		Bike electrica= new ElectricBike("Orbea", "Arriba", "M", 10,12,3 ,bateria, 8);
		Bike infantil= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
		Bike infantil2= new ChildBike("BH" , "Oregon" ,22, 10, 34, 5);
		double deposito=(adulto.getDepositToPay(fianzaInicial)+electrica.getDepositToPay(fianzaInicial)+infantil.getDepositToPay(fianzaInicial)+infantil2.getDepositToPay(fianzaInicial))*0.5;
		ArrayList<Bike> listaBicis=new ArrayList<>();
		listaBicis.add(adulto);
		listaBicis.add(electrica);
		listaBicis.add(infantil2);
		listaBicis.add(infantil);
		Resource packFamiliar=new FamilyPack(listaBicis);
		assertEquals(deposito, packFamiliar.getDepositToPay(fianzaInicial), 0.01);
	}
	
	@Test
	public void fianzaPackGrupo() {
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
		Resource packGrupo=new GroupPack(listaBicis);
		assertEquals(deposito, packGrupo.getDepositToPay(fianzaInicial), 0.01);
	}
	
	
	
	
	

}
