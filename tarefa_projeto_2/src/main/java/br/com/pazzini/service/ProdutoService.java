package br.com.pazzini.service; // Pacote que contém as classes relacionadas a serviços

import br.com.pazzini.dao.generics.IgenericDAO; // Importa a interface genérica IGenericDAO
import br.com.pazzini.domain.Produto; // Importa a classe Produto
import br.com.pazzini.service.generics.GenericService; // Importa a classe genérica de serviço GenericService

public class ProdutoService extends GenericService<Produto> implements IProdutoService { // Classe que estende a classe de serviço genérica GenericService com o tipo de parâmetro Produto e implementa a interface IProdutoService

	public ProdutoService(IgenericDAO<Produto> clienteDAO) { // Construtor da classe ProdutoService que recebe um IGenericDAO de Produto como parâmetro
		super(clienteDAO); // Chama o construtor da classe pai GenericService com o parâmetro clienteDAO
	}

}