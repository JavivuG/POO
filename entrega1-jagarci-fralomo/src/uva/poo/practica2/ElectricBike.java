package uva.poo.practica2;

/**
 * Tipo de dato que representa una bici electrica
 * @author jagarci
 * @author fralomo
 */

public class ElectricBike extends AdultBike {
	private BateriaBike bateria;
	private double parMotorNM;
	
	// Inicializadores
	/**
	 * Constructor de una bici electrica
	 * @param marca Marca de la bici (String)
	 * @param modelo Modelo de la bici (String)
	 * @param talla Talla de la bici (String)
	 * @param peso Peso de la bici en kilogramos
	 * @param numPlatos Numero de platos de la bici
	 * @param numPinones Numero de pinones de la bici
	 * @param bateria Tipo de dato Bateria
	 * @param parMotorNM Par del motor en Newtons por metro(NM)
	 */
	public ElectricBike(String marca, String modelo, String talla, double peso, int numPlatos, int numPinones, BateriaBike bateria, double parMotorNM) {
		super(marca, modelo, talla,  peso, numPlatos,  numPinones);
		setBateria(bateria);
		setParMotorNM(parMotorNM);
	}
	
	/**
	 * Devuelve el objeto bateria de la bici electrica
	 * @return bateria Bateria de la bici
	 */
	public BateriaBike getBateria() {
		return bateria;
	}

	/**
	 * Proporciona una bateria para la bici electrica
	 * @param bateria Bateria de la bici
	 * @throws IllegalArgumentException si la bateria==null
	 */
	public void setBateria(BateriaBike bateria) {
		if (bateria==null) {
			throw new IllegalArgumentException("Llamada incorrecta: bateria==null ");
		}
		this.bateria = bateria;
	}

	/**
	 * Devuelve el valor del parMotor en Newtons/metro del motor
	 * @return parMotorNM parMotor en Newtons/metro del motor
	 */
	public double getParMotorNM() {
		return parMotorNM;
	}

	/**
	 * Proporciona un nuevo valor para el par motor
	 * @param parMotorNM par del motor en Newtons por metro (NM)
	 * @throws IllegalArgumentException si el par del motor es menor o igual a 0
	 */
	public void setParMotorNM(double parMotorNM) {
		if(parMotorNM<=0) {
			throw new IllegalArgumentException("El motor no puede tener par motor menor o igual que 0");
		}
		this.parMotorNM = parMotorNM;
	}
	
	@Override
	/**
	 * Devuelve el deposito despues del incremento correspondiente. Aumenta un porcetanje el deposito en proporcion del voltaje de la bateria de la bateria
	 * @params deposit Deposito inicial
	 * @throws IllegalArgumentException si el deposito es menor o igual que 0
	 */
	public double getDepositToPay(double deposit) {
		double incremento=0;
        if (deposit<=0) {
        	throw new IllegalArgumentException("El deposito no puede ser menor o igual que 0");
        }
        else {
    		if (bateria.getVoltaje()==24) {
    			incremento=0.24;
    		}
    		else if (bateria.getVoltaje()==36) {
    			incremento=0.36;
    		}
    		else if (bateria.getVoltaje()==48) {
    			incremento=0.48;
    		}
        	return deposit + (deposit * incremento);
        }
		
	}
	
	@Override
	/**
	 * Devuelve un String con las caracteristicas de la bici electrica y de la bateria
	 */
	public String toString() {
		return super.toString() + bateria.toString()+ "Par motor: "+ getParMotorNM() +" newtons/metro.\n";
	}
	
	@Override
	/**
	 * Metodo para comparar si dos bicis electricas son iguales. En el caso de que sean distinto tipo de bici devuelve false
	 * @param otro Bici con la que se quiere comparar
	 * @throes IllegalArgumentException si otro==null
	 */
	public boolean equals(Object otro) {
		if (otro==null) {
			throw new IllegalArgumentException("Llamada incorrecta: otro==null");
		}
		else {
			if (otro instanceof ElectricBike) {
				return getIdentificador().equals(((ElectricBike) otro).getIdentificador());
			}
			return false;
		}
		
	}
	
	@Override
	/**
	 * Devuelve un clon de la bici electrica
	 */
	 public Bike clone() {
		ElectricBike clon= new ElectricBike( getMarca(), getModelo(), getTalla(), getPeso(), getNumPlatos(), getNumPinones(), getBateria(), getParMotorNM());
		clon.setIdentificador(getIdentificador());
		return clon;
	}
	
}
