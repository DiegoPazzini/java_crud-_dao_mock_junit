package br.com.pazzini; // Declaração do pacote

import org.junit.jupiter.api.BeforeEach; // Importa a anotação BeforeEach do JUnit
import org.junit.jupiter.api.Test; // Importa a anotação Test do JUnit

import br.com.pazzini.dao.ClienteDAO; // Importa a classe ClienteDAO do pacote br.com.pazzini.dao
import br.com.pazzini.domain.Cliente; // Importa a classe Cliente do pacote br.com.pazzini.domain
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException do pacote br.com.pazzini.exception
import br.com.pazzini.mock.ClienteDAOMock; // Importa a classe ClienteDAOMock do pacote br.com.pazzini.mock
import br.com.pazzini.service.ClienteService; // Importa a classe ClienteService do pacote br.com.pazzini.service
import br.com.pazzini.service.IClienteService; // Importa a interface IClienteService do pacote br.com.pazzini.service
import org.junit.jupiter.api.Assertions; // Importa a classe Assertions do JUnit

public class ClienteServiceTest { // Declaração da classe ClienteServiceTest
	
	private IClienteService service; // Declaração de um objeto IClienteService
	private Cliente c; // Declaração de um objeto Cliente
	
	public ClienteServiceTest() { // Construtor da classe
		this.service = new ClienteService(new ClienteDAOMock()); // Inicialização de um objeto ClienteService passando um novo ClienteDAOMock como argumento
	}
	
	@BeforeEach // Indica que o método deve ser executado antes de cada teste
	public void init() throws TipoChaveNaoEncontradaException { // Declaração do método init que lança a exceção TipoChaveNaoEncontradaException
		this.c = new Cliente(); // Inicialização de um novo objeto Cliente na variável c
		c.setCpf(12345678901L); // Configuração do atributo cpf do objeto c
		c.setNomeCliente("Rafael"); // Configuração do atributo nomeCliente do objeto c
		c.setCidade("São Paulo"); // Configuração do atributo cidade do objeto c
		c.setEnd("End"); // Configuração do atributo end do objeto c
		c.setEstado("SP"); // Configuração do atributo estado do objeto c
		c.setNumero(63); // Configuração do atributo numero do objeto c
		c.setTel(11953616215L); // Configuração do atributo tel do objeto c
		service.cadastrar(c); // Chama o método cadastrar do objeto service passando o objeto c como argumento
	}
	
	@Test // Indica que o método é um teste
	public void pesquisarCliente() { // Declaração do método pesquisarCliente
		// precisaremos criar um cliente para futuramente procurá-lo		
		
		Cliente clienteConsultado = service.consultar(c.getCpf()); // Chama o método consultar do objeto service passando o cpf do objeto c como argumento e armazenando o resultado na variável clienteConsultado
		
		Assertions.assertNotNull(clienteConsultado); // Verifica se clienteConsultado não é nulo usando o método assertNotNull da classe Assertions
		
	}
	
	@Test // Indica que o método é um teste
	public void salvarCliente() throws TipoChaveNaoEncontradaException { // Declaração do método salvarCliente que lança a exceção TipoChaveNaoEncontradaException
		Boolean res =  service.cadastrar(c); // Chama o método cadastrar do objeto service passando o objeto c como argumento e armazena o resultado na variável res
		Assertions.assertTrue(res); // Verifica se res é verdadeiro usando o método assertTrue da classe Assertions
	}
	
	@Test // Indica que o método é um teste
	public void excluirCliente() { // Declaração do método excluirCliente
		service.excluir(c.getCpf()); // Chama o método excluir do objeto service passando o cpf do objeto c como argumento
	}
	
	@Test // Indica que o método é um teste
	public void alterarCliente() throws TipoChaveNaoEncontradaException { // Declaração do método alterarCliente que lança a exceção TipoChaveNaoEncontradaException
		c.setNomeCliente("Nome alterado"); // Configuração do atributo nomeCliente do objeto c para "Nome alterado"
		service.alterar(c); // Chama o método alterar do objeto service passando o objeto c como argumento
		
		Assertions.assertEquals("Nome alterado", c.getNomeCliente()); // Verifica se o nome do cliente é "Nome alterado" usando o método assertEquals da classe Assertions
	}
}