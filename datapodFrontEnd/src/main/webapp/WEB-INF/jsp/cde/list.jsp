<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
   <jsp:body>
   	<br/> <br/>
   		<a href="/dashboard"> Back to DashBoard</a>
  
  	<br/> <br/>
	   <header class="align-center">
	      <h2>CDE Functional Data :  STEP 2</h2>
	   </header>
	    <form:form action="/associateFunctionalData" modelAttribute="functionalDataForm">
	    	<br/>
	    	<br/>
	    	<tr>
	    	<td> Functional CDE : </td>
	    	<td>
	    	<form:select path="dataElementIds" id="dataElementIds" multiple="true">
	   					<form:option value="0">Select Domain</form:option>
	   				 <c:forEach var="data" items="${functionalData.response}" varStatus="loop">
	        			<form:option value="${data.id}">${data.title}</form:option>
	  			 </c:forEach>
	   			</form:select>
	   			</td>
	   		</tr>	
	   		<br/>
	   		<br/>
	   		<form:button value="Submit">Associate CDE</form:button>
	    </form:form>
	  
	   
    </jsp:body>
</t:pageTemplate>
