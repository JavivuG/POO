package uva.poo.practica1;
import uva.poo.practica1.AnclajeParkingPoint;
import java.util.UUID;
/*
 * TODO
 * conocer cantidad de anclajes que tiene el punto de aparcamiento HECHO
 * conocer la cantidad de anclajes ocupados (en los que hay una bici aparcada) HECHO
 * conocer la posición GPS en la que se encuentra el punto de aparcamiento HECHO
 * conocer el identificador del punto de aparcamiento HECHO
 * dado una base de anclaje en ese aparcamiento1, saber si está vacío, reservado u ocupado HECHO
 * prestar una bici de una base de anclaje, devolver una bici a una base de anclaje
 * conocer la distancia del punto de aparcamiento a una coordenada GPS dada o a otro punto de aparcamiento de bicis dado.
 */
/**
 * Tipo de datos que representa un punto de aparcamiento de bicis
 * @author jagarci
 * @author fralomo
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
	  * Constructor por defecto. Inicializo a cero la posicion GPS y a 1 el numero de Anclajes
	  */
	 public CityBikeParkingPoint() {
		 setPosicionGPS(0,0);
		 setCantidadAnclajes(1);
	 }
	 /**
	  * Constructor que solo indico posicion GPS y a 1 el numero de Anclajes
	  * @param latitudGradosDecimales Latitud en grados decimales
	  * @param longitudGradosDecimales Longitud en grados decimales
	  * @throws IllegalArgumenException si latitudGradosDecimales o longitudGradosDecimales son menores que 0
	  */
	 public CityBikeParkingPoint(double latitudGradosDecimales, double longitudGradosDecimales) {
		 if (latitudGradosDecimales<0 || longitudGradosDecimales<0) {
			 throw new IllegalArgumentException("Llamada incorrecta: latitudGradosDecimales o longitudGradosDecimales deben ser mayores o iguales que 0");
		 }
		 setPosicionGPS(latitudGradosDecimales, longitudGradosDecimales);
		 setCantidadAnclajes(1);
	 }
	 
	 /**
	  * Constructor para poner una cantidad determinada de anclajes
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento
	  * @throws IllegalStateException si cantidad de anclajes es menor que cero
	  * @throws IllegalArgumenException si latitudGradosDecimales o longitudGradosDecimales son menores que 0
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, double latitudGradosDecimales, double longitudGradosDecimales) {
		 if (cantidadAnclajes<=0) {
			 throw new IllegalStateException("La cantidad de anclajes no puede ser menor o igual que 0");
		 }
		 else if(latitudGradosDecimales<0 || longitudGradosDecimales<0) {
			 throw new IllegalArgumentException("Llamada incorrecta: latitudGradosDecimales o longitudGradosDecimales deben ser mayores o iguales que 0");
		 }
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
	  * Devuelve la cantidad de anclajes con bici/que estan vacios
	  * @return la cantidad de anclajes que estan vacios
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
	  * Devuelve la cantidad de anclajes con bici/que estan reservados
	  * @return la cantidad de anclajes que estan ocupados
	  */
	 public int getCantidadAnclajesReservados() {
		 int contadorReservados=0;
		 for (int i=0; i<getCantidadAnclajes(); i++) {
			 if (listaAnclajes[i].isReservado()) {
				 contadorReservados++;
			 }
		 }
		 return contadorReservados;
	 }
	 
	 /**
	  * Proporciona un valor para la cantidad de anclajes que tiene el punto de aparcamiento
	  * @param cantidadAnclajes cantidad de anclajes
	  * @throws IllegalStateException si cantidad de Anclajes menor o igual que cero
	  */
	 public void setCantidadAnclajes(int cantidadAnclajes) {
		 if (cantidadAnclajes<=0) {
			 throw new IllegalStateException("La cantidad de anclajes no puede ser menor o igual que 0");
		 }
		 this.listaAnclajes=new AnclajeParkingPoint[cantidadAnclajes];
		 for (int i=0; i<listaAnclajes.length; i++) {
			 this.listaAnclajes[i]=new AnclajeParkingPoint();
		 }
	 }
	 
	 /**
	  * Devuelve la lista de anclajes
	  * @return lista de objetos anclaje
	  */
	 public AnclajeParkingPoint[] getListaAnclajes() {
		 AnclajeParkingPoint[] clon=new AnclajeParkingPoint[listaAnclajes.length];
		 for (int i=0; i<listaAnclajes.length; i++) {
			 clon[i]=listaAnclajes[i];
		 }
		 return clon;
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
	 
	 /**
	  * Proporciona un nuevo valor para la posicion en grados decimales de la longitud y la latitud
	  * @param latitudGradosDecimales
	  * @param longitudGradosDecimales
	  * @throws IllegalArgumenException si latitudGradosDecimales o longitudGradosDecimales son menores que 0
	  */
	 public void setPosicionGPS(double latitudGradosDecimales, double longitudGradosDecimales) {
		 if (latitudGradosDecimales<0 || longitudGradosDecimales<0) {
			 throw new IllegalArgumentException("Llamada incorrecta: latitudGradosDecimales o longitudGradosDecimales deben ser mayores o iguales que 0");
		 }
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
		 
		 int minutosLatitud=(int)((posicionGD[0]-gradosLatitud)*60);
		 int minutosLongitud=(int)((posicionGD[1]-gradosLongitud)*60);
		 double segundosLatitud=truncaNumero((((posicionGD[0]-gradosLatitud)*60)-minutosLatitud)*60);
		 double segundosLongitud=truncaNumero((((posicionGD[1]-gradosLongitud)*60)-minutosLongitud)*60);
		 
		 posicionGMS[0]=gradosLatitud+"º "+minutosLatitud+"' "+segundosLatitud+"''";
		 posicionGMS[1]=gradosLongitud+"º "+minutosLongitud+"' "+segundosLongitud+"''";

		 return posicionGMS;
	 }
	 
	 /**
	  * Trunca un numero a 3 cifras decimales
	  * @param numero que se desea truncar
	  * @return numero truncado
	  */
	 private double truncaNumero(double numero) {
		 numero = numero * Math.pow(10, 3); 
		 numero = Math.floor(numero); 
		 numero = numero / Math.pow(10, 3);
		 return numero;
	 }
	 
	 /**
	  * Calcula la distancia de un punto de aparcamiento a una posicion GPS dada
	  * @param posicionGPS Latitud en grados decimales
	  * @param posicionGPS Longitud en grados decimales
	  * @return distancia entre el punto de aparcamiento y la posicion GPS dada
	  */
	 public double distanciaAPosicionGPS(double posicionGPSLatitud, double posicionGPSLongitud) {
		 double lat1rad = Math.toRadians(getPosicionGPS()[0]);
		 double lon1rad = Math.toRadians(getPosicionGPS()[1]);
		 double lat2rad = Math.toRadians(posicionGPSLatitud);
		 double lon2rad = Math.toRadians(posicionGPSLongitud);

		 double difLatitud = lat1rad - lat2rad;
		 double difLongitud = lon1rad - lon2rad;
		 double a = Math.pow(Math.sin(difLatitud/2), 2) +
		            Math.cos(lat1rad) *
		            Math.cos(lat2rad) *
		            Math.pow(Math.sin(difLongitud/2), 2);
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		 double radioTierraKm = 6371.0;
		 double distancia = radioTierraKm * c;

		 return distancia;
	 }
	
	 /**
	  * Calcula la distancia de un punto de aparcamiento a un punto de aparcamiento dado
	  * @param otro Punto de aparcamiento 
	  * @return distancia entre el punto de aparcamiento y la posicion GPS dada
	  */
	 public double distanciaAPuntoAparcamiento(CityBikeParkingPoint otro) {
		 double[] posicionGPS=otro.getPosicionGPS();
		 return distanciaAPosicionGPS(posicionGPS[0], posicionGPS[1]);
	 }
	 
	 /**
	  * Devuelve un String con el identificador, la posicion GPS, la cantidad de anclajes y la cantidad de anclajes ocupados de un punto de aparcamiento
	  */
	 @Override
	 public String toString() {
		 String identificador="Indetificador:"+ getIdPuntoAparcamiento() +"\n";
		 String posicionGPS="Posicion GPS: ("+ getPosicionGPS()[0]+ ","+getPosicionGPS()[1]+")\n";
		 String cantidadAnclajes="Cantidad de Anclajes: "+ getCantidadAnclajes()+"\n";
		 String cantidadAnclajesOcupados="Cantidad de Anclajes Ocupados: "+getCantidadAnclajesOcupados()+"\n";
		 return (identificador+posicionGPS+cantidadAnclajes+cantidadAnclajesOcupados);	 
	}
	 
	 

}
