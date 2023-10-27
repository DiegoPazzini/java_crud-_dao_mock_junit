package br.com.pazzini.dao.generics;

// Importações de pacotes e classes necessárias
import java.util.Collection;

import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exception.TipoChaveNaoEncontradaException;

// Interface IGenericDAO com tipo genérico T que estende Persistente
public interface IgenericDAO <T extends Persistente>{
	
	// Assinatura dos métodos da interface
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
	
	public void excluir(Long valor);
	
	public T alterar(T entity) throws TipoChaveNaoEncontradaException;
	
	public T consultar(Long valor);
	
	public Collection<T> buscarTodos();
}
