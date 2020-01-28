<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
  
   <jsp:attribute name="additionalJs">
   </jsp:attribute>
   <jsp:body>
	   <header class="align-center">
	      <h2>Login Screen</h2>
	   </header>
	   	<form:form action="/login" method="POST" modelAttribute="signinForm">
	   		<tr>
	   			<td>
	   				UserName : 
	   			</td>
	   			
	   			<td>
	   				<form:input path="userName" />
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<tr>
	   			<td>
	   				Password : 
	   			</td>
	   			<td>
	   				<form:password path="password"/>
	   			</td>
	   		</tr>
	   		<br/>
	   		<tr>
	   			<form:button value="Login" />
	   		</tr>
	   	
	   </form:form>
    </jsp:body>
</t:pageTemplate>
