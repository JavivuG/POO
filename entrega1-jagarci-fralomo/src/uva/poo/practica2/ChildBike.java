package uva.poo.practica2;

/**
 * Tipo de dato que representa una bici infantil
 * @author jagarci
 * @author fralomo
 *
 */
public class ChildBike extends Bike {
	private int talla;
	
	// Inicizalidores
	/**
	 * Constructor de una bici infantil
	 * @param marca Marca de la bici (String)
	 * @param modelo Modelo de la bici (String)
	 * @param talla Talla de la bici un numero par entre 12 y 26
	 * @param peso Peso de la bici
	 * @param numPlatos Numero de platos de la bici
	 * @param numPinones Numero de pinones de la bici
	 */
	public ChildBike(String marca, String modelo, int talla, double peso, int numPlatos, int numPinones) {
		super(marca, modelo, peso, numPlatos, numPinones);
		setTalla(talla);
	}
	
	/**
	 * Proporciona un valor de la talla de la bici
	 * @param talla Talla de la bici (Numero par mayor que 12 y menor que 26)
	 * @throws IllegalArgumentException si la talla de la bici no es un numero par
	 * @throws IllegalArgumentException si la talla de la bici no es mayor o igual que 12 y menor o igual que 26
	 */
	public void setTalla(int talla) {
		if (talla%2==0) {
			if (talla >= 12 && talla<=26) {
				this.talla=talla;
			}
			else {
				throw new IllegalArgumentException("La talla de la bici mayor o igual que 12 y menor o igual que 26");
			}
		}
		else {
			throw new IllegalArgumentException("La talla de la bici debe ser un numero par");
		}
		
	}
	
	/**
	 * Devuelve talla de la bici infantil
	 * @return talla Talla de la bici, un numero par entre 12 y 26
	 */
	public int getTalla() {
		return talla;
	}
	
    @Override
    /**
     * Devuelve el deposito a pagar
     * @param deposit Deposito inicial
     * @returns deposit*0.85 Deposito pagar
     * @throws IllegalArgumentException si el deposito es menor o igual que 0
     */
    public double getDepositToPay(double deposit) {
        if (deposit<=0) {
        	throw new IllegalArgumentException("El deposito no puede ser menor o igual que 0");
        }
        return deposit * 0.85;
    }
    
    @Override
    /**
     * Devuelve un String con las caracteristicas de la bici y la talla
     */
    public String toString() {
    	return super.toString() + "Talla: "+ getTalla();
    }
    
    @Override
    /**
     * Metodo para comparar si dos bicis infantiles son iguales. En el caso de que sean distinto tipo de bici devuelve false
     * @param otro Bici con la que se quiere comparar
     * @throws IllegalArgumentExceptio si otro==null
     */
    public boolean equals(Object otro) {
		if (otro==null) {
			throw new IllegalArgumentException("Llamada incorrecta: otro==null");
		}
		else {
			if(otro instanceof ChildBike) {
				return getIdentificador().equals(((ChildBike) otro).getIdentificador());
			}
			return false;
		}
		
    	
    } 
    
    @Override
    /**
     * Metodo para clonar una bici infantil
     * @returns clon Clon de la bici infantil
     */
	 public Bike clone() {
    	ChildBike clon= new ChildBike( getMarca(), getModelo(), getTalla(), getPeso(), getNumPlatos(), getNumPinones());
    	clon.setIdentificador(getIdentificador());
    	return clon;
    }
}
