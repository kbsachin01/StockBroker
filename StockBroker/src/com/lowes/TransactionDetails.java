package com.lowes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDetails {
	
	private int TransactionId;
	private String TransactionType;
	private int TransactionStock;
	private Company company;
	
	public TransactionDetails(){
		super();
	}
	
	public TransactionDetails(ResultSet rs1) {
		try {
			this.TransactionId=rs1.getInt("TransactionId");
			this.TransactionType=rs1.getString("TransactionType");
			this.TransactionStock=rs1.getInt("TransactionStock");
			this.company= new Company();
			this.company.setCompanyName(rs1.getString("CompanyName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public TransactionDetails(ResultSet rs1, Company co) {
		try {
			this.TransactionId=rs1.getInt("TransactionId");
			this.TransactionType=rs1.getString("TransactionType");
			this.TransactionStock=rs1.getInt("TransactionStock");
			this.company=co;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Company getCompany() {
		return company;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Customer customer;
	
	public int getTransactionStock() {
		return TransactionStock;
	}
	public void setTransactionStock(int transactionStock) {
		TransactionStock = transactionStock;
	}
	public int getTransactionId() {
		return TransactionId;
	}
	
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

}
