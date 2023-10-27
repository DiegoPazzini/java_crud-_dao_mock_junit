// Importação das classes e pacotes necessários
package br.com.pazzini.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.pazzini.dao.generics.GenericDAO;
import br.com.pazzini.domain.Cliente;
import br.com.pazzini.singletons.SingletonMap;

// Declaração da classe ClienteDAO que estende GenericDAO e implementa IClienteDAO
public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
	
	// Construtor da classe ClienteDAO
	@SuppressWarnings("unchecked")
	public ClienteDAO() {
		super();
		// Criação de um mapa interno no construtor, caso ele não exista no SingletonMap
		Map<Long, Cliente> mapaInterno = (Map<Long, Cliente>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		if (mapaInterno == null) {
			mapaInterno = new HashMap<>();
			SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
		}
	}

	// Implementação do método getTipoClasse da interface IClienteDAO
	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	// Implementação do método atualizarDados da interface IClienteDAO
	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrada) {
		// Atualiza os dados da entidade cadastrada com os dados da entidade passada como parâmetro
		entityCadastrada.setCpf(entity.getCpf());
		entityCadastrada.setCidade(entity.getCidade());
		entityCadastrada.setEnd(entity.getEnd());
		entityCadastrada.setEstado(entity.getEstado());
		entityCadastrada.setNomeCliente(entity.getNomeCliente());
		entityCadastrada.setNumero(entity.getNumero());
		entityCadastrada.setTel(entity.getTel());
	}

}