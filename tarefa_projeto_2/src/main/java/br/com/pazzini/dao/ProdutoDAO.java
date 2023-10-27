package br.com.pazzini.dao; // Declaração do pacote

import java.util.HashMap; // Importação da classe HashMap do pacote java.util
import java.util.Map; // Importação da interface Map do pacote java.util

import br.com.pazzini.dao.generics.GenericDAO; // Importação da classe GenericDAO do pacote br.com.pazzini.dao.generics
import br.com.pazzini.domain.Produto; // Importação da classe Produto do pacote br.com.pazzini.domain
import br.com.pazzini.singletons.SingletonMap; // Importação da classe SingletonMap do pacote br.com.pazzini.singletons

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO { // Declaração da classe ProdutoDAO que estende GenericDAO e implementa IProdutoDAO
	
	public ProdutoDAO() { // Declaração do construtor da classe ProdutoDAO
		super(); // Chamada do construtor da classe pai

		// Inicialização do mapa interno com a instância do SingletonMap
		Map<Long, ?> mapaInterno = SingletonMap.getInstance().getMap().get(getTipoClasse());
		
		if(mapaInterno == null) { // Verificação se o mapa interno é nulo
			mapaInterno = new HashMap<>(); // Inicialização de um novo HashMap
			SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno); // Adição do mapa interno ao SingletonMap
		}
	}

	@Override // Indicação de sobrescrita do método
	public Class<Produto> getTipoClasse() { // Declaração do método getTipoClasse
		return Produto.class; // Retorna a classe Produto
	}

	@Override // Indicação de sobrescrita do método
	public void atualizarDados(Produto entity, Produto entityCadastrada) { // Declaração do método atualizarDados com os parâmetros entity e entityCadastrada do tipo Produto
		entityCadastrada.setId(entity.getId()); // Configuração do id de entityCadastrada com o id de entity
		entityCadastrada.setName(entity.getName()); // Configuração do nome de entityCadastrada com o nome de entity
		entityCadastrada.setIsDiscount(entity.getIsDiscount()); // Configuração do isDiscount de entityCadastrada com o isDiscount de entity
	}
}