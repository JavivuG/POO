package uva.poo.practica2;
/**
 * 
 * Tipo de datos que representa una bateria de una bici
 * @author jagarci
 * @author fralomo
 *
 */
public class BateriaBike {
	private int voltaje;
	private double cargaAh;
	
	// Inicializadores
	/**
	 * Constructor dado un voltaje en voltios y una carga en amperios/hora
	 * @param voltaje Voltaje de una bateria en voltios
	 * @param cargaAh Carga de una bateria en amperios/hora
	 * @throws IllegalStateException si el voltaje proporcionado distinto de 24, 36 o 48 voltios
	 * @throws IllegalStateException si la carga en Amperios/hora es menor o igual que 0
	 */
	public BateriaBike(int voltaje, double cargaAh) {
		if (voltaje!=24 && voltaje!=36 && voltaje!=48 ) {
			throw new IllegalStateException("Bateria debe tener voltaje de 24, 36 o 48");
		}
		else if (cargaAh<=0) {
			throw new IllegalStateException("Bateria debe tener una carga mayor que 0");
		}
		this.voltaje=voltaje;
		this.cargaAh=cargaAh;
	}
	
	/**
	 * Proporciona un valor para el voltaje de la bateria
	 * @param voltaje Voltaje de la bateria en voltios
	 */
	public void setVoltaje(int voltaje) {
		this.voltaje=voltaje;
	}
	
	/**
	 * Devuelve el voltaje de la bateria
	 * @return voltaje Voltaje de la bateria en voltios
	 */
	public int getVoltaje() {
		return voltaje;
	}
	
	/**
	 * Proporciona un valor para la carga de la bateria
	 * @param cargaAh Carga de la bateria en AmperioHora(Ah)
	 */
	public void setCarga(double cargaAh) {
		this.cargaAh=cargaAh;
	}
	
	/**
	 * Devuelve la carga de la bateria
	 * @return cargaAh Devuelve la carga de la bateria en amperios/hora
	 */
	public double getCarga() {
		return cargaAh;
	}
	
	/**
	 * Devuelve energía almacenada en la batería en kilowatiosHora
	 * @return energia almacenada en kw/h
	 */
	public double getEnergiaAlmacenada() {
		return voltaje * cargaAh;
	}
	
	@Override
	/**
	 * Devuelve un String con el voltaje, carga y energia almacenada de la bateria de la bici
	 */
	public String toString() {
		return "Bateria: "+ getVoltaje()+" voltios, "+getCarga()+" amperios/hora, "+ getEnergiaAlmacenada()+" kw/h.\n";
	}
}
