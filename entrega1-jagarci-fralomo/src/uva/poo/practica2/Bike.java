package uva.poo.practica2;
import java.util.UUID;

/**
 * 
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public abstract class Bike implements Resource {
	private String identificador=UUID.randomUUID().toString();
	private String marca;
	private String modelo;
	public int talla;
	private double peso;
	private int numPlatos;
	private int numPinones;
	
	// Inicializadores
	/**
	 * 
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 */
	public Bike(String marca, String modelo,int talla, double peso, int numPlatos, int numPinones) {
		this.marca=marca;
		this.modelo=modelo;
		this.talla=talla;
		this.peso=peso;
		this.numPlatos=numPlatos;
		this.numPinones=numPinones;
	}
	
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
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el modelo de la bici
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * 
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Proporciona un valor para peso de la bici en kilogramos
	 * @return
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el valor del peso de la bici en kilogramos
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Devuelve el numero de platos de la bici
	 * @return numPlatos
	 */
	public int getNumPlatos() {
		return numPlatos;
	}

	/**
	 * 
	 * @param numPlatos
	 */
	public void setNumPlatos(int numPlatos) {
		this.numPlatos = numPlatos;
	}

	/**
	 * 
	 * @return
	 */
	public int getNumPinones() {
		return numPinones;
	}

	/**
	 * 
	 * @param numPinones
	 */
	public void setNumPinones(int numPinones) {
		this.numPinones = numPinones;
	}
	
	/**
	 * 
	 */
	public abstract double getDepositToPay(double deposit);
	
	@Override
	public String toString() {
		return "Bike: "+identificador+", marca: "+marca+", modelo: "+modelo+", talla: "+talla+", "+peso+" kg., "+numPlatos+" platos, "+numPinones+" pinones.\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
