package br.com.pazzini.domain;

//Importações de pacotes e classes necessárias
import br.com.pazzini.annotations.TipoChave;

//Classe Cliente que estende a classe Persistente
public class Cliente extends Persistente {

	// Declaração dos campos da classe Cliente
	private String nomeCliente;
	private long cpf;
	private String cidade;
	private String end;
	private String estado;
	private int numero;
	private long tel;

	// Métodos getters e setters para acessar e modificar os campos
	public String getCidade() {
		return cidade;
	}

	public String getEnd() {
		return end;
	}

	public String getEstado() {
		return estado;
	}

	public int getNumero() {
		return numero;
	}

	public long getTel() {
		return tel;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	// Anotação do tipo de chave
	@TipoChave("getCpf")
	public long getCpf() {
		return this.cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNumero(int num) {
		this.numero = num;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

}