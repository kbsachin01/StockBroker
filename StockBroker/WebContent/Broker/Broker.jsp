<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Broker</title>
<!-- Theme CSS styles -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/theme.css">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"> 
</head>
<body>
	

	<!-- <a href="RegisterCustomer.do">Register Customer</a>
	<br>
	<br>
	<a href="RegisterCompany.do">Register Company</a>
	<br>
	<br>
	<a href="UpdateStockPrice.do">Update Stock For Company</a>
	<br>
	<br>
	<a href="ViewCompanyStock.do">Stocks of all Companies</a>
	<br> -->
	<!-- <br>
	<a href="Customer_Stock.html">View Customer Stocks</a>	 -->
	
		<nav>
	
		<div class="container px1 cf">
		
		<div class="pull-left">
		<a class="leading-3 dark-gray bold caps" href="${pageContext.request.contextPath}/index.html">Home</a>
		</div>
		
		<!--<div class="pull-right">
		<a class="leading-3 dark-gray" href="StockDetails.html"><b>Update</b></a>
		<a class="leading-3 dark-gray ml1" href="BuyStocks.html"><b>Buy</b></a>
		<a class="leading-3 dark-gray ml1" href="Customer_Login.html"><b>Login</b></a>
		</div>-->
		
		</div>
		
		</nav>
	
		<header class="bg-remember py4 p1">
		<h1 class="center caps">
		Stock Exchange
		</h1>
		<br>
		<h2 class="caps center h2">
		Stock Broker</h2>
		
		</header>
	
	
		<section>
		
			<div class="container p1 my2">
			
				<div class="col-sm-12">
				
				  <div class="col-md-6 center">
				    <button type="button" class="btn btn-primary btn-block btn-lg" onclick="window.location.href='RegisterCustomer.do'"><h3>Register Customer</h3></button>
				    <button type="button" class="btn btn-primary btn-block btn-lg" onclick="window.location.href='RegisterCompany.do'"><h3>Register Company</h3></button>
				  </div>
				
				  <div class="col-md-6 center">
				    <button type="button" class="btn btn-primary btn-block btn-lg" onclick="window.location.href='UpdateStockPrice.do'"><h3>Update Stocks</h3></button>
				    <button type="button" class="btn btn-primary btn-block btn-lg" onclick="window.location.href='ViewCompanyStock.do'"><h3>View Stocks</h3></button>
				  </div>
				
				</div>
			
			
			</div>
		
		</section>
	
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	
</body>
</html>