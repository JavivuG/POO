package uva.poo.practica1;

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
	
	/**
	 * Contructor por defecto (inicialmente esta ocupado, es decir, con una bici)
	 */
	public AnclajeParkingPoint() {
		setOcupado(true);
		setReservado(false);
		setVacio(false);
	}
	
	/**
	 * Contructor dado un anclaje ya definido
	 * @param anclaje
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
	
	/**
	 * Comprueba que un anclaje este reservado o no
	 * @return true si esta reservado, false si no lo esta
	 */
	public boolean isReservado() {
		return reservado;
	}
	
	/**
	 * Pongo el estado del anclaje en reservado
	 * @param vacio true si pongo el anclaje reservado y false si no pongo estado reservado
	 */
	public void setReservado(boolean reservado) {
		if ((isOcupado() || isVacio()) && reservado==true) {
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
	
	/**
	 * Pongo el estado del anclaje en ocupado
	 * @param vacio true si pongo el anclaje ocupado y false si no pongo estado ocupado
	 */
	public void setOcupado(boolean ocupado) {
		if ((isReservado() || isVacio()) && ocupado==true) {
			setReservado(false);
			setVacio(false);
			this.ocupado = ocupado;
		}
		else {
			this.ocupado=ocupado;
		}
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
		if ((isReservado() || isOcupado()) && vacio==true) {
			setReservado(false);
			setOcupado(false);
			this.vacio = vacio;
		}
		else {
			this.vacio=vacio;
		}
	}
	
	/**
	 * Obtiene el estado de un anclaje
	 * @return estado del anclaje
	 * @throws IllegalStateException si no se tiene ningun estado
	 */
	public String getEstado() {
		if (isReservado() && (isOcupado()==false && isVacio()==false)) {
			return ("Reservado");
		}
		else if(isOcupado() && (isReservado()==false && isVacio()==false)){
			return ("Ocupado");
		}
		else if(isVacio() && (isReservado()==false && isOcupado()==false)) {
			return ("Vacio");
		}
		else {
			throw new IllegalStateException("Error: No tiene ningun estado");
		}
	}

}
