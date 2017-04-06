package exMarzoMiguelAngelGavilanMerino.excepciones;

/**
 * Excepción que se lanza cuando la lista está vacía
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class ListaVaciaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaVaciaException(String msg) {
		super(msg);
	}
}
