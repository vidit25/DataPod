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
	      <h2>CDE Functional Data : STEP 2</h2>
	   </header>
	    <form:form action="/associateFunctionalData" modelAttribute="functionalDataForm">
	    	<br/>
	    	<br/>
	    	<table style='width:370px;'>
	    	<tr>
	    	<td style='width:160px;'>
	    	<b>Group 1:</b><br/>
	    	<form:select path="sourceDataElementIds" id="sourceDataElementIds" multiple="true">
	   				 <c:forEach var="data" items="${functionalData.response}" varStatus="loop">
	        			<form:option value="${data.id}">${data.title}</form:option>
	  			 </c:forEach>
	   			</form:select>
	   			</td>
	   			
	   			 <td style='width:50px;text-align:center;vertical-align:middle;'>
       				 <form:button id='btnRight' value ='  >  '> > </form:button>
        			<br/><form:button id='btnLeft' value ='  <  '> < </form:button>
   				 </td>
	   				<td style='width:160px;'>
	   				<b>Group 2:</b><br/>
	    			<form:select path="dataElementIds" id="dataElementIds" multiple="true">
	   				
	   				</form:select>
	   			</td>
	   		</tr>	
	   		</table>
	   		<br/>
	   		<br/>
	   		<form:button value="Submit">Associate CDE</form:button>
	    </form:form>
	  
	   
    </jsp:body>
</t:pageTemplate>
<script type="text/javascript">
    $(document).ready(function() {
    $('#btnRight').click(function(e) {
        var selectedOpts = $('#sourceDataElementIds option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#dataElementIds').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#btnLeft').click(function(e) {
        var selectedOpts = $('#dataElementIds option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#sourceDataElementIds').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });
});
</script>