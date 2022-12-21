package uva.poo.practica2;


/**
 * Tipo de datos que representa una bici de adulto 
 * @author jagarci
 * @author fralomo
 *
 */
public class AdultBike extends Bike {
	private String talla;
	
	//Inicializadores
	/**
	 * Constructor de una bici de adulto
	 * @param marca Marca de la bici
	 * @param modelo Modelo de la bici
	 * @param talla Talla de la bici de tipo String. Debe de ser S, M, L o XL
	 * @param peso Peso de la bici en kilogramos
	 * @param numPlatos Numero de platos de la bici
	 * @param numPinones Numero de pinones de la bici
	 */
	public AdultBike(String marca, String modelo, String talla, double peso, int numPlatos, int numPinones) {
		super(marca, modelo, peso, numPlatos,numPinones);
		setTalla(talla);
	}
	
	/**
	 * Proporciona un nuevo valor a la talla de la bici
	 * @param talla Talla de la bici de tipo String. Debe de ser S, M, L o XL 
	 */
	public void setTalla(String talla) {
		if (talla.equalsIgnoreCase("S") || talla.equalsIgnoreCase("M") || talla.equalsIgnoreCase("L") || talla.equalsIgnoreCase("XL")){
			this.talla=talla;
		}
		else {
			throw new IllegalArgumentException("Las tallas de las bicis son S, M, L y XL ");
		}
		
	}
	
	/**
	 * Devuelve la talla de la bici, S, M, L o XL
	 * @return talla Talla de la bici
	 */
	public String getTalla() {
		return talla;
	}
	
	@Override
	/**
	 * Devuelve el deposito a pagar
	 * @param deposit deposito a pagar
	 * @throws IllegalArgumentException si el deposito es menor o igual que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<=0) {
			throw new IllegalArgumentException("El deposito no puede ser menor o igual que 0");
		}
		return deposit;
	}
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas de la bici
	 */
	public String toString() {
		return super.toString() + "Talla: "+ getTalla();
	}
	
	@Override
	/**
	 * Devuelve true o false si una bici de adulto es igual a otra bici de adulto. En el caso de que sean distinto tipo de bici devuelve false
	 * @param otro Bici con la que se quiere comparar
	 * @throws IllegalArgumentExceptio si otro==null
	 */
	public boolean equals(Object otro) {
		if (otro==null) {
			throw new IllegalArgumentException("Llamada incorrecta: otro==null");
		}
		else {
			if (otro instanceof AdultBike) {
				return getIdentificador().equals(((AdultBike) otro).getIdentificador());
			}
			return false;
		}
		
	}
	
	@Override
	/**
	 * Devuelve un clon de la bici de adulto
	 */
	 public Bike clone() {
		AdultBike clon= new AdultBike( getMarca(), getModelo(), getTalla(), getPeso(), getNumPlatos(), getNumPinones());
        clon.setIdentificador(getIdentificador());
        return clon;
    }
	
	
}
