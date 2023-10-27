package br.com.pazzini; // Declaração do pacote

import org.junit.runner.RunWith; // Importa a anotação RunWith do JUnit
import org.junit.runners.Suite; // Importa a anotação Suite do JUnit
import org.junit.runners.Suite.SuiteClasses; // Importa a anotação SuiteClasses do JUnit

@RunWith(Suite.class) // Anotação indicando que a classe é uma suíte de testes JUnit
@SuiteClasses({ClienteDAOTest.class, ClienteServiceTest.class}) // Declara as classes de teste que serão incluídas na suíte
public class ClienteAllTests { // Declaração da classe ClienteAllTests que representa a suíte de testes

}