package uva.poo.practica1;

import uva.poo.practica2.*;

/**
 * Tipo de datos que representa un anclaje en un punto de aparcamiento
 * @author jagarci
 * @author fralomo
 *
 */
public class AnclajeParkingPoint {
	private boolean reservado;
	private boolean ocupado;
	private boolean vacio;
	private Bike bici;
	
	/**
	 * Contructor por defecto (inicialmente esta ocupado, es decir, con una bici)
	 */
	public AnclajeParkingPoint() {
		setOcupado(false);
		setReservado(false);
		setVacio(true);
	}
	
	/**
	 * Contructor dado un anclaje ya definido
	 * @param anclaje que se desea copiar
	 * @throws IllegalArgumentException si {@code fuente==null}
	 */
	public AnclajeParkingPoint(AnclajeParkingPoint anclaje) {
		if (anclaje==null) {
			throw new IllegalArgumentException("Llamada incorrecta: anclaje==null");
		}
		setOcupado(anclaje.isOcupado());
		setReservado(anclaje.isReservado());
		setVacio(anclaje.isVacio());
	}
	
	public void setBici(Bike bici) {
		if (bici==null) {
			throw new IllegalArgumentException("LLamada incorrecta: bici==null");
		}
		this.bici=bici;
	}
	
	public Bike getBici() {
		return bici.clone();
	}
	
	/**
	 * Comprueba que un anclaje este reservado o no
	 * @return true si esta reservado, false si no lo esta
	 */
	public boolean isReservado() {
		return reservado;
	}
	
	/**
	 * Pongo el estado del anclaje en reservado
	 * @param reservado true si pongo el anclaje reservado y false si no pongo estado reservado
	 */
	public void setReservado(boolean reservado) {
		if ((isOcupado() || isVacio()) && reservado) {
			setOcupado(false);
			setVacio(false);
			this.reservado = reservado;
		}
		else {
			this.reservado=reservado;
		}
	}
	
	/**
	 * Comprueba que un anclaje este ocupado o no
	 * @return true si esta ocupado, false si no lo esta
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	private void setOcupado(boolean ocupado) {
		if ((isReservado() || isVacio()) && ocupado) {
			setReservado(false);
			setVacio(false);
			this.ocupado = ocupado;
		}
		else {
			this.ocupado=ocupado;
		}
	}
	
	/**
	 * Pongo el estado del anclaje en ocupado y le asigno la bici al anclaje
	 * @param ocupado true si pongo el anclaje ocupado y false si no pongo estado ocupado
	 * @param bici Bici que se pone en el anclaje
	 */
	public void setOcupado(boolean ocupado, Bike bici) {
		setOcupado(ocupado);
		setBici(bici);
	}
	
	/**
	 * Comprueba que un anclaje este vacio o no
	 * @return true si esta vacio, false si no lo esta
	 */
	public boolean isVacio() {
		return vacio;
	}
	
	/**
	 * Pongo el estado del anclaje en vacio
	 * @param vacio true si pongo el anclaje vacio y false si no pongo estado vacio
	 */
	public void setVacio(boolean vacio) {
		if ((isReservado() || isOcupado()) && vacio) {
			setReservado(false);
			setOcupado(false);
			this.vacio = vacio;
		}
		else {
			this.vacio=vacio;
			this.bici=null;
		}
	}
	
	/**
	 * Obtiene el estado de un anclaje
	 * @return estado del anclaje
	 * @throws IllegalStateException si no se tiene ningun estado
	 */
	public String getEstado() {
		if (isReservado() && (!isOcupado() && !isVacio())) {
			return ("Reservado");
		}
		else if(isOcupado() && (!isReservado() && !isVacio())){
			return ("Ocupado");
		}
		else if(isVacio() && (!isReservado() && !isOcupado())) {
			return ("Vacio");
		}
		else {
			throw new IllegalStateException("Error: No tiene ningun estado");
		}
	}
	
	@Override
	public AnclajeParkingPoint clone() {
		return new AnclajeParkingPoint(this);
	}
	
}
