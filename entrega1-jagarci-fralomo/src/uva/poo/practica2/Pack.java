package uva.poo.practica2;
import java.util.ArrayList;

import uva.poo.practica1.CityBikeParkingPoint;
/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public abstract class Pack implements Resource {
	private ArrayList<Bike> listaBicis;
	
	/**
	 * 
	 * @param listaBicis
	 */
	public Pack(ArrayList<Bike> listaBicis) {
		setListaBicis(listaBicis);
	}
	
	/**
	 * 
	 * @param listaBicis
	 */
	public void setListaBicis(ArrayList<Bike> listaBicis) {
		if (listaBicis==null || listaBicis.isEmpty()) {
			throw new IllegalArgumentException("LLamada incorrecta: lista nula o vacía");
		}
		else {
			ArrayList<Bike> clon= new ArrayList<>();
			for (int i=0 ; i<listaBicis.size() ; i++) {
				clon.add(listaBicis.get(i).clone()); // HACER CLONE
			}
			this.listaBicis= clon;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Bike> getListaBicis(){
		ArrayList<Bike> clon= new ArrayList<>();
		for (int i=0 ; i<listaBicis.size() ; i++) {
			clon.add(listaBicis.get(i).clone()); // HACER CLONE
		}
		
		return clon;
	}
	
	/**
	 * 
	 * @param bici
	 */
	public void addBike(Bike bici) {
		ArrayList<Bike> listaBicis= getListaBicis();
		listaBicis.add(bici);
		setListaBicis(listaBicis);
	}
	
	public abstract void quitaBike(Bike bici);

	public abstract double getDepositToPay(double deposit);
	
	public double sumaDepositos(double deposit){
		double sumaDepositos=0;
		ArrayList<Bike> listaBicis= getListaBicis();
		for (int i=0; i<listaBicis.size(); i++) {
			sumaDepositos+=listaBicis.get(i).getDepositToPay(deposit);
		}
		return sumaDepositos;
	}
	
}
