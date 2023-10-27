package br.com.pazzini.dao.generics;

//Importações de pacotes e classes necessárias
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import br.com.pazzini.annotations.TipoChave;
import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exception.TipoChaveNaoEncontradaException;
import br.com.pazzini.singletons.SingletonMap;

//Classe abstrata GenericDAO que implementa a interface IGenericDAO com o tipo genérico T
public abstract class GenericDAO<T extends Persistente> implements IgenericDAO<T> {

	// Atributo singletonMap
	private SingletonMap singletonMap;
	
	// Métodos abstratos a serem implementados nas classes derivadas
	public abstract Class<T> getTipoClasse();
	public abstract void atualizarDados(T entity, T entityCadastrada);
	
	// Construtor da classe GenericDAO
	public GenericDAO() {
		this.singletonMap = SingletonMap.getInstance();
	}
	
	// Método para obter a chave
	public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
		Method[] methods = entity.getClass().getDeclaredMethods();
		Long returnVal = null;
		
		for(Method m : methods) {
			if(m.isAnnotationPresent(TipoChave.class)) {
				TipoChave tipoChave = m.getAnnotation(TipoChave.class);
				String nomeMetodo = tipoChave.value();
				try {
					Method method = entity.getClass().getMethod(nomeMetodo);
					returnVal = (Long) method.invoke(entity);
					return returnVal;
				} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada!", e);
				}
			}
		}
		if(returnVal == null) {
			String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada!";
			throw new TipoChaveNaoEncontradaException(msg);
		}
		return null;
	}
	
	// Implementação do método cadastrar da interface IGenericDAO
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		
		if(mapaInterno.containsKey(chave)) {
			return false;
		}
		
		mapaInterno.put(chave, entity);
		return true;
	}

	// Implementação do método excluir da interface IGenericDAO
	@Override
	public void excluir(Long valor) {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		T objetoCadastrado = mapaInterno.get(valor);
		if(objetoCadastrado != null) {
			mapaInterno.remove(valor, objetoCadastrado);
		}
	}

	// Implementação do método alterar da interface IGenericDAO
	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		T objetoCadastrado = mapaInterno.get(chave);
		if(objetoCadastrado != null) {
			atualizarDados(entity, objetoCadastrado);
		}
		return mapaInterno.get(chave);
	}

	// Implementação do método consultar da interface IGenericDAO
	@Override
	public T consultar(Long valor) {
		Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.get(valor);
	}

	// Implementação do método buscarTodos da interface IGenericDAO
	@Override
	public Collection<T> buscarTodos() {
		Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.values();
	}

}



