package uva.poo.practica1;
import uva.poo.practica1.CityBikeParkingPoint;

/**
 * 
 * Tipo de datos que representa una coordenada
 * @author jagarci
 * @author fralomo
 */
public class CoordenadaParkingPoint {
	private double coordenadaGPSLatitud;
	private double coordenadaGPSLongitud;
	
	// Inicializadores
	/**
	 * Constructor de las coordenadas de un punto de aparcamiento indicando la coordenada en grados decimales
	 * @param coordenadaGDLatitud Coordenadas en grados decimales latitud
	 * @param coordenadaGDLongitud Coordenadas en grados decimales longitud
	 */
	public CoordenadaParkingPoint(double coordenadaGDLatitud, double coordenadaGDLongitud) {
		this.coordenadaGPSLatitud=coordenadaGDLatitud;
		this.coordenadaGPSLongitud=coordenadaGDLongitud;
	}
	
	/**
	 * Contructor de las coordenadas de un punto de aparcamiento indicado las coordenadas en grados minutos y segundo
	 * @param coordenadaGMSLatitud Coordenadas en grados, minutos y segundos Latitud
	 * @param coordenadaGMSLongitud Coordenadas en grados, minutos y segundos Longitud
	 */
	public CoordenadaParkingPoint(double[] coordenadaGMSLatitud, double[] coordenadaGMSLongitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLatitud);
		this.coordenadaGPSLongitud=coordenadasGMSaGD(coordenadaGMSLongitud);
	}
	

	
	/**
	 * Devuelve el valor de las coordenadas de la latitud en grados decimales
	 * @return coordenadasGPSLatitud Coordenadas latitud en grados decimales
	 */
	public double getCoordenadaGPSLatitud() {
		return coordenadaGPSLatitud;
	}
	
	/**
	 * Devuelve el valor de las coordenadas de la longitud en grados decimales
	 * @return coordenadasGPSLongitud Coordenadas longitud en grados decimales
	 */
	public double getCoordenadaGPSLongitud() {
		return coordenadaGPSLongitud;
	}
	
	/**
	 * Proporciona el valor de las coordenadas de la latitud en grados decimales
	 * @param coordenadaGDLatitud Coordenadas de la latitud en grados decimales
	 */
	public void setCoordenadaGPSLatitud(double coordenadaGDLatitud) {
		this.coordenadaGPSLatitud=coordenadaGDLatitud;
	}
	
	/**
	 * 
	 * @param coordenadaGDLongitud
	 */
	public void setCoordeadaGPSLongitud(double coordenadaGDLongitud) {
		this.coordenadaGPSLongitud=coordenadaGDLongitud;
	}
	
	/**
	 * Proporciona el valor de las coordenadas latitud en grados, minutos y segundos
	 * @param coordenadaGMSLatitud Coordenadas latitud en grados, minutos y segundos
	 */
	public void setCoordenadaGPSLatitud(double[] coordenadaGMSLatitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLatitud);
	}
	

	
	/**
	 * Proporciona el valor de las coordenadas longitud en grados, minutos y segundos
	 * @param coordenadaGMSLongitud Coordenadas longitud en grados, minutos y segundos
	 */
	public void setCoordeadaGPSLongitud(double[] coordenadaGMSLongitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLongitud);
	}
	
	/**
	 * Devuelve las coordenadas de la latitud en grados,minutos y segundos
	 */
	public double[] getCoordenadasGMSLatitud() {
		return coordenadasGDaGMS(getCoordenadaGPSLatitud());
	}
	
	/**
	 * Devuelve las coordenadas de la latitud en grados,minutos y segundos
	 */
	public double[] getCoordenadasGMSLongitud() {
		return coordenadasGDaGMS(getCoordenadaGPSLongitud());
	}
	
	/**
	 * Devuelve un String con los grados, minutos y segundos. Primera posicion del vector los grados, segunda los minutos y tercera los segundos
	 * @param coordenadasGMS Coordenadas en grados minutos y segundos. Vector de tres posiciones
	 */
	public String imprimeGMS(double[] coordenadasGMS) {
		int grados=(int)coordenadasGMS[0];
		int minutos=(int)coordenadasGMS[1];
		double segundos=coordenadasGMS[2];
		
		return grados+"º "+minutos+"' "+segundos+"''";
	}
	
	private double coordenadasGMSaGD(double[] coordenadasGMS) {
		double grados=coordenadasGMS[0];
		double minutos=coordenadasGMS[1];
		double segundos=coordenadasGMS[2];

		return (double)(grados + (1/60)*minutos + (1/3600)*segundos);
	}
	
	private double[] coordenadasGDaGMS(double coordenadasGD) {
		 int grados=(int) coordenadasGD;
		 double[] gradosGMS=new double[3];
		 
		 int minutos=(int)((coordenadasGD-grados)*60);
		 double segundos=truncaNumero((((coordenadasGD-grados)*60)-minutos)*60);
		 
		 gradosGMS[0]=grados;
		 gradosGMS[1]=minutos;
		 gradosGMS[2]=segundos;
		 return gradosGMS;
	}
	
	 private double truncaNumero(double numero) {
		 numero = numero * Math.pow(10, 3); 
		 numero = Math.floor(numero); 
		 numero = numero / Math.pow(10, 3);
		 return numero;
	 }
	 
	 /**
	  * Calcula la distancia de un punto de aparcamiento a una posicion GPS dada
	  * @param posicionGPSLatitud Latitud en grados decimales
	  * @param posicionGPSLongitud Longitud en grados decimales
	  * @return distancia entre el punto de aparcamiento y la posicion GPS dada
	  * @throws IllegalArgumentException si las coordenadas GPS estan fuera de los limites
	  */
	 public double distanciaAPosicionGPS(CoordenadaParkingPoint coordenadaGPS) {
		 if(coordenadaGPS.getCoordenadaGPSLatitud()<-90 || coordenadaGPS.getCoordenadaGPSLatitud()>90 || coordenadaGPS.getCoordenadaGPSLongitud()<-180 || coordenadaGPS.getCoordenadaGPSLongitud()>180) {
			 throw new IllegalArgumentException("Llamada incorrecta: Coordenadas GPS fuera de los límites");
		 }
		 double lat1rad = Math.toRadians(getCoordenadaGPSLatitud());
		 double lon1rad = Math.toRadians(getCoordenadaGPSLongitud());
		 double lat2rad = Math.toRadians(coordenadaGPS.getCoordenadaGPSLatitud());
		 double lon2rad = Math.toRadians(coordenadaGPS.getCoordenadaGPSLongitud());

		 double difLatitud = lat1rad - lat2rad;
		 double difLongitud = lon1rad - lon2rad;
		 double a = Math.pow(Math.sin(difLatitud/2), 2) +
		            Math.cos(lat1rad) *
		            Math.cos(lat2rad) *
		            Math.pow(Math.sin(difLongitud/2), 2);
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		 double radioTierraKm = 6371.0;

		 return radioTierraKm * c;
	 }
	 
	 /**
	  * Calcula la distancia de un punto de aparcamiento a un punto de aparcamiento dado
	  * @param otro Punto de aparcamiento 
	  * @return distancia entre el punto de aparcamiento y la posicion GPS dada
	  * @throws IllegalArgumentException Entrada incorrecta: otro==null
	  */
	 public double distanciaAPuntoAparcamiento(CityBikeParkingPoint otro) {
		 if (otro==null) {
			 throw new IllegalArgumentException("Entrada incorrecta: otro==null");
		 }
		 return distanciaAPosicionGPS(otro.getCoordenada());
	 }
	
}
