package uva.poo.practica1;
import fabricante.externo.tarjetas.TarjetaMonedero;
import java.util.ArrayList;

/*
 * TODO
 * añadir un punto de aparcamiento de bicis y eliminarlo DONE
 * modificar la cantidad establecida para la fianza DONE
 * obtener todos los puntos de aparcamientos de bicis que hay en la ciudad DONE
 * obtener todos los puntos de aparcamiento con bicis disponibles (que tengan anclajes ocupados) HECHO
 * obtener todos los puntos de aparcamiento en los que haya sitio para devolver una bici (es decir que tengan anclajes vacíos) HECHO
 * obtener PUNTOS DE APARCAMIENTO de bicis CERCANOS a una coordenada GPS dada dentro de un radio en metros dado donde se pueda dejar una
bici, etc. HECHO
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
		ArrayList<CityBikeParkingPoint> clon= new ArrayList<CityBikeParkingPoint>();
		for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
			clon.add(listaPuntosAparcamiento.get(i));
		}
		
		return clon;
	}

	public void setListaPuntosAparcamiento(ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento) {
		ArrayList<CityBikeParkingPoint> clon= new ArrayList<CityBikeParkingPoint>();
		for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
			clon.add(listaPuntosAparcamiento.get(i));
		}
		
		this.listaPuntosAparcamiento= clon;
		
	}
	
	/**
	 * Añade un CityBikeParkingPoint dado a la lista de parkings
	 * @param parking a añadir
	 */
	public void addCityBikeParkingPoint(CityBikeParkingPoint parking) {
		listaPuntosAparcamiento.add(parking);
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema dado su identificador
	 * @param id
	 */
	public void removeCityBikeParkingPoint(String id) {
		//Buscar otra forma
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=getListaPuntosAparcamiento();
		for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
			if (id==puntoAparcamiento.getIdPuntoAparcamiento()) {
				listaPuntosAparcamiento.remove(puntoAparcamiento);
			}
		}
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema
	 * @param puntoAparcamiento
	 */
	public void removeCityBikeParkingPoint(CityBikeParkingPoint puntoAparcamiento) {
		//Buscar otra forma
		String id=puntoAparcamiento.getIdPuntoAparcamiento();
		removeCityBikeParkingPoint(id);
	}
	
	/**
	 * Devuelve una lista de puntos de aparcamientos que tienen bicis disponibles
	 * @return lista de puntos de aparcamientos que tienen bicis disponibles
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoBicisDisponibles(){
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=getListaPuntosAparcamiento();
		ArrayList<CityBikeParkingPoint> puntosAparcamientoBicisDisponibles=new ArrayList<CityBikeParkingPoint>();
		for (int i=0; i<listaPuntosAparcamiento.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
			
			if (puntoAparcamiento.getCantidadAnclajesOcupados()>0) {
				puntosAparcamientoBicisDisponibles.add(puntoAparcamiento);
			}
		}
		return puntosAparcamientoBicisDisponibles;
	}
	
	/**
	 * Devuelve una lista de puntos de aparcamientos en los que haya sitio para devolver una bici
	 * @return lista de puntos de aparcamientos con anclajes vacios
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoAnclajesVacios(){
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=getListaPuntosAparcamiento();
		ArrayList<CityBikeParkingPoint> puntosAparcamientoAnclajesVacios=new ArrayList<CityBikeParkingPoint>();
		for (int i=0; i<listaPuntosAparcamiento.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
			
			if (puntoAparcamiento.getCantidadAnclajesVacios()>0) {
				puntosAparcamientoAnclajesVacios.add(puntoAparcamiento);
			}
		}
		return puntosAparcamientoAnclajesVacios;
	}
	
	/**
	 * Devuelve lista de puntos de aparcamiento cercanos
	 * @param posicionGPS
	 * @param radio
	 * @return lista de puntos de aparcamiento cercanos
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanos(double[] posicionGPS, double radio){
		listaPuntosAparcamiento=getListaPuntosAparcamiento();
		ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos = new ArrayList<CityBikeParkingPoint>();
		
		for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
			double distanciaAPosicionGPS=puntoAparcamiento.distanciaAPosicionGPS(posicionGPS);
			
			if (distanciaAPosicionGPS<=radio) {
				puntosAparcamientoCercanos.add(puntoAparcamiento);
			}
		}
		return puntosAparcamientoCercanos;
	}
	
	/**
	 * Devuelve una lista de puntos de aparcamiento cercanos con anclajes vacios para dejar la bici dada una posicion GPS y un radio dado
	 * @param posicionGPS 
	 * @param radio
	 * @return Lista de puntos de aparcamiento cercanos con anclajes vacios
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanosVacios(double[] posicionGPS, double radio){
		ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos= getPuntosAparcamientoCercanos(posicionGPS, radio);
		ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanosVacios= new ArrayList<CityBikeParkingPoint>(); 
		
		for(int i =0; i<puntosAparcamientoCercanos.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento= puntosAparcamientoCercanos.get(i);
			
			if (puntoAparcamiento.getCantidadAnclajesVacios()>0) {
				puntosAparcamientoCercanosVacios.add(puntoAparcamiento);
			}
		}
		return puntosAparcamientoCercanosVacios;
	}

	/**
	 * Devuelve una lista de puntos de aparcamiento cercanos con bicis disponibles dada una posicion GPS y un radio dado
	 * @param posicionGPS
	 * @param radio
	 * @return lista de puntos de aparcamiento cercanos con bicis disponibles
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanosOcupados(double[] posicionGPS, double radio){
		ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos= getPuntosAparcamientoCercanos(posicionGPS, radio);
		ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanosOcupados= new ArrayList<CityBikeParkingPoint>(); 
		
		for(int i =0; i<puntosAparcamientoCercanos.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento= puntosAparcamientoCercanos.get(i);
			
			if (puntoAparcamiento.getCantidadAnclajesOcupados()>0) {
				puntosAparcamientoCercanosOcupados.add(puntoAparcamiento);
			}
		}
		return puntosAparcamientoCercanosOcupados;
	}
	
	 /**
	  * Devuelve los datos correspondientes a un determinado punto de aparcamiento dado su identificador
	  * @param identificador del punto de aparcamiento que quiero
	  * @return datos del punto de aparcamiento correspondiente
	  */
	 public String getDatosPuntoAparcamiento(String identificador) {
		 ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento= getListaPuntosAparcamiento();
		 for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
			 CityBikeParkingPoint puntoAparcamiento= listaPuntosAparcamiento.get(i);
			 String idPuntoAparcamiento=puntoAparcamiento.getIdPuntoAparcamiento();
			 
			 if (idPuntoAparcamiento.equals(identificador)) {
				 return puntoAparcamiento.toString();
			 }
		 }
		 return "El identificador no corresponde a ningun punto de aparcamiento";
	 }
	 
	 /**
	  * Devuelve la cantidad de puntos de Aparcamiento que tiene el sistema
	  * @return cantidad de puntos de aparcamiento del Sistema de bicis
	  */
	 public int getCantidadPuntosAparcamiento() {
		 return getListaPuntosAparcamiento().size();
	 }

	 /**
	  * Devuelve un String con el valor de la fianza del sistema y la cantidad de puntos de aparcamiento
	  */
	 @Override
	 public String toString() {
		 String fianza="Valor de fianza: "+ getFianza() +"\n";
		 String cantidadPuntosAparcamiento="Cantidad de puntos de Aparcamiento: "+ getCantidadPuntosAparcamiento()+ "\n";
		 
		 return fianza+cantidadPuntosAparcamiento;
	 }

	
	
	
	
	
	
	
	
	
	
	
}
