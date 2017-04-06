package exMarzoMiguelAngelGavilanMerino.figuras;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;

/**
 * Clase que crea una Circunferencia y hereda de FiguraCerrada
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class Circunferencia extends FiguraCerrada {
	/**
	 * Radio de la circunferencia
	 */
	private double radio;

	public Circunferencia(double radio) throws DimensionNoValidaException {
		super();
		setRadio(radio);
	}

	public Circunferencia(int identificador) {
		super(identificador);
	}

	private void setRadio(double radio) throws DimensionNoValidaException {
		if (dimensionValida(radio))
			this.radio = radio;
	}

	protected double getRadio() {
		return radio;
	}

	@Override
	protected double calcularArea() {
		return Math.PI * (Math.pow(getRadio(), 2));
	}

	@Override
	protected double calcularPerimetro() {
		return 2 * Math.PI * getRadio();
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", radio=" + radio + "]";
	}

}
