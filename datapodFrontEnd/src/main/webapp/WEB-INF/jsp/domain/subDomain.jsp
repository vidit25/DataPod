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
	      <h2>Domain Details Screen</h2>
	   </header>
	   
	   <table style="width:100%">
	   <%-- <tr>
		    <th>ID</th><th>Name</th><th>Description</th>
	   </tr> --%>
	   <tr>
		    <td>${response.response.id}</td><td>${response.response.name}</td><td>${response.response.description}</td>
	   </tr>
	   </table>
	   
	   <table style="width:100%">
	   <tr>
		    <th>ID</th><th>Name</th><th>Description</th>
	   </tr>
	   <c:forEach var="subDomain" items="${response.response.subDomains}" varStatus="loop">
	        <tr>
		    	<td><a href="#">${subDomain.id}</a></td><td>${subDomain.name}</td><td>${subDomain.description}</td>
	   		</tr>
	   </c:forEach>
	   </table>
       <form:form action="/subDomain" method="POST" modelAttribute="newSubDomainModel">
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
	   		<form:hidden path="id" value = "${response.response.id}" />
	   		<br/>
	   		<tr>
	   			<form:button value="Domain">Add Sub Domains</form:button>
	   		</tr>
	   </form:form>	   
    </jsp:body>
</t:pageTemplate>
