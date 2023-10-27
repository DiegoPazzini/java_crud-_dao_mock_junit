package br.com.pazzini; // Declaração do pacote

import org.junit.jupiter.api.BeforeEach; // Importa a anotação BeforeEach do JUnit
import org.junit.jupiter.api.Test; // Importa a anotação Test do JUnit

import br.com.pazzini.dao.IProdutoDAO; // Importa a interface IProdutoDAO
import br.com.pazzini.dao.ProdutoDAO; // Importa a classe ProdutoDAO
import br.com.pazzini.domain.Produto; // Importa a classe Produto
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException

import org.junit.jupiter.api.Assertions; // Importa a classe Assertions do JUnit

public class ProdutoDAOTest { // Declaração da classe ProdutoDAOTest

    private IProdutoDAO dao; // Declaração da instância da interface IProdutoDAO
    private Produto p; // Declaração da instância da classe Produto

    public ProdutoDAOTest() { // Construtor da classe ProdutoDAOTest
        this.dao = new ProdutoDAO(); // Inicialização da instância de ProdutoDAO
    }

    @BeforeEach // Indica que o método deve ser executado antes de cada teste
    public void init() throws TipoChaveNaoEncontradaException { // Declaração do método init com a possibilidade de lançar TipoChaveNaoEncontradaException
        this.p = new Produto(); // Inicialização da instância de Produto
        p.setId(1L); // Definição do id do produto
        p.setName("Cadeira"); // Definição do nome do produto
        p.setIsDiscount(true); // Definição do desconto do produto
        dao.cadastrar(p); // Chamada do método cadastrar da interface IProdutoDAO
    }

    @Test // Indica que o método é um teste
    public void pesquisarProduto() { // Declaração do método pesquisarProduto
        Produto pConsultado = dao.consultar(p.getId()); // Consulta o produto pelo id
        Assertions.assertNotNull(pConsultado); // Verifica se o produto consultado não é nulo
    }

    @Test // Indica que o método é um teste
    public void excluirProduto() { // Declaração do método excluirProduto
        dao.excluir(p.getId()); // Exclui o produto pelo id
    }

    @Test // Indica que o método é um teste
    public void alterarProduto() throws TipoChaveNaoEncontradaException { // Declaração do método alterarProduto com a possibilidade de lançar TipoChaveNaoEncontradaException
        p.setName("Nome Alterado"); // Altera o nome do produto
        Produto pAtualizado = null; // Declaração de uma variável Produto

        pAtualizado = dao.alterar(p); // Chama o método alterar da interface IProdutoDAO
        Assertions.assertEquals("Nome Alterado", pAtualizado.getName()); // Verifica se o nome do produto foi alterado corretamente
    }

    @Test // Indica que o método é um teste
    public void cadastrarProduto() throws TipoChaveNaoEncontradaException { // Declaração do método cadastrarProduto com a possibilidade de lançar TipoChaveNaoEncontradaException
        Produto pNew = new Produto(); // Cria um novo produto
        pNew.setId(2L); // Define o id do novo produto
        Boolean res = dao.cadastrar(pNew); // Chama o método cadastrar da interface IProdutoDAO e armazena o resultado em uma variável
        Assertions.assertTrue(res); // Verifica se o resultado do cadastro é verdadeiro
    }
}