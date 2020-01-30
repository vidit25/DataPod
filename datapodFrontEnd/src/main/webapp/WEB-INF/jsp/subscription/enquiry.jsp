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
	   			<form:select path="domainId" id="domainIds">
	   					<form:option value="0">Select Domain</form:option>
	   				 <c:forEach var="domain" items="${domains.response}" varStatus="loop">
	        			<form:option value="${domain.id}">${domain.name}</form:option>
	  			 </c:forEach>
	   			</form:select>
	   		</td>
	   	</tr>
	   	<br/>      	<br/>
	   		<tr>
	   		<td>
	   			Subscription Type :
	   		</td>
	   		<td>
	   			<form:select path="subscriptionTypeId" id="subscriptionTypeId">
	   					
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
	   			<form:input path="address.addressLineOne"/>
	   		</td>
	   	</tr>	
	   	<br/>    	<br/>
	   	
	   	<tr>
	   		<td>
	   			Address Line 2 :
	   		</td>
	   		<td>
	   			<form:input path="address.addressLineTwo"/>
	   		</td>
	   	</tr>
	   	<br/>    	<br/>
	   	
	   	<tr>
	   		<td>
	   			City :
	   		</td>
	   		<td>
	   			<form:input path="address.city"/>
	   		</td>
	   	</tr>
	   	
	   	<br/>    	<br/>
	   	<tr>
	   		<td>
	   			State :
	   		</td>
	   		<td>
	   			<form:input path="address.state"/>
	   		</td>
	   	</tr>
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			Country :
	   		</td>
	   		<td>
	   			<form:input path="address.country"/>
	   		</td>
	   	</tr>
	   	<br/>   	<br/>
	   	<tr>
	   		<td>
	   			PinCode :
	   		</td>
	   		<td>
	   			<form:input path="address.pinCode"/>
	   		</td>
	   	</tr>
	   	
	   	<br/>   	<br/>
	   	<form:button value="Submit"> Submit</form:button>
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
             
             $.getJSON("/getSubscriptionType", { domainId: dID },
                     function (data) {
                         var select = $("#subscriptionTypeId");
                         select.empty();
                         select.append($('<option/>', {
                             value: 0,
                             text: "Select a Subscription Type"
                         }));
                         $.each(data.response, function (index, itemData) {
                             select.append($('<option/>', {
                                 value: itemData.id,
                                 text: itemData.name
                             }));
                         });
                     });
         });
});
</script>
