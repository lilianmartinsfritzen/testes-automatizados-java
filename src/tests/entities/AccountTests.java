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
	
	@Test 		// Não utilizamos o When, porque só existe um cenário neste caso, é só a chamada simples do método, não possui argumentos.
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
}