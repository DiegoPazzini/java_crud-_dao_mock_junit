// Importação das classes e pacotes necessários
package br.com.pazzini.dao;

import br.com.pazzini.dao.generics.IgenericDAO;
import br.com.pazzini.domain.Produto;

// Interface IProdutoDAO que estende IGenericDAO com a entidade Produto
public interface IProdutoDAO extends IgenericDAO<Produto> {

}