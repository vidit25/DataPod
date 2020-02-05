<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="additionalCss" fragment="true" %>
<%@attribute name="additionalJs" fragment="true" %>

<!DOCTYPE HTML>

<html>
   <head>
      <%@ include file="htmlHead.jspf" %>
   </head>
   
   <body class="subpage">
	<div id="wrapper" class="console">
		<div class="container page-container">
			<%@ include file="sideMenu.jspf" %>
			<div class="content-panel">
			<!-- BEGIN HEADER -->
			<header class="header hidden-xs clearfix">
				<div class="toggle-sidemenu">
					<a href="javascript:;" class="btn-toggle-sidemenu"><i class="fa fa-bars"></i></a>
				</div>
				
				<div class="header-btn user-btn">
					<a href="#" class="btn-user">Datapod admin<i class="fa fa-ellipsis-v"></i></a>
				</div>
			</header>			
            <jsp:doBody/>
            </div>
         </div>
     </div>
         
      <%@ include file="footer.jspf" %>
      
      <%@ include file="jsFooter.jspf" %>
   </body>
</html>