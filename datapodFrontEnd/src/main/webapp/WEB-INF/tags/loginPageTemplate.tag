<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="additionalCss" fragment="true" %>
<%@attribute name="additionalJs" fragment="true" %>

<!DOCTYPE HTML>

<html>
   <head>
      <%@ include file="loginHtmlHead.jspf" %>
   </head>
   
   <body class="subpage">

      <section class="wrapper">
         <div class="inner">
            <jsp:doBody/>
         </div>
      </section>
         
      <%@ include file="footer.jspf" %>
      
      <%@ include file="loginJsFooter.jspf" %>
   </body>
</html>