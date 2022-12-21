package uva.poo.practica2;

/**
 * 
 * @author jagarci
 * @author fralomo
 *
 */
public class ChildBike extends Bike {
	private int talla;
	
	public ChildBike(String marca, String modelo, int talla, double peso, int numPlatos, int numPinones) {
		super(marca, modelo, peso, numPlatos, numPinones);
		setTalla(talla);
	}
	
	/**
	 * Proporciona un valor de la talla de la bici
	 * @param talla Talla de la bici (Numero par mayor que 12 y menor que 26)
	 * @throws IllegalArgumentException si la talla de la bici no es un numero par
	 * @throws IllegalArgumentException si la talla de la bici no es mayor o igual que 12 y menor o igual que 26
	 */
	public void setTalla(int talla) {
		if (talla%2==0) {
			if (talla >= 12 && talla<=26) {
				this.talla=talla;
			}
			else {
				throw new IllegalArgumentException("La talla de la bici mayor o igual que 12 y menor o igual que 26");
			}
		}
		else {
			throw new IllegalArgumentException("La talla de la bici debe ser un numero par");
		}
		
	}
	
	public int getTalla() {
		return talla;
	}
    @Override
    /**
     * 
     * @param deposit
     * @returns deposit*0.85
     * @throws IllegalArgumentException si el deposito es menor o igual que 0
     */
    public double getDepositToPay(double deposit) {
        if (deposit<=0) {
        	throw new IllegalArgumentException("El deposito no puede ser menor o igual que 0");
        }
        return deposit * 0.85;
    }
    
    @Override
    public String toString() {
    	return super.toString() + "Talla: "+ getTalla();
    }
    
    @Override
    public boolean equals(Object otro) {
		if (otro==null) {
			throw new IllegalArgumentException("Llamada incorrecta: tarjeta==null");
		}
    	return getIdentificador().equals(((ChildBike) otro).getIdentificador());
    } 
    
    @Override
	 public Bike clone() {
    	ChildBike clon= new ChildBike( getMarca(), getModelo(), getTalla(), getPeso(), getNumPlatos(), getNumPinones());
    	clon.setIdentificador(getIdentificador());
    	return clon;
    }
}
