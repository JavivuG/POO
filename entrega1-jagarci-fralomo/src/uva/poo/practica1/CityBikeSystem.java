package uva.poo.practica1;
import fabricante.externo.tarjetas.TarjetaMonedero;
import java.util.ArrayList;


/**
 * Tipo de Datos que representa el sistema de un aparcamiento de bicis de, por ejemplo,una ciudad.
 * @author jagarci
 * @author fralomo
 */
public class CityBikeSystem {
	private ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento;
	
	// Inicializadores
	/**
	 * Inicializa una instancia de CityBikeSystem a partir de los parámetros fianza y cantidad de puntos de aparcamiento
	 * @param fianza dinero necesario para alquilar una bici que al devolverla es reembolsado al cliente
	 * @param cantidadPuntosAparcamiento cantidad de puntos de aparcamiento gestionados por la instancia
	 * @throws IllegalArgumentException Si fianza menor que 0
	 * @throws IllegalArgumentException Si punto de aparcamiento menor que 1
	 */
	public CityBikeSystem(int cantidadPuntosAparcamiento) {
		if (cantidadPuntosAparcamiento>0) {
			listaPuntosAparcamiento= new ArrayList<>();
			setCantidadPuntosAparcamiento(cantidadPuntosAparcamiento);
		}
		else if(cantidadPuntosAparcamiento<1) {
			throw new IllegalArgumentException("No puede tener cantidad de puntos de aparcamiento menor que 1");
		}
	}
	
	/**
	 * Inicializa una instancia de CityBikeSystem copiando otra
	 * @param original instancia a copiar
	 * @throws IllegalArgumentException si punto de aparcamiento de copia es null
	 */
	public CityBikeSystem(CityBikeSystem original) {
		if (original!=null) {
			setListaPuntosAparcamiento(original.getListaPuntosAparcamiento());
		}
		else {
			throw new IllegalArgumentException("Llamada incorrecta: CityBikeSystem==null");
		}
		
	}
	
	/**
	 * Devuelve la cantidad de puntos de Aparcamiento que tiene el sistema
	 * @return cantidad de puntos de aparcamiento del Sistema de bicis
	 */
	public int getCantidadPuntosAparcamiento() {
		return getListaPuntosAparcamiento().size();
	}
	 
	 /**
	  * Proporciona una cantidad determinada de puntos de aparcamiento
	  * @param n Puntos de aparcamiento que se desean crear
	  * @throws IllegalArgumentException Si número de aparcamientos indicado es menor que 0
	  */
	public void setCantidadPuntosAparcamiento(int n) {
		if (n<1) {
			throw new IllegalArgumentException("No puede tener un número de aparcamientos menor que 0");
		}
		else {
			listaPuntosAparcamiento.clear();
			for (int i= 0 ; i<n ; i++) {
				CityBikeParkingPoint p= new CityBikeParkingPoint(1, 0, 0);
				listaPuntosAparcamiento.add(p);
			}
		}
	}
	
	/**
	 * Devuelve la lista de puntos de aparcamiento del sistema
	 * @return lista de puntos de aparcamiento del sistema 
	 */
	public ArrayList<CityBikeParkingPoint> getListaPuntosAparcamiento() {
		ArrayList<CityBikeParkingPoint> clon= new ArrayList<>();
		for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
			clon.add(listaPuntosAparcamiento.get(i).clone());
		}
		
		return clon;
	}

	/**
	 * Proporciona una nueva lista de puntos de aparcamiento al sistema
	 * @param listaPuntosAparcamiento lista que se le desea proporcionar
	 * @throws IllegalArgumentException si la lista es nula o vacia
	 */
	public void setListaPuntosAparcamiento(ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento) {
		if (listaPuntosAparcamiento==null || listaPuntosAparcamiento.isEmpty()) {
			throw new IllegalArgumentException("LLamada incorrecta: lista nula o vacía");
		}
		else {
			ArrayList<CityBikeParkingPoint> clon= new ArrayList<>();
			for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
				clon.add(listaPuntosAparcamiento.get(i).clone());
			}
			this.listaPuntosAparcamiento= clon;
		}
	}
	
	public void setFianzaGlobal(double fianza) {
		for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
			listaPuntosAparcamiento.get(i).setFianza(fianza);
		}
	}
	/**
	 * Añade un CityBikeParkingPoint dado a la lista de parkings
	 * @param puntoAparcamiento a añadir
	 * @throws IllegalArgumentException Llamada incorrecta: Parking==null
	 */
	public void addCityBikeParkingPoint(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: Parking==null");
		} 
		else {
			listaPuntosAparcamiento.add(puntoAparcamiento);
		}
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema dado su identificador
	 * @param id del punto de aparcamiento a eliminar
	 * @throws IllegalArgumentException Parking Point no esta en CityBikeSystem
	 */
	public void removeCityBikeParkingPoint(String id) {
		if (estaEnListaPuntosAparcamiento(id) && getListaPuntosAparcamiento().size()>=2) {
			listaPuntosAparcamiento.remove(indexPuntoAparcamiento(id));
		}
		else {
			throw new IllegalArgumentException("Parking Point no esta en CityBikeSystem");
		}
		setListaPuntosAparcamiento(listaPuntosAparcamiento);
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema dado el punto
	 * @param puntoAparcamiento punto de aparcamiento a eliminar
	 * @throws IllegalArgumentException si puntoAparcamiento==null
	 */
	public void removeCityBikeParkingPoint(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: puntoAparcamiento==null");
		}
		else {
			String id=puntoAparcamiento.getIdPuntoAparcamiento();
			removeCityBikeParkingPoint(id);
		}
	}
	
	/**
	 * Devuelve la posicion en la lista del punto de aparcamiento
	 * @param id del punto de aparcamiento del que se desea saber la posición en la lista
	 * @return posicion en la lista del punto de aparcamiento, -1 si no esta en la lista
	 */
	public int indexPuntoAparcamiento(String id) {
		for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
			CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
			if (id.equals(puntoAparcamiento.getIdPuntoAparcamiento())) {
				return i;
			}	
		}
		throw new IllegalStateException("No existe el punto de aparcamiento en el sistema");
	}
	
	/**
	 * Devuelve la posicion en la lista del punto de aparcamiento
	 * @param puntoAparcamiento que se desea saber la posición en la lista
	 * @return posicion en la lista del punto de aparcamiento, -1 si no esta en la lista
	 * @throws IllegalArgumentException si puntoAparcamiento==null
	 */
	public int indexPuntoAparcamiento(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: puntoAparcamiento==null");
		}
		String id=puntoAparcamiento.getIdPuntoAparcamiento();
		return indexPuntoAparcamiento(id);
	}
	
	/**
	 * Indica si un punto de aparcamiendo dado su identificador esta en la lista del sistema
	 * @param id del punto de aparcamiento del que se desea saber si esta en la lista o no
	 * @return true si esta en la lista, false de lo contrario
	 */
	public boolean estaEnListaPuntosAparcamiento(String id) {
		if(indexPuntoAparcamiento(id)!=-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Indica si un punto de aparcamiendo esta en la lista del sistema
	 * @param puntoAparcamiento del que se desea saber si esta en la lista o no
	 * @return true si esta en la lista, false de lo contrario
	 * @throws IllegalArgumentException si puntoAparcamiento==null
	 */
	public boolean estaEnListaPuntosAparcamiento(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: puntoAparcamiento==null");
		}
		else {
			String id = puntoAparcamiento.getIdPuntoAparcamiento();
			return estaEnListaPuntosAparcamiento(id);
		}
		
	}

	
	
	/**
	 * Devuelve una lista de puntos de aparcamientos que tienen bicis disponibles
	 * @return lista de puntos de aparcamientos que tienen bicis disponibles
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoBicisDisponibles(){
		ArrayList<CityBikeParkingPoint> puntosAparcamientoBicisDisponibles=new ArrayList<>();
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
		ArrayList<CityBikeParkingPoint> puntosAparcamientoAnclajesVacios=new ArrayList<>();
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
	 * @param posicionGPS desde donde se desean saber los puntos cercanos
	 * @param radio de búsqueda alrededor de la posición inicial
	 * @return lista de puntos de aparcamiento cercanos
	 * @throws IllegalArgumentException si radio es menor o igual 0 
	 * @throws IllegalArgumentException si las coordenadas GPS fuera de los limites
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanos(CoordenadaParkingPoint coordenadaGPS, double radio){
		if (radio<=0) {
			throw new IllegalArgumentException("Llamada incorrecta: radio<=0");
		}
		else if(coordenadaGPS.getCoordenadaGPSLatitud()<-90 || coordenadaGPS.getCoordenadaGPSLatitud()>90 || coordenadaGPS.getCoordenadaGPSLongitud()<-180 || coordenadaGPS.getCoordenadaGPSLongitud()>180) {
			throw new IllegalArgumentException("Llamada incorrecta: Coordenadas GPS fuera de los límites");
		}
		else {
			ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos = new ArrayList<>();
			for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
				CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
				double distanciaAPosicionGPS=coordenadaGPS.distanciaAPosicionGPS(coordenadaGPS);
				if (distanciaAPosicionGPS<=radio) {
					puntosAparcamientoCercanos.add(puntoAparcamiento);
				}
			}
			return puntosAparcamientoCercanos;
		}
		
	}
	
	/**
	 * Devuelve una lista de puntos de aparcamiento cercanos con anclajes vacios para dejar la bici dada una posicion GPS y un radio dado
	 * @param posicionGPS desde donde se desean saber los puntos cercanos con anclajes vacíos
	 * @param radio de búsqueda alrededor de la posición inicial
	 * @return Lista de puntos de aparcamiento cercanos con anclajes vacios
	 * @throws IllegalArgumentException si radio menor o igual que 0 
	 * @throws IllegalArgumentException coordenadas GPS fuera de los limites
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanosVacios(CoordenadaParkingPoint coordenadaGPS, double radio){
		if (radio<=0) {
			throw new IllegalArgumentException("Llamada incorrecta: radio<=0");
		}
		else if(coordenadaGPS.getCoordenadaGPSLatitud()<-90 || coordenadaGPS.getCoordenadaGPSLatitud()>90 || coordenadaGPS.getCoordenadaGPSLongitud()<-180 || coordenadaGPS.getCoordenadaGPSLongitud()>180) {
			throw new IllegalArgumentException("Llamada incorrecta: Coordenadas GPS fuera de los límites");
		}
		else {
			ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos= getPuntosAparcamientoCercanos(coordenadaGPS, radio);
			ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanosVacios= new ArrayList<>(); 
			for(int i =0; i<puntosAparcamientoCercanos.size(); i++) {
				CityBikeParkingPoint puntoAparcamiento= puntosAparcamientoCercanos.get(i);
				if (puntoAparcamiento.getCantidadAnclajesVacios()>0) {
					puntosAparcamientoCercanosVacios.add(puntoAparcamiento);
				}
			}
			return puntosAparcamientoCercanosVacios;
		}
		
	}

	/**
	 * Devuelve una lista de puntos de aparcamiento cercanos con bicis disponibles dada una posicion GPS y un radio dado
	 * @param posicionGPS desde donde se desean saber los puntos cercanos con bicis disponibles
	 * @param radio de búsqueda alrededor de la posición inicial
	 * @return lista de puntos de aparcamiento cercanos con bicis disponibles
	 * @throws IllegalArgumentException si radio menor o igual que 0 
	 * @throws IllegalArgumentException coordenadas GPS fuera de los limites
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosAparcamientoCercanosOcupados(CoordenadaParkingPoint coordenadaGPS, double radio){
		if (radio<=0) {
			throw new IllegalArgumentException("Llamada incorrecta: radio<=0");
		}
		else if(coordenadaGPS.getCoordenadaGPSLatitud()<-90 || coordenadaGPS.getCoordenadaGPSLatitud()>90 || coordenadaGPS.getCoordenadaGPSLongitud()<-180 || coordenadaGPS.getCoordenadaGPSLongitud()>180) {
			throw new IllegalArgumentException("Llamada incorrecta: Coordenadas GPS fuera de los límites");
		}
		else {
			ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanos= getPuntosAparcamientoCercanos(coordenadaGPS, radio);
			ArrayList<CityBikeParkingPoint> puntosAparcamientoCercanosOcupados= new ArrayList<>(); 
			
			for(int i =0; i<puntosAparcamientoCercanos.size(); i++) {
				CityBikeParkingPoint puntoAparcamiento= puntosAparcamientoCercanos.get(i);
				
				if (puntoAparcamiento.getCantidadAnclajesOcupados()>0) {
					puntosAparcamientoCercanosOcupados.add(puntoAparcamiento);
				}
			}
			return puntosAparcamientoCercanosOcupados;
		}
		
	}
	
	 /**
	  * Devuelve los datos correspondientes a un determinado punto de aparcamiento dado su identificador
	  * @param identificador del punto de aparcamiento que quiero
	  * @return datos del punto de aparcamiento correspondiente
	  * @throws IllegalArgumentException si el identificador no corresponde a ningun punto de aparcamiento
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
		 throw new IllegalArgumentException("El identificador no corresponde a ningun punto de aparcamiento");
	 }

	 /**
	  * Devuelve un String con el valor de la fianza del sistema y la cantidad de puntos de aparcamiento
	  */
	 @Override
	 public String toString() {
		 return "Cantidad de puntos de Aparcamiento: "+ getCantidadPuntosAparcamiento()+ "\n";
	 }


}
