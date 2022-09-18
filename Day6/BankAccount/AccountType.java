package Day6Assignment;

public enum AccountType {
 Saving(4),Current(6);
	private int interest;
	
	private AccountType(int interest) {
		this.interest=interest;
	}
	public int getInterest() {
		return this.interest;
	}
}
