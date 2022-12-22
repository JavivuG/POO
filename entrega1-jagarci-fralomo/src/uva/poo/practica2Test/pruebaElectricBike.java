package uva.poo.practica2Test;
import java.util.ArrayList;
import uva.poo.practica2.*;

public class pruebaElectricBike {

	public static void main(String[] args) {
		BateriaBike bateria=new BateriaBike(48, 57);
		Bike e= new ChildBike("Orbea", "Oregon", 12, 10.34, 3, 8);
		Bike r= new ChildBike("Orbea", "Oregon", 12, 10.34, 3, 8);
		Bike g =new ElectricBike("Orbea", "Arriba", "M", 10,34,3 ,bateria, 8);
		Bike p= new ElectricBike("Orbea", "Arriba", "M", 10,34,3 ,bateria, 8);
		Bike j=new AdultBike("BH" , "Oregon" ,"L", 10, 34, 5);
		ArrayList<Bike> listaBicis=new ArrayList<>();
		listaBicis.add(e);
		listaBicis.add(p);
		listaBicis.add(r);
		listaBicis.add(j);
		listaBicis.add(g);
		Pack pack=new FamilyPack(listaBicis);
		//System.out.println(pack.toString());
		pack.quitaBike(j);
		//System.out.println(pack.estaEnLista(j));
		pack.addBike(j);
		//System.out.println(pack.getDepositToPay(20) +" €");
		

	}

}
