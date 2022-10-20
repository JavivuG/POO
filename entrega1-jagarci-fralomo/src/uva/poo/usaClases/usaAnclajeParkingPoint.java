package uva.poo.usaClases;
import uva.poo.practica1.AnclajeParkingPoint;

public class usaAnclajeParkingPoint {

	public static void main(String[] args) {
		AnclajeParkingPoint p = new AnclajeParkingPoint();
		p.setReservado(true);

		System.out.println(p.isOcupado());
		System.out.println(p.isReservado());

	}

}
