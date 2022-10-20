package uva.poo.practica1;
import java.util.ArrayList;

/*
 * TODO
 * añadir un punto de aparcamiento de bicis y eliminarlo DONE
 * modificar la cantidad establecida para la fianza DONE
 * obtener todos los puntos de aparcamientos de bicis que hay en la ciudad DONE
 * obtener todos los puntos de aparcamiento con bicis disponibles (que tengan anclajes ocupados) 
 * obtener todos los puntos de aparcamiento en los que haya sitio para devolver una bici (es decir que tengan anclajes vacíos)
 * obtener PUNTOS DE APARCAMIENTO de bicis CERCANOS a una coordenada GPS dada dentro de un radio en metros dado donde se pueda dejar una
bici, etc.
 */

/**
 * 
 * @author javier
 * @author francisco
 */
public class CityBikeSystem {
	// ATRIBUTOS
	// fianza
	// puntosDeAparcamiento

	private double fianza;
	private ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento;

	public double getFianza() {
		return fianza;
	}

	public void setFianza(double fianza) {
		this.fianza = fianza;
	}

	public ArrayList<CityBikeParkingPoint> getListaPuntosAparcamiento() {
		return (ArrayList<CityBikeParkingPoint>) listaPuntosAparcamiento.clone();
	}

	public void setListaPuntosAparcamiento(ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento) {
		this.listaPuntosAparcamiento =  (ArrayList<CityBikeParkingPoint>) listaPuntosAparcamiento.clone();
		
	}
	
	/**
	 * Añade un CityBikeParkingPoint dado a la lista de parkings
	 * @param parking a añadir
	 */
	
	public void addCityBikeParkingPoint(CityBikeParkingPoint parking) {
		listaPuntosAparcamiento.add(parking);
	}
	
	public void remomeCityBikeParkingPoint(String id) {
		//Buscar otra forma
		listaPuntosAparcamiento.removeIf(parking -> parking.getIdPuntoAparcamiento()==id);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
