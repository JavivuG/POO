package uva.poo.practica2Test;

import uva.poo.practica2.*;

public class pruebaElectricBike {

	public static void main(String[] args) {
		BateriaBike bateria=new BateriaBike(48, 57);
		Resource r= new ElectricBike("Orbea", "Oregon", 36, 10.34, 3, 8, bateria, 32);
		double fianza=20;
		double fianzaModificada = r.getDepositToPay(fianza);
		System.out.println(fianzaModificada);


	}

}
