package uva.poo.practica2;
import java.util.ArrayList;

/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class GroupPack extends Pack {
	//Inicializadores
	/**
	 * 
	 * @param listaBicis
	 * @throws IllegalArgumentException si hay menos de 10 bicis
	 */
	public GroupPack(ArrayList<Bike> listaBicis) {
		super(listaBicis);
		if (listaBicis.size()<10) {
			throw new IllegalArgumentException("Debe de haber como minimo 10 bicis");
		}
	}
		
	/**
	 * @throws IllegalStateException 
	 */
	@Override
	public void quitaBike(Bike bici) {
		if (getListaBicis().size()==10) {
			throw new IllegalStateException("Debes de añadir una bici antes de eliminarla");
		}
		else {
			ArrayList<Bike> listaBicis= getListaBicis();
			listaBicis.remove(bici);
			setListaBicis(listaBicis);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public double getDepositToPay(double deposit) {
		return sumaDepositos(deposit)*0.8;
	}

	
}
