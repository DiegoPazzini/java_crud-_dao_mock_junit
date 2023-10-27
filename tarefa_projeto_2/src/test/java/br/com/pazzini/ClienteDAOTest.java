package br.com.pazzini; // Declaração do pacote

import org.junit.Before; // Importa a anotação Before do JUnit
import org.junit.Test; // Importa a anotação Test do JUnit
import br.com.pazzini.dao.ClienteDAO; // Importa a classe ClienteDAO do pacote br.com.pazzini.dao
import br.com.pazzini.dao.IClienteDAO; // Importa a interface IClienteDAO do pacote br.com.pazzini.dao
import br.com.pazzini.domain.Cliente; // Importa a classe Cliente do pacote br.com.pazzini.domain
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException do pacote br.com.pazzini.exception
import org.junit.Assert; // Importa a classe Assert do JUnit

public class ClienteDAOTest { // Declaração da classe ClienteDAOTest

    private IClienteDAO dao; // Declaração de um objeto IClienteDAO
    private Cliente c; // Declaração de um objeto Cliente

    public ClienteDAOTest() { // Construtor da classe
        this.dao = new ClienteDAO(); // Inicialização de um objeto ClienteDAO na variável dao
    }

    @Before // Indica que o método deve ser executado antes de cada teste
    public void init() throws TipoChaveNaoEncontradaException { // Declaração do método init que lança a exceção TipoChaveNaoEncontradaException
        this.c = new Cliente(); // Inicialização de um novo objeto Cliente na variável c
        c.setCpf(12345678901L); // Configuração do atributo cpf do objeto c
        c.setNomeCliente("Rafael"); // Configuração do atributo nomeCliente do objeto c
        c.setCidade("São Paulo"); // Configuração do atributo cidade do objeto c
        c.setEnd("End"); // Configuração do atributo end do objeto c
        c.setEstado("SP"); // Configuração do atributo estado do objeto c
        c.setNumero(63); // Configuração do atributo numero do objeto c
        c.setTel(11953616215L); // Configuração do atributo tel do objeto c
        dao.cadastrar(c); // Chama o método cadastrar do objeto dao passando o objeto c como argumento
    }

    @Test // Indica que o método é um teste
    public void pesquisarCliente() { // Declaração do método pesquisarCliente
        Cliente cConsultado = dao.consultar(c.getCpf()); // Chama o método consultar do objeto dao passando o cpf do objeto c como argumento e armazenando o resultado na variável cConsultado
        Assert.assertNotNull(cConsultado); // Verifica se cConsultado não é nulo usando o método assertNotNull da classe Assert
    }

    @Test // Indica que o método é um teste
    public void excluirCliente() { // Declaração do método excluirCliente
        dao.excluir(c.getCpf()); // Chama o método excluir do objeto dao passando o cpf do objeto c como argumento
    }

    @Test // Indica que o método é um teste
    public void alterarCliente() throws TipoChaveNaoEncontradaException { // Declaração do método alterarCliente que lança a exceção TipoChaveNaoEncontradaException
        c.setNomeCliente("Nome Alterado"); // Configuração do atributo nomeCliente do objeto c para "Nome Alterado"
        Cliente cAtualizado = null; // Inicialização de uma variável cAtualizado como nulo

        cAtualizado = dao.alterar(c); // Chama o método alterar do objeto dao passando o objeto c como argumento e armazena o resultado na variável cAtualizado

        Assert.assertEquals("Nome Alterado", cAtualizado.getNomeCliente()); // Verifica se o nome do cliente atualizado é "Nome Alterado" usando o método assertEquals da classe Assert
    }

    @Test // Indica que o método é um teste
    public void cadastrarCliente() throws TipoChaveNaoEncontradaException { // Declaração do método cadastrarCliente que lança a exceção TipoChaveNaoEncontradaException
        Cliente cNew = new Cliente(); // Inicialização de um novo objeto Cliente na variável cNew
        cNew.setCpf(2L); // Configuração do atributo cpf do objeto cNew
        dao.cadastrar(cNew); // Chama o método cadastrar do objeto dao passando o objeto cNew como argumento

        // Verifique se o cliente foi cadastrado com sucesso consultando-o
        Cliente clienteCadastrado = dao.consultar(cNew.getCpf()); // Chama o método consultar do objeto dao passando o cpf do objeto cNew como argumento e armazena o resultado na variável clienteCadastrado
        Assert.assertNotNull(clienteCadastrado); // Verifica se clienteCadastrado não é nulo usando o método assertNotNull da classe Assert
    }
}
