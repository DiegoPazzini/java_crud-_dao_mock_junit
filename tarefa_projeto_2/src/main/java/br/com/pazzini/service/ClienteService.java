package br.com.pazzini.service; // Declaração do pacote br.com.pazzini.service

import br.com.pazzini.dao.IClienteDAO; // Importação da interface IClienteDAO
import br.com.pazzini.dao.generics.IgenericDAO; // Importação da interface IGenericDAO
import br.com.pazzini.domain.Cliente; // Importação da classe Cliente
import br.com.pazzini.exception.TipoChaveNaoEncontradaException; // Importação da exceção TipoChaveNaoEncontradaException
import br.com.pazzini.service.generics.GenericService; // Importação da classe genérica GenericService

public class ClienteService extends GenericService<Cliente> implements IClienteService { // Declaração da classe ClienteService que estende a GenericService e implementa a interface IClienteService

    public ClienteService(IgenericDAO<Cliente> clienteDAO) { // Declaração do construtor ClienteService que aceita um parâmetro do tipo IGenericDAO de Cliente
        super(clienteDAO); // Chamada ao construtor da superclasse GenericService com o parâmetro clienteDAO
    }

}