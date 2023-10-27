package br.com.pazzini.service.generics; // Pacote que contém as classes de serviços genéricos

import br.com.pazzini.domain.Cliente; // Importa a classe Cliente do pacote de domínio
import br.com.pazzini.domain.Persistente; // Importa a classe Persistente do pacote de domínio
import br.com.pazzini.domain.Produto; // Importa a classe Produto do pacote de domínio
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importa a exceção TipoChaveNaoEncontradaException

public interface IGenericService<T extends Persistente> { // Interface genérica de serviço com tipo de parâmetro T que é uma subclasse de Persistente

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException; // Método para cadastrar uma entidade que pode lançar uma exceção TipoChaveNaoEncontradaException

    T consultar(Long chave); // Método para consultar uma entidade com base em uma chave

    void excluir(Long chave); // Método para excluir uma entidade com base em uma chave

    T alterar(T entity) throws TipoChaveNaoEncontradaException; // Método para alterar uma entidade que pode lançar uma exceção TipoChaveNaoEncontradaException

}