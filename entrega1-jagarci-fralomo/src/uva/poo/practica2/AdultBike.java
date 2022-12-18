package uva.poo.practica2;

/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class AdultBike extends Bike {
	private String talla;
	
	public AdultBike(String marca, String modelo, String talla, double peso, int numPlatos, int numPinones) {
		super(marca, modelo, peso, numPlatos,numPinones);
		setTalla(talla);
	}
	
	public void setTalla(String talla) {
		if (talla.equalsIgnoreCase("S") || talla.equalsIgnoreCase("M") || talla.equalsIgnoreCase("L") || talla.equalsIgnoreCase("XL")){
			this.talla=talla;
		}
		else {
			throw new IllegalArgumentException("Las tallas de las bicis son S, M, L y XL ");
		}
		
	}
	
	public String getTalla() {
		return talla;
	}
	
	@Override
	/**
	 * @param deposit
	 * @throws IllegalArgumentException si el deposito es menor o igual que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<=0) {
			throw new IllegalArgumentException("El deposito no puede ser menor o igual que 0");
		}
		return deposit;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Talla: "+ getTalla();
	}
	
	
}
