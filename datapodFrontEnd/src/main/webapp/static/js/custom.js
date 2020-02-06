function changePaymentMethod(index) {
	//$('#order').val(id);
	$('#changePaymentMethodSection_'+index).attr('style','');
	$('#reTryPaymentMethodButton_'+index).attr('style','');
	$('#cancelRetryChange_'+index).attr('style','');
	$('#paymentChangeMethod_'+index).attr('style','display:none');
	//$('#paymentDetailsForm').submit();
}

function enableSubmitRut($this, validr){
	var isValid = true;
	$("#paso2Form").find(".req:enabled").each(function(){
		if($(this).val()==='' || $(this).val()==null)
			isValid = false;
	});
	if (validr == false) {
		isValid = false;
	}
	if(isValid==true){
		$("#paso2Form").find("input[type=submit]").prop("disabled", false);
	}else{
		$("#paso2Form").find("input[type=submit]").prop("disabled", true);
	}
}

function cancelRetryMethod(index) {
	//$('#order').val(id);
	$('#changePaymentMethodSection_'+index).attr('style','display:none');
	$('#reTryPaymentMethodButton_'+index).attr('style','display:none');
	$('#paymentChangeMethod_'+index).attr('style','');
	$('#cancelRetryChange_'+index).attr('style','display:none');
	
	//$('#paymentDetailsForm').submit();
}

function reTryPaymentMethod (index) {
	$('#changePaymentMethodSection_'+index).attr('style','');
	//alert('pgId...' + pgId);
	$('#indexNumber').val(index);
	//$('#paymentGroupId').val(paymentGroupId);
	$('#reTryPaymentForm_'+index).submit();
}

function reverseTransaction (orderId) {
	$('#orderId').val(orderId);
	$('#reverseTransaction').submit();
}

function submitInternalUser() {
	$('#internalUserForm').submit();
}

function isNumberKey(evt) {
	 var charCode = (evt.which) ? evt.which : evt.keyCode;
     if (charCode != 46 && charCode > 31 
       && (charCode < 48 || charCode > 57))
        return false;

     return true;
}

function isDecimalNumberKey(evt) {
	 var charCode = (evt.which) ? evt.which : evt.keyCode;
	 if (charCode == 190) {
		 return true;
	 }
     if (charCode != 46 && charCode > 31 
      && (charCode < 48 || charCode > 57))
       return false;

    return true;
}

function segmentTypeOnChange() {
	var  selectedValue= $("#segmentType").val();
    //alert(selectedValue);
	$("#associateRequest").val(selectedValue);
	$("#createSegmentForm").submit();
    
}

function promotionTypeOnChange() {
	var  selectedValue= $("#promotionType").val();
    //alert(selectedValue);
	$("#promotionTypeRequest").val(selectedValue);
	$("#createPromotionForm").submit();
    
}


function addRequest11() {
	var  selectedValue= $("#segmentType").val();
	$("#addRequest").val(selectedValue);
	$("#createSegmentForm").submit();
    
}

function deleteRequest11(cnt) {
	var  selectedValue= $("#segmentType").val();
	$("#deleteRequest").val(selectedValue);
	$("#removeItemNo").val(cnt);
	$("#createSegmentForm").submit();
    
}



function retrieveSegmentUser(id) {
	 var actionUrl = $('#associateSegmentUserForm').attr("action");
	 var userId = document.getElementById(id).value;
	 actionUrl = actionUrl + "&userId="+userId;
	 $.ajax({
		   type: "post",
		   url: actionUrl,
		   cache: false,    
		   data: $('#associateSegmentUserForm').serialize(),
		   beforeSend : function(){
		    showLoadAnimation();
		   },
		   success: function(data){
		   //alert(JSON.stringify(data));
		    var htmlText = "";
		    if (data.status == 'success') {
		        if (data.userName != null) {
		     		//$('#memberShipId').html(data.memberShipId);
		     		$('#userName').html(data.userName);
		     		
		        } else {
		     		$('#userName').html('User not present');
		        }
		    } else if (data.status == 'error') {
		    	$('#userName').html('User not present');
		 	}
		   },
		   complete: function(){
		    hideLoadAnimation();
		   },
		   error: function(){      
		    alert('Error while request..');
		   }
		  });
}


function deactivateVehicleStatus(){	 
	 var actionUrl = $('#deactivateVehicleForm').attr("action");
	// alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#deactivateVehicleForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 location.reload();
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#de-activate-vehicle-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function activateVehicleStatus(){	 
	 var actionUrl = $('#activateVehicleForm').attr("action");
	// alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#activateVehicleForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 location.reload();
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#activate-vehicle-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function deactivateVehicle(){	 
	 var actionUrl = $('#deactivateVehicleForm').attr("action");
	// alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#deactivateVehicleForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 location.reload();
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#errorMessage').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function controlVehicle(){	 
	 var actionUrl = $('#fleetOperationForm').attr("action");
	 //alert(actionUrl);
	 $('#errorMessage').html('');
	 $('#success-msg').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#fleetOperationForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 htmlText += '<p>' +data.operationType+ ' success!</p>'
				$('#success-msg').html(htmlText);
				 location.reload();
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#errorMessage').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}
function editTripDetails(type) {
    var actionUrl = $('#editTripDetailsForm').attr("action") + "&type=" + type;
    //$('#fleet-message').html('');
    $.ajax({
        type: "post",
        url: actionUrl,
        cache: false,
        data: $('#editTripDetailsForm').serialize(),
        beforeSend : function(){
            showLoadAnimation();
        },
        success: function(data){
            //alert(JSON.stringify(data));
            var htmlText = "";
            if (data.status == 'success') {
                reload();
            } else if (data.status == 'failure') {
                htmlText += '<div class="msg error">';
                htmlText +=	'<p>'+data.errorMessage+'</p>';
                htmlText += '</div>';
                $('#generic-message').html(htmlText);
            }
        },
        complete: function(){
            hideLoadAnimation();
        },
        error: function(){
            alert('Error while request..');
        }
    });
}


function addAdjustments() {
	var actionUrl = $('#adjustmentForm').attr("action");
	 //$('#fleet-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#adjustmentForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 reload();
			 } else if (data.status == 'failure') {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}


function linkFaceBookSocialLogin(){	 
	 var actionUrl = $('#linkSocialLoginForm').attr("action");
	// alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#linkSocialLoginForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //location.reload();
				 $('#unlinkFacebookSocialLogin').removeClass('hide');
		         $('#linkFacebookSocialLogin').addClass('hide');
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error"><p class="title">Oops! Algo salio mal..</p>';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#social-login-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}
function linkSocialLogin(){	 
	 var actionUrl = $('#linkSocialLoginForm').attr("action");
	// alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#linkSocialLoginForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //location.reload();
				 $('#unlinkGoogleAccount').removeClass('hide');
		         $('#linkGoogleAccount').addClass('hide');
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#social-login-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function unLinkGoogleLogin(){	 
	 var actionUrl = $('#unLinkSocialLoginForm').attr("action");
	 $('#unLinkSocialLoginForm').find('#socialSiteName').val('google');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#unLinkSocialLoginForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 $('#unlinkGoogleAccount').addClass('hide');
		         $('#linkGoogleAccount').removeClass('hide');
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#social-login-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function unLinkFacebookLogin(){	 
	 var actionUrl = $('#unLinkSocialLoginForm').attr("action");
	 $('#unLinkSocialLoginForm').find('#socialSiteName').val('facebook');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#unLinkSocialLoginForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //location.reload();
				 $('#unlinkFacebookSocialLogin').addClass('hide');
		         $('#linkFacebookSocialLogin').removeClass('hide');
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#social-login-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
} 
function changeInternalUserPassword(){	 
	 var actionUrl = $('#change-password').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#change-password').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 htmlText += '<div class="msg type-1 success">';
                 htmlText +=	'<p>'+data.message+'</p>';
                 htmlText += '</div>';
                 $('#change-password-message').html(htmlText);
				 $('#changePasswordDivision').css("display", "block");
				 $('#changeProfilePassword').css("display", "none");
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                    for (lJ = 0; lJ < data.errors.length; lJ++) {
                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                    }
                    htmlText += '</div>';
                }
				 $('#change-password-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}
function changePassword(){	 
	 var actionUrl = $('#change-password').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#change-password').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 htmlText += '<div class="msg type-1 success">';
                 htmlText +=	'<p>'+data.message+'</p>';
                 htmlText += '</div>';
                 $('#change-password-message').html(htmlText);
				 $('#changePasswordDivision').css("display", "block");
				 $('#changeProfilePassword').css("display", "none");
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                     for (lJ = 0; lJ < data.errors.length; lJ++) {
                    	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                     }
                     htmlText += '</div>';
                 }
				 $('#change-password-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function changePin(){	 
	 var actionUrl = $('#change-pin').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#change-pin').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 htmlText += '<div class="msg type-1 success">';
                htmlText +=	'<p>'+data.message+'</p>';
                htmlText += '</div>';
                $('#change-password-message').html(htmlText);
				 $('#changePasswordDivision').css("display", "block");
				 $('#changeProfilePin').css("display", "none");
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                    for (lJ = 0; lJ < data.errors.length; lJ++) {
                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                    }
                    htmlText += '</div>';
                }
				 $('#change-password-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function assignMultipleZones(){
    var actionUrl = $('#assignMultipleForm').attr("action");
    $.ajax({
        type: "post",
        url: actionUrl,
        cache: false,
        data: $('#assignMultipleForm').serialize(),
        beforeSend : function(){
            showLoadAnimation();
        },
        success: function(data){
            location.href = "/admin/admin-zones?succes=yes";
        },
        complete: function(){
            hideLoadAnimation();
            location.href = "/admin/admin-zones?succes=yes";
        },
        error: function(){
            location.href = "/admin/admin-zones?succes=no";
        }
    });
}

function updateZoneStatus(status){	 
	 var actionUrl = $('#updateZoneStatus').attr("action");
	 $('#updateZoneStatus').find('#zoneStatus').val(status);
	 if ('ACTIVE' == status) {
		 $('#activate-zone-message').html('');
	 } else if ('DEACTIVE' == status){
		 $('#deActivate-zone-message').html('');
	 }
	 $('#zone-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#updateZoneStatus').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 location.reload();
				 //if ('ACTIVE' == status) {
            		 //$('#activateZoneModalClose').click();
            	 //} else if ('DEACTIVE' == status){
            		// $('#deActivateZoneModalClose').click();
            	 //}
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                    for (lJ = 0; lJ < data.errors.length; lJ++) {
                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                    }
                    htmlText += '</div>';
                 }
				 if ('ACTIVE' == status) {
            		 $('#activate-zone-message').html(htmlText);
            	 } else if ('DEACTIVE' == status){
            		 $('#deActivate-zone-message').html(htmlText);
            	 }
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function updateVehicleStatus(status){	 
	 var actionUrl = $('#updateVehicleStatus').attr("action");
	 $('#updateVehicleStatus').find('#vehicleStatus').val(status);
	 if ('ACTIVE' == status) {
		 $('#activate-vehicle-message').html('');
	 } else if ('DEACTIVE' == status){
		 $('#updateVehicleStatus').find('#listcomment').val($('#vdeactivateVehicleForm').find('#comment').val());
		 $('#deActivate-vehicle-message').html('');
	 }
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#updateVehicleStatus').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 if (data.message != "") {
					 htmlText += '<div class="msg success">';
                  	 htmlText +=	'<p>'+data.message+'</p>';
                     htmlText +=  '</div>';
				 } else {
					 location.reload(); 
				 }
				
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                   for (lJ = 0; lJ < data.errors.length; lJ++) {
                  	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                   }
                   htmlText += '</div>';
                }
				 if ('ACTIVE' == status) {
           		 $('#activate-vehicle-message').html(htmlText);
           	 } else if ('DEACTIVE' == status){
           		 $('#deActivate-vehicle-message').html(htmlText);
           	 }
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function zoneStatusFilter() {
	var lFiltervalue = '';
	$('input[name="filter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	});	
	$('#filterZoneStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}

function vehicleStatusFilter() {
	var lFiltervalue = '';
	$('input[name="filter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	});	
	$('#filterVehicleStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}

function adminUpdatePin(){	 
	 var actionUrl = $('#newPinForm').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#newPinForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			//alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert("true");
				 htmlText += '<div class="msg type-1 success mt15">';
               htmlText +=	'<p>'+data.message+'</p>';
               htmlText += '</div>';
               $('#update-pin-message').html(htmlText);
				 $('#editViewForPin').css("display", "none");
				 $('#detailViewForPin').css("display", "block");
			 } else if (typeof(data.errors) != "undefined") {
				 //alert("wrong");
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                   for (lJ = 0; lJ < data.errors.length; lJ++) {
                  	 htmlText +=	'<p class="title">'+data.errors[lJ]+'</p>';
                   }
                   htmlText += '</div>';
               }
				 $('#update-pin-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function deleteUser(){	 
	 var actionUrl = $('#deleteUser').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#deleteUser').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			//alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert("true");
				 $('#deleteConfirmationModal').modal('hide');
				  //htmlText += '<div class="msg type-1 success mt15">';
	              //htmlText +=	'<p>'+data.message+'</p>';
	              //htmlText += '</div>';
	              $('#successfulClientDeleteModal').modal('show');
			 } else if (typeof(data.errors) != "undefined") {
				// alert("wrong");
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                  for (lJ = 0; lJ < data.errors.length; lJ++) {
                 	 htmlText +=	'<p class="title">'+data.errors[lJ]+'</p>';
                  }
                  htmlText += '</div>';
                  htmlText += '<br>';
              }
				 $('#delete-user').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function resetPassword(){	 
	 var actionUrl = $('#newPasswordForm').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#newPasswordForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			//alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert("true");
				  htmlText += '<div class="msg type-1 success mt15">';
	              htmlText +=	'<p>'+data.message+'</p>';
	              htmlText += '</div>';
	              htmlText += '<br>';
	              $('#update-reset-message').html(htmlText);
	              $('#newPasswordForm').find('#cancel-reset').click();
			 } else if (typeof(data.errors) != "undefined") {
				 //alert("wrong");
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                 for (lJ = 0; lJ < data.errors.length; lJ++) {
                	 htmlText +=	'<p class="title">'+data.errors[lJ]+'</p>';
                 }
                 htmlText += '</div>';
                 htmlText += '<br>';
             }
				 $('#update-reset-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
} 



function addChildMemberShip() {
	$("#addRequest").val('addChildMemberShipSection');
	$("#createMemberShipForm").submit();
}

function modifyMemberShip() {
	$("#modifyRequest").val('modifyMemberShipSection');
	$("#createMemberShipForm").submit();
}

function removeMemberShip(index) {
	$("#removeRequest").val('removeMemberShipSection');
	$("#indexRemove").val(index);
	$("#createMemberShipForm").submit();
}


function rutCustomer(){
	//alert("function called");
	 var actionUrl = $('#rutUserForm').attr("action");
	 //var rutCode = document.getElementById("rutCode").value;
	 //actionUrl = actionUrl + "&rutCode="+rutCode;
	 var status=$('#searchType option:selected').val();
	 //alert("status "+status);
	 if(status =='userId'){
		 var value = $("#rutCode").val();
		 $('#userId1').val(value);
		 $('#rutCode1').val('');
		 $('#emailId1').val('');
		 $('#passport').val('');
		 $('#fname').val('');
		 $('#lname').val('');
	 } else if(status =='email'){
		 var value = $("#rutCode").val();
		 $('#userId1').val('');
		 $('#rutCode1').val('');
		 $('#emailId1').val(value);
		 $('#passport').val('');
		 $('#fname').val('');
		 $('#lname').val('');
	 } else if(status =='rut'){
		 var value = $("#rutCode").val();
		 var formattedRut = jQuery.Rut.formatear(value,true);
		 $('#userId1').val('');
		 $('#rutCode1').val(formattedRut);
		 $('#emailId1').val('');
		 $('#passport').val('');
		 $('#fname').val('');
		 $('#lname').val('');
		
	 } else if(status =='passport'){
		 var value = $("#rutCode").val();
		 $('#userId1').val('');
		 $('#rutCode1').val('');
		 $('#emailId1').val('');
		 $('#passport').val(value);
		 $('#fname').val('');
		 $('#lname').val('');
	 } else if(status =='fname'){
		 var value = $("#rutCode").val();
		 $('#userId1').val('');
		 $('#rutCode1').val('');
		 $('#emailId1').val('');
		 $('#passport').val('');
		 $('#fname').val(value);
		 $('#lname').val('');
	 } else if(status =='lname'){
		 var value = $("#rutCode").val();
		 $('#userId1').val('');
		 $('#rutCode1').val('');
		 $('#emailId1').val('');
		 $('#passport').val('');
		 $('#fname').val('');
		 $('#lname').val(value);
	 }
	 $.ajax({
	   type: "post",
	   url: actionUrl,
	   cache: false,    
	   data: $('#rutUserForm').serialize(),
	   beforeSend : function(){
	    showLoadAnimation();
	   },
	   success: function(data){
	   //alert(JSON.stringify(data));
	    var htmlText = "";
	    if (data.status == 'success') {
	    	if(data.count > 1){
	    		//alert("more than 1");
	    		$('#ticketModal').modal('toggle');
	    		for (var i=0; i<data.length; ++i){
	    			var userId=data.list[i].userId;
	    			var name=data.list[i].name;
	    			var rutNo=data.list[i].rutNo;
	    			htmlText += '<div class="t-row">';
	    			htmlText += '<div><span class="th visible-xs">User Id</span>'+userId+'</div>';
	    			htmlText += '<div><span class="th visible-xs">User Name</span>'+name+'</div>';
	    			htmlText += '<div><a href="javascript:searchCustomerPopUp('+userId+');" id="click"><i class="fa fa-plus-square"></i></a></div>';
	    			htmlText += '</div>';
					$('#ticketList').html(htmlText);
	    		}
	    	} else {
	    		//alert("only 1");
	    		$('#clientID').html(data.userName);
	     		$('#rutClient').val(data.userId);
	    	}
	        /*if (data.userName != null) {
	     		
	        } else {
	     		$('#clientID').html('User not present');
	     		$('#rutClient').val('');
	        }
	        */
	    } else if (data.status == 'error') {
	    	$('#clientID').html('User not present');
	    	$('#rutClient').val('');
	    	//$('#clientID').css('color' , 'red');
	 	}
	   },
	   complete: function(){
	    hideLoadAnimation();
	   },
	   error: function(){      
	    alert('Error while request..');
	   }
	  });
	}


function startTrip() {
	 var actionUrl = $('#startTripForm').attr("action");
	 //var tripId = document.getElementById("tripId").value;
	// alert(actionUrl); 
	 $('#generic-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#startTripForm').serialize(),
		 beforeSend : function(){
			    showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 //htmlText += '<p> Trip Started success!</p>';
				 // $('#startTripSection').attr('style','display:none');
				 // $('#successMessage').html(htmlText);
				 location.reload();
				 
			 } else if (data.status == 'failure' && typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			    hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function getMultipleVehiclesZones(){
    var selectedVehicles = $('#vehicleSelect')[0];
    $('#awtoList')[0].value = "";
    for (var i = 0; i < selectedVehicles.options.length; i++) {
        if(selectedVehicles.options[i].selected == true){
            $('#awtoList')[0].value += selectedVehicles.options[i].value+",";
        }
    }

    var selectedZones = $('#zonesSelect')[0];
    $('#zonesList')[0].value = "";
    for (var i = 0; i < selectedZones.options.length; i++) {
        if(selectedZones.options[i].selected == true){
            $('#zonesList')[0].value += selectedZones.options[i].value+",";
        }
    }
}

function assignZoneToVehicle() {
	$('#mapVehicleZone').submit();	
}
$(document).ready(function(){
	$('#get-all-orders-for-user').submit(function(e){
		e.preventDefault();
		searchPos();
	});
	
	$('#editZonas').on('click', function(){
		$('.operation-card .edit-zone').show();
		$('#editZonas').hide();
	});
	
	$('#cancelBtn').on('click', function(){
		$('.operation-card .assigned-area.type-2').show();
		$('.operation-card .edit-zone').hide();
		$('#editZonas').show();
	});
	$('#searchLocationBtn').on('click', function(){
		var formatAddress = $('#locationSearchInput').val();
		$("#locationRadius").change();
	});
	$('#bt-pp-cancel').on('click', function(){
		$('#confirmPayPalPaymentModal').find('#paypalconfirm').addClass('hide');
	});
	$('#locationSearchForm').submit(function(e){
		e.preventDefault();
	});
	$('#deactivateVehicleForm').submit(function(e){
		e.preventDefault();
		deactivateVehicleStatus();
	});	
	
	$('#membershipPaymentForm').submit(function(e){
		e.preventDefault();
	});
	$('#profileFormFirst').submit(function(e){
		e.preventDefault();
	});
	$('#modifyContactInfo').submit(function(e){
		e.preventDefault();
		modifyUserData();
	});
	$('#dashBoardSearchBoxForm').submit(function(e){
		e.preventDefault();
		performDashBoardSearch();
	});
	$('#confirmVehicleForm').submit(function(e){
		e.preventDefault();
		confirmTripBooking();
	});
	
	
	$('#contactUsForm').submit(function(e){
		e.preventDefault();
		contactUsForm();
	});
	$("#btnChangePin").click(function(){
		$(this).closest(".links").hide();
		$("#changeProfilePin").show();
		$('#change-password-message').html('');
		$('#change-pin').find('#pin').val('');
		$('#change-pin').find('#newPin').val('');
		$('#change-pin').find('#confirmPin').val('');
	});
	$('#rutNo').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#documentSubmit').prop('disabled', true);
			  $('#rutMessage').html('Rut inválido');
			  validrut = false;
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
			  //$('#documentSubmit').prop('disabled', false);
			  validrut = true;
			  enableSubmitRut($(this), true);
		  }, 
		  format_on: 'keyup'
	});
	$('#rutNo').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#documentSubmit').prop('disabled', true);
			  $('#rutMessage').html('Rut inválido');
			  validrut = false;
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
			  //$('#documentSubmit').prop('disabled', false);
			  validrut = true;
			  enableSubmit($(this));
		  }, 
		  format_on: 'keydown'
	});
	
	$('#rutNo').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#documentSubmit').prop('disabled', true);
			  $('#rutMessage').html('Rut inválido');
			  validrut = false;
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
			  //$('#documentSubmit').prop('disabled', false);
			  validrut = true;
			  enableSubmit($(this));
		  }, 
		  format_on: 'keypress'
	});
	$('#rutNumberV').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#rutMessage').html('Rut inválido');
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
		  }, 
		  format_on: 'keyup'
	});
	
	$('#rutNumberVe').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#rutMessage').html('Rut inválido');
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
		  }, 
		  format_on: 'keyup'
	});
	
	$('#rutNumberP').Rut({
		  on_error: function(){ 
			  //alert('Rut incorrecto'); 
			  $('#rutMessage').html('Rut inválido');
			  validrut = false;
		  },
		  on_success: function(){ 
			 // alert('Rut correcto'); 
			  $('#rutMessage').html('');
			  validrut = true;
		  }, 
		  format_on: 'keyup'
	});
	
	$('#modifyProfile').on('click', function(){
        $('#editProfileForm').show();
        $('#editProfileForm input').prop('disabled', false);
        $('#modifyProfile').hide();
        if (typeof($('#memberShipReniewLink')) != "undefined") {
        	$('#memberShipReniewLink').hide();
        }
        $('#profileOverview .profile-info.content-desc').hide();
        $('#profileOverview .select-file a').show();
    })
    $('#editProfileForm .btn-cancel').on('click', function(){
        $('#editProfileForm').hide();
        $('#editProfileForm input').prop('disabled', true);
        $('#modifyProfile').show();
        $('#profileOverview .profile-info.content-desc').show();
        $('#profileOverview .select-file a').hide();
        if (typeof($('#memberShipReniewLink')) != "undefined") {
        	$('#memberShipReniewLink').show();
        }
    })
    
    $(".detail-edit-view #mod-cus").click(function(){
    	if (typeof($('#vdlImgId1')) != "undefined") {
    		$('#dlImgId1').attr('src', $('#vdlImgId1').attr('src'));
    	}
    	if (typeof($('#vdlImgId2')) != "undefined") {
    		$('#dlImgId2').attr('src', $('#vdlImgId2').attr('src'));
    	}
		if (typeof($('#vciImgId1')) != "undefined") {
			$('#ciImgId1').attr('src', $('#vciImgId1').attr('src'));	
		}
		if (typeof($('#vciImgId2')) != "undefined") {
			$('#ciImgId2').attr('src', $('#vciImgId2').attr('src'));
		}
    	$(this).closest(".detail-edit-view").find(".detail-view").hide();
    	$(this).closest(".detail-edit-view").find(".edit-view").show();
    });
	
	$('#carAtt').find(".checkAllCarAttr").click(function(){
		if($(this).is(":checked")){
			$('#carAtt').find(".checkbox-all").find(".carcheckbox input").prop("checked", true);
			$('#carAtt').find(".checkbox-all").find(".carcheckbox").addClass('checked');	
			
		}else{
			$('#carAtt').find(".checkbox-all").find(".carcheckbox input").prop("checked", false);
			$('#carAtt').find(".checkbox-all").find(".carcheckbox").removeClass('checked');
		}
	});

    
	
	
});
function removeDamageReportImage(id) {
  var imageId = $('#removeFileId').val();
  var hideImageId = '#file'+id;
  imageId += id;
  imageId += ':';
  $('#removeFileId').val(imageId);
  $(hideImageId).hide();
}
function addExtraTimeForParkingSlot() {
	var actionUrl = $('#parkingExtraTimeForm').attr("action");
	$('#generic-message').html('');
	$.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#parkingExtraTimeForm').serialize(),
		 beforeSend : function(){
			    showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				reload();				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			    hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
	
}


function addExtraTime() {
	var actionUrl = $('#extraTimeForm').attr("action");
	$('#generic-message').html('');
	$.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#extraTimeForm').serialize(),
		 beforeSend : function(){
			    showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				reload();				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			    hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
	
}


function addEndExtraTime() {
	var actionUrl = $('#endExtraTimeForm').attr("action");
	
	$.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#endExtraTimeForm').serialize(),
		 success: function(data){
			 console.log(JSON.stringify(data));
			 alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 htmlText += '<p> Extra Time added!</p>';
				 //$('#startTripSection').attr('style','display:none');
				 //$('#successMessage').html(htmlText);
				 
			 } /*else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#errorMessage').html(htmlText);
			 } */
		 },
		 complete: function(){
			    hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
	
}

function cancelTrip() {
	 var actionUrl = $('#cancelTripForm').attr("action");
	 //alert(actionUrl);
	 
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#cancelTripForm').serialize(),
		 beforeSend : function(){
			    showLoadAnimation();
		 },
		 success: function(data){
			// console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 // htmlText += '<p> Trip Cancelled successfully!</p>';
				 // $('#startTripSection').attr('style','display:none');
				 //$('#successMessage').html(htmlText);
				 reload();
				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			    hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function onChangeMode() {
    $('#optionOne').toggle();
    $('#optionTwo').toggle();
}

function blockStandByTime(staticStandBy,static,Vvalue) {
	//console.log(static + " : " + Vvalue);
	if(Vvalue != static){
		$('#standByTime').prop('readonly',true);
        $('#standByTime').val(staticStandBy + (static - Vvalue));
	}else{
        $('#standByTime').prop('readonly',false);
	}
}

function completeTrip() {
	 var actionUrl = $('#completeTripForm').attr("action");
	 $('#generic-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#completeTripForm').serialize(),
		 success: function(data){
			var htmlText = "";
			if (data.status == 'failure') {
				if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				}
			} else {
				reload();
			}
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function customStatusFilter() {
	//alert("inside function");
	var lFiltervalue = '';
	$('input[name="filter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	    //alert("filter value.. "+lFiltervalue);
	});	
	$('#filterPropertyName').val('registrationStep');
	$('#filterCustomerStatusCookie').val('ignoreCookie');
	$('#filterCustomerStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}

function ticketStatusFilter() {
	//alert("inside function");
	var lFiltervalue = '';
	$('input[name="ticketFilter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	    //alert("filter value.. "+lFiltervalue);
	});	
	$('#filterTicketStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}

function paymentStatusFilter() {
	//alert("inside function");
	var lFiltervalue = '';
	$('input[name="paymentFilter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	    //alert("filter value.. "+lFiltervalue);
	});
	$('#filterPaymentStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}

function promotionStatusFilter() {
	//alert("inside function");
	var lFiltervalue = '';
	$('input[name="promotionFilter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	    //alert("filter value.. "+lFiltervalue);
	});
	$('#filterPromotionStatus').val(lFiltervalue);
	$('#searchBoxForm').submit();
}


function setFleetInformation(vehicleId, fleetVehicleId, fleetCode) {
	$('#fleetOperationForm').find('#vehicleId').val(vehicleId);
	$('#fleetOperationForm').find('#fleetVehicleId').val(fleetVehicleId);
	$('#fleetOperationForm').find('#operationType').val(fleetCode);
}

function openFleetModal() {	
	$('#fleet-message').html('');
	$('#show-msg').show();
	$('#show-btn').show();
	$('#control-fleet-action').click();
	$('#apply-fleet-modal').click();
}

function fleetControl() {
	var actionUrl = $('#fleetOperationForm').attr("action");
	 $('#fleet-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#fleetOperationForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 $('#show-msg').hide();
				 $('#show-btn').hide();
				 htmlText += '<div class="msg type-1 success">';
				 htmlText += '<p>' +data.operationType+ ' success!</p>'
				 htmlText += '</div>';
				 $('#fleet-message').html(htmlText);
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#fleet-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function finishTrip() {
	 var actionUrl = $('#finishTripForm').attr("action");
	 //alert(actionUrl);
	 $('#finishTripConfirmationModal').find('#finish-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#finishTripForm').serialize(),
		 beforeSend : function(){
			    showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 reload();
				// htmlText += '<p> Trip Cancelled successfully!</p>';
				// $('#finalizeTripId1').attr('style','display:none');
				// $('#successMessage').html(htmlText);
				// $('#tripStatusId').val(data.tripStatus);
				 
			 } else if (data.status == 'failure' && typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#finishTripConfirmationModal').find('#finish-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function reload(){
	location.reload();
}


function reserveCar(object) {
	var htmlText = '';
	var zoneId = $(object).data("zoneid");
	var vehicleId = $(object).data("id");
	var customerFlow = '';
	if (typeof($('#customerFlow')) != "undefined" ) {
		customerFlow = $('#customerFlow').val();
	}
	//alert(vehicleId);
	//alert("zone:"+zoneId);
	if (typeof(vehicleId) != "undefined" && typeof(zoneId) != "undefined") {
		$('#confirmVehicleForm').find('#confirmVehicleId').val(vehicleId);
		$('#confirmVehicleForm').find('#confirmZoneId').val(zoneId);
		if (customerFlow == "customerFlow") {
			$('#verifyPinModal').find('#booking-message').html('');
			$('#pinNum1').val('');
			$('#verifyPinModalId').click();
		} else {
			$('#confirmBookingModal').find('#booking-message').html('');
			$('#confirmBookingModalId').click();
		}
	} else {
		 htmlText += '<div class="msg error">';
		 htmlText +=	'<p>Vehicle id is required</p>';
		 htmlText += '</div>';
		 $('#generic-message').html(htmlText);
	}
	
}
function reserveParking(object) {
	var htmlText = '';
	var zoneId = $(object).data("zoneid");
	//alert("zone:"+zoneId);
	if (typeof(zoneId) != "undefined") {
		$('#reserveParkingSlotForm').find('#reserveZoneId').val(zoneId);
		$('#reserveParkingModalId').click();
	} else {
		 htmlText += '<div class="msg error">';
		 htmlText +=	'<p>Zone id is required</p>';
		 htmlText += '</div>';
		 $('#generic-message').html(htmlText);
	}
	
}
function confirmBooking() {
	var actionUrl = $('#confirmVehicleForm').attr("action");
	 // alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#confirmVehicleForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert(data.redirectUrl);
				 if (typeof(data.redirectUrl) != "undefined" && data.redirectUrl != "") {
					location.href = data.redirectUrl;
				 }
			 } else if (typeof(data.message) != "undefined") {
				 htmlText += '<div class="msg error"><p class="title">Oops! Algo salio mal..</p>';
				 htmlText +=	'<p>'+data.message+'</p>';
				 htmlText += '</div>';
				 $('#confirmBookingModal').find('#booking-message').html(htmlText);
                 $('#generic-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function confirmTripBooking() {
	var actionUrl = $('#confirmVehicleForm').attr("action");
	 // alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#confirmVehicleForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert(data.redirectUrl);
				 if (typeof(data.redirectUrl) != "undefined" && data.redirectUrl != "") {
					location.href = data.redirectUrl;
				 }
			 } else if (typeof(data.message) != "undefined") {
				 htmlText += '<div class="msg error"><p class="title">Oops! Algo salio mal..</p>';
				 htmlText +=	'<p>'+data.message+'</p>';
				 htmlText += '</div>';
				 $('#verifyPinModal').find('#booking-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}




function reserveParkingSlot() {
	var actionUrl = $('#reserveParkingSlotForm').attr("action");
	 // alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#reserveParkingSlotForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert(data.redirectUrl);
				 if (typeof(data.redirectUrl) != "undefined" && data.redirectUrl != "") {
					location.href = data.redirectUrl;
				 }
			 } else if (typeof(data.message) != "undefined") {
				 htmlText += '<div class="msg error"><p class="title">Oops! Algo salio mal..</p>';
				 htmlText +=	'<p>'+data.message+'</p>';
				 htmlText += '</div>';
				 $('#reserveParkingModal').find('#booking-message').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}


function initMapForZone() {
	var addressInput = (document.getElementById('direction'));
	var autocompleteAdd = new google.maps.places.Autocomplete(addressInput);
	var types = 'address';
	var geocoder = new google.maps.Geocoder();
	var map = new google.maps.Map(document.getElementById('createZoneMap'), {
        center: {lat: 52.94742979999999, lng: -106.45114769999998},
        zoom: 13
   });
   
   var marker = new google.maps.Marker({
     map: map
   });
  

	/* Geolocate & Set Locations */
	function getAddress(myLatLng){
		geocoder.geocode({'latLng': myLatLng}, function(results, status){
			if(status == google.maps.GeocoderStatus.OK){
				console.log(results[0]);
				if(results[0]){
					$country = "";
					$state = "";
					$district = "";
					$city = "";
					$subLocality = "";
					$pin = "";
					for (var ac = 0; ac < results[0].address_components.length; ac++) {
						var component = results[0].address_components[ac];
                        switch(component.types[0]) {
                        	case 'country':
                              	$country = component.long_name;
                                break;
                            case 'administrative_area_level_1':
                        		$state = component.long_name;
                                break;
                            case 'administrative_area_level_2':
                        		$district = component.long_name;
                                break;
                            case 'administrative_area_level_3':
                        		$local1 = component.long_name;
                                break;
                        	case 'locality':
                        		$city = component.long_name;
                                break;
                            case 'political':
                        		$subLocality = component.long_name;
                                break;
                            case 'postal_code':
                        		$pin = component.long_name;
                                break;
                        }
					}
					$("#country").val($country);
					$("#state").val($state);
					$("#district").val($district);
					$("#city").val($city);
					$("#subLocality").val($subLocality);
					$("#postal").val($pin);
					$("#direction").val(results[0].formatted_address);
					$('#latitude').val(results[0].geometry.location.lat());
				    $('#longitude').val(results[0].geometry.location.lng());
				    initCreateZoneMap();
				}
			}
		});
	}

	autocompleteAdd.addListener('place_changed', function() {
	    var place = autocompleteAdd.getPlace();
	    if (!place.geometry) {
	      window.alert("Autocomplete's returned place contains no geometry");
	      return;
	    }
      if (place.geometry.viewport) {
        map.fitBounds(place.geometry.viewport);
      } else {
        map.setCenter(place.geometry.location);
        map.setZoom(17);
      }

      // Set the position of the marker using the place ID and location.
      marker.setPlace({
        placeId: place.place_id,
        location: place.geometry.location
      });
      marker.setVisible(true);
      getAddress(place.geometry.location);
	});
}

function customMembershipFilter() {
	//alert("inside function");
	var lFiltervalue = '';
	$('input[name="memebership_filter"]').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	lFiltervalue += $(this).val();
	    	lFiltervalue += ':';
	    } 
	});	
	
	$('#filterMemberShipCookie').val('true');
	$('#filetrMemebrshipValues').val(lFiltervalue);
	$('#filetrMemebrship').val('true');
	$('#searchBoxForm').submit();
}

function processAwtoCredit() {	
	 var actionUrl = $('#rechargeForm').attr("action");
	 //alert(actionUrl);
	 $('#generic-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#rechargeForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //alert(JSON.stringify(data));
			 var paymentType = data.paymentType;
			 var htmlText = "";
			 if (data.success == true) {
				// alert('success'+ JSON.stringify(data));
				 location.reload();				 
			 } else {
				// alert('failure'+ JSON.stringify(data));
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 if ("PAYPAL" == paymentType) {
					 $('#confirmPayPalPaymentModal').find('#pay-pal-message').html(htmlText);
					 //$('#confirmPayPalPaymentModalId').click();
				 } else {
					 $('#generic-message').html(htmlText);
				 }
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function setPaymentMethod(obj) {
	var paymentType  = $(obj).val();
	$('#awtoCreditValidateForm').find('#paymentMethod').val(paymentType);
	
}

function validateAwtoCredit() {
	var amount = $('#rechargeForm').find('#recharge').val();
	var paymentType = '';
	$('.radio').each(function() {
	    if (this.checked) {
	    	//alert($(this).val());
	    	paymentType = $(this).val();
	    } 
	});
	$('#awtoCreditValidateForm').find('#paymentMethod').val(paymentType);
	$('#awtoCreditValidateForm').find('#amount').val(amount);
	$('#confirmPayPalPaymentModal').find('#paypalconfirm').addClass('hide');
	 var actionUrl = $('#awtoCreditValidateForm').attr("action");
	 //alert(actionUrl);
	 $('#generic-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#awtoCreditValidateForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 //alert('success'+ JSON.stringify(data));
				 var payment = data.paymentMethod;
				 if ("PAYPAL" == payment) {
					 $('#confirmPayPalPaymentModal').find('#convertedUSDRate').html(data.convertedCurrencyRateMsg);	
					 $('#confirmPayPalPaymentModal').find('#currentRate').html(data.currentConversionRateMsg);	
					 $('#confirmPayPalPaymentModal').find('#convertedAmount').val(data.convertedCurrencyRate);
					 $('#confirmPayPalPaymentModalId').click();
				 } else if ("ONECLICK" == payment && typeof(data.redirectUrl) != "undefined") {
					 $('#confirmWebPayPaymentModal').find('#webPayconfirmUrl').val(data.redirectUrl);
					 $('#confirmWebPayPaymentModalId').click();
					 //location.href = data.redirectUrl;
				 }				
			 } else {
				 //alert('failure'+ JSON.stringify(data));
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				// var paymentM = data.paymentMethod;
				 //if ("PAYPAL" == paymentM) {
					// $('#confirmPayPalPaymentModal').find('#pay-pal-message').html(htmlText);
					// $('#confirmPayPalPaymentModalId').click();
				 //} else if ("ONECLICK" == payment && typeof(data.redirectUrl) != "undefined") {					 
					// $('#confirmWebPayPaymentModal').find('#webpay-message').html(htmlText);
					// $('#confirmWebPayPaymentModal').find('#webPayconfirmUrl').val(data.redirectUrl);
					// $('#confirmWebPayPaymentModalId').click();
				 //}
				 $('#generic-message').html(htmlText);

				 
				 
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
	
}



function processWebPayAwtoCredit() {
	var url = $('#confirmWebPayPaymentModal').find('#webPayconfirmUrl').val();
	if (typeof(url) != "undefined" && url != ''  ) {
		location.href = url;
	}
}

function customerDashboardStartTrip() {
	 var actionUrl = $('#startTripForm').attr("action");
	 //var tripId = document.getElementById("tripId").value;
	 //alert(actionUrl);
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#startTripForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				 reload();				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic -message').html(htmlText);
			 } 
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function customerDashboardFinishTrip() {
	 var actionUrl = $('#customerDashboardfinishTripForm').attr("action");
	 //alert(actionUrl);
	 $('#finishTripConfirmationModal').find('#finish-message').html('');
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#customerDashboardfinishTripForm').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				reload();				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#finishTripConfirmationModal').find('#finish-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function customerDashboardCancelTrip() {
	 var actionUrl = $('#customerDashboardCancelTrip').attr("action");
	 //alert(actionUrl);
	 
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#customerDashboardCancelTrip').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				reload();
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error">';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function customerCancelTrip() {
	 var actionUrl = $('#customerCancelTrip').attr("action");
	// alert(actionUrl);
	 
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#customerCancelTrip').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			 //console.log(JSON.stringify(data));
			 //alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.status == 'success') {
				reload();				 
			 } else if (typeof(data.errorMessage) != "undefined") {
				 htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
				 htmlText +=	'<p>'+data.errorMessage+'</p>';
				 htmlText += '</div>';
				 $('#cancel-trip-generic-message').html(htmlText);
			 } 
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function deactivateCustomer(){	 
	 var actionUrl = $('#deactivateCustomer').attr("action");
	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#deactivateCustomer').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			//alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 $('#deleteClientDashboardConfirmationModal').modal('hide');
				 htmlText += '<div class="msg type-1 success">';
				 htmlText += '<p class="title">'+data.message+'</p>';
				 htmlText += '</div>';
				 htmlText += '<br/>';
				 $('#showDeactivateMessage').html(htmlText);
				 $('#deactivateCustomerDiv').attr('style','display:none');
			 } else if (typeof(data.errors) != "undefined") {
				// alert("wrong");
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                 for (lJ = 0; lJ < data.errors.length; lJ++) {
                	 htmlText +=	'<p class="title">'+data.errors[lJ]+'</p>';
                 }
                 htmlText += '</div>';
                 htmlText += '<br>';
             }
				 //$('#delete-user').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
}

function purchaseTypeOnChange() {
	var  selectedValue= $("#orderType").val();
    //alert(selectedValue);
	$("#addRequest").val(selectedValue);
	$("#purchaseOrderForm").submit();
    
}

function segmentTypeOnChange() {
	var  selectedValue= $("#segmentType").val();
    //alert(selectedValue);
	$("#associateRequest").val(selectedValue);
	$("#createSegmentForm").submit();
    
}

function addRequest11() {
	var  selectedValue= $("#segmentType").val();
	$("#addRequest").val(selectedValue);
	$("#createSegmentForm").submit();
    
}

function deleteRequest11(cnt) {
	var  selectedValue= $("#segmentType").val();
	$("#deleteRequest").val(selectedValue);
	$("#removeItemNo").val(cnt);
	$("#createSegmentForm").submit();
    
}
/*function retrieveTrip() {
	 var actionUrl = $('#associateTripForm').attr("action");
	 var tripId = document.getElementById("tripId").value;
	 actionUrl = actionUrl + "&tripId="+tripId;
	 $.ajax({
		   type: "post",
		   url: actionUrl,
		   cache: false,    
		   data: $('#associateTripForm').serialize(),
		   beforeSend : function(){
		    showLoadAnimation();
		   },
		   success: function(data){
		   //alert(JSON.stringify(data));
		    var htmlText = "";
		    if (data.status == 'success') {
		        if (data.userName != null) {
		     		$('#tripUserId').html(data.userName);
		     		$('#userType').html(data.userType);
		     		
		        } else {
		     		$('#tripUserId').html('User not present');
		        }
		    } else if (data.status == 'error') {
		    	$('#tripUserId').html('User not present');
		 	}
		   },
		   complete: function(){
		    hideLoadAnimation();
		   },
		   error: function(){      
		    alert('Error while request..');
		   }
		  });
}*/

function retrieveTrip() {
	 var actionUrl = $('#associateTripForm').attr("action");
	 //var tripId = document.getElementById("tripId").value;
	 //actionUrl = actionUrl + "&tripId="+tripId;
	 $('#hiddenTripId').val('');
	 var status=$('#searchType option:selected').val();
	 //alert("status "+status);
	 if(status =='userId'){
		 var value = $("#searchPOTrip").val();
		 $('#userId1').val(value);
		 $('#tripId1').val('');
		 $('#emailId').val('');
	 } else if(status =='trip'){
		 var value = $("#searchPOTrip").val();
		 $('#userId1').val('');
		 $('#tripId1').val(value);
		 $('#emailId').val('');
	 } else if(status =='email'){
		 var value = $("#searchPOTrip").val();
		 $('#userId1').val('');
		 $('#tripId1').val('');
		 $('#emailId').val(value);
	 }
	 $.ajax({
		   type: "post",
		   url: actionUrl,
		   cache: false,    
		   data: $('#associateTripForm').serialize(),
		   beforeSend : function(){
		    showLoadAnimation();
		   },
		   success: function(data){
		   //alert(JSON.stringify(data));
		    var htmlText = "";
		    if (data.status == 'success') {
		    	if(data.count>1){
		    		//alert("more than 1");
		    		$('#tripModel').modal('toggle');
		    		//alert("length "+data.length);
					for (var i=0; i<data.length; ++i){
						var tripId=data.list[i].tripId;
						//alert("trip id"+tripId);
						htmlText += '<div class="t-row">';
						htmlText += '<div><span class="th visible-xs">Trip ID</span>'+tripId+'</div>';
						htmlText += '<div><a href="javascript:retrieveUserData('+tripId+');" id="click"><i class="fa fa-plus-square"></i></a></div>';
						htmlText += '</div>';
						$('#tripList').html(htmlText);
					}
		    	} else{
		    		//alert("only 1");
			    	if (data.userName != null) {
			     		$('#tripUserId').html(data.userName);
			     		$('#userType').html(data.userType);
			     		$('#hiddenTripId').val(data.tripId);
			        } else {
			     		$('#tripUserId').html('User not present');
			     		$('#userType').html('');
			     		$('#hiddenTripId').val('');
			        }
		    	}
		    } else if (data.status == 'error') {
		    	$('#tripUserId').html('User not present');
		    	$('#userType').html('');
		    	$('#hiddenTripId').val('');
		 	}
		   },
		   complete: function(){
		    hideLoadAnimation();
		   },
		   error: function(){      
		    alert('Error while request..');
		   }
		  });
}


function retrieveUser() {
	 var actionUrl = $('#associateUserForm').attr("action");
	 //var tripId = document.getElementById("userId").value;
	 //actionUrl = actionUrl + "&userId="+tripId;
	 var status=$('#searchType option:selected').val();
	 if(status =='userId'){
		 var value = $("#searchUser").val();
		 //alert("value "+value);
		 $('#userId2').val(value);
		 $('#emailId2').val('');
	 } else if(status =='email'){
		 var value = $("#searchUser").val();
		 //alert("value "+value);
		 $('#userId2').val('');
		 $('#emailId2').val(value);
	 }
	 $.ajax({
		   type: "post",
		   url: actionUrl,
		   cache: false,    
		   data: $('#associateUserForm').serialize(),
		   beforeSend : function(){
		    showLoadAnimation();
		   },
		   success: function(data){
		   //alert(JSON.stringify(data));
		    var htmlText = "";
		    if (data.status == 'success') {
		        if (data.memberShipName != null) {
		     		$('#memberShipId').html(data.memberShipId);
		     		$('#memberShipName').html(data.memberShipName);
		     		
		     		$('#tripUserId').html(data.userName);
		     		$('#userType').html(data.userType);
		     		$('#hiddenUserId').val(data.userId);
		     		
		        } else {
		     		$('#memberShipId').html('User not present');
		     		$('#userType').html('');
		     		$('#tripUserId').html('User not present');
		     		$('#hiddenUserId').val('');
		     		$('#memberShipName').html('');
		        }
		    } else if (data.status == 'error') {
		    	$('#memberShipId').html('User not present');
		    	$('#userType').html('');
		    	$('#tripUserId').html('User not present');
		    	$('#hiddenUserId').val('');
		    	$('#memberShipName').html('');
		 	}
		   },
		   complete: function(){
		    hideLoadAnimation();
		   },
		   error: function(){      
		    alert('Error while request..');
		   }
		  });
}

function retrieveMemberShip(id) {
	 var actionUrl = $('#associateSegmentUserForm').attr("action");
	 var userId = document.getElementById(id).value;
	 actionUrl = actionUrl + "&userId="+userId;
	 $.ajax({
		   type: "post",
		   url: actionUrl,
		   cache: false,    
		   data: $('#associateSegmentUserForm').serialize(),
		   beforeSend : function(){
		    showLoadAnimation();
		   },
		   success: function(data){
		   //alert(JSON.stringify(data));
		    var htmlText = "";
		    if (data.status == 'success') {
		        if (data.userName != null) {
		     		//$('#memberShipId').html(data.memberShipId);
		     		$('#userName').html(data.userName);
		     		
		        } else {
		     		$('#userName').html('User not present');
		        }
		    } else if (data.status == 'error') {
		    	$('#userName').html('User not present');
		 	}
		   },
		   complete: function(){
		    hideLoadAnimation();
		   },
		   error: function(){      
		    alert('Error while request..');
		   }
		  });
}


function changePOStatus(id) {
	$('#purchaseOrderId').val(id);
	$('#invoicedForm').submit();
}

function openPaymentDetails(id) {
	$('#order').val(id);
	$('#paymentDetailsForm').submit();
}

function suspendUser(id, orderId) {
	$('#order').val(orderId);
	$('#suspendedUserId').val(id);
	$('#userSuspendedForm').submit();
}

function activateUser(id, orderId) {
	$('#orderActivateUser').val(orderId);
	$('#activateUserId').val(id);
	$('#userActivateForm').submit();
}

function openCalculator() {
	var actionUrl = $('#retrieveCalculatorData').attr("action");
	 
	 $.ajax({
		 type: "get",
		 url: actionUrl,
		 cache: false,    
		 data: $('#retrieveCalculatorData').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(json){
			 console.log(JSON.stringify(json));
			 var htmlText = "";
			 if(json.status=="success"){
					var vechicles = '<option value="" disabled="" selected="">Seleccione</option>';
					var memberships = '<option value="" disabled="" selected="">Seleccione</option>';
					$.each(json.vehicleTpe, function(){
						vechicles = vechicles.concat('<option value="'+this.code+'">'+this.codeValue+'</option>');
					});
					$.each(json.memberShip, function(){
						memberships = memberships.concat('<option value="'+this.membershipId+'">'+this.membershipName+'</option>');
					});
					console.log(vechicles);
					$("#simulatorForm #tipoVehicle").html(vechicles);
					$("#simulatorForm #membership").html(memberships);
				}
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
} 
	 function calculatePricing() {
		 var inUseHrs = document.getElementById('timeHrs').value;
		 var inUseMins = document.getElementById('timeMins').value;
		 var timeParkHrs = document.getElementById('timeParkHrs').value;
		 
		 var timeParkMins = document.getElementById('timeParkMins').value;
		 var kms = document.getElementById('kms').value;
		 var extraCost = document.getElementById('extraCost').value;
		 var tipoVehicle = document.getElementById('tipoVehicle').value;
		 var membership = document.getElementById('membership').value;
		 
		 
		 var actionUrl = $('#calculatePricingCalculator').attr("action");
		 actionUrl = actionUrl + "?timeInUseHoursCal="+inUseHrs;
		 var paramters = "?timeInUseHoursCal="+inUseHrs;
		 paramters = paramters +"&timeInUseMinutesCal="+inUseMins;
		 
		 	
		 $('#membershipIdCal').val(membership);
		 $('#timeInUseHoursCal').val(inUseHrs);
		 $('#timeInUseMinutesCal').val(inUseMins);
		 $('#parkedTimeHoursCal').val(timeParkHrs);
		 $('#parkedTimeMinutesCal').val(timeParkMins);
		 $('#distanceTravelCal').val(kms);
		 $('#vehicleTypeCal').val(tipoVehicle);
		 $('#extraCostCal').val(extraCost);
		
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#calculatePricingCalculator').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(json){
				 console.log(JSON.stringify(json));
				 var htmlText = "";
				 if(json.status=="success") {
					 $("#simulatorForm #totalPriceCal").val(json.totalAmount);
					 
					 $("#simulatorForm #totalPriceCal").html(json.totalAmount);
					}
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
		 
	 }
	 
	 function orderStatusFilter() {
			var lFiltervalue = '';
			$('input[name="filter"]').each(function() {
			    if (this.checked) {
			    	//alert($(this).val());
			    	lFiltervalue += $(this).val();
			    	lFiltervalue += ':';
			    } 
			});	
			$('#filterOrderStatus').val(lFiltervalue);
			$('#searchBoxForm').submit();
	 }

	
	 $("#radioButtonDiscountType input[name='discountType']").change(function(){
		    alert($('input:radio[name=discountType]:checked').val());
		    if ($('input:radio[name=discountType]:checked').val() == "COUPON") {
		    	$('#couponCodeSection').attr('style','');
		    	
		    }
	 });
	 
	 function maintenanceStatusFilter() {
			var lFiltervalue = '';
			$('input[name="filter"]').each(function() {
			    if (this.checked) {
			    	//alert($(this).val());
			    	lFiltervalue += $(this).val();
			    	lFiltervalue += ':';
			    } 
			});	
			$('#filterMaintenanceStatus').val(lFiltervalue);
			$('#searchBoxForm').submit();
		}

	 

	 function applyReferalCouponCode() {
			var actionUrl = $('#referalCouponCodeForm').attr("action");
			 var tripId = document.getElementById("userId").value;
			 actionUrl = actionUrl + "&userId="+tripId;
			 $.ajax({
				   type: "post",
				   url: actionUrl,
				   cache: false,    
				   data: $('#referalCouponCodeForm').serialize(),
				   beforeSend : function(){
				    showLoadAnimation();
				   },
				   success: function(data){
				   //alert(JSON.stringify(data));
				    var htmlText = "";
				    if (data.status == 'success') {
				        if (data.memberShipName != null) {
				     		$('#memberShipId').html(data.memberShipId);
				     		$('#memberShipName').html(data.memberShipName);
				     		
				     		$('#tripUserId').html(data.userName);
				     		$('#userType').html(data.userType);
				     		
				        } else {
				     		$('#memberShipId').html('User not present');
				        }
				    } else if (data.status == 'error') {
				    	$('#memberShipId').html('User not present');
				 	}
				   },
				   complete: function(){
				    hideLoadAnimation();
				   },
				   error: function(){      
				    alert('Error while request..');
				   }
				  });
	 }
	 
	 function tripStatusFilter() {
			var lFiltervalue = '';
			$('input[name="filter"]').each(function() {
			    if (this.checked) {
			    	
			    	lFiltervalue += $(this).val();
			    	lFiltervalue += ':';
			    } 
			});	
			$('#filterTripStatus').val(lFiltervalue);
			$('#searchBoxForm').submit();
		}
	 
	 function reserveTripStatusFilter() {
			var lFiltervalue = '';
			$('input[name="filter"]').each(function() {
			    if (this.checked) {
			    	
			    	lFiltervalue += $(this).val();
			    	lFiltervalue += ':';
			    } 
			});	
			$('#filterReserveTripStatus').val(lFiltervalue);
			$('#searchBoxForm').submit();
		}
	 
	 function invoiceStatusFilter() {
			var lFiltervalue = '';
			$('input[name="filter"]').each(function() {
			    if (this.checked) {
			    	//alert($(this).val());
			    	lFiltervalue += $(this).val();
			    	lFiltervalue += ':';
			    } 
			});	
			$('#filterInvoiceStatus').val(lFiltervalue);
			$('#searchBoxForm').submit();
		}
	 
	 function updateMemberShipPayment(){	 
		 var actionUrl = $('#membershipPaymentForm').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#membershipPaymentForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					if (typeof(data.paymentMethod) != "undefined" 
						&& data.paymentMethod == "ONECLICK" && typeof(data.webPayUrl) != "undefined") {
						location.href = data.oneClickUrl;
					} else {
						reload();
					}
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                }
					 $('#membership-payment-msg').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	 
	function showMemberInfo(obj) {
		//alert($(obj).val());
		var memstandbyId = "#memstandby" + $(obj).val();
		var memusageId = "#memusage" + $(obj).val();
		$('.memusage').each(function() {
			$(this).addClass("hide");
		});
		$('.memstandby').each(function() {
			$(this).addClass("hide");
		});
		$(memusageId).removeClass('hide');
		$(memstandbyId).removeClass('hide');
	}
	
	function performDashBoardSearch(){	 
		 var actionUrl = $('#dashBoardSearchBoxForm').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#dashBoardSearchBoxForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.href = data.redirectUrl;
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function searchDamageReportTrip(){	 
		 //alert("function");
		 var actionUrl = $('#searchTripForm').attr("action");
		 $('#generic-message').html('');
		 var status=$('#searchType option:selected').val();
		 //alert("status "+status);
		 if(status =='userId'){
			 var value = $("#searchTrip").val();
			 $('#userId1').val(value);
			 $('#tripId1').val('');
			 $('#emailId').val('');
		 } else if(status =='trip'){
			 var value = $("#searchTrip").val();
			 $('#userId1').val('');
			 $('#tripId1').val(value);
			 $('#emailId').val('');
		 } else if(status =='email'){
			 var value = $("#searchTrip").val();
			 $('#userId1').val('');
			 $('#tripId1').val('');
			 $('#emailId').val(value);
		 }
		  $.ajax({
				 type: "get",
				 url: actionUrl,
				 cache: false,    
				 data: $('#searchTripForm').serialize(),
				 beforeSend : function(){
					 showLoadAnimation();
				 },
				 success: function(data){
					// alert(JSON.stringify(data));
					 var htmlText = "";
					 if (data.success == true) {
						 if (data.count > 1){
							 //alert("more than 1");
							 $('.damage-trip-modal').modal('toggle');
							 //alert("length "+data.length);
							 for (var i=0; i<data.length; ++i){
								var tripId=data.list[i].tripId;
								//alert("trip id"+tripId);
								htmlText += '<div class="t-row">';
								htmlText += '<div><span class="th visible-xs">Trip ID</span>'+tripId+'</div>';
								htmlText += '<div><a href="javascript:searchTripPopUp('+tripId+');" id="click"><i class="fa fa-plus-square"></i></a></div>';
								htmlText += '</div>';
								$('#tripList').html(htmlText);	
							 }
						 } else {
							 //alert("only 1");
							 $('#damage-report').find('#startDate').val(data.startDate);
							 $('#damage-report').find('#endDate').val(data.endDate);
							 $('#damage-report').find('#customerName').val(data.customerName);
							 $('#damage-report').find('#tId').val(data.tripId);
							 $('#damage-report').find('#userId').val(data.userId);		
						 }
					 } else if (typeof(data.errorMessage) != "undefined") {
						 htmlText += '<div class="msg error">';
						 htmlText +=	'<p>'+data.errorMessage+'</p>';
						 htmlText += '</div>';
						 $('#generic-message').html(htmlText);
						 $('#damage-report').find('#startDate').val('');
						 $('#damage-report').find('#endDate').val('');
						 $('#damage-report').find('#customerName').val('');
						 $('#damage-report').find('#tId').val('');
						 $('#damage-report').find('#userId').val('');	
					 }
				 },
				 complete: function(){
					 hideLoadAnimation();
				 },
				 error: function(){      
					 alert('Error while request..');
				 }
			 });
		 
	}
	
	function searchFuelReportTrip(){	 
		 var actionUrl = $('#searchTripForm').attr("action");
		 $('#generic-message').html('');
		 var status=$('#searchType option:selected').val();
		 //alert("status "+status);
		 if(status =='userId'){
			 var value = $("#searchFuelTrip").val();
			 $('#userId1').val(value);
			 $('#tripId1').val('');
			 $('#emailId').val('');
		 } else if(status =='trip'){
			 var value = $("#searchFuelTrip").val();
			 $('#userId1').val('');
			 $('#tripId1').val(value);
			 $('#emailId').val('');
		 } else if(status =='email'){
			 var value = $("#searchFuelTrip").val();
			 $('#userId1').val('');
			 $('#tripId1').val('');
			 $('#emailId').val(value);
		 }
		 //alert(actionUrl);
		 //alert($('#searchTripForm').serialize());
		 //$('#searchTripForm').find('#tripId').val($('#searchTrip').val());
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#searchTripForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 if (data.count > 1){
						 //alert("more than 1");
						 $('.damage-trip-modal').modal('toggle');
						 //alert("length "+data.length);
						 for (var i=0; i<data.length; ++i){
							 var tripId=data.list[i].tripId;
							 //alert("trip id"+tripId);
							htmlText += '<div class="t-row">';
							htmlText += '<div><span class="th visible-xs">Trip ID</span>'+tripId+'</div>';
							htmlText += '<div><a href="javascript:searchTripPopUp('+tripId+');" id="click"><i class="fa fa-plus-square"></i></a></div>';
							htmlText += '</div>';
							$('#tripList').html(htmlText);
						 }
						 
					 } else {
						 //alert("only 1");
						 $('#fuel-report').find('#startDate').val(data.startDate);
						 $('#fuel-report').find('#customerName').val(data.customerName);
						 $('#fuel-report').find('#tId').val(data.tripId);
						 $('#fuel-report').find('#userId').val(data.userId);
					 }
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
					 $('#fuel-report').find('#startDate').val('');
					 $('#fuel-report').find('#customerName').val('');
					 $('#fuel-report').find('#tId').val('');
					 $('#fuel-report').find('#userId').val('');
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function downLoadInvoice(){	 
		 var actionUrl = $('#downLoadInvoiceForm').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#downLoadInvoiceForm').serialize());
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#downLoadInvoiceForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true && typeof(data.invoicePdfUrl) != "undefined") {
					 window.open(data.invoicePdfUrl, '_blank');					 
				 } else if (typeof(data.errors) != "undefined") {
					if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                }
					$('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	

	function applyReferenceCouponCode() {
		$("#applyReferalCodeAction").val('true');
		$("#referenceCouponCodeForm").submit();
	}
	
	function invoiceOrderBasedOnId(){	 
		 var actionUrl = $('#invoiceOrder').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#invoiceOrder').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function invoiceMembershipBasedOnId(){	 
		 var actionUrl = $('#invoiceMemberShip').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#invoiceMemberShip').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function createTripPoOrderId(){	 
		 var actionUrl = $('#createTripPoOrder').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#createTripPoOrder').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	
	function copyToClipboard(element) {
		  var $temp = $("<input>");
		  $("body").append($temp);
		  $temp.val($(element).val()).select();
		  document.execCommand("copy");
		  $temp.remove();
	}
	
	function contactUsForm(){	 
		 var actionUrl = $('#contactUsForm').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#contactUsForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 $('#contactModal').find('.close').click();
					 $('#contactUsForm').find('#name').val('');
					 $('#contactUsForm').find('#email').val('');
					 $('#contactUsForm').find('#subject').val('');
					 $('#contactUsForm').find('#content').val('');
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                    $('#generic-message').html(htmlText);
	                 }
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}

	function assignZoneModalClose() {
		$('#assignZoneModal').find('#assignZoneModalClose').click();
	}
	
	function vehicleListModalClose() {
		$('#activateVehicleModal').find('#activateVehicleModalClose').click();
	}
	
	function vehicleListDeactivateModalClose() {
		$('#deActivateVehicleModal').find('#deActivateVehicleModalClose').click();
	}
	
	function fleetControlModalClose() {
		$('#fleetControlModal').find('#fleetControlModalClose').click();
	}
	
	function closeVehicleActivate() {
		$('#activateVehicleModal').find('#activateVehicleModalClose').click();
	}
	
	function closeVehicleDeActivate() {
		$('#deActivateVehicleModal').find('#activateVehicleModalClose').click();
	}
	
	function showPostpaidPayment() {
		$('#inputSelectPayment').html('<option value="ONECLICK" selected="true">Webpay - One Click</option>');
	}
	
	function showPrepaidPayment() {
		$('#inputSelectPayment').html('<option value="ONECLICK" selected="true">Webpay - One Click</option><option value="PAYPAL">Pay Pal</option>');
	}
	
	function firstTimeLogin(){	 
		 var actionUrl = $('#profileFormFirst').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 contentType: 'multipart/form-data',
			 cache: false,    
			 data: $('#profileFormFirst').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.href = data.redirectUrl;
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                }
					 $('#first-time-err').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function updateUserStatus(status){	 
		 var actionUrl = $('#updateUserStatus').attr("action");
		 $('#updateUserStatus').find('#usrStatus').val(status);
		 if ('ACTIVE' == status) {
			 $('#activate-user-message').html('');
		 } else if ('REJECTED' == status){
			 $('#deActivate-user-message').html('');
		 }
		 $('#zone-message').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#updateUserStatus').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();
					 
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 if ('ACTIVE' == status) {
	            		 $('#activate-user-message').html(htmlText);
	            	 } else if ('REJECTED' == status){
	            		 $('#deActivate-user-message').html(htmlText);
	            	 }
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	

	
	function updateCusStatus(){	 
		$('#up-user-message').html('');
		var index = $('#confirmModel').val();
		//alert("indexxxx "+index);
		var actionUrl = $('#updateUserStatusForm').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#updateUserStatusForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
					 //location.reload();
					 $('#upConfirmationModal').modal('toggle');
					 $("#regStatus"+index).text(data.message);
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 $('#up-user-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function usrActModalClose() {
		$('#confirmationModal').find('#usrActModalCloseX').click();
	}
	
	function usrRejModalClose() {
		$('#rejectConfirmationModal').find('#usrRejModalCloseX').click();
	}
	
	function usrStaModalClose() {
		$('#upConfirmationModal').find('#usrStaModalCloseX').click();
	}
	
	function applyStatus(obj) {
		$this = $(obj);
		var userId = $this.closest("form").find(".row-uq-id").val();
		var status = $this.closest("form").find(".radio:checked").val();
		//alert(userId);
		//alert("status "+status);
		$('#updateStatusProfileId').val(userId);
		$('#updatedStatus').val(status);
	    $this.closest(".box").hide();
	    $('#upConfirmationModalHref').click();
	}
	
	function upStatus(userId,index) {
		$('#updateStatusProfileId').val(userId);
		//alert("index."+index);
		var idclass = "."+userId;
		var sta = "";
		$(idclass).each(function() {
		    if (this.checked) {
		    	//alert($(this).val());
		    	sta = $(this).val();
		    	//alert("aaa "+sta);
		    } 
		});
		$('#updatedStatus').val(sta);
		$("#box"+index).hide();
		$('#confirmModel').val(index);
	    $('#upConfirmationModalHref').click();
	}
	
	
	function typeUser(obj) {
		var type = $(obj).val();
		if (type == 'Foreign') {
			$('.id-card').hide();
			$('#upCustomer').prop("disabled", false);
		} else {
			$('.id-card').show();			
		}
	}
	
	
	function modifyUserData(){	 
		$('#mgeneric-message').html('');
		$('#rutMessage').html('');
		if (typeof($('#rutNumberP')) != "undefined" && !validrut) {
			$('#rutMessage').html('Rut inválido');
		} else {
			var actionUrl = $('#modifyContactInfo').attr("action");
			 $.ajax({
				 type: "post",
				 url: actionUrl,
				 cache: false,    
				 data: $('#modifyContactInfo').serialize(),
				 beforeSend : function(){
					 showLoadAnimation();
				 },
				 success: function(data){
					 var htmlText = "";
					 if (data.success == true) {
						 if ($('#updateProfileImage').find('#iDFront').val() != "") {
							$('#updateProfileImage').submit();
						 } else {
							 location.reload();
						 }					 
					 } else if (typeof(data.errors) != "undefined") {
						 if (data.errors.length > 0) {
							 htmlText += '<div class="msg error">';
		                    for (lJ = 0; lJ < data.errors.length; lJ++) {
		                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
		                    }
		                    htmlText += '</div>';
		                 }
						 $('#mgeneric-message').html(htmlText);
					 }
				 },
				 complete: function(){
					 hideLoadAnimation();
				 },
				 error: function(){      
					 alert('Error while request..');
				 }
			 });
		}
		
	}
	
	function trCancelModalClose() {
		$('#tripCancelModal').find('#tripCancelModalX').click();
	}
	
	function applyCookieFilter() {
		var customerStatus = $('#cookieForm').find('#cookieCustomerStatus').val();
		var customerStatusPropName = $('#cookieCustomerPropName').find('#cookieCustomerStatus').val();
		var customerMembership = $('#cookieForm').find('#cookieMemebrshipValues').val();
		var apply = false;
		if (typeof(customerStatus) != "undefined" && customerStatus != "") {
			$('#filterCustomerStatus').val(customerStatus);
			apply = true;
		}
		if (typeof(customerMembership) != "undefined" && customerMembership != "") {
			$('#filetrMemebrship').val(true);
			$('#filetrMemebrshipValues').val(customerMembership);
			apply = true;
		}
		if (apply) {
			$('#searchBoxForm').submit();
		}		
	}
	
	function reserveTripRedirect(redirectUri) {
		if (typeof(redirectUri) != "undefined") {
			location.href = redirectUri;
		}
	}
	
	function reniewMembershipCancelModalClose() {
		$('#reniewMembershipCancelModalClose').find('#reniewMembershipCancelModalCloseX').click();
	}
	
	
	function reniewUserMemberShip() {		
		$('#up-reniew-message').html('');
		var actionUrl = $('#reniewMemberShipForm').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#reniewMemberShipForm').serialize(),
			 beforeSend : function(){
				showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error"><p class="title">Oops! Algo salio mal..</p>';
                   	 htmlText +=	'<p>'+data.errorMessage+'</p>';
	                 htmlText += '</div>';
					 $('#up-reniew-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });		
	}
	

	function purchaseOrderStatusUpdate(orderId,index){	 
		 //alert("orderId. "+orderId);
		 //alert("index. "+index);
		 var actionUrl = $('#updatePurchaseOrderStatus').attr("action");
		 $('#orderId').val(orderId);
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#updatePurchaseOrderStatus').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				//alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 //alert("true");
					 $("#changeOrderStatus"+index).text(data.message);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	function migrateUserData(){	 
		 var actionUrl = $('#migrateUser').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false, 
			 async: false,
			 data: $('#migrateUser').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 htmlText += '<div class="msg">';
					 htmlText +=	'<p>User migrated successfully</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function repriceTripInfo(){	 
		 var actionUrl = $('#repriceTrip').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#repriceTrip').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	
	function migrateTripData(){	 
		 var actionUrl = $('#migrateTrip').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,
			 async: false,
			 data: $('#migrateTrip').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 htmlText += '<div class="msg">';
					 htmlText +=	'<p>Trip migrated successfully</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function createPo() {
		location.href = $('#redirectPo').val();
	}
	function getPurchaseOrder(){	 
		 var actionUrl = $('#getPurchaseOrderForm').attr("action");
		 $('#purchaseOrderId').find('#po').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#getPurchaseOrderForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.status == true) {
					 $('#purchaseOrderId').find('#po').html("ID OC: " +data.orderId);
					 $('#purchaseOrderId').removeClass('hide');
					 $('#poupfdid').val(data.orderId);					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText +=	data.errorMessage;
					 $('#purchaseOrderId').find('#po').html(htmlText);
					 $('#purchaseOrderId').removeClass('hide');
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	
	function addPoToFuelReport(){	 
		 var actionUrl = $('#uppotofuel').attr("action");
		 $('#errorMessage').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#uppotofuel').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
					 reload();
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
				 	 $('#errorMessage').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function addPoToDamageReport(){	 
		 var actionUrl = $('#uppotodamage').attr("action");
		 $('#errorMessage').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#uppotodamage').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
					 reload();
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 $('#errorMessage').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	/* Select PO */
	function getSelectedPOOrder(){
		var selectedItems = [];
		$("#modalCreateSingleInvoiceOrder .list-right .item").each(function(){
			selectedItems.push($(this).data("id"));
		});
		$("#selectedSingleInvoiceOrderItems").val(selectedItems.toString());
	}
	
	function searchPos() {
		 var actionUrl = $('#get-all-orders-for-user').attr("action");
		 $('#errorMessage').html('');
		 $('#poItemOrder').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#get-all-orders-for-user').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.status == true) {
                    for (lJ = 0; lJ < data.orders.length; lJ++) {
                    	htmlText += '<span class="item" data-id="'+data.orders[lJ].orderId+'">'+data.orders[lJ].orderId+'('+data.orders[lJ].orderType+')</span>';
                    } 
                    $('#modalCreateSingleInvoiceOrder').find('#poItemOrder').html(htmlText);
                    $('#selectedSingleInvoiceUserId').val($('#get-all-orders-for-user').find('#usId').val());
				 } else if (typeof(data.errorMessage) != "undefined") {
					htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
	                htmlText +=	'<p>'+data.errorMessage+'</p>';	                    
	                htmlText += '</div>';	                 
					$('#errorMessage').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function closePo() {
		$("#modalCreateSingleInvoiceOrder").modal("hide");
	}
	
	function generateSingleInvoice() {
		 var actionUrl = $('#generate-single-invoice').attr("action");
		 $('#errorMessage').html('');
		 getSelectedPOOrder();
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#generate-single-invoice').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
	               reload();
				 } else if (typeof(data.errorMessage) != "undefined") {
				   htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
	               htmlText +=	'<p>'+data.errorMessage+'</p>';	                    
	               htmlText += '</div>';	                 
				   $('#errorMessage').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function retryPaymentInfo(){	 
		 var actionUrl = $('#retryPayment').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#retryPayment').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	
	function migratePoData(){	 
		 var actionUrl = $('#migratePo').attr("action");
		 $('#generic-message').html('');
		 //alert(actionUrl);
		 //alert($('#dashBoardSearchBoxForm').serialize());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,
			 async: false,
			 data: $('#migratePo').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 htmlText += '<div class="msg">';
					 htmlText +=	'<p>PO migrated successfully</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	/*$('#searchType').on('change', function() {
		  alert( this.value );
		  var status = $(this).val();
		  $('#status1').val(status);
	});
	*/
	
	
	function retrieveUserData(tripId){	
		 //var actionUrl = $('#searchTripForm').attr("action");
		 //$('#generic-message').html('');
		//alert("trip id in purchase order>>> "+tripId);
		var actionUrl = $('#associateTripForm').attr("action");
		$('#userId1').val('');
		$('#tripId1').val(tripId);
		$('#emailId').val('');
		$('.damage-trip-modal').modal('toggle');
		$.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#associateTripForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 if (data.status == 'success'){
					 if (data.success == true) {
						 //alert("true");
						 $('#tripUserId').html(data.userName);
				     	 $('#userType').html(data.userType);
				     	 $('#hiddenTripId').val(data.tripId);
					 } else {
				     	 $('#tripUserId').html('User not present');
				     	 $('#hiddenTripId').val('');
				     	 $('#userType').html('');
					 }
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		});
	}
	
	function searchTripPopUp(tripId){	
		 //var actionUrl = $('#searchTripForm').attr("action");
		 //$('#generic-message').html('');
		//alert("trip id>>> "+tripId);
		var actionUrl = $('#searchTripForm').attr("action");
		$('#userId1').val('');
		$('#tripId1').val(tripId);
		$('#emailId').val('');
		$('.damage-trip-modal').modal('toggle');
		$.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#searchTripForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 if (data.success == true) {
					 //alert("true");
					 $('#startDate').val(data.startDate);
					 $('#endDate').val(data.endDate);
					 $('#customerName').val(data.customerName);
					 $('#tId').val(data.tripId);
					 $('#userId').val(data.userId);	
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#generic-message').html(htmlText);
				 }
				 
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		});
	}
	
	
	$('#clearButton').on('click', function(){
		$('#clientID').html('');
		$('#rutCode').val('');
		$('#rutClient').val('');
	})
	
	$("#rutCode").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	rutCustomer();
	    }
	});
	
	$("#searchTrip").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	searchDamageReportTrip();
	    }
	});
	
	$("#searchFuelTrip").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	searchFuelReportTrip();
	    }
	});

	$("#searchUser").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	retrieveUser();
	    }
	});
	
	$("#searchPOTrip").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	retrieveTrip();
	    }
	});
	
	function dropDownChange(){
		//alert("function calling");
		var status = $('#dashBoardSearchBoxForm').find('#searchProperty').val();
		if(status=='customer'){
			status=$('#customerDropdown option:selected').val();
			//alert("status "+status);
			$('#searchProperty1').val('customer.'+status);
		} else if(status=='ticket'){
			status=$('#ticketDropdown option:selected').val();
			//alert("status "+status);
			$('#searchProperty1').val('ticket.'+status);
		} else if(status=='vehicle'){
			status=$('#vehicleDropdown option:selected').val();
			//alert("status "+status);
			$('#searchProperty1').val('vehicle.'+status);
		} else if(status=='zone'){
			status=$('#zoneDropdown option:selected').val();
			//alert("status "+status);
			$('#searchProperty1').val('zone.'+status);
		} else if(status=='trip'){
			status=$('#tripDropdown option:selected').val();
			//alert("status "+status);
			$('#searchProperty1').val('trip.'+status);
		} else if(status=='po'){
			status=$('#poDropdown option:selected').val();
			//alert("status "+status);
			if(status=='date'){
				$('#searchInput').css('display','none');
				$('#dateRange').css('display','block');
				$('#searchInput').css('display','none');
				$('#dateRangeSearchBtn').css('display','block');
				$('#searchInputKeyword').val('0');
			} else {
				$('#searchInput').css('display','block');
				$('#dateRange').css('display','none');
				$('#searchInput').css('display','block');
				$('#dateRangeSearchBtn').css('display','none');
				$('#searchInputKeyword').val('');
			}
			$('#searchProperty1').val('po.'+status);
		} else if(status=='invoice'){
			status=$('#invoiceDropdown option:selected').val();
			//alert("status "+status);
			if(status=='date'){
				$('#searchInput').css('display','none');
				$('#dateRange').css('display','block');
				$('#searchInput').css('display','none');
				$('#dateRangeSearchBtn').css('display','block');
				$('#searchInputKeyword').val('0');
			} else {
				$('#searchInput').css('display','block');
				$('#dateRange').css('display','none');
				$('#searchInput').css('display','block');
				$('#dateRangeSearchBtn').css('display','none');
				$('#searchInputKeyword').val('');
			}
			$('#searchProperty1').val('invoice.'+status);
		} else if(status=='payment'){
			status=$('#paymentDropdown option:selected').val();
			//alert("status "+status);
			if(status=='date'){
				$('#searchInput').css('display','none');
				$('#dateRange').css('display','block');
				$('#searchInput').css('display','none');
				$('#dateRangeSearchBtn').css('display','block');
				$('#searchInputKeyword').val('0');
			} else {
				$('#searchInput').css('display','block');
				$('#dateRange').css('display','none');
				$('#searchInput').css('display','block');
				$('#dateRangeSearchBtn').css('display','none');
				$('#searchInputKeyword').val('');
			}
			$('#searchProperty1').val('payment.'+status);
		}
	}
	
	$(document).on("click", ".custom-select .custom-select-options span", function(){
	    var value = $(this).closest(".custom-select").find(".custom-select-value").val();
	    //alert(value);
	    if(value=='customer'){
	    	$('#customerDiv').css('display','block');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='ticket'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','block');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='vehicle'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','block');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='zone'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','block');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='trip'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','block');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='po'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','block');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='invoice'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','block');
	    	$('#paymentDiv').css('display','none');
	    } else if(value=='payment'){
	    	$('#customerDiv').css('display','none');
	    	$('#ticketDiv').css('display','none');
	    	$('#vehicleDiv').css('display','none');
	    	$('#zoneDiv').css('display','none');
	    	$('#tripDiv').css('display','none');
	    	$('#poDiv').css('display','none');
	    	$('#invoiceDiv').css('display','none');
	    	$('#paymentDiv').css('display','block');
	    }
	});
	
	$("#searchInputKeyword").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	performDashBoardSearch();
	    }
	});
	
	function dateRange(){
		//alert("date range function");
		//var startDate=$('#fromDate').val();
		//var endDate=$('#toDate').val();
		//alert("from date "+startDate);
		//alert("endDate "+endDate);
		//$('#startDateRange').val(startDate);
		//$('#endDateRange').val(endDate);
		$('#searchBoxForm').submit();
		
	}
	
	function dateRangeSearch(){
		performDashBoardSearch();
	}
	
	function searchCustomerPopUp(userId){
		//alert("user id>>> "+userId);
		var actionUrl = $('#rutUserForm').attr("action");
		$('#userId1').val(userId);
		$('#rutCode1').val('');
		$('#emailId1').val('');
		$('#passport').val('');
		$('#ticketModal').modal('toggle');
		$.ajax({
			type: "post",
			   url: actionUrl,
			   cache: false,    
			   data: $('#rutUserForm').serialize(),
			   beforeSend : function(){
			    showLoadAnimation();
			   },
			   success: function(data){
				   var htmlText = "";
				   if (data.status == 'success') {
					   $('#clientID').html(data.userName);
					   $('#rutClient').val(data.userId);
				   } else if (data.status == 'error') {
				    	$('#clientID').html('User not present');
				    	$('#rutClient').val('');
				 	}
				   
			   },
			   complete: function(){
				    hideLoadAnimation();
			   },
			   error: function(){      
			    alert('Error while request..');
			   }
			
		});
		
	}
	
	function renderKm(){	 
		 var actionUrl = $('#simulatorForm').find("#simulatorFormKm").val();
		 var memId = $('#simulatorForm').find("#membership").val();
		 var carType = $('#simulatorForm').find("#tipoVehicle").val();
		 actionUrl =  actionUrl + '?memberShipId=' + memId + "&carType=" + carType; 
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#simulatorForm').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				//alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 $('#simtext').find('#kmval').text(data.perDayKm);
				 } 
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	$("#searchInput").keypress(function(e) {
	    if(e.which == 13) {
	    	e.preventDefault();
	    	rutFormat();
	    }
	});
	
	
	function rutFormat(){
		var searchKeyword=$('#search_keyword').val();
		//alert("search keyword "+searchKeyword);
		if(searchKeyword=='client.rutNo'){
			var rutNo=$('#searchInput').val();
			var formattedRut = jQuery.Rut.formatear(rutNo,true);
			//alert("formatted rut "+formattedRut);
			$('#searchInput').val(formattedRut);
			$('#searchBoxForm').submit();
		} else if(searchKeyword=='rutNo'){
			var rutNo=$('#searchInput').val();
			var formattedRut = jQuery.Rut.formatear(rutNo,true);
			//alert("formatted rut "+formattedRut);
			$('#searchInput').val(formattedRut);
			$('#searchBoxForm').submit();
		} else if(searchKeyword=='awUser.rutNo'){
			var rutNo=$('#searchInput').val();
			var formattedRut = jQuery.Rut.formatear(rutNo,true);
			//alert("formatted rut "+formattedRut);
			$('#searchInput').val(formattedRut);
			$('#searchBoxForm').submit();
		} else if(searchKeyword=='awUser.rutNo'){
			var rutNo=$('#searchInput').val();
			var formattedRut = jQuery.Rut.formatear(rutNo,true);
			//alert("formatted rut "+formattedRut);
			$('#searchInput').val(formattedRut);
			$('#searchBoxForm').submit();
		} else {
			$('#searchBoxForm').submit();
		}
	}
	
	function showFleetDetail(id) {		
		 var actionUrl = $('#fchd').val()+ "?id=" + id;
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 //alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {					 
					 if (typeof(data.fleetCommunications) != "undefined" && data.fleetCommunications.length > 0) {
						 for (lI = 0; lI < data.fleetCommunications.length; lI++) {
							 $('#detailsModal').find('#fleet-cmd-id').html(data.fleetCommunications[lI].id);
							 $('#detailsModal').find('#fstartD').html(data.fleetCommunications[lI].startDate);
							 $('#detailsModal').find('#fcmd').html(data.fleetCommunications[lI].operationType);
							 $('#detailsModal').find('#fendD').html(data.fleetCommunications[lI].endDate);
							 $('#detailsModal').find('#fcode').html(data.fleetCommunications[lI].code);
							 $('#detailsModal').find('#forigin').html(data.fleetCommunications[lI].origin);
							 $('#detailsModal').find('#fuser').html(data.fleetCommunications[lI].userName);							 
							 
						 }						 
					 }
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                    $('#detailsModal').find('#gen-msg').html(htmlText);
					}
				}
				$('#detailsModal').modal();
				 
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
		
	
	function fleetComSearch() {
		var actionUrl = $('#fch').attr("action");
		$('#moreInfoModal').find('#gen-msg').html("");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#fch').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 //alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {					 
					 if (typeof(data.fleetCommunications) != "undefined" && data.fleetCommunications.length > 0) {
						 for (lI = 0; lI < data.fleetCommunications.length; lI++) {
							 htmlText += '<div class="t-row">';
			                   	htmlText += '<div class="tb-data">';
			                   	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'Shipping';
			                   	htmlText += '</span>';
			                	htmlText +=  data.fleetCommunications[lI].startDate;
			                   	htmlText +=	'</div>';
			                   	htmlText += '<div class="tb-data">';
			                   	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'Command';
			                   	htmlText += '</span>';
			                   	htmlText += '<span>';
			                	htmlText +=  data.fleetCommunications[lI].operationType;
			                	htmlText += '</span>';
			                   	htmlText +=	'</div>';
			                   	htmlText += '<div class="tb-data">';
			                   	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'Answer';
			                   	htmlText += '</span>';
			                	htmlText +=  data.fleetCommunications[lI].endDate;
			                   	htmlText +=	'</div>';
			                	htmlText += '<div class="tb-data">';
			                	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'Code';
			                   	htmlText += '</span>';
			                	htmlText +=  data.fleetCommunications[lI].code;
			                   	htmlText +=	'</div>';
			                   	htmlText += '<div class="tb-data">';
			                   	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'Origin';
			                   	htmlText += '</span>';
			                	htmlText +=  data.fleetCommunications[lI].origin;
			                   	htmlText +=	'</div>';
			                   	htmlText += '<div class="tb-data">';
			                   	htmlText += '<span class="visible-xs th">';
			                   	htmlText += 'User';
			                   	htmlText += '</span>';
			                	htmlText +=  data.fleetCommunications[lI].userName;
			                   	htmlText +=	'</div>';
			                	htmlText +=	'</div>';
		                 }
						 $('#moreInfoModal').find('#fleet-communication-info').html(htmlText);
						 if (typeof(data.pagination) != "undefined" && data.pagination  != "") {
							 $('#moreInfoModal').find('#pagnation').html(data.pagination); 
						 }
					 }
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                    $('#moreInfoModal').find('#gen-msg').html(htmlText);
					}
				}
				$('#moreInfoModal').modal();
				 
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function getHistory(pageNum) {
		if (typeof(pageNum) != "undefined") {
			$('#fch').find('#pg-num').val(pageNum);
			fleetComSearch();
		}		
	}
	
	function validatePromCode() {
		var data = $('#discountType').val();
		if (typeof(data) != "undefined") {
			if (data == "GLOBAL") {
				$('#couponCode').attr("disabled", true);
                if($('#selectedSegmentItems')[0].value == "") {
                    document.getElementById('submitPromotionBtn').disabled = true;
                }
			} else {
				$('#couponCode').attr("disabled", false);
                document.getElementById('submitPromotionBtn').disabled = false;
			}
		}
	}

	function updatePOStatus(poStatus){
		//alert(poStatus);
		var actionUrl = $('#updatePurchaseOrderStatus').attr("action");
		$('#postatus').val(poStatus);
		$.ajax({
			type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#updatePurchaseOrderStatus').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 if (data.success == true) {
					 location.reload();
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
			 
		});
		
	}
	
	function releaseParkingSlot(parkingId){
		var actionUrl = $('#releaseParkingSlot').attr("action");
		$('#parkingId').val(parkingId);
		$.ajax({
			type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#releaseParkingSlot').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 if (data.success == true) {
					 location.reload();
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						var htmlText = '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                    $('#gen-msg').html(htmlText);
					 }
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
			 
		});
		
	}
	
	
	function startCustomerTripWithoutDamage() {
		 var actionUrl = $('#startTripForm').attr("action");
		 //var tripId = document.getElementById("tripId").value;
		// alert(actionUrl); 
		 $('#sgeneric-message').html('');
		 $('#startTripForm').find('#observation').val('');		 
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#startTripForm').serialize(),
			 beforeSend : function(){
				    showLoadAnimation();
			 },
			 success: function(data){
				 //console.log(JSON.stringify(data));
				 //alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.status == 'success') {
					 //htmlText += '<p> Trip Started success!</p>';
					 // $('#startTripSection').attr('style','display:none');
					 // $('#successMessage').html(htmlText);
					 location.reload();
					 
				 } else if (data.status == 'failure' && typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#sgeneric-message').html(htmlText);
				 } 
			 },
			 complete: function(){
				    hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	function startCustomerTrip() {
		 var comment = $('#damageForm').find('#comment').val();
		 if (comment == "" || comment == " ") {
			 var ehtmlText = '<div class="msg error">';
			 ehtmlText +=	'<p>Por favor ingrese el comentario</p>';
			 ehtmlText += '</div>';
			 $('#sgeneric-message').html(ehtmlText);
		 } else {
			 var actionUrl = $('#startTripForm').attr("action");
			 //var tripId = document.getElementById("tripId").value;
			 // alert(actionUrl); 
			 $('#sgeneric-message').html('');
			 $('#startTripForm').find('#observation').val($('#damageForm').find('#comment').val());		 
			 $.ajax({
				 type: "post",
				 url: actionUrl,
				 cache: false,    
				 data: $('#startTripForm').serialize(),
				 beforeSend : function(){
					    showLoadAnimation();
				 },
				 success: function(data){
					 //console.log(JSON.stringify(data));
					 //alert(JSON.stringify(data));
					 var htmlText = "";
					 if (data.status == 'success') {
						 //htmlText += '<p> Trip Started success!</p>';
						 // $('#startTripSection').attr('style','display:none');
						 // $('#successMessage').html(htmlText);
						 location.reload();
						 
					 } else if (data.status == 'failure' && typeof(data.errorMessage) != "undefined") {
						 htmlText += '<div class="msg error">';
						 htmlText +=	'<p>'+data.errorMessage+'</p>';
						 htmlText += '</div>';
						 $('#sgeneric-message').html(htmlText);
					 } 
				 },
				 complete: function(){
					    hideLoadAnimation();
				 },
				 error: function(){      
					 alert('Error while request..');
				 }
			 });
		 }
		
		 
	}
	
	
	
	function addVehicleData() {
		var status = $('#addVehicle').find('#vehicleCurrentStatus').val();
		if (status != undefined && status == 'DEACTIVE') {
			$('#deActivateVehicleModal').modal();
		} else {
			$('#addVehicle').submit();
		}
	}
	
	function updateVehicleData() {
		var status = $('#newVechicleForm').find('#vehicleCurrentStatus').val();
		if (status != undefined && status == 'DEACTIVE') {
			$('#deActivateVehicleModalX').modal();
		} else {
			$('#newVechicleForm').submit();
		}
	}
	
	function deactivateVehicleComment() {
		var comment = $('#deactivateCommentForm').find('#comment').val();
		$('#newVechicleForm').find('#deactive-comment').val(comment);
		$('#newVechicleForm').submit();
	}
	
	function addDeactivateVehicleComment() {
		var comment = $('#deactivateCommentForm').find('#comment').val();
		$('#addVehicle').find('#deactive-comment').val(comment);
		$('#addVehicle').submit();
	}
	
	function deactivateVehicleX() {
		$('#deActivateVehicleModal').modal();
	}
	
	function showZoneMoreInfo(zoneId) {
		 var actionUrl = $('#zoneInfoForm').attr("action");
		 //alert(actionUrl);
		 actionUrl = actionUrl + '&zoneId=' + zoneId;
		 
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#zoneInfoForm').serialize(),
			 beforeSend : function(){
				    showLoadAnimation();
			 },
			 success: function(data){
				// console.log(JSON.stringify(data));
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.status == 'success') {
					 if (typeof(data.zoneInfo.imageUrl) != "undefined") {
						 htmlText += '<img src="' + data.zoneInfo.imageUrl + '" title="'+data.zoneInfo.imageUrl+'" alt="'+data.zoneInfo.imageUrl+'" />';
						 $('#showZoneMoreInfo').find('#zoneImg').html(htmlText);
					 }
					 if (typeof(data.zoneInfo.description) != "undefined") {
						 $('#showZoneMoreInfo').find('#zoneDes').html(data.zoneInfo.description);
					 }
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#zgeneric-message').html(htmlText);
				 } 
				 $('#showZoneMoreInfo').modal();
			 },
			 complete: function(){
				    hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function cancelParkingSlot() {
		 var actionUrl = $('#cancelParkingSlot').attr("action");
		 //alert(actionUrl);
		 
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#cancelParkingSlot').serialize(),
			 beforeSend : function(){
				    showLoadAnimation();
			 },
			 success: function(data){
				// console.log(JSON.stringify(data));
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.status == 'success') {
					 // htmlText += '<p> Trip Cancelled successfully!</p>';
					 // $('#startTripSection').attr('style','display:none');
					 //$('#successMessage').html(htmlText);
					 reload();
					 
				 } else if (typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#cpgeneric-message').html(htmlText);
				 } 
			 },
			 complete: function(){
				    hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function updateOneClickPayment(){	 
		 var actionUrl = $('#re-authorize-webpay-form').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#re-authorize-webpay-form').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					if (typeof(data.paymentMethod) != "undefined" 
						&& data.paymentMethod == "ONECLICK" && typeof(data.webPayUrl) != "undefined") {
						location.href = data.oneClickUrl;
					} else {
						reload();
					}
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                }
					 $('#re-authorize-webpay-msg').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}

	
	
	
	
	

	
	function deleteSegment(){	 
		$('#deActivate-Segment-message').html('');
		var actionUrl = $('#deleteSegment').attr("action");
		var pageUrl = $('#pageUrl').val();
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#deleteSegment').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
					 //location.reload();
					 location.href = pageUrl;
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 $('#deActivate-Segment-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function updateGroupStatus(status){	 
		 var actionUrl = $('#groupStatus').attr("action");
		 $('#groupStatus').find('#groupStatus').val(status);
		 if ('ACTIVE' == status) {
			 $('#activate-group-message').html('');
		 } else if ('DEACTIVE' == status){
			 $('#deActivate-group-message').html('');
		 }
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#groupStatus').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();
					
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 if ('ACTIVE' == status) {
	            		 $('#activate-group-message').html(htmlText);
	            	 } else if ('DEACTIVE' == status){
	            		 $('#deActivate-group-message').html(htmlText);
	            	 }
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function deleteMemberShip() {
		 var actionUrl = $('#process-membership-delete').attr("action");
	 	 $.ajax({
		 type: "post",
		 url: actionUrl,
		 cache: false,    
		 data: $('#process-membership-delete').serialize(),
		 beforeSend : function(){
			 showLoadAnimation();
		 },
		 success: function(data){
			// alert(JSON.stringify(data));
			 var htmlText = "";
			 if (data.success == true) {
				 if (data.userAssociated == true && typeof(data.userInfo) != "undefined") {
	                   for (lI = 0; lI < data.userInfo.length; lI++) {
	                	 htmlText += '<div class="t-row">';
	  					 htmlText += '<div><span class="visible-xs th">Nombre</span><span>';
	  					 htmlText += data.userInfo[lI].firstName + " " + data.userInfo[lI].lastName;
	  					 htmlText += '</span></div>';
	  					 htmlText += '<div><span class="visible-xs th">Email</span><span>';
	  					 htmlText += data.userInfo[lI].emailAddress;
	  					 htmlText += '</span></div>';
	  					 htmlText += '<div><span class="visible-xs th">Telefono</span><span>';
	  					 htmlText += data.userInfo[lI].mobileNo;
	  					 htmlText += '</span></div>';
	  					 htmlText += '</div>';
	                   }	
	                   if ( typeof(data.pagination) != "undefined") {
	                	   $('#mem-pagination').html(data.pagination);
	                   }	
	                   $('#meminfo').find('#current-membership-name').html(data.currentMemberShip.membershipName);
	                   var newMemberShipHtml = '';
	                   if (typeof(data.memberShips) != "undefined") {
	                	   newMemberShipHtml += '<select class="form-control select valid" id="newMemId" name="newMemId" required="" aria-required="true" aria-invalid="false" style="color: rgb(129, 129, 129);">';
	      				   if (data.memberShips.length > 0) {
	      					   for (lK = 0; lK < data.memberShips.length; lK++) {
	      						 newMemberShipHtml += '<option value="'+data.memberShips[lK].membershipId+'">'+data.memberShips[lK].membershipName+'</option>';
	      					   }
	      				   }
	      				 newMemberShipHtml += '</select>';
	                   }
	                   $('#meminfo').find('#select-new-member').html(newMemberShipHtml);
	                   $('#mem-user-list').html(htmlText);
	                   $('#deativeMemModal').modal();
				 } else {
					 $('#delMemModal').modal();
				 }
				
			 } else if (typeof(data.errors) != "undefined") {
				 if (data.errors.length > 0) {
					 htmlText += '<div class="msg error">';
                   for (lJ = 0; lJ < data.errors.length; lJ++) {
                  	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
                   }
                   htmlText += '</div>';
                }
           		$('#mem-error').html(htmlText);
			 }
		 },
		 complete: function(){
			 hideLoadAnimation();
		 },
		 error: function(){      
			 alert('Error while request..');
		 }
	 });
	}
	
	function deleteMembershipData() {
		 var actionUrl = $('#delete-membership').attr("action");
		 var contextPath = $('#delete-membership').find("#contextPath").val();
		 $('#delete-membership').find('#newMemberId').val($('#meminfo').find('#newMemId').val());
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#delete-membership').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();					
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
            		 $('#mem-error').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function deleteMembershipDataInfo() {
		$('#delete-membership').find('#newMemberId').val('');
		$('#delete-membership').find('#newMemberId').val('');
		 var actionUrl = $('#delete-membership').attr("action");
		 var contextPath = $('#delete-membership').find("#contextPath").val();
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#delete-membership').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();					
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
           		 $('#delete-mem-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function activateMemberShip() {
		 var actionUrl = $('#active-membership').attr("action");
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#active-membership').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();					
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 $('#active-mem-message').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function getUserData(pageNum) {
		if (typeof(pageNum) != "undefined") {
			$('#process-membership-delete').find('#pageNum').val(pageNum);
			deleteMemberShip();
		}	
	}
	
	function deleteCarAttribute(id) {
		var actionUrl = $('#delete-car-attribute').attr("action");
		$('#delete-car-attribute').find('#attributeId').val(id);
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#delete-car-attribute').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				// alert(JSON.stringify(data));
				 var htmlText = "";
				 if (data.success == true) {
					 location.reload();					
				 } else if (typeof(data.errors) != "undefined") {
					 if (data.errors.length > 0) {
						 htmlText += '<div class="msg error">';
	                    for (lJ = 0; lJ < data.errors.length; lJ++) {
	                   	 htmlText +=	'<p>'+data.errors[lJ]+'</p>';
	                    }
	                    htmlText += '</div>';
	                 }
					 $('#car-attr-msg').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function searchUserInfo(obj) {
		//if (typeof($('#ser').val()) != "undefined" && $('#ser').val() != "") {
			$('#searchUserI').find('#searchValue').val($('#ser').val());
			if (typeof($('#selectedUserItems')) != "undefined") {
				 $('#searchUserI').find('#selectedIds').val($('#selectedUserItems').val());
			}
			loadNextUser(1);
		//}	
	}
	
	function loadNextUser(pageNumber) {	
		 getSelectedUsers();
		 var actionUrl = $('#searchUserI').attr("action");
		 $('#searchUserI').find('#pageNumber').val(pageNumber);
		 if (typeof($('#selectedUserItems')) != "undefined") {
			 $('#searchUserI').find('#selectedIds').val($('#selectedUserItems').val());
		 }
		 $.ajax({
			 type: "get",
			 url: actionUrl,
			 cache: false,    
			 data: $('#searchUserI').serialize(),
			 beforeSend : function(){
				 showLoadAnimation();
			 },
			 success: function(data){
				 var htmlText = "";
				 if (data.success == true) {
                   for (lJ = 0; lJ < data.userInfos.length; lJ++) {
                   	htmlText += '<span class="item" data-id="'+data.userInfos[lJ].userId+'">'+data.userInfos[lJ].firstName+' '+data.userInfos[lJ].lastName+'('+data.userInfos[lJ].emailAddress+')</span>';
                   } 
                   $('#modalAddUsers').find('#userItemInfo').html(htmlText);
                   if (typeof(data.pagination) != "undefined") {
                       $('#modalAddUsers').find('#paginationInfo').html(data.pagination);                   
                   }
				 } else if (typeof(data.errorMessage) != "undefined") {
					htmlText += '<div class="msg error"><p class="title">Ops!  Algo salió mal..</p>';
	                htmlText +=	'<p>'+data.errorMessage+'</p>';	                    
	                htmlText += '</div>';	                 
					$('#errorMessage').html(htmlText);
				 }
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
		
	}
	
	
	function forceTrip() {
		 var actionUrl = $('#forceTripForm').attr("action");
		 //alert(actionUrl);
		 $('#forceTripConfirmationModal').find('#finish-message').html('');
		 $.ajax({
			 type: "post",
			 url: actionUrl,
			 cache: false,    
			 data: $('#forceTripForm').serialize(),
			 beforeSend : function(){
				    showLoadAnimation();
			 },
			 success: function(data){
				var htmlText = "";
				 if (data.status == 'success') {
					 reload();
				 } else if (data.status == 'failure' && typeof(data.errorMessage) != "undefined") {
					 htmlText += '<div class="msg error">';
					 htmlText +=	'<p>'+data.errorMessage+'</p>';
					 htmlText += '</div>';
					 $('#forceTripConfirmationModal').find('#finish-message').html(htmlText);
				 } 
			 },
			 complete: function(){
				 hideLoadAnimation();
			 },
			 error: function(){      
				 alert('Error while request..');
			 }
		 });
	}
	
	function checkTerms() {
		var checkT = false;
		$('input[name="input_checkbox"]').each(function() {
		    if (this.checked) {
		    	checkT = true;
		    } 
		});
		if (checkT) {
			$('#transBankForm').submit();
		} else {
			$('#errorMsg').css("display","block");
		}
		
	}
