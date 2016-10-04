<jsp:useBean id="customer" class="com.lowes.Customer" scope="request" >
	<jsp:setProperty name="customer" property="*"/>
</jsp:useBean>
<jsp:useBean id="company" class="com.lowes.Company" scope="request" >
	<jsp:setProperty name="company" property="*"/>
</jsp:useBean>
<jsp:useBean id="transaction" class="com.lowes.TransactionDetails" scope="request" >
	<jsp:setProperty name="transaction" property="*"/>
</jsp:useBean>
<jsp:forward page="/ss.do" />