package uva.poo.practica2;
/**
 * Tipo de datos que representa un pack
 * @author jagarci
 * @author fralomo
 *
 */
public abstract class Pack implements Resource {
	private Bike[] listaBicis;
	
	// Inicializadores
	/**
	 * Constructor de un pack de bicis indicando la lista de bicis
	 * @param listaBicis Lista de bicis
	 */
	public Pack(Bike[] listaBicis) {
		setListaBicis(listaBicis);
	}
	
	/**
	 * Proporciona un lista de bicis al pack
	 * @param listaBicis Lista de bicis que forman el pack
	 * @throws IllegalArgumentException si la listaBicis esta vacia o listaBicis==null
	 * @throws IllegalStateException si hay bicis repetidas en la lista de bicis
	 */
	public void setListaBicis(Bike[] listaBicis) {
		if (listaBicis==null) {
			throw new IllegalArgumentException("LLamada incorrecta: lista nula o vacía");
		}
		else if (bicisIgualesEnLista(listaBicis)) {
			throw new IllegalStateException("No puede haber bicis repetidas en la lista");
		}
		else {
			Bike[] clon=new Bike[listaBicis.length];
			for (int i=0 ; i<listaBicis.length ; i++) {
				clon[i]=listaBicis[i]; 
			}
			this.listaBicis= clon;
		}
	}
	
	private boolean bicisIgualesEnLista(Bike[] listaBicis) {
		for (int i=0; i<listaBicis.length; i++) {
			for (int j=i+1; j<listaBicis.length; j++) {
				if (listaBicis[j].equals(listaBicis[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Devuelve la lista de bicis del pack
	 * @return clon Lista de bicis
	 */
	public Bike[] getListaBicis(){
		Bike[] clon=new Bike[listaBicis.length]; 
		for (int i=0 ; i<listaBicis.length ; i++) {
			clon[i]=listaBicis[i].clone();
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
		Bike[] listaBicis= new Bike[getListaBicis().length+1];
		for (int i=0; i<getListaBicis().length; i++) {
			listaBicis[i]=getListaBicis()[i];
		}
		listaBicis[getListaBicis().length]=bici;
		setListaBicis(listaBicis);
	}
	
	/**
	 * Devuelve la cantidad de bicis que forman el pack
	 * @return cantidad de bicis del pack
	 */
	public int getCantidadBicis() {
		return getListaBicis().length;
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
		for (int i=0; i<getListaBicis().length; i++) {
			if (getListaBicis()[i].equals(bici)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Devuelve una bici dado su identificador
	 * @param id Identificador de la bici que se desea obtener
	 * @return clon Clon de la bici
	 * @throws IllegalStateException si no existe ninguna bici con ese identificador en el pack
	 */
	public Bike getBici(String id) {
		for (int i=0; i<getListaBicis().length; i++) {
			if (getListaBicis()[i].getIdentificador().equals(id)) {
				Bike clon=getListaBicis()[i].clone();
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
		for (int i=0; i<getListaBicis().length; i++) {
			if (getListaBicis()[i] instanceof ElectricBike) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Devuelve la cantidad de bicis de adulto que hay en el pack
	 * @return cantidad de bicis de adulto
	 */
	public int getCantidadBicisAdultos() {
		int contador=0;
		for (int i=0; i<getListaBicis().length; i++) {
			if (getListaBicis()[i] instanceof AdultBike) {
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
		for (int i=0; i<getListaBicis().length; i++) {
			if (getListaBicis()[i] instanceof ChildBike) {
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
		Bike[] listaBicis= getListaBicis();
		for (int i=0; i<listaBicis.length; i++) {
			sumaDepositos+=listaBicis[i].getDepositToPay(deposit);
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
		return "Pack: "+ getCantidadBicis() +" bicis, " +getCantidadBicisAdultos()+ " bicis de adulto, " + getCantidadBicisElectricas() +" bicis electricas, "+ getCantidadBicisInfantiles() + " bicis infantiles\n";
	}
	
	
	@Override
	/**
	 * Comprueba si dos packs son iguales
	 * @throws IllegalArgumentException si otro==null
	 */
	public boolean equals(Object otro) {
	    if (otro == null )  {
	        throw new IllegalArgumentException("Llamada incorrecta: otro==null");
	    }
	    else {
	    	if (otro instanceof Pack) {
	    		Pack otroPack = (Pack) otro;
	    	    if (getListaBicis().length != otroPack.getListaBicis().length) {
	    	        return false;
	    	    }
	    	    for (Bike bici : getListaBicis()) {
	    	        boolean encontrada = false;
	    	        int i = 0;
	    	        while (i < otroPack.getListaBicis().length && !encontrada) {
	    	            if (bici.equals(otroPack.getListaBicis()[i])) {
	    	                encontrada = true;
	    	            }
	    	            i++;
	    	        }
	    	        if (!encontrada) {
	    	            return false;
	    	        }
	    	    }
	    	    return true;
	    	}
	    	return false;
	    }
	}
}
