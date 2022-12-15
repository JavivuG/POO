package uva.poo.practica2;
/**
 * 
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
	 * @param voltaje
	 * @param cargaAh
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
	 * @param voltaje
	 */
	public void setVoltaje(int voltaje) {
		this.voltaje=voltaje;
	}
	
	/**
	 * Devuelve el voltaje de la bateria
	 * @return
	 */
	public int getVoltaje() {
		return voltaje;
	}
	
	/**
	 * Proporciona un valor para la carga de la bateria
	 * @param cargaAh Carga de la bateria
	 */
	public void setCarga(double cargaAh) {
		this.cargaAh=cargaAh;
	}
	
	/**
	 * Devuelve la carga de la bateria
	 * @return
	 */
	public double getCarga() {
		return cargaAh;
	}
	
	/**
	 * Devuelve energía almacenada en la batería en kilowatiosHora
	 * @return voltaje*cargaAh Energia almacenada en la bateria en kilowatiosHora
	 */
	public double getEnergiaAlmacenada() {
		return voltaje * cargaAh;
	}
	
	@Override
	public String toString() {
		return "Bateria: "+ voltaje+" voltios, "+cargaAh+" amperios/hora.\n";
	}
}
