<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
  
  
   <jsp:body>
	   <header class="align-center">
	      <h2>Subscription List</h2>
	       <style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		</style>
	   </header>
	   
	  <table style="width:100%">
	   <tr>
		    <th>ID</th><th>Name</th><th>status</th> <th>Actions</th>
	   </tr>
	   <c:forEach var="subscription" items="${subscriptions.response}" varStatus="loop">
	        <tr>
		    	<td><a href="/subscriptionDetails/${subscription.id}">${subscription.id}</a></td><td>${subscription.organizationName}</td><td>${subscription.status}</td><td><a href="#" data-subscriptionid="${subscription.id}">ACTIVATE</a></td>
	   		</tr>
	   </c:forEach>
	   </table>
	   
    </jsp:body>
</t:pageTemplate>
<script type="text/javascript">
$(document).ready(function () {
	 $('a').click(function(){
		 var subscriptionId=$(this).data('subscriptionid');
		 $.post('/activate-subscription',  
			        { id: subscriptionId }, 
			        function(data, status, xhr) {
			        
			            //$('p').append('status: ' + status + ', data: ' + data);

			        }).done(function() { alert('Request done!'); })
			        .fail(function(jqxhr, settings, ex) { alert('failed, ' + ex); });
	 });
	
});
</script>