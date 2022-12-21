package uva.poo.practica2Test;

import uva.poo.practica2.*;

public class pruebaElectricBike {

	public static void main(String[] args) {
		BateriaBike bateria=new BateriaBike(48, 57);
		Resource r= new ChildBike("Orbea", "Oregon", 12, 10.34, 3, 8);
		ElectricBike p= new ElectricBike("Orbea", "Arriba", "M", 10,34,3 ,bateria, 8);
		Bike h=p.clone();
		System.out.println(h.equals(p));

	}

}
