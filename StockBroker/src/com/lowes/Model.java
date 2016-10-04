package com.lowes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	/*public static void main(String str[]){
		Model m= new Model();
		List<Company> col= new ArrayList<Company>();
		col=m.viewCompanyStocks();
		for (int j = 0; j < col.size(); j++) {
			System.out.println("Company Id : "+col.get(j).getCompanyId() + "Company Name : "+col.get(j).getCompanyName()+"Stock price: "+col.get(j).getStockPrice()+"No of Stocks: "+col.get(j).getNoOfStocks());
		}
		
		Customer c= new Customer(),cu= new Customer();
		cu.setCustomerId(1);
		
		c=m.viewCustomerStocks(cu);
		System.out.println("Its in main");
		System.out.println(c.getCustomerId()+" "+c.getCustomerName());
		System.out.println("list size : "+c.getCustomerTrasactionDetails().size());
		for(int i =0;i<c.getCustomerTrasactionDetails().size();i++){
			System.out.println(c.getCustomerTrasactionDetails().get(i).getTransactionId()+" "+c.getCustomerTrasactionDetails().get(i).getCompany().getCompanyName()+ " "+c.getCustomerTrasactionDetails().get(i).getTransactionStock()+ " "+c.getCustomerTrasactionDetails().get(i).getTransactionType());	
		}
		
		Customer cu= new Customer();Company c= new Company();
		cu.setCustomerId(4);
		List<TransactionDetails> customerTrasactionDetails= new ArrayList<TransactionDetails>();
		customerTrasactionDetails.add(new TransactionDetails().setCompany(c));
		cu.setCustomerTrasactionDetails(customerTrasactionDetails);
		m.sellStock(cu);
		
	}*/
	
	public String registerCompany(Company cob) {
		
		System.out.println("inside register() of Model");
		System.out.println("bean "+cob.getCompanyName()+" "+cob.getNoOfStocks()+" "+cob.getStockPrice());
		
		// perform user input validations
		
		String result = cob.validate();
		
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("input validations succeeded...");
			// then perform business validations
			
			Connection con = null;
			PreparedStatement ps_sel =null, ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops DB problem. No connection. Contact DBA!";
				else
				{
					System.out.println("conn to db established");
					
					ps_sel = con.prepareStatement("select * from Company where CompanyName = ?");
					ps_sel.setString(1, cob.getCompanyName());
					ps_sel.execute();
					
					rs = ps_sel.getResultSet();
					if(rs.next())
					{
						System.out.println("one row exists with company - duplicate");
						return "Oye you entered duplicate.";
			
					}
					else
					{
						// then apply business logic

						ps_ins = con.prepareStatement("insert into Company(CompanyName,StockPrice,TotalNoOfStocks) values(?,?,?)");
						ps_ins.setString(1, cob.getCompanyName());
						ps_ins.setFloat(2, cob.getStockPrice());
						ps_ins.setInt(3, cob.getNoOfStocks());
						ps_ins.execute();
						
						// return control string
						return Constants.SUCCESS;					
					}
					
				}
			}
			catch(SQLException e)
			{
				return "Oops something bad happened with DB "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
			}	
		}
		else
			return result;
	}
	
	
	public String registerCustomer(Customer cb){
		
		
		System.out.println("inside register() of Model");
		System.out.println("bean "+cb.getCustomerId()+" "+cb.getCustomerName());
		
		// perform user input validations
		
		String result = cb.validate();
		
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("input validations succeeded...");
			// then perform business validations
			
			Connection con = null;
			PreparedStatement ps_sel =null, ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops DB problem. No connection. Contact DBA!";
				else
				{
					System.out.println("conn to db established");
					
					ps_sel = con.prepareStatement("select * from Customer where Name = ?");
					ps_sel.setString(1, cb.getCustomerName());
					ps_sel.execute();
					
					rs = ps_sel.getResultSet();
					if(rs.next())
					{
						System.out.println("one row exists with name - duplicate");
						return "Oye you are entering the duplicate name";
			
					}
					else
					{
						// then apply business logic

						ps_ins = con.prepareStatement("insert into Customer(Name) values(?)");
						ps_ins.setString(1, cb.getCustomerName());
						ps_ins.execute();
						
						// return control string
						return Constants.SUCCESS;					
					}
					
				}
			}
			catch(SQLException e)
			{
				return "Oops something bad happened with DB "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
			}

			
		}
		else
			return result;
		
	}
	
	public String updateCompanyStock(Company co) { //co id, co name, co stock price 
		
		String result = co.validateUpdateStPc();
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			PreparedStatement ps_sel =null, ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops DB problem. No connection. Contact DBA!";
				else
				{	
						System.out.println("conn to db established");
						
						ps_sel = con.prepareStatement(" update Company set StockPrice = ? where CompanyId=?");
						ps_sel.setFloat(1, co.getStockPrice());
						ps_sel.setInt(2, co.getCompanyId());
						ps_sel.executeUpdate();

							return Constants.SUCCESS;					

					}
			
				}
				catch(SQLException e)
				{
					return "Oops something bad happened with DB "+e.getMessage();
				}
				finally
				{
					JDBCHelper.close(rs);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(con);
				}
		
		}
		else
			return result;
	}

	public List<Company> viewCompanyStocks(){
		

		System.out.println("Inside viewCompanyStocks() of Model");
		
		Connection con = null;
		PreparedStatement ps_sel =null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null){
				System.out.println("Problem Connecting to DB");
				return null;
			}
			else
			{	
				List<Company> col= new ArrayList<Company>();
			//	Company c= new Company();
				System.out.println("connection to db established");
				String qry = "select CompanyId,CompanyName,StockPrice,TotalNoOfStocks from Company";
				
				ps_sel = con.prepareStatement(qry);
				ps_sel.executeQuery();
				
				rs = ps_sel.getResultSet();
				
				
					while(rs.next())
					{	
						System.out.println("inside rs");
						col.add(new Company(rs));
					}
				System.out.println(col.size());
				return col;
			}
		}
		catch(SQLException e)
		{
			//return "Oops something bad happened with DB "+e.getMessage();
			System.out.println("Oops something bad happened with DB "+e.getMessage());
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}

		return null;
	}
	
	public String buyStock(Customer cu){ //Customer id, company id, no of stocks, TransactionType=buy
		
		System.out.println("inside buyStock() of Model");
		System.out.println("bean "+cu.getCustomerId()+" "+cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyId()+" "+cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
		
		// perform user input validations
		
		String result = cu.validateSellBuyStock();
		
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("input validations succeeded...");
			// then perform business validations
			
			Connection con = null;
			PreparedStatement ps_upd =null, ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops DB problem. No connection. Contact DBA!";
				else
				{
					System.out.println("conn to db established");
					
					ps_upd = con.prepareStatement(" update Company set TotalNoOfStocks=TotalNoOfStocks-? select Company.TotalNoOfStocks from Company,Transaction_Details where Company.CompanyId=? and Transaction_Details.TransactionType=?");
					ps_upd.setInt(1, cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
					ps_upd.setInt(2, cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyId());
					ps_upd.setString(3, cu.getCustomerTrasactionDetails().get(0).getTransactionType());
					ps_upd.executeUpdate();
					
					ps_ins=con.prepareStatement(" insert into Transaction_Details values (?, ?, ?,?)");
					ps_ins.setInt(1,  cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyId());
					ps_ins.setInt(2, cu.getCustomerId());
					ps_ins.setString(3, cu.getCustomerTrasactionDetails().get(0).getTransactionType());
					ps_ins.setInt(4, cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
					ps_ins.execute();
						
						// return control string
						return Constants.SUCCESS;					
					
					
				}
			}
			catch(SQLException e)
			{
				return "Oops something bad happened with DB "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_upd);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
			}

			
		}
		else
			return result;
	}
	
	public String sellStock(Customer cu){ //Customer id, company name, no of stocks
		
		System.out.println("inside buyStock() of Model");
		System.out.println("bean "+cu.getCustomerId()+" "+cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyName()+" "+cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
		
		// perform user input validations
		
		String result = cu.validateSellBuyStock();
		
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("input validations succeeded...");
			// then perform business validations
			
			Connection con = null;
			PreparedStatement ps_upd =null, ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops DB problem. No connection. Contact DBA!";
				else
				{
					System.out.println("conn to db established");
					
					ps_ins=con.prepareStatement(" insert into Transaction_Details values (?,?,?,?)");
					ps_ins.setInt(1,  cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyId());
					ps_ins.setInt(2, cu.getCustomerId());
					ps_ins.setString(3, cu.getCustomerTrasactionDetails().get(0).getTransactionType());
					ps_ins.setInt(4, cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
					ps_ins.execute();
					
					ps_upd = con.prepareStatement(" update Company set TotalNoOfStocks=TotalNoOfStocks+? select Company.TotalNoOfStocks from Company,Transaction_Details where Company.CompanyId=? and Transaction_Details.TransactionType=?");
					ps_upd.setInt(1, cu.getCustomerTrasactionDetails().get(0).getTransactionStock());
					ps_upd.setInt(2, cu.getCustomerTrasactionDetails().get(0).getCompany().getCompanyId());
					ps_upd.setString(3,"Sell");
					ps_upd.executeUpdate();
					
					
						
					// return control string
					return Constants.SUCCESS;					
					
					
				}
			}
			catch(SQLException e)
			{
				return "Oops something bad happened with DB "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_upd);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
			}

			
		}
		else
			return result;
	}
	
	@SuppressWarnings("resource")
	public Customer viewCustomerStocks(Customer c){

		System.out.println("inside viewCustomerStocks() of Model");
		System.out.println("bean "+c.getCustomerId()+" "+c.getCustomerName());
		
		// perform user input validations
		
		String result = c.validateCustomerId();
		
		//Customer Details
		List<TransactionDetails> tdl = new ArrayList<TransactionDetails>();
		
		
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("input validations succeeded...");
			// then perform business validations
			
			Connection con = null;
			PreparedStatement ps_sel =null,ps_sel1=null;
			ResultSet rs = null,rs1=null,rs2= null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null){
					System.out.println("Problem Conncecting to DB");
					return null;
				}
				else
				{
					System.out.println("connection to db established");
					
					ps_sel = con.prepareStatement("select CustomerId,Name from Customer where CustomerId = ?");
					ps_sel.setInt(1, c.getCustomerId());
					ps_sel.execute();
					
					rs = ps_sel.getResultSet();

					ps_sel = con.prepareStatement("SELECT CompanyName,TransactionId,TransactionType, TransactionStock  FROM [Company] O RIGHT JOIN Transaction_Details C ON O.CompanyId = C.CompanyId WHERE C.CustomerId=?");
					ps_sel.setInt(1, c.getCustomerId());
					ps_sel.execute();				
					rs1 = ps_sel.getResultSet();
					
					if(rs.next())
					{
						c.setCustomerName(rs.getString("Name"));
					}
	
					while(rs1.next()){
					//	System.out.println(rs1.getInt("TransactionId")+" "+rs1.getString("CompanyName")+" "+rs1.getString("TransactionType")+" "+rs1.getInt("TransactionStock"));
						tdl.add(new TransactionDetails(rs1));
					}
				}
				c.setCustomerTrasactionDetails(tdl);
			}
			catch(SQLException e)
			{
				//return "Oops something bad happened with DB "+e.getMessage();
				System.out.println("Oops something bad happened with DB "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(rs1);
				JDBCHelper.close(rs2);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_sel1);
				JDBCHelper.close(con);
			}

			return c;
		}
		else
			return c;
	}
	
	
}
