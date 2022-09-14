package Day5Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class grossSalaryComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {

		return Double.compare(o1.calculateGrossSalary(), o2.calculateGrossSalary());
	}

}

public class Employee {
	private int empId;
	private String empName, empDept;
	private double empBasicSalary, empGrossSalary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String empDept, double empBasicSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empBasicSalary = empBasicSalary;
		this.empGrossSalary = calculateGrossSalary();
	}

	public double calculateGrossSalary() {
		double HRA = (0.12) * (this.empBasicSalary);
		double DA = (0.08) * (this.empBasicSalary);
		this.empGrossSalary = this.empBasicSalary + HRA + DA;
		return empGrossSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + ", empBasicSalary="
				+ empBasicSalary + ", empGrossSalary=" + empGrossSalary + "]";
	}

	public static Employee[] sortEmployee(Employee[] arr) {
		Arrays.sort(arr, new grossSalaryComparator());
		return arr;

	}

//method for diplaying employee in specific dept
	public static void searchEmployee(Employee eArray[], String searchDept) {
		ArrayList<Employee> a = new ArrayList<Employee>();
		for (int i = 0; i < eArray.length; i++) {
			if (eArray[i].empDept.equalsIgnoreCase(searchDept)) {
				a.add(eArray[i]);
			}

		}
		for (Employee e : a) {
			System.out.println(e);
		}
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		if (this.empId == e.empId && (this.empName).equalsIgnoreCase(e.empName))
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating the employee array
		Employee[] empArr = new Employee[5];

		empArr[0] = new Employee(1, "Nikki", "CSE", 4000);
		empArr[1] = new Employee(2, "Shubh", "CSE", 10000);
		empArr[2] = new Employee(3, "Bhoomi", "C", 6000);
		empArr[3] = new Employee(4, "Johny", "EE", 2000);
		empArr[4] = new Employee(5, "Daniel", "CSE", 1000);
		
      //for sorting arr of obj in ascending order
		Employee[] sortedArr = sortEmployee(empArr);
		for (Employee e : sortedArr) {
			System.out.println(e);
		}

		// for searching specific dept
		String department="c";
		searchEmployee(empArr,department);
		
		//for checking whether two emp are equal or not
		Employee e1=new Employee(22,"yamuna","ME",7000);
		Employee e2=new Employee(23,"Yashi","ME",9000);
		System.out.println(e1.equals(e2));
	}

}
