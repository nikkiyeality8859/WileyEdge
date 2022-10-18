package com.ebg.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerUtility {
//1.1
	public static boolean registerCustomer(Customer customer) throws Exception {
		Connection con = MyConnection.buildConnection();
		PreparedStatement prst = con.prepareStatement("insert into customer values(?,?,?,?)");

		prst.setInt(1, customer.getCustomerId());
		prst.setString(2, customer.getCustomerName());
		prst.setString(3, customer.getCustomerType());
		prst.setString(4, customer.getAreaCode());

		int ex = prst.executeUpdate();
		if (ex > 0)
			return true;
		else
			return false;
	}

	// 1.2
	public static boolean addConsumption(CustomerConsumption customerConsumption) throws Exception {
		Connection con = MyConnection.buildConnection();
		PreparedStatement prst = con.prepareStatement("insert into customer_Consumption values(?,?,?,?)");
		prst.setInt(1, customerConsumption.getCustomerId());
		prst.setString(2, customerConsumption.getMonth());
		prst.setDouble(3, customerConsumption.getUnits());
		prst.setDouble(4, customerConsumption.getTotalBill());

		int ex = prst.executeUpdate();
		if (ex > 0)
			return true;
		return false;

	}

	// 3.1
	public static List<Customer> listCustomers() throws Exception {
		List<Customer> arrCustomer = new ArrayList<Customer>();

		Connection con = MyConnection.buildConnection();
		Statement prst = con.createStatement();
		ResultSet executeQuery = prst.executeQuery("select * from customer");
		while (executeQuery.next()) {
			Customer c = new Customer();
			c.setCustomerId(executeQuery.getInt(1));
			c.setCustomerName(executeQuery.getString(2));
			c.setCustomerType(executeQuery.getString(3));
			c.setAreaCode(executeQuery.getString(4));
			arrCustomer.add(c);
		}

		return arrCustomer;
	}

	// 3.2
	public static void getCustomersOnMonth(String monthValue) throws Exception {
		Connection con = MyConnection.buildConnection();
		CallableStatement prst = con.prepareCall("{call getRecordsOnMonth(?)}");
		prst.setString(1, monthValue);
		ResultSet rs = prst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + " , " + rs.getString(2));
		}

	}

//	3.3
	public static void getParticularCustomer(int cId, String monthValue) throws Exception {
		Connection con = MyConnection.buildConnection();
		CallableStatement prst = con.prepareCall("{call particularCustomer(?,?,?) }");
		prst.setInt(1, cId);
		prst.setString(2, monthValue);

		int executeUpdate = prst.executeUpdate();
		System.out.println(prst.getString(3));
	}

	// 3.4
	public static void totalBill(String monthValue) throws Exception {
		Connection con = MyConnection.buildConnection();
		CallableStatement prst = con.prepareCall("{call getTotalBillforMonth(?,?) }");

		prst.setString(1, monthValue);

		prst.executeUpdate();
		System.out.println(prst.getString(2));
	}

	// 3.5
	public static void SortCustomerByBill(String monthValue) throws Exception {
		Connection con = MyConnection.buildConnection();
		CallableStatement prst = con.prepareCall("{call displayCustomerBydesc(?) }");

		prst.setString(1, monthValue);

		ResultSet rs = prst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + " , " + rs.getString(2));
		}

	}

	// 3.6
//	public static void modifyCustomerDetails(int cId) throws Exception {
//		
//		Connection con = MyConnection.buildConnection();
//		Statement prst = con.createStatement();
//
//		System.out.println("Enter 1 for name change");
//		System.out.println("Enter 2 for Area Code change");
//		System.out.println("Enter 3 for customer type change  ");
//		System.out.println("Enter 4 for delete customer  ");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		int input=Integer.parseInt(br.readLine());
//		switch (input) {
//		case 1: {
//			System.out.println("Enter the  new customer name");
//			
//			String cname = br.readLine();
//			prst.execute("update customer set customer_name='" + cname + "' where customer_id=" + cId);
//			System.out.println("Updated successfully");
//			break;
//
//		}
//		case 2: {
//			System.out.println("Enter the  new customer AreaCode");
//		
//			String areaCode =br.readLine();
//			prst.execute("update customer set areaCode='" + areaCode + "' where customer_id=" + cId);
//			System.out.println("Updated successfully");
//			break;
//		}
//		case 3: {
//			System.out.println("Enter the  new Customer type");
//		
//			String customerType =br.readLine();
//			prst.execute("update customer set customer_type='" + customerType + "' where customer_id=" + cId);
//			System.out.println("Updated successfully");
//			break;
//
//		}
//		case 4: {
//
//			prst.execute("delete from customer where customer_id=" + cId);
//			System.out.println("deleted successfully");
//			break;
//
//		}
//		default:
//			System.out.println("Invalid choice");
//
//		}
//		
//	}
public static void modifyCustomerDetails(int cId) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		Connection con = MyConnection.buildConnection();
		Statement prst = con.createStatement();

		System.out.println("Enter 1 for name change");
		System.out.println("Enter 2 for Area Code change");
		System.out.println("Enter 3 for customer type change  ");
		System.out.println("Enter 4 for delete customer  ");
		String input = br.readLine();
		switch (Integer.parseInt(input)) {
		case 1: {
			System.out.println("Enter the  new customer name");
			String cname = br.readLine();
			prst.execute("update customer set customer_name='" + cname + "' where customer_id=" + cId);
			System.out.println("Updated successfully");
			break;

		}
		case 2: {
			System.out.println("Enter the  new customer AreaCode");
			String areaCode =  br.readLine();
			prst.execute("update customer set areaCode='" + areaCode + "' where customer_id=" + cId);
			System.out.println("Updated successfully");
			break;
		}
		case 3: {
			System.out.println("Enter the  new Customer type");
			String customerType =  br.readLine();
			prst.execute("update customer set customer_type='" + customerType + "' where customer_id=" + cId);
			System.out.println("Updated successfully");
			break;

		}
		case 4: {

			prst.execute("delete from customer where customer_id=" + cId);
			System.out.println("deleted successfully");
			break;

		}
		default:
			System.out.println("Invalid choice");

		}
}
}
