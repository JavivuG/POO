package uva.poo.practica2;
import uva.poo.practica2.BateriaBike;

/**
 * 
 * @author jagarci
 * @author fralomo
 */
public class ElectricBike extends Bike {
	private BateriaBike bateria;
	private double parMotorNM;
	
	/**
	 * Constructor 
	 * @param marca
	 * @param modelo
	 * @param talla
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 * @param bateria
	 * @param parMotorNM
	 * @throws IllegalStateException si bateria no tiene voltaje de 24, 36 o 48 voltios
	 */
	public ElectricBike(String marca, String modelo, int talla, double peso, int numPlatos, int numPinones, BateriaBike bateria, double parMotorNM) {
		super(marca, modelo, talla, peso, numPlatos, numPinones);

		if(parMotorNM<=0) {
			throw new IllegalStateException("El motor no puede tener par motor menor o igual que 0");
		}
		this.bateria=bateria;
		this.parMotorNM=parMotorNM;
	}

	/**
	 * 
	 * @return
	 */
	public BateriaBike getBateria() {
		return bateria;
	}

	/**
	 * 
	 * @param bateria
	 */
	public void setBateria(BateriaBike bateria) {
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
	 * @param parMotorNM
	 */
	public void setParMotorNM(double parMotorNM) {
		this.parMotorNM = parMotorNM;
	}
	
	@Override
	/**
	 * 
	 */
	public double getDepositToPay(double deposit) {
		double incremento=0;
		if (bateria.getVoltaje()==24) {
			incremento=0.1;
		}
		else if (bateria.getVoltaje()==36) {
			incremento=0.15;
		}
		else if (bateria.getVoltaje()==48) {
			incremento=0.2;
		}
		
		return deposit + (deposit * incremento);
	}
	
	@Override
	public String toString() {
		return super.toString()+ bateria.toString()+ "Par motor: "+ parMotorNM +" newtons/metro.\n";
	}
	
	
	
}
