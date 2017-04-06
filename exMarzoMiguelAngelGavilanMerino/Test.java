package exMarzoMiguelAngelGavilanMerino;

import exMarzoMiguelAngelGavilanMerino.excepciones.DimensionNoValidaException;
import exMarzoMiguelAngelGavilanMerino.excepciones.FiguraNoExisteException;
import exMarzoMiguelAngelGavilanMerino.excepciones.ListaVaciaException;
import exMarzoMiguelAngelGavilanMerino.figuras.Circunferencia;
import exMarzoMiguelAngelGavilanMerino.figuras.Cuadrado;
import exMarzoMiguelAngelGavilanMerino.figuras.Rectangulo;
import exMarzoMiguelAngelGavilanMerino.figuras.TrianguloRectangulo;
import utiles.Menu;
import utiles.Teclado;

public class Test {
	private static String[] opciones = { "Altas", "Bajas", "Listar" };
	private static Menu menu = new Menu("General", opciones);
	private static String[] opcionesAltas = { "Masiva (Dimensiones aleatorias, 3 figuras de cada tipo)",
			"Selectiva (Dimensiones por teclado)" };
	private static Menu menuAltas = new Menu("Altas", opcionesAltas);
	private static String[] opcionesFiguras = { "C�rculo", "Cuadrado", "Rect�ngulo", "Tri�ngulo rect�ngulo" };
	private static Menu menuFiguras = new Menu("Elige una figura a crear", opcionesFiguras);
	private static String[] opcionesListar = { "Todos", "Tri�ngulos", "Del rev�s" };
	private static Menu menuListar = new Menu("Listar", opcionesListar);
	private static String[] opcionesBajas = { "Por identificador", "Por �ndice en la lista" };
	private static Menu menuBajas = new Menu("Bajas", opcionesBajas);

	static Figuras figuritas = new Figuras();

	public static void main(String[] args) {
		do {
			switch (menu.gestionar()) {
			case 1:
				altasFigura();
				break;

			case 2:
				bajasFiguras();
				break;

			case 3:
				listarFiguras();
				break;

			default:
				System.out.println("\nSALIENDO...");
				return;
			}
		} while (true);

	}

	/**
	 * Maneja las bajas de las figuras, tanto por identificador como por índice
	 */
	private static void bajasFiguras() {
		if (figuritas.isEmpty()) {
			System.out.println("La lista est� vac�a");
			return;
		}

		do {
			switch (menuBajas.gestionar()) {
			case 1:
				bajaIdentificador();
				break;

			case 2:
				bajaIndice();
				break;

			default:
				return;
			}
		} while (true);

	}

	/**
	 * Realiza una baja por índice
	 */
	private static void bajaIndice() {
		Menu menu = new Menu("Escoja una figura", figuritas.generarOpcionesMenu());
		try {
			System.out.println("Se ha borrado: " + figuritas.borrarIndice(menu.gestionar() - 1));
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Realiza una baja por identificador
	 */
	private static void bajaIdentificador() {
		try {
			figuritas.bajaIdentificador(Teclado.leerEntero("Dame el identificador de la figura: "));
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Maneja el listado de las figuras. Muestra todas las figuras, solo los
	 * triángulos o todas las figuras del revés
	 */
	private static void listarFiguras() {
		if (figuritas.isEmpty()) {
			System.out.println("La lista est� vac�a");
			return;
		}

		do {
			try {
				switch (menuListar.gestionar()) {
				case 1:
					System.out.println(figuritas.mostrarFiguras());
					break;
				case 2:
					System.out.println(figuritas.mostrarTriangulos());
					break;
				case 3:

					System.out.println(figuritas.mostrarDelReves());

				default:
					return;
				}
			} catch (ListaVaciaException e) {
				System.err.println(e.getMessage());
			}
			break;
		} while (true);

	}

	/**
	 * Maneja las altas de las figuras, tanto la alta masiva como la alta
	 * selectiva
	 */
	private static void altasFigura() {
		do {
			switch (menuAltas.gestionar()) {
			case 1:
				altaMasiva();
				break;

			case 2:
				altaSelectiva();
				break;

			default:
				return;
			}
		} while (true);

	}

	/**
	 * Genera 3 figuras de cada clase y las muestra
	 */
	private static void altaMasiva() {
		figuritas.altaMasiva();

		listarTodo();
	}

	/**
	 * Crea la figura deseada escogida mediante un menú
	 */
	private static void altaSelectiva() {
		do {
			try {
				switch (menuFiguras.gestionar()) {
				case 1:
					figuritas.add(new Circunferencia(pedirDimension("Introduzca el radio")));
					break;

				case 2:
					figuritas.add(new Cuadrado(pedirDimension("Introduzca el lado")));
					break;

				case 3:
					figuritas.add(new Rectangulo(pedirDimension("Introduzca la base"),
							pedirDimension("Introduzca la altura")));
					break;

				case 4:
					figuritas.add(new TrianguloRectangulo(pedirDimension("Introduzca la base"),
							pedirDimension("Introduzca la altura")));
					break;

				default:
					System.out.println("\n>>>Volviendo al menu principal!");
					return;
				}
			} catch (DimensionNoValidaException e) {
				System.err.println(e.getMessage());
			}
		} while (true);
	}

	/**
	 * Pide una dimensión para las figuras
	 * 
	 * @param string
	 * @return dimensión
	 */
	private static double pedirDimension(String string) {
		return Teclado.leerDecimal(string);
	}

	/**
	 * Lista todas las figuras
	 */
	private static void listarTodo() {
		try {
			System.out.println(figuritas.mostrarFiguras());
		} catch (ListaVaciaException e) {
			System.err.println(e.getMessage());
		}
	}

}
