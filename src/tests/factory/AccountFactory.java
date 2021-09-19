package tests.factory;

import entities.Account;

// A fábrica pode ter mais de uma forma de instanciar objetos, como criar apenas um método para passar o valor do zero
public class AccountFactory {
	
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}
