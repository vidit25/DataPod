<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
  
  
   <jsp:body>
	   <header class="align-center">
	      <h2>Enquiry Form</h2>
	   </header>
	   
	   <form:form action="/submitEnquiry" modelAttribute="subscriptionForm">
	   	<tr>
	   		<td>
	   			Organization Name :
	   		</td>
	   		<td>
	   			<form:input path="organizationName"/>
	   		</td>
	   	</tr>
	   	<br/>        	<br/>
	   	<tr>
	   		<td>
	   			Organization Description :
	   		</td>
	   		<td>
	   			<form:textarea path="organizationDescription"/>
	   		</td>
	   	</tr>
	   	<br/>         	<br/>
	   	<tr>
	   		<td>
	   			Email :
	   		</td>
	   		<td>
	   			<form:input path="email"/>
	   		</td>
	   	</tr>
	   	<br/>      	<br/>
	   		<tr>
	   		<td>
	   			Domain :
	   		</td>
	   		<td>
	   			<form:select path="domainId">
	   				<form:options items="${domains}" itemValue="domainId" itemLabel="domainName"/>
	   			</form:select>
	   		</td>
	   	</tr>
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			phone :
	   		</td>
	   		<td>
	   			<form:input path="phone"/>
	   		</td>
	   	</tr>
	    <br/>     	<br/>
	   
	   	<tr>
	   		<td>
	   			Address Line 1 :
	   		</td>
	   		<td>
	   			<form:input path="addressLineOne"/>
	   		</td>
	   	</tr>	
	   	<br/>    	<br/>
	   	
	   	<tr>
	   		<td>
	   			Address Line 2 :
	   		</td>
	   		<td>
	   			<form:input path="addressLineTwo"/>
	   		</td>
	   	</tr>
	   	<br/>    	<br/>
	   	
	   	<tr>
	   		<td>
	   			City :
	   		</td>
	   		<td>
	   			<form:input path="city"/>
	   		</td>
	   	</tr>
	   	
	   	<br/>    	<br/>
	   	<tr>
	   		<td>
	   			State :
	   		</td>
	   		<td>
	   			<form:input path="state"/>
	   		</td>
	   	</tr>
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			Country :
	   		</td>
	   		<td>
	   			<form:input path="country"/>
	   		</td>
	   	</tr>
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			PinCode :
	   		</td>
	   		<td>
	   			<form:input path="pinCode"/>
	   		</td>
	   	</tr>
	   	
	   	<br/>   	<br/>
	   	<form:button value="Submit"> Submit</form:button>
	   </form:form>
	   
    </jsp:body>
</t:pageTemplate>
