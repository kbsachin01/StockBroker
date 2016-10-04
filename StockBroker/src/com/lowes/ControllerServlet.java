package com.lowes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    protected void process(HttpServletRequest request, HttpServletResponse response){
    	
    	try
		{
			System.out.println("inside process() of CS");
			
			String uri = request.getRequestURI();
			System.out.println("uri = "+uri);
			RequestDispatcher rd = null;
			Model model = new Model();			

			/*HOME PAGE*/
			if(uri.contains("/openBrokerView"))
			{
				System.out.println("inside uri /openBrokerView");
				rd = request.getRequestDispatcher("/Broker/Broker.jsp"); //Over
				rd.forward(request, response);
			}
			
			if(uri.contains("/openCustomerView"))
			{	
				System.out.println("inside openCustomer View ");
				rd = request.getRequestDispatcher("/Customer/Customer.jsp");
				System.out.println("after customer view");
				rd.forward(request, response);
			}
			
			/*END HOME PAGE*/
			
			/*BROKER HOME*/
			
			if(uri.contains("/RegisterCustomer"))
			{	
				System.out.println("Inside /RegisterCustomer");
				rd = request.getRequestDispatcher("/Broker/RegCustomer.jsp"); //-->forward to RegCustomerInt.jsp then from Int to /registerCustomer.do
				rd.forward(request, response);
			}
			
			if(uri.contains("/RegisterCompany"))
			{
				rd = request.getRequestDispatcher("/Broker/RegCompany.jsp");  //-->forward to RegCompanyInt.jsp then from Int to /registerCompany.do
				rd.forward(request, response);
			}
			
			if(uri.contains("/UpdateStockPrice"))
			{
				rd = request.getRequestDispatcher("/Broker/UpdateStPc.jsp");
				rd.forward(request, response);
			}
			
			if(uri.contains("/ViewCompanyStock"))
			{
				/*rd = request.getRequestDispatcher("/Broker/ViewComStk.jsp");
				rd.forward(request, response);*/
				
				System.out.println("inside uri /viewCompanyStock");

				List<Company> csl= new ArrayList<Company>();
				
				csl = model.viewCompanyStocks();
				
				System.out.println("result of calling viewCompanyStock() on Model = "+csl);
				if(csl!=null)
				{
					System.out.println("forwarding to success view");
					request.setAttribute("comList", csl);
					request.getRequestDispatcher("/Broker/ViewComStk.jsp").forward(request, response);
					System.out.println("after rd");
					
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", csl);
					rd = request.getRequestDispatcher("/Broker/Broker.jsp");
					rd.forward(request, response);
					
				}
			}
			
			/*END BROKER HOME*/
			
			/*CUSTOMER HOME*/
			
			if(uri.contains("/Buy"))
			{	
				System.out.println("Inside Buy");
				rd = request.getRequestDispatcher("/Customer/BuyStk.jsp");
				rd.forward(request, response);
			}
			
			if(uri.contains("/Sell"))
			{
				rd = request.getRequestDispatcher("/Customer/SellStk.jsp");
				rd.forward(request, response);	
			}
			
			/*VIEW HIS OWN STOCK- CUSTOMER*/
			
			if(uri.contains("/ViewCustomerStock"))
			{	
				System.out.println("inside ViewCustomerStock()");
				rd = request.getRequestDispatcher("/Customer/ViewCusStk.jsp");
				rd.forward(request, response);
			}
			
			/*END CUSTOMER HOME*/
			
			/*Reg Customer*/
			if(uri.contains("/rc"))
			{
				System.out.println("inside uri /registerCustomer");
				Customer cu = (Customer)request.getAttribute("customer");
				
				System.out.println("customer name" + cu.getCustomerName());		
				String result = model.registerCustomer(cu);
				System.out.println("result of calling registerCustomer() on Model = "+result);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("forwarding to success view");
					rd = request.getRequestDispatcher("/Broker/Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Broker/Broker.jsp");
					rd.forward(request, response);
					
				}
			}
			
			/*Reg Company*/
			if(uri.contains("/cor"))
			{
				System.out.println("inside uri /registerCompany(rco)");
				
				Company co = (Company)request.getAttribute("company");
				
				System.out.println("company name " + co.getCompanyName());		
				System.out.println("No of Stocks " + co.getNoOfStocks());
				System.out.println("Stock Price " + co.getStockPrice());
				String result = model.registerCompany(co);
				
				System.out.println("result of calling registerCustomer() on Model = "+result);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("forwarding to success view");
					rd = request.getRequestDispatcher("/Broker/Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Broker/Broker.jsp");
					rd.forward(request, response);
					
				}
			}
			
			/*Update Company Stock Price*/
			if(uri.contains("/updateStPc"))
			{
				System.out.println("inside uri /updateStPC()");
				
				Company co = (Company)request.getAttribute("company");
				
				System.out.println("company id " + co.getCompanyId());		
				//System.out.println("No of Stocks " + co.getNoOfStocks());
				System.out.println("New Stock Price " + co.getStockPrice());
				String result = model.updateCompanyStock(co);
				
				System.out.println("result of calling registerCustomer() on Model = "+result);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("forwarding to success view");
					rd = request.getRequestDispatcher("/Broker/Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Broker/Broker.jsp");
					rd.forward(request, response);
					
				}
			}
			
			/*BUY STOCK*/
			if(uri.contains("/bs")) // cust id, co id, no of stk,
			{
				System.out.println("inside uri /bs");
				
				List<TransactionDetails> tdl = new ArrayList<TransactionDetails>();
				TransactionDetails t = (TransactionDetails)request.getAttribute("transaction");
				Customer cus = (Customer) request.getAttribute("customer");
				Company com = (Company)request.getAttribute("company");
				t.setTransactionType("Buy");
				t.setCompany(com);
				tdl.add(t);
				cus.setCustomerTrasactionDetails(tdl);
			
				String result = model.buyStock(cus);
				System.out.println("result of calling buyStock() on Model = "+result);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("forwarding to success view");
					rd = request.getRequestDispatcher("/Customer/Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Register.jsp");
					rd.forward(request, response);
					
				}
			}
			
			
			
			/*SELL STOCK*/
			
			if(uri.contains("/ss"))
			{
				System.out.println("inside uri /ss");
				
				List<TransactionDetails> tdl = new ArrayList<TransactionDetails>();
				TransactionDetails t = (TransactionDetails)request.getAttribute("transaction");
				Customer cus = (Customer) request.getAttribute("customer");
				Company com = (Company)request.getAttribute("company");
				t.setTransactionType("Sell");
				t.setCompany(com);
				tdl.add(t);
				cus.setCustomerTrasactionDetails(tdl);
				
			
				
				String result = model.sellStock(cus);
				System.out.println("result of calling buyStock() on Model = "+result);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("forwarding to success view");
					rd = request.getRequestDispatcher("/Customer/Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Customer/Customer.jsp");
					rd.forward(request, response);
					
				}
			}
			
			if(uri.contains("/vcs"))
			{
				System.out.println("inside uri /vcs");

				Customer cus = (Customer) request.getAttribute("customer");
			
				Customer vcus = model.viewCustomerStocks(cus);
				List<TransactionDetails> tdl = new ArrayList<TransactionDetails>();
				tdl= vcus.getCustomerTrasactionDetails();
				System.out.println("result of calling buyStock() on Model = "+vcus);
				
				if(vcus!=null)
				{
					System.out.println("forwarding to success view");
					request.setAttribute("cus", vcus);
					request.setAttribute("trList", tdl);
					request.getRequestDispatcher("/Customer/DisplayCustomerStocks.jsp").forward(request, response);
					System.out.println("after rd in vcs");
				}
				else
				{
					System.out.println("saving errormsg and forwarding to error view");
					request.setAttribute("errorMsg", vcus);
					rd = request.getRequestDispatcher("/Customer/Customer.jsp");
					rd.forward(request, response);
					
				}
			}
			
			
			
		}catch(Exception e)
		{
			request.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("inside doGet() of CS");
		process(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
