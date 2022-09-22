package com.electricityBill;

import java.io.Serializable;

public class Customer implements Serializable {
	private int customerId;
	private String customerName;
	private String customerAreaCode;
	private long numberOfUnitConsumed;
	private double totalBill;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAreaCode() {
		return customerAreaCode;
	}
	public void setCustomerAreaCode(String customerAreaCode) {
		this.customerAreaCode = customerAreaCode;
	}
	public long getNumberOfUnitConsumed() {
		return numberOfUnitConsumed;
	}
	public void setNumberOfUnitConsumed(long numberOfUnitConsumed) {
		this.numberOfUnitConsumed = numberOfUnitConsumed;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public Customer(int customerId, String customerName, String customerAreaCode, long numberOfUnitConsumed
			) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAreaCode = customerAreaCode;
		this.numberOfUnitConsumed = numberOfUnitConsumed;
		this.totalBill = generatetotalBill();
	}
	//bill generator method
	private double generatetotalBill() {
		long units=this.getNumberOfUnitConsumed();
		if(units<=100) {
			this.totalBill=(units*0.50);
			return totalBill;
		}else if(units >100&&units<=150) {
			long unit100=units-100;
			this.totalBill= ((100*0.50)+(unit100*0.75));
			return totalBill;
		}
		//175=100+50+25
		//units-100-50=25
		//units-
		else {
//			long unitafter150=units-100-50;
//			long unit50=50;
//			
			this.totalBill=((units-150*1)+(100*0.50)+(50*0.75));
			return this.totalBill;
		}
	
	}
	@Override
	public String toString() {
		return "Customer Details: customerId=" + customerId + ", customerName=" + customerName + ", customerAreaCode="
				+ customerAreaCode + ", numberOfUnitConsumed=" + numberOfUnitConsumed + ", totalBill=" +"Rs"+ totalBill
				;
	}

	
}
