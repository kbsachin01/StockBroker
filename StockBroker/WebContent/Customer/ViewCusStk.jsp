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
	<!-- view customer stock -->
	<!-- <h1>View Customer held stocks</h1>
	<form action="Customer/ViewCusStkInt.jsp" method="post">	
		Enter Customer Id : <input type="text" name="customerId"/><br/>
		<input type="submit"/>
	
	</form> -->

	<nav>

    <div class="container px1 cf">

      <div class="pull-left">
        <a class="leading-3 dark-gray bold caps" href="index.html">Home</a>
      </div>

   <!--   <div class="pull-right">
        <a class="leading-3 dark-gray" href="StockDetails.html">Update</a>
        <a class="leading-3 dark-gray ml1" href="BuyStocks.html">Buy</a>
        <a class="leading-3 dark-gray ml1" href="Customer_Login.html">Login</a>
      </div>-->

    </div>

 </nav>

  <header class="bg-remember py4 p1">
    <h2 class="center caps">
      Customer Information
    </h2>
    <br>
    <h3 class="caps center h3">
      To View Stocks</h3>

  </header>


  <section>

    <div class="container p1 my2">

      <div class="col-md-8 col-md-offset-2">

        <form name="myForm" action="Customer/ViewCusStkInt.jsp" method="post">
          <br>

          <h3><b>Enter Customer ID:</b></h3>
          <center>
            <input type="text" class="form-control" id="nme" placeholder="Enter Customer ID" name="customerId">
            <br>
			<center><p><b><h4>If you click submit, without filling out the text field,your browser will display an error message.</h4></b></p></center>
			<br>
           <!--  <button type="submit" class="btn btn-primary btn-lg btn-block" onclick=" myfunction();">Register</button> -->
           <input type="submit" value="Submit" class="btn btn-primary btn-lg btn-block" onclick=" myfunction();"/>
          </center>
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


<script>
function myfunction()
{
  var x = document.forms["myForm"]["customerId"].value;
  if (x == null || x == "")
{
      alert("Please enter your name");
      return false;
  }
}

</script>
</body>
</html>