package uva.poo.practica2;
import java.util.ArrayList;
/**
 * Tipo de datos que representa un pack familiar de bicis
 * @author jagarci
 * @author fralomo
 *
 */
public class FamilyPack extends Pack{
	// Inicializadores
	/**
	 * Constructor de un pack familiar en el que se indica la lista de bicis
	 * @param listaBicis Lista de bicis
	 * @throws IllegalArgumentException si no hay 4 o mas bicis
	 * @throws IllegalArgumentException si no hay 2 o mas bicis infantiles
	 */
	public FamilyPack(ArrayList<Bike> listaBicis) {
		super(listaBicis);
		if (listaBicis.size()<4) {
			throw new IllegalArgumentException("Debe de haber como minimo 4 bicis");
		}else if(contadorBicisInfantiles(listaBicis)<2) {
			throw new IllegalArgumentException("Debe de tener como minino 2 bicis infantiles");
		}
	}
	
	// Cuenta la cantidad de bicis infantiles que tiene la lista
	private int contadorBicisInfantiles(ArrayList<Bike> listaBicis) {
		int contador=0;
		for (int i=0; i<listaBicis.size(); i++) {
			if (listaBicis.get(i) instanceof ChildBike) {
				contador++;
			}
		}
		return contador;
	}
	/**
	 * Quita una bici de la lista de bicis
	 * @throws new IllegalStateException si el numero de bicis de la lista es 4, el minimo posible
	 */
	@Override
	public void quitaBike(Bike bici) {
		if (getCantidadBicis()==4) {
			throw new IllegalStateException("Debe añadir una bici antes de eliminarla");
		}
		else {
			ArrayList<Bike> listaBicis= getListaBicis();
			listaBicis.remove(bici);
			contadorBicisInfantiles(listaBicis);
			if(contadorBicisInfantiles(listaBicis)<2) {
				throw new IllegalArgumentException("Debe de tener como minino 2 bicis infantiles");
			}
			setListaBicis(listaBicis);
		}
	}
	

	@Override
	/**
	 * Devuelve el total del deposito. Se aplica un descuento del 50% al deposito inicial
	 * @param deposit Deposito inicial
	 * @throws IllegalArgumentException si el deposito es menor que 0
	 */
	public double getDepositToPay(double deposit) {
		if (deposit<0) {
			throw new IllegalArgumentException("El deposito debe ser mayor que 0");
		}
		return sumaDepositos(deposit)*0.5;
	}
}
