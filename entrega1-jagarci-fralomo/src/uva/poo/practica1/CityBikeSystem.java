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
	
	/**
	 * Devuelve el valor de la fianza de CityBikeSystem
	 * @return valor de la fianza
	 */
	public double getFianza() {
		return fianza;
	}
	
	/**
	 * Proporciona un nuevo valor a la fianza del CityBikeSystem
	 * @param fianza
	 */
	public void setFianza(double fianza) {
		if (fianza<0) {
			throw new IllegalStateException("No puede tener fianza menor que 0");
		}
		this.fianza = fianza;
	}

	/**
	 * Devuelve la lista de puntos de aparcamiento del sistema
	 * @return lista de puntos de aparcamiento del sistema 
	 */
	public ArrayList<CityBikeParkingPoint> getListaPuntosAparcamiento() {
		ArrayList<CityBikeParkingPoint> clon= new ArrayList<CityBikeParkingPoint>();
		for (int i=0 ; i<listaPuntosAparcamiento.size() ; i++) {
			clon.add(listaPuntosAparcamiento.get(i));
		}
		
		return clon;
	}

	/**
	 * Proporciona una nueva lista de puntos de aparcamiento al sistema
	 * @param listaPuntosAparcamiento
	 */
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
	 * @throws 
	 */
	public void addCityBikeParkingPoint(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: Parking==null");
		} 
		listaPuntosAparcamiento.add(puntoAparcamiento);
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema dado su identificador
	 * @param id
	 * @throws
	 */
	public void removeCityBikeParkingPoint(String id) {
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=getListaPuntosAparcamiento();
		if (estaEnListaPuntosAparcamiento(id)) {
			listaPuntosAparcamiento.remove(indexPuntoAparcamiento(id));
		}
		else {
			throw new IllegalStateException("Parking Point no esta en CityBikeSystem");
		}
		setListaPuntosAparcamiento(listaPuntosAparcamiento);
	}
	
	/**
	 * Quitar un punto de aparcamiento del sistema
	 * @param puntoAparcamiento
	 */
	public void removeCityBikeParkingPoint(CityBikeParkingPoint puntoAparcamiento) {
		if (puntoAparcamiento==null) {
			throw new IllegalArgumentException("Llamada incorrecta: Parking==null");
		}
		
		String id=puntoAparcamiento.getIdPuntoAparcamiento();
		removeCityBikeParkingPoint(id);
	}
	
	/**
	 * Devuelve la posicion en la lista del punto de aparcamiento
	 * @param id
	 * @return posicion en la lista del punto de aparcamiento, -1 si no esta en la lista
	 */
	public int indexPuntoAparcamiento(String id) {
		ArrayList<CityBikeParkingPoint> listaPuntosAparcamiento=getListaPuntosAparcamiento();
		if (estaEnListaPuntosAparcamiento(id)) {
			for(int i=0; i<listaPuntosAparcamiento.size(); i++) {
				CityBikeParkingPoint puntoAparcamiento=listaPuntosAparcamiento.get(i);
				if (id==puntoAparcamiento.getIdPuntoAparcamiento()) {
					return i;
				}	
			}
		}
		return -1;

	}
	
	/**
	 * Devuelve la posicion en la lista del punto de aparcamiento
	 * @param id
	 * @return posicion en la lista del punto de aparcamiento, -1 si no esta en la lista
	 */
	public int indexPuntoAparcamiento(CityBikeParkingPoint otro) {
		String id=otro.getIdPuntoAparcamiento();
		return indexPuntoAparcamiento(id);
	}
	
	/**
	 * Indica si un punto de aparcamiendo dado su identificador esta en la lista del sistema
	 * @param id
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
	 * @param punto de Aparcamiento
	 * @return true si esta en la lista, false de lo contrario
	 */
	public boolean estaEnListaPuntosAparcamiento(CityBikeParkingPoint otro) {
		String id = otro.getIdPuntoAparcamiento();
		return estaEnListaPuntosAparcamiento(id);
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

	 /**
	 * Permite a un cliente alquilar la bicicleta de un anclaje y se le descuenta la fianza de su TarjetaMonedero
	 * **@param** tarjeta del cliente que quiere alquilar la bicicleta
	 * **@param** anclaje del que se quiere alquilar la bicicleta
	 * **@throws** IllegalStateException El anclade del que se quiere alquilar la bicicleta está vacío o reservado.
	 */
	 public void alquilarBici(TarjetaMonedero tarjeta,AnclajeParkingPoint anclaje) {
		 if (anclaje.isOcupado()) {
			 tarjeta.descontarDelSaldo("***REMOVED***", fianza);
		 	 anclaje.setVacio(true);
	 	}else {
	 		throw new IllegalStateException("El anclaje del que se quiere alquilar la bicicleta está vacío o reservado.");
	 	}
	 }

	 /**
	 * Permite al cliente devolver una bicicleta alquilada y se le devuelve la fianza en su TarjetaMonedero
	 * **@param** tarjeta del cliente que quiere devolver la bicicleta
	 * **@param** anclaje donde se quiere devolver la bicicleta
	 * **@throws** IllegalStateException El anclaje donde se quiere dejar la bicicleta está ocupado por otra bicicleta.
	 */
	 public void devolverBici(TarjetaMonedero tarjeta,AnclajeParkingPoint anclaje) {
		 if (anclaje.isVacio()) {
			 tarjeta.recargaSaldo("A156Bv09_1zXo894", fianza);
			 anclaje.setOcupado(true);
		 }
		 else {
			 throw new IllegalStateException("El anclaje donde se quiere dejar la bicicleta está ocupado por otra bicicleta.");
		 }
	 }
	 
	 /**
	 * Permite al cliente reservar la bicicleta de un anclaje y se le decuenta la fianza de su TarjetaMonedero
	 * **@param** tarjeta del cliente que quiere reservar la bicicleta
	 * **@param** anclaje del que se quiere reserervar la bicicleta
	 * **@throws** IllegalStateException El anclaje del que se quiere reservar la bicicleta está vacío o ya reservado para otro cliente.
	 */
	 public void reservarBici(TarjetaMonedero tarjeta,AnclajeParkingPoint anclaje) {
		 if(anclaje.isOcupado() && !anclaje.isReservado()) {
			 tarjeta.descontarDelSaldo("***REMOVED***", fianza);
			 anclaje.setOcupado(true);
		 }
		 else {
			 throw new IllegalStateException("El anclaje del que se quiere reservar la bicicleta está vacío o ya reservado para otro cliente.");
		 }
	 }
	
	
	
	
}
