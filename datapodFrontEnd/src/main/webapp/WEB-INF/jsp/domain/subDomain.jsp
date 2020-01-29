<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
  
  
   <jsp:body>
	   <header class="align-center">
	      <h2>Sub Domain Screen</h2>
	   </header>
	   <%-- <table style="width:100%">
	   <tr>
		    <th>ID</th><th>Name</th><th>Description</th>
	   </tr>
	   <c:forEach var="domain" items="${response.response}" varStatus="loop">
	        <tr>
		    	<th><a href="#">${domain.id}</a></th><th>${domain.name}</th><th>${domain.description}</th>
	   		</tr>
	   </c:forEach>
	   </table> --%>
	   <%-- <form:form action="/domain" method="GET" modelAttribute="domains">
	   		<tr>
	   			<c:out value="${domains.response}"></c:out>
	   		</tr>
	   		<br/>
	   		<tr>
	   			<form:button value="Domain" >Get Domains</form:button>
	   		</tr>
	   	
	   </form:form> --%>
    </jsp:body>
</t:pageTemplate>
