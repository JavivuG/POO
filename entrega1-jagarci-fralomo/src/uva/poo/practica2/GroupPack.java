package uva.poo.practica2;
import java.util.ArrayList;

/**
 * Tipo de datos que representa un pack de grupo de bicis
 * @author jagarci
 * @author fralomo
 *
 */
public class GroupPack extends Pack {
	//Inicializadores
	/**
	 * Constructor de un pack de grupo indicando la lista de bicis
	 * @param listaBicis
	 * @throws IllegalArgumentException si hay menos de 10 bicis
	 */
	public GroupPack(ArrayList<Bike> listaBicis) {
		super(listaBicis);
		if (listaBicis.size()<10) {
			throw new IllegalArgumentException("Debe de haber como minimo 10 bicis");
		}
	}
		
	@Override
	/**
	 * Quitar una bici de la lista de  bicis
	 * @param bici Bici que se desea quitar
	 * @throws IllegalStateException si el numero de bicis en el pack es 10, minimo permitido
	 */
	public void quitaBike(Bike bici) {
		if (getCantidadBicis()==10) {
			throw new IllegalStateException("Debes de añadir una bici antes de eliminarla");
		}
		else {
			ArrayList<Bike> listaBicis= getListaBicis();
			listaBicis.remove(bici);
			setListaBicis(listaBicis);
		}
	}
	
	

	@Override
	/**
	 * Devuelve el total del deposito. Se aplica un descuento del 80% al deposito inicial
	 * @param deposit Deposito inicial
	 * @throws IllegalArgumentException si el deposito es menor que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<0) {
			throw new IllegalArgumentException("El deposito debe ser mayor que 0");
		}
		return sumaDepositos(deposit)*0.8;
	}
	
	@Override
	public String toString() {
		return "Pack de grupo\n" + super.toString();
	}

	
}
