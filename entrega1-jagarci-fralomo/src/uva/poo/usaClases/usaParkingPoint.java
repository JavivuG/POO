package uva.poo.usaClases;
import uva.poo.practica1.*;
public class usaParkingPoint {

	public static void main(String[] args) {
		CityBikeParkingPoint p = new CityBikeParkingPoint(3,4,8);
		CityBikeParkingPoint g = new CityBikeParkingPoint(5,9);
		
		AnclajeParkingPoint[] listaAnclajesP=p.getListaAnclajes();
		System.out.println(p.getCantidadAnclajes());
		boolean h=listaAnclajesP[1].isOcupado();
		System.out.println(h);
		System.out.println(p.getIdPuntoAparcamiento());
		System.out.println(g.getIdPuntoAparcamiento());
	}

}
