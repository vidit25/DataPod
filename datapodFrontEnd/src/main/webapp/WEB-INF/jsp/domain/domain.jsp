<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
  
  
   <jsp:body>
	   <header class="align-center">
	   <style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		</style>
	      <h2>Domain Screen</h2>
	   </header>
	   <table style="width:100%">
	   <tr>
		    <th>ID</th><th>Name</th><th>Description</th>
	   </tr>
	   <c:forEach var="domain" items="${response.response}" varStatus="loop">
	        <tr>
		    	<%-- <th>${domain.id}</th><th>${domain.name}</th><th>${domain.description}</th> --%>
		    	<td><a href="#">${domain.id}</a></td><td>${domain.name}</td><td>${domain.description}</td>
	   		</tr>
	   </c:forEach>
	   </table>
	  <form:form action="/domain" method="POST" modelAttribute="newDomainModel">
	   		<tr>    
	   		    <td>
	   				Name : 
	   			</td>
	   			
	   			<td>
	   				<form:input path="name" />
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<tr>
	   			<td>
	   				Description : 
	   			</td>
	   			<td>
	   				<form:input path="description"/>
	   			</td>
	   		</tr>
	   		<br/>
	   		<tr>
	   			<form:button value="Domain">Add Domains</form:button>
	   		</tr>
	   	
	   </form:form>
    </jsp:body>
</t:pageTemplate>
