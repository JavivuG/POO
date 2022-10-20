package uva.poo.usaClases;
import uva.poo.practica1.*;
public class usaParkingPoint {

	public static void main(String[] args) {
		CityBikeParkingPoint p = new CityBikeParkingPoint(3,4,8);
		CityBikeParkingPoint g = new CityBikeParkingPoint(5,9);
		
		AnclajeParkingPoint[] listaAnclajesP=p.getListaAnclajes();
		System.out.println(p.getCantidadAnclajes());
		listaAnclajesP[2].setVacio(true);
		System.out.println(listaAnclajesP[1].isOcupado());
		System.out.println(listaAnclajesP[2].isVacio());
		System.out.println(listaAnclajesP[2].isOcupado());
		System.out.println(listaAnclajesP[0].isOcupado());
		System.out.println(p.getIdPuntoAparcamiento());
		System.out.println("Cantidad de Anclajes Ocupados: "+p.getCantidadAnclajesOcupados());
		System.out.println("Cantidad de Anclajes Reservados: "+p.getCantidadAnclajesReservados());
		System.out.println(p.toString());
		System.out.println(p.getIdPuntoAparcamiento());
		System.out.println(g.getIdPuntoAparcamiento());
	}
}
