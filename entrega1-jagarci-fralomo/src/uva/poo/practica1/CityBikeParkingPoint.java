package uva.poo.practica1;
import uva.poo.practica1.AnclajeParkingPoint;
import java.util.UUID;
/*
 * TODO
 * conocer cantidad de anclajes que tiene el punto de aparcamiento
 * conocer la cantidad de anclajes ocupados (en los que hay una bici aparcada) 
 * conocer la posición GPS en la que se encuentra el punto de aparcamiento
 * conocer el identificador del punto de aparcamiento HECHO
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
	 private double latitudGradosDecimales;
	 private double longitudGradosDecimales;
	 private String idPuntoAparcamiento=UUID.randomUUID().toString();;
	 
	 // Inicializadores
	 /**
	  * Constructor por defecto. Inicializo a cero la posicion GPS. Se debe indicar despues el numero de anclajes 
	  */
	 public CityBikeParkingPoint() {
		 setPosicionGPS(0,0);
	 }
	 /**
	  * Constructor que solo indico posicion GPS. Se debe indicar despues el numero de anclajes 
	  * @param
	  * @param
	  */
	 public CityBikeParkingPoint(double latitudGradosDecimales, double longitudGradosDecimales) {  
		 setPosicionGPS(latitudGradosDecimales, longitudGradosDecimales);
	 }
	 
	 /**
	  * Constructor para poner una cantidad determinada de anclajes
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento
	  * 
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, double latitudGradosDecimales, double longitudGradosDecimales) {
		 setCantidadAnclajes(cantidadAnclajes);
		 setPosicionGPS(latitudGradosDecimales, longitudGradosDecimales);
	 }
	 
	 // METODOS
	 /**
	  * Devuelve el identificador del punto de Aparcamiento
	  * @return identicador asociado al punto de aparcamiento
	  */
	 public String getIdPuntoAparcamiento() {
		return idPuntoAparcamiento;
	 }
	 /**
	  * Devuelve la cantidad de anclajes que tiene el punto de aparcamiento
	  * @return cantidad de anclajes que tiene un punto de aparcamiento
	  */
	 public int getCantidadAnclajes() {
		 return listaAnclajes.length;
	 }
	 
	 /**
	  * Devuelve la cantidad de anclajes con bici/que estan ocupados
	  * @return la cantidad de anclajes que estan ocupados
	  */
	 public int getCantidadAnclajesOcupados() {
		 int contadorOcupado=0;
		 for (int i=0; i<getCantidadAnclajes(); i++) {
			 if (listaAnclajes[i].isOcupado()) {
				 contadorOcupado++;
			 }
		 }
		 return contadorOcupado;
	 }
	 
	 /**
	  * Devuelve la cantidad de anclajes con bici/que estan ocupados
	  * @return la cantidad de anclajes que estan ocupados
	  */
	 public int getCantidadAnclajesVacios() {
		 int contadorVacios=0;
		 for (int i=0; i<getCantidadAnclajes(); i++) {
			 if (listaAnclajes[i].isVacio()) {
				 contadorVacios++;
			 }
		 }
		 return contadorVacios;
	 }
	 
	 /**
	  * Proporciona un valor para la cantidad de anclajes que tiene el punto de aparcamiento
	  * @param cantidadAnclajes cantidad de anclajes
	  */
	 public void setCantidadAnclajes(int cantidadAnclajes) {
		 this.listaAnclajes=new AnclajeParkingPoint[cantidadAnclajes];
	 }
	 
	 public AnclajeParkingPoint[] getListaAnclajes() {
		 return this.listaAnclajes;
	 }
	 
	 /**
	  * Devuelve la posicion GPS en grados  decimales (opcion por defecto)
	  * @return la posicion GPS en grados decimales
	  */
	 public double[] getPosicionGPS() {
		 double[] posicionGPS=new double[2];
		 posicionGPS[0]=latitudGradosDecimales;
		 posicionGPS[1]=longitudGradosDecimales;
		 
		 return posicionGPS;
	 }
	 
	 public void setPosicionGPS(double latitudGradosDecimales, double longitudGradosDecimales) {
		 this.latitudGradosDecimales=latitudGradosDecimales;
		 this.longitudGradosDecimales=longitudGradosDecimales;
	 }

	 /**
	  * Devuelve en un array de Strings la posicion GPS en grados minutos y segundos
	  * @return posicion GPS en grados minutos y segundos
	  */
	 public String[] getPosicionGMS() {
		 double[] posicionGD=getPosicionGPS();
		 String[] posicionGMS=new String[2];
		 
		 int gradosLatitud=(int) posicionGD[0];
		 int gradosLongitud=(int) posicionGD[1];
		 
		 double minutosLatitud=(int)((posicionGD[0]-gradosLatitud)*60);
		 double minutosLongitud=(int)((posicionGD[1]-gradosLongitud)*60);
		 double segundosLatitud=(((posicionGD[0]-gradosLatitud)*60)-minutosLatitud)*60;
		 double segundosLongitud=(((posicionGD[1]-gradosLongitud)*60)-minutosLongitud)*60;
		 
		 posicionGMS[0]=gradosLatitud+"º "+minutosLatitud+"' "+segundosLatitud+"''";
		 posicionGMS[1]=gradosLongitud+"º "+minutosLongitud+"' "+segundosLongitud+"''";

		 return posicionGMS;
	 }
	 
	 

}
