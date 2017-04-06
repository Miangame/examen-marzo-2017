package exMarzoMiguelAngelGavilanMerino.figuras;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;

/**
 * Clase que crea un Rectángulo y hereda de FiguraCerrada
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Rectangulo extends FiguraCerrada {
	/**
	 * Base del rectángulo
	 */
	private double base;
	
	/**
	 * Altura del rectángulo
	 */
	private double altura;

	public Rectangulo(double base, double altura) throws DimensionNoValidaException {
		super();
		setBase(base);
		setAltura(altura);
	}

	protected double getBase() {
		return base;
	}

	protected double getAltura() {
		return altura;
	}

	private void setBase(double base) throws DimensionNoValidaException {
		if (dimensionValida(base))
			this.base = base;
	}

	private void setAltura(double altura) throws DimensionNoValidaException {
		if (dimensionValida(base))
			this.altura = altura;
	}

	@Override
	protected double calcularArea() {
		return getBase() * getAltura();
	}

	@Override
	protected double calcularPerimetro() {
		return (2 * getBase()) + (2 * getAltura());
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", base=" + base + ", altura=" + altura + "]";
	}

}
