package br.com.pazzini.domain;

//Importações de pacotes e classes necessárias
import br.com.pazzini.annotations.TipoChave;

//Classe Produto que estende a classe Persistente
public class Produto extends Persistente {
	
	// Declaração dos campos da classe Produto
	private Long id;
	private String name;
	private Boolean isDiscount;
	
	// Métodos getters e setters para acessar e modificar os campos
	public void setId(Long id) {
		this.id = id;
	}
	
	// Anotação do tipo de chave
	@TipoChave("getId")
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(Boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
}