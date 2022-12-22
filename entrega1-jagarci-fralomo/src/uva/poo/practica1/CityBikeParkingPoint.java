package uva.poo.practica1;
import uva.poo.practica1.AnclajeParkingPoint;
import uva.poo.practica2.*;
import java.util.Arrays;
import java.util.UUID;

import fabricante.externo.tarjetas.TarjetaMonedero;

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
	 private double fianza;
	 
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
		 coordenadaGPS.setCoordenadaGPSLongitud(longitudGradosDecimales);
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
	 
	 /**
	  * Constructor de un CityBikeParkingPoint
	  * @param cantidadAnclajes Numero de anclajes que quiero que tenga el punto de aparcamiento 
	  * @param coordenadasGPS CoordenadasGPS del punto de Aparcamiento
	  */
	 public CityBikeParkingPoint(int cantidadAnclajes, CoordenadaParkingPoint coordenadasGPS) {
		 if (cantidadAnclajes<=0) {
			 throw new IllegalStateException("La cantidad de anclajes no puede ser menor o igual que 0");
		 }
		 else if (coordenadasGPS==null) {
			 throw new IllegalArgumentException("Llamada incorrecta: coordenadas==null");
		 }
		 this.coordenadaGPS=coordenadasGPS;
		 setCantidadAnclajes(cantidadAnclajes);
		 
	 }
	 
	 // METODOS
	 /**
	  * Devuelve las coordenadas del punto de aparcamiento
	  * @return Coordenadas del punto de aparcamiento
	  */
	 public CoordenadaParkingPoint getCoordenada() {
		 return new CoordenadaParkingPoint(coordenadaGPS.getCoordenadaGPSLatitud(), coordenadaGPS.getCoordenadaGPSLongitud());
	 }
	 /**
	 * Devuelve el valor de la fianza de CityBikeSystem
	 * @return fianza valor de la fianza
	 */
	 public double getFianza() {
		 return fianza;
	 }
	 
	 /**
	 * Proporciona un nuevo valor a la fianza del CityBikeSystem
	 * @param fianza Valor de la fianza que se establece al sistema
	 * @throws IllegalArgumentException si fianza menor que 0
	 */
	 public void setFianza(double fianza) {
		 if (fianza<0) {
				throw new IllegalArgumentException("No puede tener fianza menor que 0");
		 }
		 this.fianza= fianza;
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
		 CityBikeParkingPoint clon= new CityBikeParkingPoint(getCantidadAnclajes(),getCoordenada());
         clon.idPuntoAparcamiento= this.idPuntoAparcamiento;
         clon.setListaAnclajes(getListaAnclajes());
         clon.setFianza(fianza);
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
	 
	 /**
		 * Permite a un cliente alquilar la bicicleta de un anclaje y se le descuenta la fianza de su TarjetaMonedero
		 * @param tarjeta del cliente que quiere alquilar la bicicleta
		 * @param bici Bicicleta que se quiere alquilas
		 * @throws IllegalArgumentException si tarjeta==null
		 * @throws IllegalArgumentException si bici==null
		 * @throws IllegalStateException si no hay saldo suficiente en la tarjeta
		 */
		 public void alquilarBici(TarjetaMonedero tarjeta,Bike bici) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(bici==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: bici==null");
			 }
			 else if (tarjeta.getSaldoActual()<getFianza()) {
				 throw new IllegalStateException("No hay saldo suficiente en la tarjeta para pagar la fianza");
			 }
			 else if (getAnclajeDeBici(bici).isOcupado()){
				 tarjeta.descontarDelSaldo("***REMOVED***", bici.getDepositToPay(getFianza()));
			 	 getAnclajeDeBici(bici).setVacio(true);
			 }
			 else {
				 throw new IllegalStateException("El anclaje del que se quiere alquilar la bicicleta está vacío o reservado.");
			 }
		 }

		 /**
		 * Permite al cliente devolver una bicicleta alquilada y se le devuelve la fianza en su TarjetaMonedero
		 * @param tarjeta del cliente que quiere devolver la bicicleta
		 * @param bici Bicicleta que se quiere devolver
		 * @throws IllegalArgumentException si bici==nulls
		 * @throws IllegalArgumentException si tarjeta==null
		 */
		 public void devolverBici(TarjetaMonedero tarjeta, Bike bici) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(bici==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: bici==null");
			 }
			 else {
				 getAnclajeVacio().setOcupado(true, bici);
				 tarjeta.recargaSaldo("A156Bv09_1zXo894",bici.getDepositToPay(fianza)); 
			 }

				
		 }
		 
		 /**
		 * Permite al cliente reservar la bicicleta de un anclaje y se le decuenta la fianza de su TarjetaMonedero
		 * @param tarjeta Tarjeta del cliente que quiere reservar la bicicleta
		 * @param bici Bicicleta que se quiere reservar
		 * @throws IllegalArgumentException si tarjeta==null
		 * @throws IllegalArgumentException si bici==null
		 * @throws IllegalStateException si no hay saldo suficiente en la tarjeta
		 */
		 public void reservarBici(TarjetaMonedero tarjeta,Bike bici) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(bici==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: bici==null");
			 }
			 else if (tarjeta.getSaldoActual()<getFianza()) {
				 throw new IllegalStateException("No hay saldo suficiente en la tarjeta para pagar la fianza");
			 }
			 else if(getAnclajeDeBici(bici).isOcupado()) {
				 tarjeta.descontarDelSaldo("***REMOVED***", bici.getDepositToPay(fianza));
				 getAnclajeDeBici(bici).setReservado(true);
			 }
			 else {
				 throw new IllegalStateException("El anclaje del que se quiere reservar la bicicleta está vacío o ya reservado para otro cliente.");
			 }
			 
		 }
		 
		 /**
		  * Permite a un cliente alquilar un pack de bicicletas de un punto de aparcamiento y se le descuenta la fianza de su TarjetaMonedero
		  * @param tarjeta Tarjeta del cliente que quiere alquilar el pack de bicis
		  * @param packBicis Pack de bicis que se desea alquilar
		  * @throws IllegalArgumentException si la tarjeta==null
		  * @throws IllegalArgumentException si packBicis==null
		  * @throws IllegalStateException si no hay tantas bicis disponibles en el punto de aparcamiento como bicis tiene el pack
		  */
		 public void alquilarPack(TarjetaMonedero tarjeta, Pack packBicis) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(packBicis==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: packBicis==null");
			 }
			 else if(packBicis.getCantidadBicis()>getCantidadAnclajesOcupados()) {
				 throw new IllegalStateException("No hay tantas bicis disponibles");
			 }else {
				 for (int i=0; i<packBicis.getCantidadBicis(); i++) {
					 Bike biciActual=packBicis.getListaBicis()[i];
					 if (getAnclajeDeBici(biciActual).isOcupado()){ // Encuentro el anclaje de la bici y miro si esta disponible
					 	 getAnclajeDeBici(biciActual).setVacio(true); // Si esta disponible pongo el anclaje como vacio
					 }
				 }
				 tarjeta.descontarDelSaldo("***REMOVED***", packBicis.sumaDepositos(getFianza()));
			 }
			 
		 }
		 
		 /**
		  * Permite a un cliente reservar un pack de bicicletas de un punto de aparcamiento y se le descuenta la fianza de su TarjetaMonedero
		  * @param tarjeta Tarjeta del cliente que quiere reservar el pack de bicis 
		  * @param packBicis Pack de bicis que se desea reservar
		  * @throws IllegalArgumentException si tarjeta==null
		  * @throws IllegalArgumentException si packBicis==null
		  * @throws IllegalStateException si no hay tantas bicis disponibles en el punto de aparcamiento como bicis hay en el pack
		  */
		 public void reservarPack(TarjetaMonedero tarjeta, Pack packBicis) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(packBicis==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: packBicis==null");
			 }
			 else if(packBicis.getCantidadBicis()>getCantidadAnclajesOcupados()) {
				 throw new IllegalStateException("No hay tantas bicis disponibles");
			 }else {
				 for (int i=0; i<packBicis.getCantidadBicis(); i++) {
					 Bike biciActual=packBicis.getListaBicis()[i];
					 if (getAnclajeDeBici(biciActual).isOcupado()){ // Encuentro el anclaje de la bici y miro si esta disponible
					 	 getAnclajeDeBici(biciActual).setReservado(true); // Si esta disponible pongo el anclaje como reservado
					 }
				 }
				 tarjeta.descontarDelSaldo("***REMOVED***", packBicis.sumaDepositos(getFianza()));
			 }
			 
		 }
		 
		 /**
		  * Permite a un cliente devolver un pack de bicicletas de un punto de aparcamiento y se le descuenta la fianza de su TarjetaMonedero
		  * @param tarjeta Tarjeta del cliente que quiere devolver el pack de bicis
		  * @param packBicis Pack de bicis que se desea devolver
		  * @throws IllegalArgumentException si tarjeta==null
		  * @throws IllegalArgumentException si packBicis==null
		  * @throws IllegalStateException si no hay tantos anclajes vacios para dejar las bicis del pack
		  */
		 public void devolverPack(TarjetaMonedero tarjeta, Pack packBicis) {
			 if (tarjeta==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
			 }
			 else if(packBicis==null) {
				 throw new IllegalArgumentException("Llamada incorrecta: packBicis==null");
			 }
			 else if(packBicis.getCantidadBicis()>getCantidadAnclajesVacios()) {
				 throw new IllegalStateException("No hay tantos anclajes libres");
			 }else {
				 for (int i=0; i<packBicis.getCantidadBicis(); i++) {
					 Bike biciActual=packBicis.getListaBicis()[i];
					 getAnclajeVacio().setOcupado(true, biciActual);
				 }
				 tarjeta.recargaSaldo("A156Bv09_1zXo894", packBicis.sumaDepositos(getFianza()));
			 }
			 
		 }
		 
		 private AnclajeParkingPoint getAnclajeVacio() {
			 for (int i=0; i<listaAnclajes.length; i++) {
				 if (listaAnclajes[i].isVacio()) {
					 return listaAnclajes[i];
				 }
			 }
			 throw new IllegalStateException("No hay ningun anclaje vacio");
		 }
		 
		 private AnclajeParkingPoint getAnclajeDeBici(Bike bici) {
			 for (int i=0; i<listaAnclajes.length; i++) {
				 if (listaAnclajes[i].getBici().equals(bici)) {
					 return listaAnclajes[i];
				 }
			 }
			 throw new IllegalStateException("Ningun anclaje tiene esa bici");
		 }

}
