package exMarzoMiguelAngelGavilanMerino.figuras;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;

/**
 * Clase que crea un Cuadrado y hereda de RectÃ¡ngulo
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class Cuadrado extends Rectangulo {

	public Cuadrado(double dimension) throws DimensionNoValidaException {
		super(dimension, dimension);
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", lado=" + Matematicas.redondear(getBase()) + "]";
	}

}
