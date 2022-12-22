package uva.poo.practica2;
import java.util.ArrayList;
/**
 * Tipo de datos que representa un pack
 * @author jagarci
 * @author fralomo
 *
 */
public abstract class Pack implements Resource {
	private ArrayList<Bike> listaBicis;
	
	// Inicializadores
	/**
	 * Constructor de un pack de bicis indicando la lista de bicis
	 * @param listaBicis Lista de bicis
	 */
	public Pack(ArrayList<Bike> listaBicis) {
		setListaBicis(listaBicis);
	}
	
	/**
	 * Proporciona un lista de bicis al pack
	 * @param listaBicis Lista de bicis que forman el pack
	 * @throws IllegalArgumentException si la listaBicis esta vacia o listaBicis==null
	 * @throws IllegalStateException si hay bicis repetidas en la lista de bicis
	 */
	public void setListaBicis(ArrayList<Bike> listaBicis) {
		if (listaBicis==null || listaBicis.isEmpty()) {
			throw new IllegalArgumentException("LLamada incorrecta: lista nula o vacía");
		}
		else if (bicisIgualesEnLista(listaBicis)) {
			throw new IllegalStateException("No puede haber bicis repetidas en la lista");
		}
		else {
			ArrayList<Bike> clon= new ArrayList<>();
			for (int i=0 ; i<listaBicis.size() ; i++) {
				clon.add(listaBicis.get(i).clone()); 
			}
			this.listaBicis= clon;
		}
	}
	
	private boolean bicisIgualesEnLista(ArrayList<Bike> listaBicis) {
		for (int i=0; i<listaBicis.size(); i++) {
			if (listaBicis.subList(i + 1, listaBicis.size()).contains(listaBicis.get(i))) {
                return true;
			}
		}
		return false;
	}
	
	/**
	 * Devuelve la lista de bicis del pack
	 * @return clon Lista de bicis
	 */
	public ArrayList<Bike> getListaBicis(){
		ArrayList<Bike> clon= new ArrayList<>();
		for (int i=0 ; i<listaBicis.size() ; i++) {
			clon.add(listaBicis.get(i).clone()); 
		}
		
		return clon;
	}
	
	/**
	 * Añade una bici a la lista de bicis del pack
	 * @param bici Bici que se desea añadir
	 * @throws IllegalArgumentException si bici==null
	 */
	public void addBike(Bike bici) {
		if (bici==null) {
			throw new IllegalArgumentException("Llamada incorrecta: bici==null");
		}
		ArrayList<Bike> listaBicis= getListaBicis();
		listaBicis.add(bici);
		setListaBicis(listaBicis);
	}
	
	/**
	 * Devuelve la cantidad de bicis que forman el pack
	 * @return cantidad de bicis del pack
	 */
	public int getCantidadBicis() {
		return getListaBicis().size();
	}
	
	/**
	 * Devuelve true o false si una bici esta en el pack
	 * @param bici Bici que se quiere comprobar que esta en el pack
	 * @throws IllegalArgumentException si bici==null
	 * @return True si la bici esta en el pack y false si no esta en el pack
	 */
	public boolean estaEnLista(Bike bici) {
		if (bici==null) {
			throw new IllegalArgumentException("Llamada incorrecta: bici==null");
		}
		return getListaBicis().contains(bici);
	}
	
	/**
	 * Devuelve una bici dado su identificador
	 * @param id Identificador de la bici que se desea obtener
	 * @return clon Clon de la bici
	 * @throws IllegalStateException si no existe ninguna bici con ese identificador en el pack
	 */
	public Bike getBici(String id) {
		for (int i=0; i<getListaBicis().size(); i++) {
			if (getListaBicis().get(i).getIdentificador().equals(id)) {
				Bike clon=getListaBicis().get(i).clone();
				return clon;
			}
		}
		throw new IllegalStateException("No existe ninguna bici con ese identificador");
	}
	
	/**
	 * Devuelve la cantidad de bicis electricas que hay en el pack
	 * @return cantidad de bicis electricas que hay
	 */
	public int getCantidadBicisElectricas() {
		int contador=0;
		for (int i=0; i<getListaBicis().size(); i++) {
			if (getListaBicis().get(i) instanceof ElectricBike) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Devuelve la cantidad de bicis de adulto que hay en el pack
	 * @return cantidad de bicis de adulto
	 */
	public int getCantidadBicisAdultas() {
		int contador=0;
		for (int i=0; i<getListaBicis().size(); i++) {
			if (getListaBicis().get(i) instanceof AdultBike) {
				contador++;
			}
		}
		return contador-getCantidadBicisElectricas();
	}
	
	/**
	 * Devuelve la cantidad de bicis infantiles que hay en el pack
	 * @return Cantidad de bicis infantiles
	 */
	public int getCantidadBicisInfantiles() {
		int contador=0;
		for (int i=0; i<getListaBicis().size(); i++) {
			if (getListaBicis().get(i) instanceof ChildBike) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Devuelve la suma de depositos de las bicis de la lista
	 * @param deposit Deposito
	 * @return sumaDepositos Suma de los depositos de las bicis de la lista
	 */
	public double sumaDepositos(double deposit){
		double sumaDepositos=0;
		ArrayList<Bike> listaBicis= getListaBicis();
		for (int i=0; i<listaBicis.size(); i++) {
			sumaDepositos+=listaBicis.get(i).getDepositToPay(deposit);
		}
		return sumaDepositos;
	}
	
	/**
	 * Quita una bici de la lista
	 * @param bici Bici que se desea quitar del pack
	 */
	public abstract void quitaBike(Bike bici);
	
	public abstract double getDepositToPay(double deposit);
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas del pack
	 */
	public String toString() {
		return "Pack: "+ getCantidadBicis() +" bicis, " +getCantidadBicisAdultas()+ " bicis de adulto, " + getCantidadBicisElectricas() +" bicis electricas, "+ getCantidadBicisInfantiles() + " bicis infantiles\n";
	}
	
}
