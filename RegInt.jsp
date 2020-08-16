<jsp:useBean class="com.uttara.mvc.RegBean" id="reg" scope="request">
	<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="register.do"/>

<!-- 
	1) instantiate RegBean obj
	2) invoker setter methods and pass user inputs from req as param
	3) save the inst, populated bean obj in chosen scope
	4) forward the control to controller
 -->
