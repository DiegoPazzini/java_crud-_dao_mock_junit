// Declaração do pacote onde a anotação está localizada
package br.com.pazzini.annotations;

// Importação das classes necessárias para a definição da anotação
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Definição da retenção da anotação durante a execução em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
// Definição do tipo de elemento que a anotação pode ser aplicada
@Target(ElementType.METHOD)
// Definição da própria anotação, com nome "TipoChave"
public @interface TipoChave {

    // Declaração do atributo "value" que pode ser usado ao aplicar a anotação
    String value();

}