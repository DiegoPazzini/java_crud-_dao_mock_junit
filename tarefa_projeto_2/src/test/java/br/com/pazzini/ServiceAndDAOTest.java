package br.com.pazzini;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)  // Indica que esta classe é uma suíte de teste que pode ser executada pelo JUnit.
@SuiteClasses({ProdutoAllTests.class, ClienteAllTests.class})  // Especifica as classes de teste a serem incluídas nesta suíte.
public class ServiceAndDAOTest {
	// Esta classe representa uma suíte de teste que executa casos de teste para as classes de teste ProdutoAllTests e ClienteAllTests.
	// Aqui, as duas suítes de teste são executadas em conjunto para testar as funcionalidades relacionadas a produtos e clientes.
}