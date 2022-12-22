package uva.poo.practica2Test;
import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;
import uva.poo.practica1.*;
import uva.poo.practica2.*;

public class pruebaElectricBike {

	public static void main(String[] args) {
		BateriaBike bateria=new BateriaBike(48, 57);
		Bike e= new ChildBike("Orbea", "Oregon", 12, 10.34, 3, 8);
		Bike r= new ChildBike("Orbea", "Oregon", 12, 10.34, 3, 8);
		Bike g =new ElectricBike("Orbea", "Arriba", "M", 10,34,3 ,bateria, 8);
		Bike p= new ElectricBike("Orbea", "Arriba", "M", 10,48,3 ,bateria, 8);
		Bike j=new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);

		TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894", 50);
		CoordenadaParkingPoint coordenadas=new CoordenadaParkingPoint(14.5, 68.72);
		CoordenadaParkingPoint coordenadas1=new CoordenadaParkingPoint(18.9, 73.421);
		
		CityBikeParkingPoint puntoAparcamiento=new CityBikeParkingPoint(3,coordenadas);
		CityBikeParkingPoint puntoAparcamiento1=new CityBikeParkingPoint(6,coordenadas1);
		
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=new ArrayList<>();
		listaPuntosAparcamiento.add(puntoAparcamiento);
		listaPuntosAparcamiento.add(puntoAparcamiento1);
		
		CityBikeSystem sistema=new CityBikeSystem(listaPuntosAparcamiento);
		puntoAparcamiento.setFianza(10);
		System.out.println("Fianza del punto de aparcamiento: " + puntoAparcamiento.getFianza());
		sistema.setFianzaGlobal(10);
		System.out.println("Fianza del sistema:" +sistema.getFianza());
		System.out.println("Fianza del punto de aparcamiento: " + puntoAparcamiento.getFianza());
		AnclajeParkingPoint anclaje=puntoAparcamiento.getListaAnclajes()[2];
		anclaje.setOcupado(true, j);
		double saldoAntesDeQuitarBici=tarjeta.getSaldoActual();
		System.out.println("");
		System.out.println("Saldo inicial: "+ tarjeta.getSaldoActual());
		sistema.getListaPuntosAparcamiento().get(0).alquilarBici(tarjeta, anclaje);
		double saldoCobrado=saldoAntesDeQuitarBici-tarjeta.getSaldoActual();
		if (saldoCobrado<0) {
			System.out.println("Se ha devuelto: "+ saldoCobrado*(-1));
		}
		else {
			System.out.println("Se ha cobrado: "+ saldoCobrado);
		}
		
		System.out.println("Saldo actual: "+ tarjeta.getSaldoActual());
		
		System.out.println("");
		double saldoAntesDeQuitarBici1=tarjeta.getSaldoActual();
		System.out.println("Saldo inicial: "+ saldoAntesDeQuitarBici1);
		sistema.getListaPuntosAparcamiento().get(0).devolverBici(tarjeta, anclaje, j);
		double saldoCobrado1=saldoAntesDeQuitarBici1-tarjeta.getSaldoActual();
		if (saldoCobrado1<0) {
			System.out.println("Se ha devuelto: "+ saldoCobrado1*(-1));
		}
		else {
			System.out.println("Se ha cobrado: "+ saldoCobrado1);
		}
		
		System.out.println("Saldo actual: "+ tarjeta.getSaldoActual());
	}

}
