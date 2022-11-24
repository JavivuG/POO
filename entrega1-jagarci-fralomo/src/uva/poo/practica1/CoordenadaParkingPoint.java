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
	 * 
	 * @param coordenadaGPSLatitud
	 * @param coordenadaGPSLongitud
	 */
	public CoordenadaParkingPoint(double coordenadaGDLatitud, double coordenadaGDLongitud) {
		this.coordenadaGPSLatitud=coordenadaGDLatitud;
		this.coordenadaGPSLongitud=coordenadaGDLongitud;
	}
	
	/**
	 * 
	 * @param coordenadaGMSLatitud
	 * @param coordenadaGMSLongitud
	 */
	public CoordenadaParkingPoint(double[] coordenadaGMSLatitud, double[] coordenadaGMSLongitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLatitud);
		this.coordenadaGPSLongitud=coordenadasGMSaGD(coordenadaGMSLongitud);
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCoordenadaGPSLatitud() {
		return coordenadaGPSLatitud;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCoordenadaGPSLongitud() {
		return coordenadaGPSLongitud;
	}
	
	/**
	 * 
	 * @param coordenadaGDLatitud
	 */
	public void setCoordenadaGPSLatitud(double coordenadaGDLatitud) {
		this.coordenadaGPSLatitud=coordenadaGDLatitud;
	}
	
	/**
	 * 
	 * @param coordenadaGMSLatitud
	 */
	public void setCoordenadaGPSLatitud(double[] coordenadaGMSLatitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLatitud);
	}
	
	/**
	 * 
	 * @param coordenadaGDLongitud
	 */
	public void setCoordeadaGPSLongitud(double coordenadaGDLongitud) {
		this.coordenadaGPSLongitud=coordenadaGDLongitud;
	}
	
	/**
	 * 
	 * @param coordenadaGMSLongitud
	 */
	public void setCoordeadaGPSLongitud(double[] coordenadaGMSLongitud) {
		this.coordenadaGPSLatitud=coordenadasGMSaGD(coordenadaGMSLongitud);
	}
	
	/**
	 * 
	 * @return
	 */
	public double[] getCoordenadasGMSLatitud() {
		return coordenadasGDaGMS(getCoordenadaGPSLatitud());
	}
	
	/**
	 * 
	 * @return
	 */
	public double[] getCoordenadasGMSLongitud() {
		return coordenadasGDaGMS(getCoordenadaGPSLongitud());
	}
	
	/**
	 * 
	 * @param coordenadasGMS
	 * @return
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
