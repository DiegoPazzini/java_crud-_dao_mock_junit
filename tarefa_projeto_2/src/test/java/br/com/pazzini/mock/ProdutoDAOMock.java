package br.com.pazzini.mock; // Pacote que contém a classe ProdutoDAOMock

import java.util.Collection; // Importa a interface Collection do Java

import br.com.pazzini.dao.IProdutoDAO; // Importa a interface IProdutoDAO
import br.com.pazzini.domain.Produto; // Importa a classe Produto
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException

public class ProdutoDAOMock implements IProdutoDAO { // Classe que implementa a interface IProdutoDAO

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        return true; // Retorna true simulando o cadastro bem-sucedido
    }

    @Override
    public void excluir(Long valor) {
        // TODO Auto-generated method stub
    }

    @Override
    public Produto alterar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        return entity; // Retorna o objeto Produto fornecido para simular a atualização
    }

    @Override
    public Produto consultar(Long valor) {
        Produto p = new Produto(); // Cria uma nova instância de Produto
        p.setId(valor); // Define o valor do ID para o valor fornecido
        return p; // Retorna o objeto Produto criado
    }

    @Override
    public Collection<Produto> buscarTodos() {
        // TODO Auto-generated method stub
        return null; // Retorna nulo para simular que não há objetos Produto
    }

}
