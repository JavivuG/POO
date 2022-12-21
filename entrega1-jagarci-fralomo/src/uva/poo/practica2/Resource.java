package uva.poo.practica2;

/**
 * Interfaz que representa un recurso
 * @author jagarci
 * @author fralomo
 *
 */
public interface Resource {
	/**
	 * Devuelve el deposito para pagar
	 * @param deposit Deposito inicial
	 * @return deposit Deposito que se tiene que pagar
	 */
	public double getDepositToPay(double deposit);
}
