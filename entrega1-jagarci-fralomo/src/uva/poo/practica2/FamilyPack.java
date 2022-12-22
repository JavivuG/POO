package uva.poo.practica2;

/**
 * Tipo de datos que representa un pack familiar de bicis
 * @author jagarci
 * @author fralomo
 *
 */
public class FamilyPack extends Pack{
	// Inicializadores
	/**
	 * Constructor de un pack familiar en el que se indica la lista de bicis
	 * @param listaBicis Lista de bicis
	 * @throws IllegalArgumentException si no hay 4 o mas bicis
	 * @throws IllegalArgumentException si no hay 2 o mas bicis infantiles
	 */
	public FamilyPack(Bike[] listaBicis) {
		super(listaBicis);
		if (listaBicis.length<4) {
			throw new IllegalArgumentException("Debe de haber como minimo 4 bicis");
		}else if(contadorBicisInfantiles(listaBicis)<2) {
			throw new IllegalArgumentException("Debe de tener como minino 2 bicis infantiles");
		}
	}
	
	// Cuenta la cantidad de bicis infantiles que tiene la lista
	private int contadorBicisInfantiles(Bike[] listaBicis) {
		int contador=0;
		for (int i=0; i<listaBicis.length; i++) {
			if (listaBicis[i] instanceof ChildBike) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	/**
	 * Quita una bici de la lista de bicis
	 * @throws IllegalStateException si el numero de bicis de la lista es 4, el minimo posible
	 */
	public void quitaBike(Bike bici) {
		if (getCantidadBicis()==4) {
			throw new IllegalStateException("Debe añadir una bici antes de eliminarla");
		}
		else if (contadorBicisInfantiles(getListaBicis())==2 && bici instanceof ChildBike) {
			throw new IllegalArgumentException("Debe de tener como minino 2 bicis infantiles");
		}
		else {
			Bike[] listaBicis= new Bike[getListaBicis().length-1];
			int posicion=0;
			for (int i=0; i<getListaBicis().length; i++) {
				if (!getListaBicis()[i].equals(bici)) {
					listaBicis[posicion]=getListaBicis()[i];
					posicion++;
				}
				else {
					posicion--;
				}
			}
			setListaBicis(listaBicis);
		}
	}
	

	@Override
	/**
	 * Devuelve el total del deposito. Se aplica un descuento del 50% al deposito inicial
	 * @param deposit Deposito inicial
	 * @throws IllegalArgumentException si el deposito es menor que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<0) {
			throw new IllegalArgumentException("El deposito debe ser mayor que 0");
		}
		return sumaDepositos(deposit)*0.5;
	}
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas del pack familiar
	 */
	public String toString() {
		return "Pack familiar\n" + super.toString();
	}
	
	@Override
	/**
	 * Comprueba si dos packs familiares son iguales
	 */
	public boolean equals(Object otro) {
	    if (otro == null )  {
	        throw new IllegalArgumentException("Llamada incorrecta: otro==null");
	    }
	    else {
	    	if (otro instanceof FamilyPack) {
	    	    FamilyPack otroPack = (FamilyPack) otro;
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
