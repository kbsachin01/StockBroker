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
	
	<!-- <h1>Register Company</h1>
	<form action="Broker/RegCompanyInt.jsp" method="post">	
		Enter Company Name: <input type="text" name="companyName"/><br/>
		Stock Price : <input type="text" name="stockPrice"/><br/>
		Number of Stocks : <input type="text" name="noOfStocks"/><br/>
		<input type="submit"/>
	
	</form>
	 -->
	<nav>

    <div class="container px1 cf">

      <div class="pull-left">
        <a class="leading-3 dark-gray bold caps" href="index.html">Home</a>
      </div>

     <!-- <div class="pull-right">
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
    <h2 class="center caps h2">
      Company Registration
    </h2>

  </header>


  <section>

    <div class="container p1 my2">

      <div class="col-md-8 col-md-offset-2">
	   <form name="myForm" class="form-horizontal" action="Broker/RegCompanyInt.jsp" method="post">

        

        <h3><b> Company Name:</b></h3>
        <input type="text" class="form-control" placeholder="Enter company name" name="companyName">
		<br>
		<h3> <b>Number of Stocks:</b></h3>
        <input type="text" class="form-control" placeholder="Enter number of stocks" name="noOfStocks">
		<br>
        <h3><b>StockPrice:</b></h3>
        <input type="text" class="form-control" placeholder="Enter Stock Price" name="stockPrice">
		<br>
		<center><p><b><h4>If you click submit, without filling out the text field,your browser will display an error message.</h4></b></p></center>
        <br>
        <button type="submit" class="btn btn-primary btn-lg btn-block" onclick="myfunction(); myfunction1(); myfunction2();">Register</button>

       </form>

      </div>


    </div>

  </section>


  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

  <script>
function myfunction()
{
  var x = document.forms["myForm"]["companyName"].value;
  if (x == null || x == "")
{
      alert("Please enter your name");
      return false;
  }
}
function myfunction1()
{
  var x = document.forms["myForm"]["noOfStocks"].value;
  if (x == null || x == "")
{
      alert("Please enter the number of stocks");
      return false;
  }
}
function myfunction2()
{
  var x = document.forms["myForm"]["stockPrice"].value;
  if (x == null || x == "")
{
      alert("Please enter the stockprice");
      return false;
  }
}
</script>

	<%
		if(request.getAttribute("errorMsg")!=null)
		{
			out.println("<h1>Errorappaerror!</h1>");
			out.println(request.getAttribute("errorMsg"));
		}
	%>
</body>
</html>