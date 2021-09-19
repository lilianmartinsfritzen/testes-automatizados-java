package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test		// <AÇÃO> should <EFEITO> [when <CENÁRIO>]
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		// PADRÃO AAA
		// Arrange: para instanciar os objetos necessários (o teste abaixo está com exemplo concreto)
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);
		
		// Act: execute as ações necessárias
		acc.deposit(amount);
		
		// Assert: declare o que deveria acontecer (resultado esperado)
		Assertions.assertEquals(expectedValue, acc.getBalance()); // É uma lib de declarações e possui vários métodos estáticos para fazermos as declarações
	}
}