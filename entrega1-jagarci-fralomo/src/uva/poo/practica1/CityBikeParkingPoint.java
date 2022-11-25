package uva.poo.practica1;
import uva.poo.practica1.AnclajeParkingPoint;
import java.util.UUID;

/**
 * Tipo de datos que representa un punto de aparcamiento de bicis
 * @author jagarci
 * @author fralomo
 *
 */
 public class CityBikeParkingPoint {
	 private AnclajeParkingPoint[] listaAnclajes;
	 private CoordenadaParkingPoint coordenadaGPS;
	 private String idPuntoAparcamiento=UUID.randomUUID().toString();
	 
	 // Inicializadores
	 /**
	  * Constructor para poner una cantidad determinada de anclajes
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento
	  * @param latitudGradosDecimales Latitud en grados decimales
	  * @param longitudGradosDecimales Longitud en grados decimales
	  * @throws IllegalStateException si cantidad de anclajes es menor que cero
	  * @throws IllegalArgumentException si latitudGradosDecimales o longitudGradosDecimales son menores que 0
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, double latitudGradosDecimales, double longitudGradosDecimales) {
		 if (cantidadAnclajes<=0) {
			 throw new IllegalStateException("La cantidad de anclajes no puede ser menor o igual que 0");
		 }
		 else if(latitudGradosDecimales<0 || longitudGradosDecimales<0) {
			 throw new IllegalArgumentException("Llamada incorrecta: latitudGradosDecimales o longitudGradosDecimales deben ser mayores o iguales que 0");
		 }
		 setCantidadAnclajes(cantidadAnclajes);
		 coordenadaGPS.setCoordenadaGPSLatitud(latitudGradosDecimales);
		 coordenadaGPS.setCoordeadaGPSLongitud(longitudGradosDecimales);
	 }
	 
	 /**
	  * Constructor para poner una cantidad determinada de anclajes
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento
	  * @param latitudGMS Latitud en grados minutos y segundos
	  * @param longitudGMS Longitud en grados minutos y segundos
	  * @throws IllegalStateException si cantidad de anclajes es menor que cero
	  * @throws IllegalArgumentException si latitudGradosDecimales o longitudGradosDecimales son menores que 0
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, double[] latitudGMS, double[] longitudGMS) {
		 if (cantidadAnclajes<=0) {
			 throw new IllegalStateException("La cantidad de anclajes no puede ser menor o igual que 0");
		 }
		 setCantidadAnclajes(cantidadAnclajes);
		 coordenadaGPS.setCoordenadaGPSLatitud(latitudGMS);
		 coordenadaGPS.setCoordeadaGPSLongitud(longitudGMS);
	 }
	 
	 // METODOS
	 /**
	  * 
	  * @return
	  */
	 public CoordenadaParkingPoint getCoordenada() {
		 return coordenadaGPS;
	 } 
	 
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
	  * @throws IllegalStateException si cantidad de Anclajes menor o igual que cero o si ya se habia establecido una cantidad de anclajes
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
	 
	 public void setListaAnclajes(AnclajeParkingPoint[] listaAnclajes) {
		 this.listaAnclajes= listaAnclajes;
	 }
	 
	 @Override
	 public CityBikeParkingPoint clone() {
		 CityBikeParkingPoint clon= new CityBikeParkingPoint(getCantidadAnclajes(),coordenadaGPS.getCoordenadaGPSLatitud(),coordenadaGPS.getCoordenadaGPSLongitud());
         clon.idPuntoAparcamiento= this.idPuntoAparcamiento;
         clon.setListaAnclajes(getListaAnclajes());
         return clon;
     }
	 
	 /**
	  * Devuelve un String con el identificador, la posicion GPS, la cantidad de anclajes y la cantidad de anclajes ocupados de un punto de aparcamiento
	  */
	 @Override
	 public String toString() {
		 String identificador="Indetificador:"+ getIdPuntoAparcamiento() +"\n";
		 String posicionGPS="Posicion GPS: ("+ coordenadaGPS.getCoordenadaGPSLatitud()+ ","+coordenadaGPS.getCoordenadaGPSLongitud()+")\n";
		 String cantidadAnclajes="Cantidad de Anclajes: "+ getCantidadAnclajes()+"\n";
		 String cantidadAnclajesOcupados="Cantidad de Anclajes Ocupados: "+getCantidadAnclajesOcupados()+"\n";
		 return (identificador+posicionGPS+cantidadAnclajes+cantidadAnclajesOcupados);	 
	}

}
