package br.com.pazzini; // Declaração do pacote

import org.junit.Before; // Importa a anotação Before do JUnit
import org.junit.Test; // Importa a anotação Test do JUnit

import br.com.pazzini.domain.Produto; // Importa a classe Produto
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException
import br.com.pazzini.mock.ProdutoDAOMock; // Importa a classe ProdutoDAOMock
import br.com.pazzini.service.IProdutoService; // Importa a interface IProdutoService
import br.com.pazzini.service.ProdutoService; // Importa a classe ProdutoService
import org.junit.Assert; // Importa a classe Assert do JUnit

public class ProdutoServiceTest { // Declaração da classe ProdutoServiceTest
	private IProdutoService service; // Declaração da instância da interface IProdutoService
	private Produto p; // Declaração da instância da classe Produto
	
	public ProdutoServiceTest() { // Construtor da classe ProdutoServiceTest
		this.service = new ProdutoService(new ProdutoDAOMock()); // Inicialização da instância de ProdutoService com ProdutoDAOMock
	}
	
	@Before // Indica que o método deve ser executado antes de cada teste
	public void init() throws TipoChaveNaoEncontradaException { // Declaração do método init com a possibilidade de lançar TipoChaveNaoEncontradaException
		this.p = new Produto(); // Inicialização da instância de Produto
		p.setId(1l); // Definição do id do produto
		p.setIsDiscount(true); // Definição do desconto do produto
		p.setName("Cadeira"); // Definição do nome do produto
		service.cadastrar(p); // Chamada do método cadastrar da interface IProdutoService
	}
	
	@Test // Indica que o método é um teste
	public void cadastrarProduto() throws TipoChaveNaoEncontradaException { // Declaração do método cadastrarProduto com a possibilidade de lançar TipoChaveNaoEncontradaException
		Boolean res = service.cadastrar(p); // Chama o método cadastrar da interface IProdutoService e armazena o resultado em uma variável
		Assert.assertTrue(res); // Verifica se o resultado do cadastro é verdadeiro
	}
	
	@Test // Indica que o método é um teste
	public void consultarProduto() { // Declaração do método consultarProduto
		Produto pCadastrado  = service.consultar(p.getId()); // Consulta o produto pelo id
		Assert.assertNotNull(pCadastrado); // Verifica se o produto consultado não é nulo
	}
	
	@Test // Indica que o método é um teste
	public void excluirProduto() { // Declaração do método excluirProduto
		service.excluir(p.getId()); // Exclui o produto pelo id
	}
	
	@Test  // Indica que o método é um teste
	public void alterarProduto() throws TipoChaveNaoEncontradaException { // Declaração do método alterarProduto com a possibilidade de lançar TipoChaveNaoEncontradaException
		p.setName("Nome alterado"); // Altera o nome do produto
		Produto pAtualizado = service.alterar(p); // Chama o método alterar da interface IProdutoService e armazena o resultado em uma variável
		
		Assert.assertEquals("Nome alterado", pAtualizado.getName()); // Verifica se o nome do produto foi alterado corretamente
	}
}