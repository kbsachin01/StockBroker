package com.lowes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
	
	
	private String CompanyName;
	private int CompanyId;
	private float StockPrice;
	private int NoOfStocks;
	
	public Company(){
		super();
	}
	
	
	public Company(ResultSet rs) {
		try {
			this.CompanyName = rs.getString("CompanyName");
			this.StockPrice = rs.getFloat("StockPrice");
			this.CompanyId =rs.getInt("CompanyId");
			this.NoOfStocks = rs.getInt("TotalNoOfStocks");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@Override
	public String toString() {
		return CompanyName ;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public int getCompanyId() {
		return CompanyId;
	}
	public float getStockPrice() {
		return StockPrice;
	}
	public int getNoOfStocks() {
		return NoOfStocks;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	public void setStockPrice(float stockPrice) {
		StockPrice = stockPrice;
	}
	public void setNoOfStocks(int noOfStocks) {
		NoOfStocks = noOfStocks;
	}
	
	public String validate() {
		System.out.println("inside validate() of CompanyBean");
		StringBuilder sb = new StringBuilder("");
		if(CompanyName==null || CompanyName.trim().equals(""))
			sb.append("Enter Company? <br/>");
		if(StockPrice==0)
			sb.append("Enter Stock Price <br/>");
		if(NoOfStocks==0)
			sb.append("Enter No. of Stock Price <br/>");
		
		String msg = sb.toString();
		System.out.println("validation result = "+msg);
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	public String validateUpdateStPc() {
		System.out.println("inside validate() of CompanyBean");
		StringBuilder sb = new StringBuilder("");
		if(CompanyName==null || CompanyName.trim().equals(""))
			sb.append("Enter Company? <br/>");
		if(StockPrice==0)
			sb.append("Enter Stock Price <br/>");

		String msg = sb.toString();
		System.out.println("validation result = "+msg);
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	
}
