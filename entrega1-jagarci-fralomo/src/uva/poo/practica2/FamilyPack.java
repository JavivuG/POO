package uva.poo.practica2;
import java.util.ArrayList;
/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class FamilyPack extends Pack{
	// Inicializadores
	/**
	 * 
	 * 
	 * @param listaBicis
	 * @throws IllegalArgumentException si no hay 4 o mas bicis
	 */
	public FamilyPack(ArrayList<Bike> listaBicis) {
		super(listaBicis);
		if (listaBicis.size()<4) {
			throw new IllegalArgumentException("Debe de haber como minimo 4 bicis");
		}
	}
	/**
	 * 
	 */
	public void addBike(Bike bici) {
		
	}
	
	/**
	 * 
	 * @throws new IllegalStateException si
	 */
	public void quitaBike(Bike bici) {
		if (getListaBicis().size()==4) {
			throw new IllegalStateException("Debe añadir una bici antes de eliminarla");
		}
	}
	
	/**
	 * 
	 */
	public double getDepositToPay(double deposit) {
		return sumaDepositos(deposit)*0.5;
	}
}
