package Day6Assignment;

import java.util.Scanner;

/*
 *
7. Create the BankAccount with the following details: 
Attributes: accountId, accountHolderName, AccountType
 AccountType be enum contains the types SAVINGS and CURRENT. The enum 
Should also provide the default interest rate for SAVINGS and CURRENT 
account. That should be returned from one of the methods from the enum 
Behaviour: BankAccount should have the method, calculateTotalInterest as shown below:
calculateTotalInterest(double amount, int years)
The main class should create object of BankAccount and provide the accounttype. It should 
later invoke the calculateTotalInterest() by providing arguments. Print the total interest on 
investments.
8. Modify the above BankAccount class by connecting it with DepositAmountException. This 
exception should be generated if the amount passed in the calculateTotalInterest is not 
positive. 
 */
public class BankAccount {
	public int accountId;
	public String accountHolderName;
	public AccountType accType;
	public BankAccount(int accountId, String accountHolderName, AccountType accType) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accType = accType;
		
	}
	public double calculateTotalInterest(double amount,int years) {
		double interestRate=this.accType.getInterest();
		return ((amount*interestRate*years)/100);
	}
	
	
	public static void main(String[]args) {
		BankAccount bk=new BankAccount(1, "Nikita", AccountType.Saving);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount");
		try {
		double amount=sc.nextDouble();
		double totalInterest=bk.calculateTotalInterest(amount, 2);
		
		if(amount<0) {
			throw new DepositAmountException();
		}
		System.out.println("Total interest of user "+bk.accountHolderName+" is:"+totalInterest);
		}catch(DepositAmountException e) {
			e.printStackTrace();
		}
		}
		

}
