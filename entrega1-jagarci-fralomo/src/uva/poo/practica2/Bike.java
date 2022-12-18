package uva.poo.practica2;
import java.util.UUID;

import uva.poo.practica1.CityBikeParkingPoint;

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
	private double peso;
	private int numPlatos;
	private int numPinones;
	
	// Inicializadores
	/**
	 * Constructor de una bicicleta indicando la marca, modelo, peso, numero de platos y numero de pinones
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 * @throws IllegalArgumentException si el numero de platos es menor que 1
	 * @throws IllegalArgumentException si el numero de pinones es menor que 1
	 */
	public Bike(String marca, String modelo, double peso, int numPlatos, int numPinones) {
		setMarca(marca);
		setModelo(modelo);
		setPeso(peso);
		setNumPlatos(numPlatos);
		setNumPinones(numPinones);
	}
	
	/**
	 * Devuelve el identificador de una bicicleta
	 * @return identificador
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
	 * Proporciona el modelo de la bici
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Proporciona un valor para peso de la bici en kilogramos
	 * @return peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el valor del peso de la bici en kilogramos
	 * @param peso
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
		if (numPlatos<1) {
			throw new IllegalArgumentException("No puede tener menos de 1 plato");
		}
	
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
		if (numPinones<1) {
			throw new IllegalArgumentException("No puede tener menos de 1 pinon");
		}
		this.numPinones = numPinones;
	}
	
	/**
	 * 
	 */
	public abstract double getDepositToPay(double deposit);
	
	@Override
	public String toString() {
		return "Bike: "+getIdentificador()+", Marca: "+getMarca()+", Modelo: "+getModelo()+", "+getPeso()+" kg., "+ getNumPlatos()+" platos, "+ getNumPinones()+" pinones.\n";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
