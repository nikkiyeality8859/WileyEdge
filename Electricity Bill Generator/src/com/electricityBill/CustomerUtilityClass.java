package com.electricityBill;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.*;

public class CustomerUtilityClass {

	public static void mapCustomerByAreaCode(List<Customer> customerList, Map<String, List<Customer>> map) {
		for (Customer c : customerList) {
			String key = c.getCustomerAreaCode();
			map.putIfAbsent(key, new ArrayList<Customer>());
			map.get(key).add(c);
		}
		System.out.println(map);
	}

	private static void displayAllCustomersDetails(ArrayList<Customer> customerList, Consumer<Customer> c) {
		customerList.forEach(customer -> c.accept(customer));

	}

	private static void displayAllCustomersWithCErtainAreaCode(ArrayList<Customer> customerList, String areaCodeSearch,
			Predicate<Customer> p) {
		for (Customer cus : customerList) {
			if (p.test(cus)) {
				System.out.println(cus);
			}

		}

	}

	private static void displayAllCustomerSortedByBills(ArrayList<Customer> customerList) {
		Collections.sort(customerList, (c1, c2) -> ((Double) c2.getTotalBill()).compareTo(c1.getTotalBill()));

		for (Customer c : customerList) {
			System.out.println(c);
		}
	}

	public static void serializeAllCustomers(List<Customer> customerList) {

		try (FileOutputStream fos = new FileOutputStream("customers.dat");) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customerList);
			System.out.println("Objects serialized!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deserializeAllCustomers() {

		try (FileInputStream fis = new FileInputStream("customers.dat");) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Customer> customerList = (List<Customer>) ois.readObject();
			System.out.println("List of customers obtained after deserialization:");

			System.out.println("----------All Customer Details are---------");
			CustomerUtilityClass.displayAll(customerList);

			// CustomerUtility.displayAllCustomers(customerList);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void displayAll(List<Customer> customers) {
		for (Customer c : customers) {
			System.out.println(c);
		}
	}

	public static void main(String args[]) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Scanner sc = new Scanner(System.in);

		System.out.println("-----Welcome to the electricity generator application-----");
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("If you want to add the customer onto the list Please Enter '1':");
			System.out.println("If you want to display  the list of customer with details  Please Enter '2:");
			System.out.println(
					"If you want to display  the list of customer sorted in terms of maximum Bill  Please Enter '3:");
			System.out.println(
					"If you want to display  the list of customer with your specified Area code  Please Enter '4:");
			System.out.println("If you want to Serialize the list of customer '5:");
			System.out.println("If you want to Deserialize the list of customer '6:");
			System.out.println("If you want to map representation  of the list of customer '7:");
			System.out.println("If you want to exit '8:");

			System.out.println();
			int no = sc.nextInt();
			switch (no) {
			case 1: {
				System.out.println("Enter the number of Customer you want to add");

				int noOfCustomer = sc.nextInt();
				for (int i = 0; i < noOfCustomer; i++) {
					System.out.println("Enter the Customer Details for Customer: " + (i + 1));
					System.out.println("Enter the cutomer id:");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the customer Name:");
					String name = sc.nextLine();

					System.out.println("Enter the customerAreaCode:");
					String code = sc.nextLine();

					System.out.println("Enter the units consumed by customer");
					long units = sc.nextLong();

					customerList.add(new Customer(id, name, code, units));
					// displayAllCustomersDetails(customerList, );

				}

			}
			case 2: {
				System.out.println("----------All Customer Details are---------");
				displayAllCustomersDetails(customerList, (customer) -> System.out.println(customer));
				break;
			}
			case 3: {
				System.out.println("----------All Customer Details sorted by bills are---------");
				displayAllCustomerSortedByBills(customerList);
				break;
			}
			case 4: {
				System.out.println("----------------");
				sc.nextLine();
				System.out.println("enter the area code which you want to search");
				String areaCodeSearch = sc.nextLine();
				displayAllCustomersWithCErtainAreaCode(customerList, areaCodeSearch,
						(customer) -> ((Customer) customer).getCustomerAreaCode().equals(areaCodeSearch));
				break;
			}
			case 5: {
				serializeAllCustomers(customerList);
				break;

			}
			case 6: {
				deserializeAllCustomers();
				break;
			}
			case 7: {
				Map<String, List<Customer>> map = new HashMap<String, List<Customer>>();
				mapCustomerByAreaCode(customerList, map);
				break;
			}

			case 8: {
				System.out.println("Thankyou for visiting");
				flag = false;
				break;
			}
			default: {
				System.out.println("Entered valid choice");

			}

			}

		}
		System.out.println("Thankyou for visiting");
		sc.close();

	}

}
