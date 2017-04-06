package exMarzoMiguelAngelGavilanMerino.excepciones;

/**
 * Excepción que se lanza cuando una dimensión no es válida
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class DimensionNoValidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DimensionNoValidaException(String msg) {
		super(msg);
	}

}
