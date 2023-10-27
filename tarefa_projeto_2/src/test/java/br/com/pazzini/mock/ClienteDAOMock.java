package br.com.pazzini.mock; // Pacote que contém a classe ClienteDAOMock

import java.util.Collection; // Importa a interface Collection do Java

import br.com.pazzini.dao.IClienteDAO; // Importa a interface IClienteDAO
import br.com.pazzini.domain.Cliente; // Importa a classe Cliente
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException

public class ClienteDAOMock implements IClienteDAO { // Classe que implementa a interface IClienteDAO

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        return true; // Retorna true simulando o cadastro bem-sucedido
    }

    @Override
    public void excluir(Long valor) {
        // TODO Auto-generated method stub
    }

    @Override
    public Cliente consultar(Long valor) {
        // TODO Auto-generated method stub
        Cliente c = new Cliente(); // Cria uma nova instância de Cliente
        c.setCpf(valor); // Define o valor do CPF para o valor fornecido
        return c; // Retorna o objeto Cliente criado
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        return null; // Retorna nulo para simular que não há objetos Cliente
    }

    @Override
    public Cliente alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return entity; // Retorna o objeto Cliente fornecido para simular a atualização
        // TODO Auto-generated method stub
    }

}