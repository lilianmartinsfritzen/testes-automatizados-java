package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test		// <AÇÃO> should <EFEITO> [when <CENÁRIO>]
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		// PADRÃO AAA
		// Arrange: para instanciar os objetos necessários (o teste abaixo está com exemplo concreto)
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		// Act: execute as ações necessárias
		acc.deposit(amount);
		
		// Assert: declare o que deveria acontecer (resultado esperado)
		Assertions.assertEquals(expectedValue, acc.getBalance()); // É uma lib de declarações e possui vários métodos estáticos para fazermos as declarações
	}
	
	@Test		// Quando a quantia informada for negativa o depósito não fará nada
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
				// Testa o saque total, limpa e retorna o saldo
	@Test		// Não utilizamos o When, porque só existe um cenário neste caso, é só a chamada simples do método, não possui argumentos.
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	@Test		// Verifica a retirada com saldo suficiente e retorna o valor restante
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	@Test		// Quando o saque é maior que o saldo
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		// No JUnit 5 em assertions para tratamento de exceção temos que passar primeiro tipo da exceção com o .class para dizer que é um tipo
		// e em seguida criar uma função lâmbida contendo o procedimento executável
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
	}
}

