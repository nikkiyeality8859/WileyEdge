package com.ebg.model;

public class CustomerConsumption {
private int customerId;
private String month;
private int units;
private double totalBill;
public CustomerConsumption() {
	super();
	// TODO Auto-generated constructor stub
}
public CustomerConsumption(int customerId, String month, int units) {
	super();
	this.customerId = customerId;
	this.month = month;
	this.units = units;
	this.totalBill = this.generatetotalBill();
}
@Override
public String toString() {
	return "CustomerConsumption [customerId=" + customerId + ", month=" + month + ", units=" + units + ", totalBill="
			+ totalBill + "]";
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public int getUnits() {
	return units;
}
public void setUnits(int units) {
	this.units = units;
}
public double getTotalBill() {
	return totalBill;
}
public void setTotalBill(double totalBill) {
	this.totalBill = totalBill;
}
//totalbillgenerator
private double generatetotalBill() {
	int units=this.getUnits();
	if(units<=100) {
		this.totalBill=(units*0.50);
		return totalBill;
	}else if(units >100&&units<=150) {
		int unit100=units-100;
		this.totalBill= ((100*0.50)+(unit100*0.75));
		return totalBill;
	}
	
	else {

		this.totalBill=((units-150*1)+(100*0.50)+(50*0.75));
		return this.totalBill;
	}

}

}
