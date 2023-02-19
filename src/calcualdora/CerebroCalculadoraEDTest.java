package calcualdora;

//Para hacer las pruebas he modificado a public del código original: CerebroCalculadoraED,el array historial y double resultado,numero1 y numero2.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CerebroCalculadoraEDTest {
	private CerebroCalculadoraED aPrueba;

	@BeforeEach
	void iniciacion() {
		aPrueba = new CerebroCalculadoraED();
	}

	@Test
	void sumaTest() {
		aPrueba.procesarOperacion("1");
		assertEquals(aPrueba.resultado, aPrueba.numero1 + aPrueba.numero2);
	}

	@Test
	void restaTest() {
		aPrueba.procesarOperacion("2");
		assertEquals(aPrueba.resultado, aPrueba.numero1 - aPrueba.numero2);
	}

	@Test
	void multiplicaTest() {
		aPrueba.procesarOperacion("3");
		assertEquals(aPrueba.resultado, aPrueba.numero1 * aPrueba.numero2);
	}

	@Test
	void divideTest() {
		aPrueba.procesarOperacion("4");
		assertEquals(aPrueba.resultado, aPrueba.numero1 / aPrueba.numero2);
	}

	@Test
	void sumarResultadoTest() {
		double resultadoInicial = aPrueba.resultado;
		aPrueba.procesarOperacion("5");
		assertEquals(aPrueba.resultado, resultadoInicial + aPrueba.numero2);
	}

	/// En esta falla.En el código está sumando en vez de restar.
	@Test
	void restarResultadoTest() {
		double resultadoInicial = aPrueba.resultado;
		aPrueba.procesarOperacion("6");
		assertEquals(aPrueba.resultado, resultadoInicial - aPrueba.numero2);
	}

	@Test
	void multiplicarResultadoTest() {
		double resultadoInicial = aPrueba.resultado;
		aPrueba.procesarOperacion("7");
		assertEquals(aPrueba.resultado, resultadoInicial * aPrueba.numero2);
	}

	@Test
	void dividirResultadoTest() {
		double resultadoInicial = aPrueba.resultado;
		aPrueba.procesarOperacion("8");
		assertEquals(aPrueba.resultado, resultadoInicial / aPrueba.numero2);
	}

	@Test
	void randomTest() {
		aPrueba.procesarOperacion("10");
		assertTrue(aPrueba.resultado > 0 && aPrueba.resultado < 100);
	}

	@Test
	void historialTest() {
		aPrueba.procesarOperacion("1");
		String descripcionOperacion1 = Operaciones.SUMAR.getNombre() + " -> " + Double.toString(aPrueba.numero1) + " " + Operaciones.SUMAR.getSimbolo() + " " + Double.toString(aPrueba.numero2) + " = " + Double.toString(aPrueba.resultado);

		aPrueba.procesarOperacion("2");
		String descripcionOperacion2 = Operaciones.RESTAR.getNombre() + " -> " + Double.toString(aPrueba.numero1) + " " + Operaciones.RESTAR.getSimbolo() + " "	+ Double.toString(aPrueba.numero2) + " = " + Double.toString(aPrueba.resultado);

		aPrueba.procesarOperacion("3");
		String descripcionOperacion3 = Operaciones.MULTIPLICAR.getNombre() + " -> " + Double.toString(aPrueba.numero1) + " " + Operaciones.MULTIPLICAR.getSimbolo() + " " + Double.toString(aPrueba.numero2) + " = " + Double.toString(aPrueba.resultado);

		aPrueba.procesarOperacion("4");
		String descripcionOperacion4 = Operaciones.DIVIDIR.getNombre() + " -> " + Double.toString(aPrueba.numero1) + " " + Operaciones.DIVIDIR.getSimbolo()	+ " " + Double.toString(aPrueba.numero2) + " = " + Double.toString(aPrueba.resultado);

		aPrueba.procesarOperacion("5");
		String descripcionOperacion5 = Operaciones.SUMAR_RES.getNombre() + " -> " + Double.toString(aPrueba.numero1) + " " + Operaciones.SUMAR_RES.getSimbolo()	+ " " + Double.toString(aPrueba.numero2) + " = " + Double.toString(aPrueba.resultado);

		String[] resultadosEsperados = new String[] { descripcionOperacion5, descripcionOperacion4, descripcionOperacion3, descripcionOperacion2, descripcionOperacion1 };

		assertArrayEquals(resultadosEsperados, aPrueba.historial);
	}

}
