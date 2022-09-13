package Day4Assignment;

public enum accountType {
	SAVINGS(500), CURRENT(1000);

	private double minBal;

	private accountType(double minBal) {
		this.minBal = minBal;
	}

	public double getminBalance() {
		return this.minBal;
	}
}
