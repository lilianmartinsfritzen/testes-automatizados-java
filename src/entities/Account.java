package entities;

public class Account {
	
	public static double DEPOSITE_FEE_PERCENTAGE = 0.02;  // A cada depósito o banco desconta 2% de taxa
	
	private Long id;
	private Double balance;
	
	public Account() {
	}

	public Account(Long id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}	
	
	public void deposit(double amount) {
		if (amount > 0) {
			amount -= amount * DEPOSITE_FEE_PERCENTAGE;
			balance += amount;
		}
	}
		
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException();
		}
		balance -= amount;
	}
	
	public double fullWithdraw() {
		double aux = balance;
		balance = 0.0;
		return aux;
	}
}
