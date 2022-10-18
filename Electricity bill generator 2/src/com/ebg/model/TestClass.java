package com.ebg.model;

import java.util.*;

public class TestClass {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("-----Welcome to the electricity generator application-----");
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("If you want to add the customer onto the list Please Enter '1':");
			System.out.println("If you want to add  the consumption of customer  Please Enter '2':");
			System.out.println("If you want to display  list of all the customer Please Enter '3': ");
			System.out.println("If you want to display bill for all customer for a particular month Please Enter '4':");
			System.out.println(
					"If you want to display bill for particular customer for a particular month Please Enter '5':");
			System.out.println("If you want to total bill for all customer for a particular month '6':");
			System.out.println("If you want to sort the customer list for a particular month in descending order '7':");
			System.out.println("If you want to modify the details '8':");
			System.out.println("If you want to exit '9':");

			System.out.println();
			
			int no = sc.nextInt();
			switch (no) {
			case 1: {

				System.out.println("Enter Customer details");
				sc.nextLine();
				System.out.println("Enter Customer id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Customer name");
				String name = sc.nextLine();
				System.out.println("Enter Customer type");
				String type = sc.nextLine();

				System.out.println("Enter Customer Areacode");
				String areaCode = sc.nextLine();
				Customer c = new Customer(id, name, type, areaCode);
				boolean resultant = CustomerUtility.registerCustomer(c);
				System.out.println("register successfully");
				break;

			}
			case 2: {
				System.out.println("Enter Customer Id");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the month");
				String month=sc.nextLine();
				System.out.println("Enter the number of units consumed");
				int unit=sc.nextInt();
				
				CustomerConsumption obj = new CustomerConsumption(id,month,unit);
				boolean isAdded=CustomerUtility.addConsumption(obj);
				if(isAdded) {
					System.out.println("Customer Consumption details added successfully");
				}
				else
					System.out.println("Failed to add details");
				
				break;			}
			case 3: {
				System.out.println("List of Customers");
				List<Customer> customers = CustomerUtility.listCustomers();
				for (Customer a : customers) {
					System.out.println(a);

				}

				break;
			}
			case 4: {
				sc.nextLine();
				System.out.println("Enter the month value ");
				String monthValue = sc.nextLine();
				System.out.println("List of customer for the particular month value");
				CustomerUtility.getCustomersOnMonth(monthValue);

				break;
			}
			case 5: {
				sc.nextLine();
				System.out.println("Enter the Customer id ");
				int id = sc.nextInt();
				if (true) {
					System.out.println("Enter the month ");
					String monthValue = sc.nextLine();
					CustomerUtility.getParticularCustomer(2, monthValue);
				} else
					System.out.println("Invalid customer id");
				break;

			}
			case 6: {
				sc.nextLine();
				System.out.println("Enter the month");
				String monthValue = sc.nextLine();
				System.out.println("Total bill :");
				CustomerUtility.totalBill(monthValue);
				break;
			}
			case 7: {
				sc.nextLine();
				System.out.println("Enter the month");
				String monthValue = sc.nextLine();
				System.out.println("Sorted customer details :");
				CustomerUtility.SortCustomerByBill(monthValue);
				break;
			}

			case 8: {
				System.out.println("Enter the customer id to modify that customer details");

				int id = sc.nextInt();
				CustomerUtility.modifyCustomerDetails(id);
				break;
			}
			case 9: {
				flag = false;
				break;
			}
			default: {
				System.out.println("Entered invalid choice");

			}

			}

		}
		System.out.println("Thankyou for visiting");
		sc.close();

	}

}
