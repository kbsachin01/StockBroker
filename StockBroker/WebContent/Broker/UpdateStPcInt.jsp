<jsp:useBean id="company" class="com.lowes.Company" scope="request" >
	<jsp:setProperty name="company" property="*"/>
</jsp:useBean>
<jsp:forward page="/updateStPc.do" />