package Day6Assignment;
/*
 *  
9. Create the Employee class, which should contain the attributes empId, empName. Along 
with that, it should also contain empAddresses, which is array of address. This should consist 
of temporary address and permanent address. 
Write a program to instantiate the employee object and display all the attributes of the 
same.
Attributes of address class: flatNumber, flatName, roadName, cityName.
 */
public class Employee {
	public int empId;
	public String empName;
	public Address[] empAddress;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//iterate and display array of address
public void displayAddress(Address[] empad) {
	for(int i=0;i<empad.length;i++) {
		if(i==0) {
			System.out.println("Temporary Address: "+empad[i]);
		}else {
			System.out.println("Permanent Address: "+empad[i]);
		}
	}
}
	public Employee(int empId, String empName, Address[] empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
//display all attribute of employee
public void display() {
	System.out.println("Employee id: "+this.empId);
	System.out.println("Employee Name: "+this.empName+"\n"+"Address");
	displayAddress(this.empAddress);
}

	public static void main(String[] args) {
		Address[]add=new Address[] {new Address(11,"Villa1","Moradabad-road","Merrut"),new Address(12,"Villa2","Nahtaur-road","Bijnor")};
		Employee e1=new Employee(1,"nik", add);
		e1.display();
	}

}
