package exMarzoMiguelAngelGavilanMerino;

import java.util.ArrayList;
import java.util.ListIterator;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;
import exMarzoMiguelAngelGavilanMerino.excepciones.FiguraNoExisteException;
import exMarzoMiguelAngelGavilanMerino.excepciones.ListaVaciaException;
import exMarzoMiguelAngelGavilanMerino.figuras.Circunferencia;
import exMarzoMiguelAngelGavilanMerino.figuras.Cuadrado;
import exMarzoMiguelAngelGavilanMerino.figuras.FiguraCerrada;
import exMarzoMiguelAngelGavilanMerino.figuras.Rectangulo;
import exMarzoMiguelAngelGavilanMerino.figuras.TrianguloRectangulo;

/**
 * Envoltorio de un ArrayList de figuras cerradas
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class Figuras {
	/**
	 * ArrayList que almacenarÃ¡ figuras cerradas
	 */
	private ArrayList<FiguraCerrada> figuritas = new ArrayList<FiguraCerrada>();

	/**
	 * MÃ©todo que aÃ±ade al arrayList una figura
	 * 
	 * @param figura
	 */
	void add(FiguraCerrada figura) {
		figuritas.add(figura);
	}

	/**
	 * Muestra todas las figuras
	 * 
	 * @return cadena con las figuras
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarFiguras() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista estï¿½ vacï¿½a");

		StringBuilder cadena = new StringBuilder();
		int i = 1;
		for (FiguraCerrada figuraCerrada : figuritas) {
			cadena.append("\n" + i++ + ". " + figuraCerrada);
		}

		return cadena;
	}

	/**
	 * Muestra todos los triÃ¡ngulos
	 * 
	 * @return cadena con los triÃ¡ngulos
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarTriangulos() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista estï¿½ vacï¿½a");

		StringBuilder cadena = new StringBuilder();
		int i = 1;
		for (FiguraCerrada figuraCerrada : figuritas) {
			if (figuraCerrada instanceof TrianguloRectangulo)
				cadena.append("\n" + i++ + ". " + figuraCerrada);
		}

		return cadena;
	}

	/**
	 * Muestra el arrayList del revÃ©s
	 * 
	 * @return cadena con las figuras
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarDelReves() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista estï¿½ vacï¿½a");

		ListIterator<FiguraCerrada> it = figuritas.listIterator(figuritas.size());

		StringBuilder cadena = new StringBuilder();
		int i = 1;

		while (it.hasPrevious()) {
			cadena.append("\n" + i++ + ". " + it.previous());
		}

		return cadena;
	}

	/**
	 * Indica si la lista estÃ¡ vacia
	 * 
	 * @return true si la lista estÃ¡ vacia. False si no lo estÃ¡
	 */
	boolean isEmpty() {
		return figuritas.isEmpty();
	}

	/**
	 * Realiza un alta de 3 figuras de cada clase
	 */
	void altaMasiva() {
		for (int i = 0; i < 3; i++) {
			anadirCircunferencia();
			anadirCuadrado();
			anadirRectangulo();
			anadirTriangulo();
		}

	}

	/**
	 * AÃ±ade un triÃ¡ngulo con dimensiones aleatorias. Si la dimensiÃ³n no es
	 * vÃ¡lida, salta una excepciÃ³n
	 */
	private void anadirTriangulo() {
		try {
			figuritas.add(new TrianguloRectangulo(dimensionAleatoria(), dimensionAleatoria()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * AÃ±ade un rectÃ¡ngulo con dimensiones aleatorias. Si la dimensiÃ³n no es
	 * vÃ¡lida, salta una excepciÃ³n
	 */
	private void anadirRectangulo() {
		try {
			figuritas.add(new Rectangulo(dimensionAleatoria(), dimensionAleatoria()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * AÃ±ade un cuadrado con dimensiones aleatorias. Si la dimensiÃ³n no es
	 * vÃ¡lida, salta una excepciÃ³n
	 */
	private void anadirCuadrado() {
		try {
			figuritas.add(new Cuadrado(dimensionAleatoria()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * AÃ±ade una circunferencia con dimensiones aleatorias. Si la dimensiÃ³n no
	 * es vÃ¡lida, salta una excepciÃ³n
	 */
	private void anadirCircunferencia() {
		try {
			figuritas.add(new Circunferencia(dimensionAleatoria()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Genera una dimensiÃ³n aleatoria
	 * 
	 * @return dimensiÃ³n aleatoria
	 */
	private static double dimensionAleatoria() {
		return Math.random();
	}

	/**
	 * Genera las opciones para poder usarlas en un menÃº
	 * 
	 * @return String[] con las opciones
	 */
	String[] generarOpcionesMenu() {
		String[] opciones = new String[figuritas.size()];
		int i = 0;
		for (FiguraCerrada figura : figuritas) {
			opciones[i] = figura.toString();
			i++;
		}

		return opciones;
	}

	/**
	 * Devuelve un elemento indicado por Ã­ndice
	 * 
	 * @param index
	 * @return elemento devuelto
	 */
	FiguraCerrada get(int index) {
		if (index < 0 || index >= figuritas.size())
			throw new IndexOutOfBoundsException("Se ha salido de rango");

		return figuritas.get(index);
	}

	/**
	 * Borra las figuras por Ã­ndice en la lista
	 * 
	 * @param figuraCerrada
	 * @return
	 * @throws FiguraNoExisteException
	 */
	public FiguraCerrada borrarIndice(int indice) throws FiguraNoExisteException {
		// if (indice < 0 || indice >= figuritas.size())
		// throw new FiguraNoExisteException("La figura no existe");
		try {
			return figuritas.remove(indice);
		} catch (Exception e) {
			throw new FiguraNoExisteException("La figura no existe");
		}
	}

	/**
	 * Borra las figuras por identificador
	 * 
	 * @param identificador
	 * @throws FiguraNoExisteException
	 */
	public void bajaIdentificador(int identificador) throws FiguraNoExisteException {
		if (!figuritas.remove(new Circunferencia(identificador)))
			throw new FiguraNoExisteException("La figura no existe");

	}
}
