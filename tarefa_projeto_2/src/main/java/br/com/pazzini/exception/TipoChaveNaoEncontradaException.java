// Declaração do pacote para a exceção
package br.com.pazzini.exception;

// Definição da classe TipoChaveNaoEncontradaException, que estende a classe Exception
public class TipoChaveNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L; // Declaração do campo serialVersionUID

    // Construtor da exceção com mensagem
    public TipoChaveNaoEncontradaException(String message) {
        this(message, null); // Chama o construtor da classe Exception com a mensagem fornecida e nenhuma causa associada
    }
	
    // Construtor da exceção com mensagem e uma causa
    public TipoChaveNaoEncontradaException(String message, Throwable e) {
        super(message, e); // Chama o construtor da classe Exception com a mensagem e a causa fornecidas
    }
}