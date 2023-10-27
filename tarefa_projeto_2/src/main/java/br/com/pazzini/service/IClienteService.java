package br.com.pazzini.service; // Declaração do pacote br.com.pazzini.service

import br.com.pazzini.domain.Cliente; // Importação da classe Cliente
import br.com.pazzini.service.generics.IGenericService; // Importação da interface IGenericService

public interface IClienteService extends IGenericService<Cliente> { // Declaração da interface IClienteService que estende a IGenericService com o parâmetro de tipo Cliente

	
}