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
<!-- /SellStkInt -->
	<!-- <h1>Sell Stock</h1>
	<form action="Customer/SellStkInt.jsp" method="post">	
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
</nav>

<header class="bg-remember py4 p1">


<h1 class="center caps">
Stock Exchange
</h1>
<br>
<h2 class="caps center h2">
Stock Auction Form</h2>

</header>
<br>
<section>

    <div class="container p1 my2">

      <div class="col-md-8 col-md-offset-2">
	   <form name="myForm" class="form-horizontal" action="Customer/SellStkInt.jsp" method="post">

        

        <h3><b> Company Id:</b></h3>
        <input type="text" class="form-control" placeholder="Enter company name" name="companyId">
		<br>
		<h3> <b>Customer Id :</b></h3>
        <input type="text" class="form-control" placeholder="Enter number of stocks" name="customerId">
		<br>
        <h3><b>Number of Stocks :</b></h3>
        <input type="text" class="form-control" placeholder="Enter Stock Price" name="transactionStock">
		<br>
		<center><p><b><h4>If you click submit, without filling out the text field,your browser will display an error message.</h4></b></p></center>
        <br>
        <button type="submit" class="btn btn-primary btn-lg btn-block" onclick="myfunction(); myfunction1(); myfunction2();">Submit</button>

       </form>

      </div>


    </div>

  </section>
</body>
</html>