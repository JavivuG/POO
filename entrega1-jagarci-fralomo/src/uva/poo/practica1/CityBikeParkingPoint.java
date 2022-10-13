package uva.poo.practica1;
import uva.poo.practica1.AnclajeParkingPoint; 
/*
 * TODO
 * conocer cantidad de anclajes que tiene el punto de aparcamiento
 * conocer la cantidad de anclajes ocupados (en los que hay una bici aparcada) 
 * conocer la posición GPS en la que se encuentra el punto de aparcamiento
 * conocer el identificador del punto de aparcamiento
 * dado una base de anclaje en ese aparcamiento1, saber si está vacío, reservado u ocupado
 * prestar una bici de una base de anclaje, devolver una bici a una base de anclaje
 * conocer la distancia del punto de aparcamiento a una coordenada GPS dada o a otro punto de aparcamiento de bicis dado.
 */
/**
 * 
 * @author javier
 * @author francisco
 *
 */
 public class CityBikeParkingPoint {
	 // ATRIBUTOS
	 // anclajes 
	 // posicionGPS
	 // id del punto
	 private AnclajeParkingPoint[] listaAnclajes;
	 private double posicionGradosDecimales; // FALTA LATITUD Y LONGITUD
	 private int idPuntoAparcamiento;
	 
	 // Inicializadores
	 /**
	  * Constructor predeterminado, por defecto se inicia a 1 el numero de anclajes 
	  * @param idPuntoAparcamiento Identificador que se le asigna al punto de Aparcamiento
	  */
	 public CityBikeParkingPoint(int idPuntoAparcamiento) { 
		 
	 }
	 
	 /**
	  * Constructor para poner una cantidad determinada de anclajes
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento
	  * @param idPuntoAparcamiento Identificador que se le asigna al punto de Aparcamiento
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, int idPuntoAparcamiento) {
		 
	 }
	 
	 /**
	  * Devuelve la cantidad de anclajes que tiene el punto de aparcamiento
	  * @return cantidad de anclajes que tiene un punto de aparcamiento
	  */
	 public int getCantidadAnclajes() {
		 return listaAnclajes.length;
	 }
	 
	 /**
	  * Proporciona un valor para la cantidad de anclajes que tiene el punto de aparcamiento
	  * @param cantidadAnclajes cantidad de anclajes
	  */
	 public void setAnclajes(int cantidadAnclajes) {
		 this.listaAnclajes=new AnclajeParkingPoint[cantidadAnclajes];
	 }
	 
	 /**
	  * Devuelve la posicion GPS
	  * @return la posicion GPS en grados decimales
	  */
	 public double getPosicionGPS() {
		 
	 }
	 
	 /**
	  * 
	  * @param 
	  */
	 public double setPosicionGPS() {
		 
	 }
	 
	 /**
	  * 
	  * @return posicion GPS en grados minutos y segundo
	  */
	 public getPosicionGMS() {
		 double posicionGradosDecimales=getPosicionGPS();
	 }
	 
	 /**
	  * 
	  * @param
	  */
	 public void setPosicionGMS() {
		 
	 }
	 
	 
}
