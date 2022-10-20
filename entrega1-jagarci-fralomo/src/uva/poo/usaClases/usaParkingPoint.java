package uva.poo.usaClases;
import uva.poo.practica1.*;
public class usaParkingPoint {

	public static void main(String[] args) {
		CityBikeParkingPoint p = new CityBikeParkingPoint(3,40.352133333333335,3.350913888888889);
		CityBikeParkingPoint g = new CityBikeParkingPoint(5,9);
		
		AnclajeParkingPoint[] listaAnclajesP=p.getListaAnclajes();
		System.out.println(p.getCantidadAnclajes());
		listaAnclajesP[2].setVacio(true);
		System.out.println(p.getIdPuntoAparcamiento());
		System.out.println("Cantidad de Anclajes Ocupados: "+p.getCantidadAnclajesOcupados());
		System.out.println("Cantidad de Anclajes Reservados: "+p.getCantidadAnclajesReservados());
		System.out.println(p.toString());
		System.out.println(p.getPosicionGPS()[0]+","+p.getPosicionGPS()[1]);
		System.out.println(p.getPosicionGMS()[0]+", "+p.getPosicionGMS()[1]);
		System.out.println(p.getIdPuntoAparcamiento());
		System.out.println(g.getIdPuntoAparcamiento());
	}
}
