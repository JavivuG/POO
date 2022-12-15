package uva.poo.practica2Test;

import uva.poo.practica2.*;

public class pruebaElectricBike {

	public static void main(String[] args) {
		BateriaBike bateria=new BateriaBike(24, 57);
		Bike p= new ElectricBike("Orbea", "Oregon", 24, 10.34, 3, 8, bateria, 32);
		System.out.println(p.toString());


	}

}
