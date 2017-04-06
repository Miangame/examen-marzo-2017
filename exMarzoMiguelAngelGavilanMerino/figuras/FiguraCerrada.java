package exMarzoMiguelAngelGavilanMerino.figuras;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;

/**
 * Clase padre que crea una figura cerrada. Todas las figuras cerradas tienen
 * identificador, area y perÃ­metro
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public abstract class FiguraCerrada {
	/**
	 * identificador de cada figura
	 */
	private int identificador;
	/**
	 * Contador que irÃ¡ aumentando al crear figuras
	 */
	private static int contador = 1;

	FiguraCerrada() {
		identificador = generarContador();
	}
	
	FiguraCerrada(int identificador) {
		this.identificador=identificador;
	}

	public int getIdentificador() {
		return identificador;
	}

	protected int generarContador() {
		return  FiguraCerrada.contador++;
	}

	/**
	 * Comprueba si una dimensiÃ³n es vÃ¡lida o no
	 * 
	 * @param base
	 *            DimensiÃ³n que se comprobarÃ¡
	 * @return True si base>0.5
	 * @throws DimensionNoValidaException
	 */
	protected boolean dimensionValida(double base) throws DimensionNoValidaException {
		if (base <= 0.5)
			throw new DimensionNoValidaException("ERROR al crear el " + getClass().getSimpleName() + ": " + base
					+ ": La dimensiÃ³n ha de tenerun mÃ­nimo de 0.5");

		return true;
	}

	/**
	 * CÃ¡lculo del area de cada figura cerrada
	 * 
	 * @return Ã�rea
	 */
	protected abstract double calcularArea();

	/**
	 * CÃ¡lculo del perÃ­metro de cada figura cerrada
	 * 
	 * @return PerÃ­metro
	 */
	protected abstract double calcularPerimetro();
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		FiguraCerrada other = (FiguraCerrada) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [Identificador=" + getIdentificador() + ", Area=" + calcularArea()
				+ ", Perimetro=" + calcularPerimetro() + "]";
	}

}
