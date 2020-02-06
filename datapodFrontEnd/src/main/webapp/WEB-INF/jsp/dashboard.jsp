<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:pageTemplate> 
  
   <jsp:body>
	   <div class="page-contents page-call-center client-profile">
		<div class="content-header">
			<h1>Dashboard</h1>
		</div>
		<div class="contents">
			<div class="row">
				
				<div class="col-md-6 col-xs-12">
					<div class="content-card">
						<div class="card client-tickets internal-users-card">
							<div class="table table-striped table-highlight tickets-table user-table">
								<div class="tbody">
									<div class="row t-row">
										<div class="t-cells clearfix">
											<div class="td col-md-6"><a href="#">Admin</a></div>
											<div class="td col-md-6">18.123.456-7</div>
											<div class="td col-md-6 strong">Email:</div>
											<div class="td col-md-6">admin@datapod.com</div>
											<div class="td col-md-6 strong">Contact no:</div>
											<div class="td col-md-6">+56987654321</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    </jsp:body>
</t:pageTemplate>
