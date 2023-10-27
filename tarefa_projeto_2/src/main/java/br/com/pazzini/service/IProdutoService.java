package br.com.pazzini.service; // Pacote que contém as classes relacionadas a serviços

import br.com.pazzini.domain.Produto; // Importa a classe Produto
import br.com.pazzini.service.generics.IGenericService; // Importa a interface genérica IGenericService

public interface IProdutoService extends IGenericService<Produto> { // Interface que estende a interface genérica IGenericService com o tipo de parâmetro Produto

}