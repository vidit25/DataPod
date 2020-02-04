<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate>
   <jsp:body>
     <br/> <br/>
   		<a href="/">Back to HOME</a>
  <br/> <br/>
	   <header class="align-center">
	      <h2>CDE Functional Data :  STEP 1</h2>
	   </header>
	   
	   <form:form action="/retrieve-functional-data" modelAttribute="functionalDataForm">
	   	
	   	<br/>      	<br/>
	   		<tr>
	   		<td>
	   			Domain :
	   		</td>
	   		<td>
	   			<form:select path="domainId" id="domainIds">
	   					<form:option value="0">Select Domain</form:option>
	   				 <c:forEach var="domain" items="${domains.response}" varStatus="loop">
	        			<form:option value="${domain.id}">${domain.name}</form:option>
	  			 </c:forEach>
	   			</form:select>
	   		</td>
	   	</tr>
	   	
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			Sub Domain :
	   		</td>
	   		<td>
	   			<form:select path="subDomainIds" id="subDomainIds">
	   				 
	   			</form:select>
	   		</td>
	   	</tr>
	   	<br/> <br/>
	   	
	   	<form:button value="Submit"> Continue</form:button>
	   </form:form>
	   
    </jsp:body>
</t:pageTemplate>
<script type="text/javascript">
$(document).ready(function () {
         $("#domainIds").change(function () {
             var dID= $(this).val();             
             $.getJSON("/getSubDomains", { domainId: dID },
                    function (data) {
                        var select = $("#subDomainIds");
                        select.empty();
                        select.append($('<option/>', {
                            value: 0,
                            text: "Select a SubDomain"
                        }));
                        $.each(data.response.subDomains, function (index, itemData) {
                            select.append($('<option/>', {
                                value: itemData.id,
                                text: itemData.name
                            }));
                        });
                    });
             
       
         });
});
</script>
