<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Broker</title>
<!-- Theme CSS styles -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/theme.css">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"> 
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>

<nav>

    <div class="container px1 cf">

      <div class="pull-left">
        <a class="leading-3 dark-gray bold caps" href="${pageContext.request.contextPath}/index.html">Home</a>
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
    <h2 class="center caps">
     Customer Details
    </h2>
  </header>
  <br>
  <br>
<table style="width:100%" class="container">
  <tr>
    
    <th>Company Name</th>	
	<th>Transaction Type</th>
    <th>Number of Stocks</th>
	
  </tr>
  <c:forEach var="transactionDetails" items="${trList}" varStatus="rowCounter">
     <tr>
    <td>${transactionDetails.company}</td>		
    <td>${transactionDetails.transactionType}</td>
	 <td>${transactionDetails.transactionStock}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>