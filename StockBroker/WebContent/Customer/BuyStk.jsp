<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Theme CSS styles -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/theme.css">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"> 
</head>
<body>
<!-- /BuyStkInt -->

<!-- <h1>Buy Stock</h1>
	<form action="Customer/BuyStkInt.jsp" method="post">	
		Enter Customer Id : <input type="text" name="customerId"/><br/>
		Enter Company Id : <input type="text" name="companyId"/><br/>
		Number of Stocks : <input type="text" name="transactionStock"/><br/>
		<input type="submit"/>
	
	</form> -->
	
	<nav>

    <div class="container px1 cf">

      <div class="pull-left">
        <a class="leading-3 dark-gray bold caps" href="index.html">Home</a>
      </div>

     <!-- <div class="pull-right">
        <a class="leading-3 dark-gray" href="StockDetails.html"><b>Update</b></a>
        <a class="leading-3 dark-gray ml1" href="BuyStocks.html"><b>Buy</b></a>
        <a class="leading-3 dark-gray ml1" href="Customer_Login.html"><b>Login</b></a>
      </div> -->

    </div>

  </nav>

  <header class="bg-remember py4 p1">
  <h1 class="center caps">
Stock Exchange
</h1>
<br>
    <h2 class="center caps h2">
      Stock Purchase Details
    </h2>

  </header>


  <section>

    <div class="container p1 my2">

      <div class="col-md-8 col-md-offset-2">

        <form class="form-horizontal" action="Customer/BuyStkInt.jsp" method="post">

        <h3><b>Customer ID:</b></h3>
        <input type="text" class="form-control" placeholder="Enter Customer ID" name="customerId">
		<br>
		<h3> <b>Company ID:</b></h3>
        <input type="text" class="form-control" placeholder="Enter Company name" name="companyId">
		<br>
        <h3><b>Number of Stocks:</b></h3>
        <input type="text" class="form-control" placeholder="Enter number of stocks" name="transactionStock">
		<br>
		
        <br>
        <button type="submit" class="btn btn-primary btn-lg btn-block" onclick=" myfunction(); myfunction1();  myfunction2();">Submit</button>

       </form>

      </div>


    </div>

  </section>


  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

	<%
		if(request.getAttribute("errorMsg")!=null)
		{
			out.println("<h1>Errorappaerror!</h1>");
			out.println(request.getAttribute("errorMsg"));
		}
	%>
</body>
</html>