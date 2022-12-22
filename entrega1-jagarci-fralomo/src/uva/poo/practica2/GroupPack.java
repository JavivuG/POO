package uva.poo.practica2;

/**
 * Tipo de datos que representa un pack de grupo de bicis
 * @author jagarci
 * @author fralomo
 *
 */
public class GroupPack extends Pack {
	//Inicializadores
	/**
	 * Constructor de un pack de grupo indicando la lista de bicis
	 * @param listaBicis Lista de bicis que forman el pack
	 * @throws IllegalArgumentException si hay menos de 10 bicis
	 */
	public GroupPack(Bike[] listaBicis) {
		super(listaBicis);
		if (listaBicis.length<10) {
			throw new IllegalArgumentException("Debe de haber como minimo 10 bicis");
		}
	}
		
	@Override
	/**
	 * Quitar una bici de la lista de  bicis
	 * @param bici Bici que se desea quitar
	 * @throws IllegalStateException si el numero de bicis en el pack es 10, minimo permitido
	 */
	public void quitaBike(Bike bici) {
		if (getCantidadBicis()==10) {
			throw new IllegalStateException("Debes de añadir una bici antes de eliminarla");
		}
		else {
			Bike[] listaBicis=new Bike[getListaBicis().length-1];
			int posicion=0;
			for (int i=0; i<getListaBicis().length; i++){
				if (!getListaBicis()[i].equals(bici)){
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
	 * Devuelve el total del deposito. Se aplica un descuento del 80% al deposito inicial
	 * @param deposit Deposito inicial
	 * @throws IllegalArgumentException si el deposito es menor que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<0) {
			throw new IllegalArgumentException("El deposito debe ser mayor que 0");
		}
		return sumaDepositos(deposit)*0.8;
	}
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas del pack de grupo
	 */
	public String toString() {
		return "Pack de grupo\n" + super.toString();
	}
	
	@Override
	/**
	 * Comprueba si dos packs de grupo son iguales
	 */
	public boolean equals(Object otro) {
	    if (otro == null )  {
	        throw new IllegalArgumentException("Llamada incorrecta: otro==null");
	    }
	    else {
	    	if (otro instanceof GroupPack) {
	    		GroupPack otroPack = (GroupPack) otro;
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
