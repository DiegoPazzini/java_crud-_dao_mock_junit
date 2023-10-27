// Importação das classes e pacotes necessários
package br.com.pazzini.dao;

import br.com.pazzini.dao.generics.IgenericDAO;
import br.com.pazzini.domain.Cliente;

// Interface IClienteDAO que estende IGenericDAO com a entidade Cliente
public interface IClienteDAO extends IgenericDAO<Cliente> {

}