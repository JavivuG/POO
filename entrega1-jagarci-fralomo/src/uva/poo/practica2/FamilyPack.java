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
	 * @throws IllegalArgumentException si no hay 2 o mas bicis infantiles
	 */
	public FamilyPack(ArrayList<Bike> listaBicis) {
		super(listaBicis);
		if (listaBicis.size()<4) {
			throw new IllegalArgumentException("Debe de haber como minimo 4 bicis");
		}else if(contadorBicisInfantiles()<2) {
			throw new IllegalArgumentException("Debe de tener como minino 2 bicis infantiles");
		}
	}

	private int contadorBicisInfantiles() {
		int contador=0;
		for (int i=0; i<getListaBicis().size(); i++) {
			if (getListaBicis().get(i) instanceof ChildBike) {
				contador++;
			}
		}
		return contador;
	}
	/**
	 * 
	 * @throws new IllegalStateException si
	 */
	@Override
	public void quitaBike(Bike bici) {
		if (getListaBicis().size()==4) {
			throw new IllegalStateException("Debe añadir una bici antes de eliminarla");
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
		return sumaDepositos(deposit)*0.5;
	}
}
