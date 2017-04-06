package exMarzoMiguelAngelGavilanMerino.figuras;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;

/**
 * Clase que crea un TrianguloRectangulo y hereda de FiguraCerrada
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class TrianguloRectangulo extends FiguraCerrada {
	/**
	 * Base del triángulo
	 */
	private double base;
	
	/**
	 * Altura del triángulo
	 */
	private double altura;

	public TrianguloRectangulo(double base, double altura) throws DimensionNoValidaException {
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
		if (dimensionValida(altura))
			this.altura = altura;
	}

	@Override
	protected double calcularArea() {
		return (getBase() * getAltura()) / 2;
	}

	@Override
	protected double calcularPerimetro() {
		return getBase() + getAltura() + Math.sqrt((Math.pow(getBase(), 2) + Math.pow(getAltura(), 2)));
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", base=" + base + ", altura=" + altura + "]";
	}

}
