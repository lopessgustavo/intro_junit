package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
	Carrinho carrinho;
	Produto produto;
	
	@BeforeEach
	public void inicializa() {
		
		carrinho = new Carrinho();
		produto = new Produto("Livro de como fazer testes usando JUnit", 10.00);
		
	}
	
	@DisplayName("Teste do metodo getQtdeItems e addItem")
	@Test
	public void testGetQtdeItemsEAddItem() {
		assertEquals(0, carrinho.getQtdeItems());
		
		carrinho.addItem(produto);
		
		assertEquals(1, carrinho.getQtdeItems());
	}
	
	@DisplayName("Teste do metodo getValorTotal")
	@Test
	public void testGetValorTotal() {
		assertEquals(0.00, carrinho.getValorTotal());
		
		carrinho.addItem(produto);
		
		assertEquals(10.00, carrinho.getValorTotal());
	}
	
	@DisplayName("Teste do metodo getEsvazia")
	@Test
	public void testEsvazia() {
		carrinho.addItem(produto);
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Teste do metodo removeItem")
	@Test
	public void testRemoveItem() {
		carrinho.addItem(produto);
		try {
			carrinho.removeItem(produto);
			assertEquals(0, carrinho.getQtdeItems());
		}
		catch(ProdutoNaoEncontradoException e) {
			Assertions.fail("O produto deveria ter sido removido com sucesso");
		}
		
	}
	
	@DisplayName("Teste da exceção produtoNaoEncontradoException")
	@Test
	public void testProdutoNaoEncontradoException() {
		Assertions.assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(produto));
		
		
	}
	
}
