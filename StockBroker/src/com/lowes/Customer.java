package com.lowes;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String CustomerName;
	private int CustomerId;
	private List<TransactionDetails> CustomerTrasactionDetails;
	
	public Customer(){
		CustomerTrasactionDetails= new ArrayList<TransactionDetails>();
	}
	
	public List<TransactionDetails> getCustomerTrasactionDetails() {
		return CustomerTrasactionDetails;
	}

	public void setCustomerTrasactionDetails(List<TransactionDetails> customerTrasactionDetails) {
		CustomerTrasactionDetails = customerTrasactionDetails;
	}

	public String getCustomerName() {
		return CustomerName;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	
	public String validate() {
		System.out.println("inside validate() of CustomerBean");
		StringBuilder sb = new StringBuilder("");
		if(CustomerName==null || CustomerName.trim().equals(""))
			sb.append("Enter name ri. Adhu ilva? <br/>");
		String msg = sb.toString();
		System.out.println("validation result = "+msg);
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}

	public String validateCustomerId() {
		System.out.println("inside validateCustomerId() of CustomerBean");
		StringBuilder sb = new StringBuilder("");
		if(CustomerId==0)
			sb.append("Enter Customer Id Properly<br/>");
		String msg = sb.toString();
		System.out.println("validation result = "+msg);
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}

	public String validateSellBuyStock() {//Customer id, company id, no of stocks, TransactionType=buy
		System.out.println("inside validateBuyStock() of CustomerBean");
		StringBuilder sb = new StringBuilder("");
		if(CustomerId==0)
			sb.append("Enter ID properly <br/>");
		String msg = sb.toString();
		System.out.println("validation result = "+msg);
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}

	
	
}
