package uva.poo.practica2;
import java.util.UUID;

/**
 * 
 * Tipo de datos que representa un bici
 * @author jagarci
 * @author fralomo
 *
 */
public abstract class Bike implements Resource {
	private String identificador=UUID.randomUUID().toString();
	private String marca;
	private String modelo;
	private double peso;
	private int numPlatos;
	private int numPinones;
	
	// Inicializadores
	/**
	 * Constructor de una bicicleta indicando la marca, modelo, peso, numero de platos y numero de pinones
	 * @param marca Marca de la bici (String)
	 * @param modelo Modelo de la bici (String)
	 * @param peso Peso de la bici en kilogramos
	 * @param numPlatos Numero de platos de la bici
	 * @param numPinones Numero de pinones de la bici
	 */
	public Bike(String marca, String modelo, double peso, int numPlatos, int numPinones) {
		setMarca(marca);
		setModelo(modelo);
		setPeso(peso);
		setNumPlatos(numPlatos);
		setNumPinones(numPinones);
	}
	
	protected void setIdentificador(String identificador) {
		this.identificador=identificador;
	}
	
	/**
	 * Devuelve el identificador de una bicicleta
	 * @return identificador Identificador de la bici
	 */
	public String getIdentificador() {
		return identificador;
	}
	
	/**
	 * Devuelve la marca de la bici
	 * @return marca Marca de la bici
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Proporciona un valor para la marca de la bici
	 * @param marca Marca de la bici
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el modelo de la bici
	 * @return modelo Modelo de la bici
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Proporciona el modelo de la bici
	 * @param modelo Modelo de la bici
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Proporciona un valor para peso de la bici en kilogramos
	 * @return peso Peso de la bici en kilogramos
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el valor del peso de la bici en kilogramos
	 * @param peso Peso de la bici
	 * @throws IllegalArgumentException si el peso es menor o igual que 0
	 */
	public void setPeso(double peso) {
		if (peso<=0) {
			throw new IllegalArgumentException("El peso no puede ser menor o igual que 0");
		}
		this.peso = peso;
	}

	/**
	 * Devuelve el numero de platos de la bici
	 * @return numPlatos Numero de platos de la bici
	 */
	public int getNumPlatos() {
		return numPlatos;
	}

	/**
	 * Proporciona un valor para el numero de platos de la bici
	 * @param numPlatos Numero de platos de la bicicleta
	 * @throws IllegalArgumentException si el numero de platos es menor que 1
	 */
	public void setNumPlatos(int numPlatos) {
		if (numPlatos<1) {
			throw new IllegalArgumentException("No puede tener menos de 1 plato");
		}
	
		this.numPlatos = numPlatos;
	}

	/**
	 * Devuelve el numero de pinones de la bici
	 * @return numPinones Numero de pinones de la bici
	 */
	public int getNumPinones() {
		return numPinones;
	}

	/**
	 * Proporciona un valor para el numero de pinones de la bici
	 * @param numPinones Numero de pinones de la bici
	 * @throws IllegalArgumentException si el numero de pinones es menor que 1
	 */
	public void setNumPinones(int numPinones) {
		if (numPinones<1) {
			throw new IllegalArgumentException("No puede tener menos de 1 pinon");
		}
		this.numPinones = numPinones;
	}
	
	public abstract double getDepositToPay(double deposit);
	
	public abstract Bike clone();
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas de la bici
	 */
	public String toString() {
		return "Bike: "+getIdentificador()+", Marca: "+getMarca()+", Modelo: "+getModelo()+", "+getPeso()+" kg., "+ getNumPlatos()+" platos, "+ getNumPinones()+" pinones.\n";
	}
	
	@Override
	/**
	 * Devuelve true o false si una bici es igual a otra bici. En el caso de que sean distinto tipo de bici devuelve false
	 * @param otro Bici con la que se quiere comparar
	 * @throws IllegalArgumentException si otro==null
	 */
	public boolean equals(Object otro) {
		if (otro==null) {
			throw new IllegalArgumentException("Llamada incorrecta: otro==null");
		}
		else {
			if (otro instanceof Bike) {
				return getIdentificador().equals(((Bike) otro).getIdentificador());
			}
			return false;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
