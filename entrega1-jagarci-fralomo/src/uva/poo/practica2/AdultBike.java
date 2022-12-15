package uva.poo.practica2;

/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class AdultBike extends Bike {
	
	@Override
	/**
	 * @param deposit
	 */
	public double getDepositToPay(double deposit) {
		return deposit;
	}
}
