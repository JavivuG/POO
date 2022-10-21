package uva.poo.usaClases;
import uva.poo.practica1.*;
import java.util.ArrayList;
public class usaBikeSystem {

	public static void main(String[] args) {
		CityBikeSystem SistemaPuntosAparcamiento=new CityBikeSystem();
		ArrayList<CityBikeParkingPoint> lista=new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint p=new CityBikeParkingPoint(5,3,6.7);
		CityBikeParkingPoint h=new CityBikeParkingPoint(12,5,6.7);
		lista.add(p);
		lista.add(h);
		
		SistemaPuntosAparcamiento.setFianza(23.50);
		SistemaPuntosAparcamiento.setListaPuntosAparcamiento(lista);
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=SistemaPuntosAparcamiento.getListaPuntosAparcamiento();
		System.out.println(listaPuntosAparcamiento.get(1).toString());
		System.out.println(SistemaPuntosAparcamiento.getFianza());
		System.out.println(SistemaPuntosAparcamiento.toString());

	}

}
