package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Teste do metodo compara")
	@Test
	public void testCompara() {
		Assertions.assertAll(
				()->assertEquals(1, calc.compara(5, 4)),
				()->assertEquals(0, calc.compara(5, 5)),
				()->assertEquals(-1, calc.compara(4, 5))
				);
	}
	
	@DisplayName("Teste do metodo é positivo")
	@Test
	public void testEhPositivo() {
		Assertions.assertAll(
				()->assertTrue(calc.ehPositivo(1)),
				()->assertTrue(calc.ehPositivo(0)),
				()->assertFalse(calc.ehPositivo(-1))
				);
	}
	
	@DisplayName("Teste do metodo multiplicaçao")
	@Test
	public void testMultiplica() {
		Assertions.assertAll(
				()->assertEquals(25, calc.multiplicacao(5, 5)),
				()->assertEquals(0, calc.multiplicacao(5, 0)),
				()->assertEquals(-25, calc.multiplicacao(5, -5))
				);
	}
	
	@DisplayName("Teste do metodo somatoria")
	@Test
	public void testSomatoria() {
		Assertions.assertAll(
				()->assertEquals(10, calc.somatoria(4))
				);
	}
	
	@DisplayName("Teste do metodo subtração")
	@Test
	public void testSubtracao() {
		Assertions.assertAll(
				()->assertEquals(0, calc.subtracao(5, 5)),
				()->assertEquals(5, calc.subtracao(5, 0)),
				()->assertEquals(-5, calc.subtracao(0, 5)),
				()->assertEquals(10, calc.subtracao(5, -5)),
				()->assertEquals(-10, calc.subtracao(-5, 5))
				);
	}
	

}
