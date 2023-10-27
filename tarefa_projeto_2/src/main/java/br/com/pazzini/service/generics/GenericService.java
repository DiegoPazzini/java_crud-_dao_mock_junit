package br.com.pazzini.service.generics; // Pacote que contém as classes de serviços genéricos

import br.com.pazzini.dao.generics.IgenericDAO; // Importa a interface IGenericDAO do pacote de DAO genérico
import br.com.pazzini.domain.Persistente; // Importa a classe Persistente do pacote de domínio
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException

public abstract class GenericService<T extends Persistente> implements IGenericService<T> { // Classe abstrata de serviço genérico que estende a interface IGenericService com o tipo de parâmetro T, que é uma subclasse de Persistente

    private IgenericDAO<T> dao; // Variável privada do tipo IGenericDAO de tipo de parâmetro T

    public GenericService(IgenericDAO<T> clienteDAO) { // Construtor da classe GenericService que recebe um parâmetro do tipo IGenericDAO de tipo de parâmetro T como argumento
        this.dao = clienteDAO; // Atribui o argumento clienteDAO à variável dao
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException { // Método de implementação para cadastrar uma entidade
        return this.dao.cadastrar(entity); // Chama o método cadastrar da classe DAO correspondente e retorna seu resultado
    }

    @Override
    public T consultar(Long chave) { // Método de implementação para consultar uma entidade com base em uma chave
        return this.dao.consultar(chave); // Chama o método consultar da classe DAO correspondente e retorna seu resultado
    }

    @Override
    public void excluir(Long chave) { // Método de implementação para excluir uma entidade com base em uma chave
        this.dao.excluir(chave); // Chama o método excluir da classe DAO correspondente
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException { // Método de implementação para alterar uma entidade
        return this.dao.alterar(entity); // Chama o método alterar da classe DAO correspondente e retorna seu resultado
    }
}