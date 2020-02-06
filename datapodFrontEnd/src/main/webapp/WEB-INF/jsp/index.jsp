<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:loginPageTemplate>
  
   <jsp:attribute name="additionalJs">
   </jsp:attribute>
   <jsp:body>

	   
	   <div class="login-content">
        <img src="${pageContext.request.contextPath}/static/img/datapod_logo.png" width="250px"/>

        <!-- Login -->
        <div class="nk-block toggled" id="l-login">
            <form:form action="/login" method="POST" modelAttribute="signinForm">
        
            <div class="nk-form">
                <div class="input-group">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-support"></i></span>
                    <div class="nk-int-st">
                        <form:input path="userName" type="text" class="form-control" placeholder="Username"/>
                    </div>
                </div>
                <div class="input-group mg-t-15">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-edit"></i></span>
                    <div class="nk-int-st">
                        <form:password path="password" class="form-control" placeholder="Password"/>
                    </div>
                </div>
                <!-- <div class="fm-checkbox">
                    <label><input type="checkbox" class="i-checks"> <i></i> Keep me signed in</label>
                </div>-->
            	<form:button value="Login" class="btn btn-login btn-success btn-float"><i class="notika-icon notika-right-arrow right-arrow-ant"></i></form:button>
            </div>

             <div class="nk-navigation nk-lg-ic">
                <a href="#" data-ma-action="nk-login-switch" data-ma-block="#l-forget-password"><i>?</i> <span>Forgot Password</span></a>
            </div> 
            </form:form>
            
        </div>

        
    </div>
	   
	   
    </jsp:body>
</t:loginPageTemplate>
