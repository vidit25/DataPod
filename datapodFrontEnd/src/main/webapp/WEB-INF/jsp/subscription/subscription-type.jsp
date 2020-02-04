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
	   <style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		</style>
	      <h2>Subscription Types Screen</h2>
	   </header>
	   <table style="width:100%">
	   <tr>
		    <th>ID</th><th>Name</th><th>Description</th><th>Cost</th><th>DataMinUsage</th><th>DataMaxUsage</th><th>TimeMinUsage</th><th>TimeMaxUsage</th>
	   </tr>
	   <c:forEach var="subscriptionType" items="${response.response}" varStatus="loop">
	        <tr>
		    	<td>${subscriptionType.id}</td><td>${subscriptionType.name}</td><td>${subscriptionType.description}</td><td>${subscriptionType.cost}</td>
		    	<td>${subscriptionType.dataMinUsage}</td><td>${subscriptionType.dataMaxUsage}</td><td>${subscriptionType.timeMinUsage}</td><td>${subscriptionType.timeMaxUsage}</td>
	   		</tr>
	   </c:forEach>
	   </table>
	   
	   <h2>Add Subscription Type</h2>
	  <form:form action="/subscriptionType" method="POST" modelAttribute="newSubscriptionType">
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
	   		<tr></tr>
	   		<form:hidden path="domainId" value ="${sessionScope.currDomainId}"/>
	   		<%-- <tr>
	   			<td>
	   				DomainId : 
	   			</td>
	   			<td>
	   				<form:input path="domainId" value="${sessionScope.currDomainId}"/>
	   			</td>
	   		</tr> --%>
	   		<tr></tr>
	   		<tr>
	   			<td>
	   				Cost : 
	   			</td>
	   			<td>
	   				<form:input path="cost"/>
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<br/>
	   		<tr>
	   			<td>
	   				DataMinUsage : 
	   			</td>
	   			<td>
	   				<form:input path="dataMinUsage"/>
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<tr>
	   			<td>
	   				DataMaxUsage : 
	   			</td>
	   			<td>
	   				<form:input path="dataMaxUsage"/>
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<br/>
	   		<tr>
	   			<td>
	   				TimeMinUsage : 
	   			</td>
	   			<td>
	   				<form:input path="timeMinUsage"/>
	   			</td>
	   		</tr>
	   		<tr></tr>
	   		<tr>
	   			<td>
	   				TimeMaxUsage : 
	   			</td>
	   			<td>
	   				<form:input path="timeMaxUsage"/>
	   			</td>
	   		</tr>
	   		<br/>
	   		<tr>
	   			<form:button value="SubscriptionType">Add SubscriptionType</form:button>
	   		</tr>
	   	
	   </form:form>
	   
	   <a href="/domain">Domains</a>
    </jsp:body>
</t:pageTemplate>