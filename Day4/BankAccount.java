package Day4Assignment;



public class BankAccount {
	private int accountId;
	private String accountHolderName,accType;
	private   double openingBalance; 
	private double currentBalance;
	static double totalBalance=10000;
	
	accountType acc1=accountType.CURRENT;
	accountType acc2=accountType.SAVINGS;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int accountId, String accountHolderName, double openingBalance,String accType) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.openingBalance=openingBalance;
		
		//code for the first question
//		if(openingBalance<500) {
//			
//			System.out.println("Account of  "+accountHolderName+" can't be created due to insufficient openening amount");
//			
//		}else {
//			this.openingBalance=openingBalance;
//			this.currentBalance=openingBalance;
//			System.out.println("Account of  "+accountHolderName+" is created successfully");
//			
//				}
//		accountType acc1=accountType.CURRENT;
//		accountType acc2=accountType.SAVINGS;
		if(((acc1.equals(accType))&&(openingBalance>=acc1.getminBalance()))||((acc2.equals(accType))&&(openingBalance>=acc2.getminBalance()))) {
			this.currentBalance=openingBalance;
			this.accType=accType;
			System.out.println("Account of  "+accountHolderName+" is created successfully");
			display();
			
		}else {
			System.out.println("Account of  "+accountHolderName+" can't be created due to insufficient opening balance .opening balanace for savings account should be atleast 500 and for current account it should be atleast 1000 rupees only");
			
		}
		
	}

	public  void withdraAmount(double amount) {
		if(((this.accType).equalsIgnoreCase("SAVINGS"))&&(this.currentBalance-amount>=acc2.getminBalance()))
        { 
			this.currentBalance-=amount;
			totalBalance-=amount;
			System.out.println(amount+" is withdraw from your savings account");
			display();
		
			System.out.println("Total amount present in the bank is "+totalBalance);
		}else if(((this.accType).equalsIgnoreCase("CURRENT"))&&(this.currentBalance-amount>=acc1.getminBalance())) {
			this.currentBalance-=amount;
			totalBalance-=amount;
			System.out.println(amount+" is withdraw from your current account");
			display();
			System.out.println("Total amount present in the bank is "+totalBalance);
		
			
		}else {
			System.out.println(amount+" can't be withdraw from your account due to insuffient balance");
		}
		

	}

	public  void depositeAmount(double amount) {
		this.currentBalance+=amount;
		totalBalance+=amount;
		System.out.println(amount+" is credited to tour account successfully");
		display();
		System.out.println("Total amount present in the bank is "+totalBalance);
		

	}

	public  void display() {
		//BankAccount b=new BankAccount();
		
    System.out.println("BankAccount Details[accountId=" + this.accountId + ", accountHolderName=" +this.accountHolderName 
				+ ", currentBalance=" + this.currentBalance + " Account type= "+this.accType+"]");
	}
	

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//code for the 1 question
//		BankAccount customer1=new BankAccount(1,"Nikita",100);
//		if(customer1.openingBalance<=500) {
//			customer1=null;
//			System.out.println("User doesn't exists Kindly create your Account with the minimum opening amount=500");
//		}
//		if(customer1!=null) {
//			customer1.depositeAmount(2000);
//			System.out.println("hello");
//			//one.withdraAmount(500);
//			
//		}
		//user1
		BankAccount user1=new BankAccount(1,"Kalpit",2000,"SAVINGS");
		
        if((user1.accType.equalsIgnoreCase("SAVINGS")&&user1.openingBalance<500)||(user1.accType.equalsIgnoreCase("CURRENT")&&user1.openingBalance<1000)) {
        	user1=null;
        }else {
        
		user1.withdraAmount(500);
		user1.depositeAmount(2000);
		System.out.println();
        }
		//user2
		BankAccount user2=new BankAccount(2,"Nikita",22,"SAVINGS");
		if((user2.accType.equalsIgnoreCase("SAVINGS")&&user2.openingBalance<500)||(user2.accType.equalsIgnoreCase("CURRENT")&&user2.openingBalance<1000)) {
        	user2=null;
        }
		else {
		user2.withdraAmount(522);
		user2.depositeAmount(200);
		System.out.println();
		}
		
		//user3
		BankAccount user3=new BankAccount(3,"shubh",1000,"CURRENT");
		if((user3.accType.equalsIgnoreCase("SAVINGS")&&user3.openingBalance<500)||(user3.accType.equalsIgnoreCase("CURRENT")&&user3.openingBalance<1000)) {
        	user3=null;
        }else {
		user3.withdraAmount(5);
		user3.depositeAmount(2000);
        }
	}

}
