package uva.poo.practica2;

/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class ChildBike extends Bike {

    @Override
    /**
     * 
     * @param deposit
     * @returns deposit*0.85
     */
    public double getDepositToPay(double deposit) {
        // Aplicar un descuento del 15% sobre la fianza normal establecida
        return deposit * 0.85;
    }
}
