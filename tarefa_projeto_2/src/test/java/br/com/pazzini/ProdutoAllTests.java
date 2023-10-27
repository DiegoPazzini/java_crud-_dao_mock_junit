package br.com.pazzini; // Declaração do pacote

import org.junit.runner.RunWith; // Importa a anotação RunWith do JUnit
import org.junit.runners.Suite; // Importa a classe Suite do JUnit
import org.junit.runners.Suite.SuiteClasses; // Importa a anotação SuiteClasses do JUnit

@RunWith(Suite.class) // Indica que a classe é uma suíte de testes e utiliza a classe Suite do JUnit para executar os testes
@SuiteClasses({ProdutoDAOTest.class, ProdutoServiceTest.class}) // Indica as classes de teste que compõem esta suíte, neste caso ProdutoDAOTest e ProdutoServiceTest
public class ProdutoAllTests { // Declaração da classe ProdutoAllTests

}