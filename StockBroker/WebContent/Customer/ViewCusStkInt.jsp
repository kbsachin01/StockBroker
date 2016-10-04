<jsp:useBean id="customer" class="com.lowes.Customer" scope="request" >
	<jsp:setProperty name="customer" property="*"/>
</jsp:useBean>
<jsp:forward page="/vcs.do" />