
/* Main Menu */
var validrut = false;

$(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).fadeIn("fast");
            $(this).toggleClass('open');           
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).fadeOut("fast");
            $(this).toggleClass('open');              
        });
});

/* Select Style */
$(document).on('change', '.select', function(){
	$(this).css({'color': '#444'});
});

$(document).ready(function(){
	$(".console .select").each(function(){
		if($(this).val()!=null){
			$(this).css("color", "818181");
		}
	});
});

/* Checkbox Style */
$(".checkbox input").click(function(){
	if($(this).is(':checked')) {
		$(this).closest('.checkbox').addClass("checked");
		if($(this).closest(".t-row").length){
			$(this).closest(".t-row").addClass("checked-row");
		}
	}else{
		$(this).closest('.checkbox').removeClass("checked");
		if($(this).closest(".t-row").length){
			$(this).closest(".t-row").removeClass("checked-row");
		}
	}
});

/* Custom Select */
$(document).on("click", ".custom-select .custom-select-input", function(){
	$(this).closest(".custom-select").find(".custom-select-options").toggle();
});

$(document).on("click", ".custom-select .custom-select-options span", function(){
	$(this).closest(".custom-select").find(".custom-select-input span").text($(this).text());
	$(this).closest(".custom-select").find(".custom-select-value").val($(this).data("value"));
	$(this).closest(".custom-select").find(".custom-select-options").hide();
});

$(document).mouseup(function(e){
	var container = $(".custom-select");

	if (!container.is(e.target) // if the target of the click isn't the container...
		&& container.has(e.target).length === 0) // ... nor a descendant of the container
	{
		$(".custom-select .custom-select-options").hide();
	}
});


/* File Uploader */
$(".btn-browse").click(function(){
	$(this).closest(".file-uploader").find(".file-input").click();
});


/* Upload Identification Documents */
$(document).on("change", ".upload-docs .file-input.prev", function(e){
	var $this = $(this);
	var ext = $this.val().split('.').pop().toLowerCase();
	if($.inArray(ext, ['png','jpg','jpeg']) == -1){
	    alert("Formato de archivo no permitido.");
	}else{
	    if(this.files && this.files[0]){
			showLoadAnimation();
			var file = this.files[0];
			new ImageCompressor(file, {
				quality: .5,
				success: function(result){
					var removeBtn = '<div class="remove-file"><i class="fa fa-times"></i><a href="javascript:;" class="btn-remove">Eliminar imagen</a></div>';
					var previewImg = '<img src="" class="preview">';
					
					var reader = new FileReader();
					reader.onload = function(e){
						$this.closest(".file-uploader").find(".img-preview .sample").hide();
						$this.closest(".file-uploader").find(".img-preview").append(previewImg);
						$this.closest(".file-uploader").find(".img-preview .preview").attr("src", e.target.result);
						$this.closest(".file-uploader").find(".select-file").after(removeBtn);
						$this.closest(".file-uploader").find(".select-file").hide();
						$this.after('<input type="file" id="'+$this.attr("id")+'" class="'+$this.attr("class")+'" name="'+$this.attr("name")+'" value="">');
						$this.closest(".file-uploader").find(".userChileID").val(e.target.result);
						$this.closest(".file-uploader").find(".userDrivingLicense").val(e.target.result);
						$this.remove();
						hideLoadAnimation();
					}
					reader.readAsDataURL(result);
				},
				error: function(e){
				  console.log(e.message);
				},
			});
		}
	}
});

$(document).on("click", ".upload-docs .file-uploader .btn-remove", function(){
	var elId = $(this).closest(".file-uploader").find(".file-input").attr("id");
	var elClass = $(this).closest(".file-uploader").find(".file-input").attr("class");
	var elName = $(this).closest(".file-uploader").find(".file-input").attr("name");
	$(this).closest(".file-uploader").find(".file-input").remove();
	$(this).closest(".file-uploader").append('<input type="file" id="'+elId+'" class="'+elClass+'" name="'+elName+'" value="">');
	$(this).closest(".file-uploader").find(".img-preview .preview").remove();
	$(this).closest(".file-uploader").find(".img-preview .sample").show();
	$(this).closest(".file-uploader").find(".select-file").show();
	$(this).closest(".file-uploader").find(".userChileID").val("");
	$(this).closest(".file-uploader").find(".userDrivingLicense").val("");
	$(this).closest(".file-uploader").find(".remove-file").remove();
	//enableSubmit($(this));
	
	
});

/* Upload Company Logo and Display Preview Thumbnail */
$(".profile-pic .file-input.prev").change(function(e){
	var $this = $(this);
	var ext = $this.val().split('.').pop().toLowerCase();
	if($.inArray(ext, ['png','jpg','jpeg']) == -1){
	    alert("Formato de archivo no permitido.");
	}else {
	    if(this.files && this.files[0]){
			showLoadAnimation();
			var file = this.files[0];
			new ImageCompressor(file, {
				quality: .5,
				success: function(result){
					var removeBtn = '<div class="remove-file"><i class="fa fa-times"></i><a href="javascript:;" class="btn-remove">Eliminar imagen</a></div>';
					var previewImg = '<img src="" class="preview">';
					
					var reader = new FileReader();
					reader.onload = function(e){
						$this.closest(".file-uploader").find(".img-preview .sample").hide();
						$this.closest(".file-uploader").find(".img-preview").append(previewImg);
						$this.closest(".file-uploader").find(".img-preview .preview").attr("src", e.target.result);
						$this.closest(".file-uploader").find(".select-file").after(removeBtn);
						$this.closest(".file-uploader").find(".select-file").hide();
						//$this.after('<input type="hidden" id="profilePhotoFile" name="profile_photo" value="'+e.target.result+'">');
						$this.closest(".file-uploader").find("#userProfilePhoto").val(e.target.result);
						hideLoadAnimation();
					}
					reader.readAsDataURL(result);
				},
				error: function(e){
				  console.log(e.message);
				},
			});
		}
	}
});

$(document).on("click", ".profile-pic.file-uploader .btn-remove", function(){
	$(this).closest(".file-uploader").find(".img-preview .preview").remove();
	$(this).closest(".file-uploader").find(".img-preview .sample").show();
	$(this).closest(".file-uploader").find(".select-file").show();
	$(this).closest(".file-uploader").find(".remove-file").remove();
	$("#profilePhotoFile").remove();
	//enableSubmit($(this));
	
});



/* Select Multiple Damage Photos using Browse Button */
$(".damage-photo-uploader .upload-btn-t").click(function(){
	$("#ticketFile").click();
});

$(".damage-photo-uploader #ticketFile").change(function(e){
	handleTicketFileSelect(e, false);
});

$('.damage-photo-uploader .upload-file-t').on('dragover', function(e) {
    e.preventDefault();
    e.stopPropagation();
});

$('.damage-photo-uploader .upload-file-t').on('dragenter', function(e) {
    e.preventDefault();
    e.stopPropagation();
});

$('.damage-photo-uploader .upload-file-t').on('drop', function(e) {
	handleTicketFileSelect(e, true);
});

$(".damage-photo-uploader .upload-btn").click(function(){
	$("#damagePhotos").click();
});

$(".damage-photo-uploader #damagePhotos").change(function(e){
	handleFileSelect(e, false);
});

/* Select Multiple Damage Photos using Drag and Drop */
$('.damage-photo-uploader .upload-file').on('dragover', function(e) {
    e.preventDefault();
    e.stopPropagation();
});

$('.damage-photo-uploader .upload-file').on('dragenter', function(e) {
    e.preventDefault();
    e.stopPropagation();
});

$('.damage-photo-uploader .upload-file').on('drop', function(e) {
    handleFileSelect(e, true);
});

/*function handleFileSelect(e, dnd){
	if(dnd==true){
		e.stopPropagation();
    	e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
	}else{
		var files = e.target.files;
	}
	for(var i = 0, f; f = files[i]; i++){
		if(!f.type.match('image.*')){
			alert("Formato de archivo no permitido.");
	        continue;
	    }
	    var reader = new FileReader();
	    reader.onload = (function(file){
        	return function(e){
		       	var output = '<div class="row data-view">'+
								'<input type="hidden" name="damageReportImg" value="'+e.target.result+'">'+
								'<div class="col-md-6 file-name">'+
									file.name+
								'</div>'+
								'<div class="col-md-6">'+
									'<i class="fa fa-times"></i><a href="javascript:;" class="btn-remove-file">Eliminar imagen</a>'+
								'</div>'+
							'</div>';			
		    	$(".damage-photo-uploader .files").append(output);
		    }
	    })(f);
	    reader.readAsDataURL(f);
	}
}
*/
function handleFileSelect(e, dnd){
	if(dnd==true){
		e.stopPropagation();
    	e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
	}else{
		var files = e.target.files;
	}
	//showLoadAnimation();
	for(var i = x = 0, f; f = files[i]; i++){
		if(!f.type.match('image.*')){
			alert("Formato de archivo no permitido.");
			x = x + 1;
	        continue;
	    }
	    if($('.loading-animation').length==0){
			showLoadAnimation();
		}
		new ImageCompressor(f, {
			quality: .5,
			success: function(result){
				x = x + 1;
				var reader = new FileReader();
				reader.onload = (function(f){
					return function(e){
						var output = '<div class="row data-view">'+
								'<input type="hidden" name="damageReportImg" value="'+e.target.result+'">'+
								'<div class="col-md-6 file-name">'+
									result.name+
								'</div>'+
								'<div class="col-md-6">'+
									'<i class="fa fa-times"></i><a href="javascript:;" class="btn-remove-file">Eliminar imagen</a>'+
								'</div>'+
							'</div>';			
						$(".damage-photo-uploader .files").append(output);
						if(x==files.length){
							hideLoadAnimation();
						}
					}
				})(f);
				reader.readAsDataURL(result);
			},	
			error: function(e){
			  console.log(e.message);
			},
		});
	}
}
function handleTicketFileSelect(e, dnd){
	if(dnd==true){
		e.stopPropagation();
    	e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
	}else{
		var files = e.target.files;
	}
	for(var i = 0, f; f = files[i]; i++){
		//if(!f.type.match('image.*')){
			//alert("Formato de archivo no permitido.");
	        //continue;
	    //}	    
	    var reader = new FileReader();
	    reader.onload = (function(file){
        	return function(e){
		       	var output = '<div class="row data-view">'+
								'<input type="hidden" name="damageReportImg" value="'+e.target.result+'">'+
								'<input type="hidden" name="fileName" value="'+file.name+'">'+
								'<div class="col-md-6 file-name">'+
									file.name+
								'</div>'+
								'<div class="col-md-6">'+
									'<i class="fa fa-times"></i><a href="javascript:;" class="btn-remove-file">Eliminar imagen</a>'+
								'</div>'+
							'</div>';
		    	$(".damage-photo-uploader .files").append(output);
		    }
	    })(f);
	    reader.readAsDataURL(f);
	}
}



/* Remove Selected Damage Report Image File */
$(document).on("click", ".damage-photo-uploader .btn-remove-file", function(){
	$(this).closest(".data-view").remove();
});

/* Payment Type */
$(".payment-type #monthlyPay").click(function(){
	$(".s-payment-type .monthly-pay").show();
	$(".s-payment-type .pre-pay").hide();
	$(this).closest("form").find(".btn-submit").val("Pagar y Enviar Registro");
});

$(".payment-type #prePay").click(function(){
	$(".s-payment-type .monthly-pay").hide();
	$(".s-payment-type .pre-pay").show();
	$(this).closest("form").find(".btn-submit").val("Enviar Registro");
});

/* Plan Selection */
$(".rental-plans .radio").click(function(){
	$(".rental-plans .plan").removeClass("active");
	$(this).closest(".plan").addClass("active");
});

/* Enable Submit button on required field fill-up */

function enableSubmit($this){
	//alert("this value "+$this);
	var isValid = true;
	$this.closest("form").find(".req:enabled").each(function(){
		if($(this).val()==='' || $(this).val()==null)
			isValid = false;
	});
	if (typeof($this.closest("form").attr("id")) != "undefined" && $this.closest("form").attr("id") == "paso2Form") {

		if (validrut == false) {
			//isValid = false;
		}
	}
	if(isValid==true){
		$this.closest("form").find("input[type=submit]").prop("disabled", false);
	}else{
		$this.closest("form").find("input[type=submit]").prop("disabled", true);
	}
}
$(".req").keypress(function(){
	 $this = $(this);
	 enableSubmit($this);
});

$(".req").change(function(){
	$this = $(this);
	enableSubmit($this);
});



/* Hide Required Error Messages */
jQuery.validator.messages.required = "";

/* Contact Form */
$("#paso1Form").validate({
	ignore: [],
	rules: {
		"email":
		{
			email: true,
			pattern: /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/,
		}
	},
	messages: 
	{
		"email":
		{
			email: "This email is not valid",
			pattern: "This email is not valid",
		}
	},
});

/* CONSOLE */
$(document).ready(function(){
	var h = $(document).height();
	$(".main-menu").css("height", h+140);
});

/* Toggle Side Menu*/
$(".btn-toggle-sidemenu").click(function(){
	$(".side-menu, .content-panel").toggleClass("active");
});

/* Check All Checkbox - Table */
$(".check-all").click(function(){
	if($(this).is(":checked")){
		$(".selected-row-actions").show();
		$(this).closest(".table").find(".tbody .checkbox input").prop("checked", true);
		$(this).closest(".table").find(".tbody .checkbox").addClass('checked');	
		
	}else{
		$(this).closest(".table").find(".tbody .checkbox input").prop("checked", false);
		$(this).closest(".table").find(".tbody .checkbox").removeClass('checked');
		$(".selected-row-actions").hide();
	}
});

$('#invAtt').find(".checkAllInv").click(function(){
		if($(this).is(":checked")){
			$('#invAtt').find(".checkbox-all").find(".checkbox input").prop("checked", true);
			$('#invAtt').find(".checkbox-all").find(".checkbox").addClass('checked');	
			
		}else{
			$('#invAtt').find(".checkbox-all").find(".checkbox input").prop("checked", false);
			$('#invAtt').find(".checkbox-all").find(".checkbox").removeClass('checked');
		}
});

$(".table .tbody .checkbox input").click(function(){
	if($(this).is(":checked")){
		$(".selected-row-actions").show();
	}else{
		var allUncheck = false;
		if (typeof($('input[name="vehicleIds"]')) != "undefined") {
			$('input[name="vehicleIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		if (typeof($('input[name="orderIds"]')) != "undefined") {
			$('input[name="orderIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		if (typeof($('input[name="zoneIds"]')) != "undefined") {
			$('input[name="zoneIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		if (typeof($('input[name="userIds"]')) != "undefined") {
			$('input[name="userIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		
		if (typeof($('input[name="stationBasedzoneIds"]')) != "undefined") {
			$('input[name="stationBasedzoneIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		
		if (typeof($('input[name="segmentIds"]')) != "undefined") {
			$('input[name="segmentIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		if (typeof($('input[name="groupIds"]')) != "undefined") {
			$('input[name="groupIds"]').each(function() {
			    if (this.checked) {
			    	allUncheck = true;
			    } 
			});
		}
		
			
		
		if(allUncheck==false){
			$(".selected-row-actions").hide();
			$(".table .thead").find(".check-all").prop("checked", false);
			$(".table .thead").find(".checkbox").removeClass("checked");
		}
		//$(".selected-row-actions").hide();
		if($(this).closest(".table").find(".check-all").is(":checked")){
			var allUncheck = false;
			$(this).closest(".table").find(".tbody .checkbox input").each(function(){
				if($(this).is(":checked")){
					allUncheck = true;
				}
			});
			if(allUncheck==false){
				$(this).closest(".table").find(".check-all").prop("checked", false);
				$(".selected-row-actions").hide();
			}
		}	
	}
});

$('.table .tbody .checkbox input[name="vehicleIds"]').click(function(){
	if($(this).is(":checked")){
		$(".selected-row-actions").show();
	}else{
		var allUncheck = false;
		$('input[name="vehicleIds"]').each(function() {
		    if (this.checked) {
		    	allUncheck = true;
		    } 
		});	
		if(allUncheck==false){
			$(".selected-row-actions").hide();
			$(".table .thead").find(".check-all").prop("checked", false);
			$(".table .thead").find(".checkbox").removeClass("checked");
		}
		
	}
});

/* Check All Checkbox */
$(".check-all-box .check-all").click(function(){
	if($(this).is(":checked")){
		$(this).closest(".check-all-box").find(".checkbox-all .checkbox input").prop("checked", true);
	}else{
		$(this).closest(".check-all-box").find(" .checkbox-all .checkbox input").prop("checked", false);
	}
});

$(".checkbox-all .checkbox input").click(function(){
	if($(this).closest(".check-all-box").find(".check-all").is(":checked")){
		var allUncheck = false;
		$(this).closest(".check-all-box").find(".checkbox-all .checkbox input").each(function(){
			if($(this).is(":checked")){
				allUncheck = true;
			}
		});
		if(allUncheck==false){
			$(this).closest(".check-all-box").find(".check-all").prop("checked", false);
		}
	}	
});

/* Collapse Card */
$(".collapse-card .card-header").click(function(){
	$(this).closest(".collapse-cards").find(".card-header.active").toggleClass("active");
	$(this).closest(".collapse-cards").find(".card-body.active").toggleClass("active");
	$(this).toggleClass("active");
	$(this).closest(".collapse-card").find(".card-body").toggleClass("active");
});


/* Change Profile Password */
$("#btnChangePassword").click(function(){
	$(this).closest(".links").hide();
	$("#changeProfilePassword").show();
	$('#change-password').find('#oldPassword').val('');
	$('#change-password').find('#newPassword').val('');
	$('#change-password').find('#confirmPassword').val('');
	$('#change-password-message').html('');
});

/* Content-Card Edit Form */
$(".btn-edit").click(function(){
	$(this).closest(".content-card").find(".update-form").show();
	$(this).closest(".content-card").find(".form-data").hide();
});

$(".btn-cancel").click(function(){
	$(this).closest(".content-card").find(".update-form").hide();
	$(this).closest(".content-card").find(".form-data").show();
});

/* Edit Disabled Form */
$(".btn-edit-disabled").click(function(){
	$(this).closest("form").find(".form-control[disabled]").prop("disabled", false);
});


/* Google Map & Geocoding */
function initMap() {
	var addressInput = (document.getElementById('direction'));
	var autocompleteAdd = new google.maps.places.Autocomplete(addressInput);
	var types = 'address';
	var geocoder = new google.maps.Geocoder();
	
   
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
					//$("#direction").val(results[0].formatted_address);
					$('#latitude').val(results[0].geometry.location.lat());
				    $('#longitude').val(results[0].geometry.location.lng());
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
	    getAddress(place.geometry.location);
	});
}

/* Detail Edit Form */
$(".detail-edit-view .btn-edit-view").click(function(){
	$(this).closest(".detail-edit-view").find(".detail-view").hide();
	$(this).closest(".detail-edit-view").find(".edit-view").show();
});

$(".detail-edit-view .btn-cancel").click(function(){
	$(this).closest(".detail-edit-view").find(".detail-view").show();
	$(this).closest(".detail-edit-view").find(".edit-view").hide();
});

/* Dropdown Box */
$(".btn-box").click(function(){
	var left = Math.round($(this).position().left);
	var width = $(this).closest(".dropdown-box").outerWidth();
	var inWidth = parseInt($(this).closest(".dropdown-box").css("padding-left"));
	var elmWidth = ($(this).width());
	var right = (width - left) - elmWidth - inWidth - 8;
	$(this).closest(".dropdown-box").find(".box").css("right", right);
	$(this).closest(".dropdown-box").find(".box").show();
});

/* Close Dropdown Box When Clicked Outside */
$(document).mouseup(function(e){
	var container = $(".box");

	if (!container.is(e.target)
		&& container.has(e.target).length === 0)
	{
		$(".box").hide();
	}
});

/* Close Dropdown Box */
$(".dropdown-box .btn-close").click(function(){
	$(this).closest(".box").hide();
});

/* Trip Start End Markers */
//Function Changed
$(function(){
	if($(".trip-distinations").length){
		var h = $(".trip-distinations .trip-start").outerHeight();
		var h1 = $(".trip-distinations .trip-mid").outerHeight();
		$(".trip-markers .start-to-end").css("height", h+h1+70);
		$(".trip-markers .markers.mid").css("top", h+25);
		$(".trip-markers .markers.end").css("top", h+h1+10);
	}
});

/* Loading Aimation */
function showLoadAnimation(){
	var animation = '<div class="loading-animation"><div class="uil-ring-css" style="transform:scale(0.89);"><div></div></div></div>';
	$("body").append(animation);
}

function hideLoadAnimation(){
	$(".loading-animation").remove();
}

$('#simulatorModal .action-btns a#calculate').on('click', function(){
	$('#calculate').hide();
	$('.cost-total').show();
	$('#backCalc').show().css('display', 'inline-block');
});
$('#simulatorModal .action-btns a#backCalc').on('click', function(){
	$('#calculate').show();
	$('#backCalc').hide();
	$('.cost-total').hide();
});

function displayFunction(val){
	if(val.value==2){
		$('#displaySelect').show();
	}else{
		$('#displaySelect').hide();
	}
}

$("#locationSearchForm").submit(function(e){
	e.preventDefault();
});

/* Car Reservation Map */
function initReserveMap(){
	var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	var myLatLng = new google.maps.LatLng(lat, lng);
	var marker = "https://gowgo.awto.cl/static/img/source-marker.png";
	var zoneMarkerImage = {
	    url: 'https://gowgo.awto.cl/static/img/zoneMarkerImage.png',
	};
	var activeZoneMarker = "https://gowgo.awto.cl/static/img/zoneMarkerImageActive.png";
	var locationInput = (document.getElementById('locationSearchInput'));
	var types = 'address';
	var geocoder = new google.maps.Geocoder();
	var zoneMarkers = [];
	var autocompleteSource = new google.maps.places.Autocomplete(locationInput);

	setDetaultLocation(myLatLng);
	
	/* Geolocate & Set Location*/
	var formattedAdd;
	function setLocation(myLatLng, mapEvent, callback){
		geocoder.geocode({'latLng': myLatLng}, function(results, status){
			if(status == google.maps.GeocoderStatus.OK){
				if(results[0]){
					$('#latitude').val(marker.getPosition().lat());
				    $('#longitude').val(marker.getPosition().lng());
				    formattedAdd = results[0].formatted_address;
					if(mapEvent=='dragend'){
						$("#locationSearchInput").val(formattedAdd);
					}
					callback();
				}
			}
		});
	}
	
	/* Set Saved Address */
	function setDetaultLocation(myLatLng){
		geocoder.geocode({'latLng': myLatLng}, function(results, status){
			if(status == google.maps.GeocoderStatus.OK){
				if(results[0]){
				    formattedAdd = results[0].formatted_address;
					$("#locationSearchInput").val(formattedAdd);
					setZoneMarkers(formattedAdd);
					circle.setCenter(myLatLng);
					circle.setRadius($('#locationRadius').val()*1000);
					$('#locationRadius').prop('disabled', false);
				}
			}
		});
	}
	
	var map = new google.maps.Map(document.getElementById('locationMap'), {
		center: myLatLng,
		zoom: 14,
		streetViewControl: true,
		mapTypeControl: true,
		scrollwheel: true,
		zoomControl: true,
	    zoomControlOptions: {
	        position: google.maps.ControlPosition.RIGHT_TOP
	    }
	});

    var allZones = new getAllZones(map);


	var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    draggable: true,
	    icon: marker
	});
	
	/* Get User Location */
	if(navigator.geolocation){
	  navigator.geolocation.getCurrentPosition(function(position){
		var pos = {
		  lat: position.coords.latitude,
		  lng: position.coords.longitude
		};
		map.setCenter(pos);
		marker.setPosition(pos);
		var myLatLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
		setDetaultLocation(myLatLng);
		$('#latitude').val(position.coords.latitude);
	    $('#longitude').val(position.coords.longitude);
	  });
	}else{
		alert("Unable to locate");
	}
	
	/* Set Location */
	autocompleteSource.addListener('place_changed', function(){
		$('#locationRadius').prop('disabled', false);
	    marker.setVisible(false);
	    var place = autocompleteSource.getPlace();
	    if (!place.geometry) {
	      window.alert("Autocomplete's returned place contains no geometry");
	      return;
	    }

	    // If the place has a geometry, then present it on a map.
	    if (place.geometry.viewport) {
	      map.fitBounds(place.geometry.viewport);
	    } else {
	      map.setCenter(place.geometry.location);
	    }
	    marker.setPosition(place.geometry.location);
	    map.setCenter(place.geometry.location);
	    marker.setVisible(true);
	    map.setZoom(14);
		setLocation(place.geometry.location, 'place_changed', function(){
	    	setZoneMarkers(formattedAdd);
	    });
	    circle.setCenter(place.geometry.location);
	    circle.setRadius($('#locationRadius').val()*1000);
	});
		
	marker.addListener('dragend', function() {
	    map.setCenter(marker.getPosition());
	    setLocation(marker.getPosition(), 'dragend', function(){
	    	setZoneMarkers(formattedAdd);
	    });
	    circle.setCenter(marker.getPosition());
	});
	
	$("#locationRadius").change(function(){
		circle.setRadius($('#locationRadius').val()*1000);
		setZoneMarkers();
	});
	
	var circle = new google.maps.Circle({
        strokeColor: '#4988fd',
        strokeOpacity: 1,
        strokeWeight: 2,
        fillColor: '#FF0000',
        fillOpacity: 0,
        map: map,
        center: myLatLng,
        radius: 0
    });
    
	function setZoneMarkers(formattedAdd){
		if(formattedAdd){
			var location = formattedAdd;
		}else{
			var location = $("#locationSearchInput").val();	
		}
		var lat = $("#latitude").val();
		var lng = $("#longitude").val();
		var radius = $('#locationRadius').val();
		var actionUrl = $('#locationSearchForm').attr("action");
		$('#generic-message').html('');
		
		// Clear Markers
		zoneMarkers.forEach(function(marker) {
			marker.setMap(null);
		});
		zoneMarkers = [];
		
		$.get(actionUrl, {location: location, lat: lat, lng: lng, radius: radius}, function(data){
			//var json = $.parseJSON(data);
			var json = data;
			if(json.status=="success"){
				var i = m = 1;
				if($(".zone-and-cars").length){
					$(".zone-and-cars").remove();
				}
				var zoneHTML = '<div class="zone-and-cars">';

				$.each(json.zones, function(){
					markerZones = new google.maps.Marker({
			        	position: new google.maps.LatLng(this.lat, this.lng),
			        	map: map,
			        	icon: zoneMarkerImage,
			      	});
					
					var activeZone = "";
			      	if(m==1){
						markerZones.setIcon(activeZoneMarker);
						var activeZone = "active";
					}m++;

					google.maps.event.addListener(markerZones, 'click', (function(markerZones, i){
			        	return function(){
			      			$(".zone-and-cars .zone.active").removeClass("active");
	        				$(".zone-and-cars .zone:nth-child("+i+")").addClass("active");

	        				if($(window).width() > 767){
						        $(".zone-and-cars").scrollTop(390);
		        				var scrollPos = $(".zone-and-cars .zone:nth-child("+i+")").offset().top - 20;
		        				$('.zone-and-cars').animate({
						            scrollTop: scrollPos
						        }, 400);
						    }else{
						    	var scrollPos = $("body .zone:nth-child("+i+")").offset().top - 10;
		        				window.scrollTo(0,scrollPos);
						    }    
	        				for(var j = 0; j < zoneMarkers.length; j++){
						      zoneMarkers[j].setIcon(zoneMarkerImage);
						    }
						    markerZones.setIcon(activeZoneMarker);
			        	}
			      	})(markerZones, i));
			      	i++;
			      	zoneMarkers.push(markerZones);
			      	var zoneId = this.id;
			      	if (this.showZoneInfo != undefined && this.showZoneInfo == true) {
			      		zoneHTML = zoneHTML.concat('<div class="zone '+activeZone+'">'+
		      					'<div class="zone-details">'+
									'<div class="detail-view">'+
			                            '<div class="data-view clearfix">'+
			                                '<div class="title">Zona:</div>'+
			                                '<div class="data">'+this.name+' <a href="javascript:void(0);" onclick="showZoneMoreInfo('+zoneId+');">Más información</a></div>'+
			                            '</div>'+
			                            '<div class="data-view clearfix">'+
			                               '<div class="title">Disponibles:</div>'+
			                                '<div class="data">'+this.noOfCars+' autos disponibles</div>'+
			                            '</div>'+
			                            '<div class="data-view clearfix">'+
			                                '<div class="title">Distancia:</div>'+
			                                '<div class="data">'+this.distance+'</div>'+
			                            '</div>'+
			                        '</div>'+
								'</div>'+
							'<div class="cars">');
			      	} else {
			      		zoneHTML = zoneHTML.concat('<div class="zone '+activeZone+'">'+
		      					'<div class="zone-details">'+
									'<div class="detail-view">'+
			                            '<div class="data-view clearfix">'+
			                                '<div class="title">Zona:</div>'+
			                                '<div class="data">'+this.name+'</div>'+					                                
			                            '</div>'+
			                            '<div class="data-view clearfix">'+
			                               '<div class="title">Disponibles:</div>'+
			                                '<div class="data">'+this.noOfCars+' autos disponibles</div>'+
			                            '</div>'+
			                            '<div class="data-view clearfix">'+
			                                '<div class="title">Distancia:</div>'+
			                                '<div class="data">'+this.distance+'</div>'+
			                            '</div>'+
			                        '</div>'+
								'</div>'+
							'<div class="cars">');

			      	}			      	
			      	
					$.each(this.cars, function(){
						zoneHTML = zoneHTML.concat('<div class="car clearfix">'+
										'<div class="car-img">'+
											'<img src="'+this.img+'">'+
										'</div>'+
										'<div class="car-details">'+
											'<div class="car-title">'+this.model+'</div>'+
											'<div class="detail-view">'+
												'<div class="data-view clearfix">'+
					                                '<div class="title"><a href="" class="flota-btn">'+this.platNo+'</a></div>'+
					                                '<div class="data trip-type text-right">'+this.tripType+'</div>'+
					                            '</div>'+					                            
					                            '<div class="data-view clearfix">'+
					                                '<div class="title">Combustible:</div>'+
					                                '<div class="data text-right"><i class="fa fa-circle '+this.status+'"></i> '+this.fuel+'%</div>'+
					                            '</div>'+
					                        '</div>'+
					                        '<a href="#" class="btn btn-secondary reserve-btn" data-id="'+this.id+'" data-zoneid="'+zoneId+'" onclick="reserveCar(this);">Reservar AWTO</a>'+
										'</div>'+
									'</div>');
					});
					zoneHTML = zoneHTML.concat('</div>'+
										'</div>');
				});
				zoneHTML = zoneHTML.concat('</div>');
				$(".location-map").append(zoneHTML);
			}else{
				if(json.status=="failure" && typeof(json.message)!="undefined"){
					if($(".zone-and-cars").length){
						$(".zone-and-cars").remove();
					}
					var zoneHTML = '<div class="zone-and-cars">'+
										'<div class="zone-car-error">'+
											'<i class="fa fa-warning"></i><span>'+ json.message +'</span>'+
										'</div>'+	
									'</div>';
					$(".location-map").append(zoneHTML);
				}
			}
		});

	}
}


/* Car Destination Map */
function initDestinationMap(){
	var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	var myLatLng = new google.maps.LatLng(lat, lng);
	var marker = "https://gowgo.awto.cl/static/img/source-marker.png";
	var zoneMarkerImage = {
	    url: 'https://gowgo.awto.cl/static/img/zoneMarkerImage.png',
	};
	var activeZoneMarker = "https://gowgo.awto.cl/static/img/zoneMarkerImageActive.png";
	var locationInput = (document.getElementById('locationSearchInput'));
	var types = 'address';
	var geocoder = new google.maps.Geocoder();
	var zoneMarkers = [];
	var autocompleteSource = new google.maps.places.Autocomplete(locationInput);

	setDetaultLocation(myLatLng);
	
	/* Geolocate & Set Location*/
	var formattedAdd;
	function setLocation(myLatLng, mapEvent, callback){
		geocoder.geocode({'latLng': myLatLng}, function(results, status){
			if(status == google.maps.GeocoderStatus.OK){
				if(results[0]){
					$('#latitude').val(marker.getPosition().lat());
				    $('#longitude').val(marker.getPosition().lng());
				    formattedAdd = results[0].formatted_address;
					if(mapEvent=='dragend'){
						$("#locationSearchInput").val(formattedAdd);
					}
					callback();
				}
			}
		});
	}
	
	/* Set Saved Address */
	function setDetaultLocation(myLatLng){
		geocoder.geocode({'latLng': myLatLng}, function(results, status){
			if(status == google.maps.GeocoderStatus.OK){
				if(results[0]){
				    formattedAdd = results[0].formatted_address;
					$("#locationSearchInput").val(formattedAdd);
					setZoneMarkers(formattedAdd);
					circle.setCenter(myLatLng);
					circle.setRadius($('#locationRadius').val()*1000);
					$('#locationRadius').prop('disabled', false);
				}
			}
		});
	}
	
	var map = new google.maps.Map(document.getElementById('locationMap'), {
		center: myLatLng,
		zoom: 14,
		streetViewControl: false,
		mapTypeControl: false,
		scrollwheel: false,
		zoomControl: true,
	    zoomControlOptions: {
	        position: google.maps.ControlPosition.RIGHT_TOP
	    }
	});

	var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    draggable: true,
	    icon: marker
	});

	/* Get User Location */
	if(navigator.geolocation){
	  navigator.geolocation.getCurrentPosition(function(position){
		var pos = {
		  lat: position.coords.latitude,
		  lng: position.coords.longitude
		};
		map.setCenter(pos);
		marker.setPosition(pos);
		var myLatLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
		setDetaultLocation(myLatLng);
	  });
	}else{
		alert("Unable to locate");
	}
	
	/* Set Location */
	autocompleteSource.addListener('place_changed', function(){
		$('#locationRadius').prop('disabled', false);
	    marker.setVisible(false);
	    var place = autocompleteSource.getPlace();
	    if(!place.geometry){
	      	window.alert("Autocomplete's returned place contains no geometry");
	      	return;
	    }

	    // If the place has a geometry, then present it on a map.
	    if(place.geometry.viewport){
	      	map.fitBounds(place.geometry.viewport);
	    }else{
	      	map.setCenter(place.geometry.location);
	    }
	    marker.setPosition(place.geometry.location);
	    map.setCenter(place.geometry.location);
	    marker.setVisible(true);
	    map.setZoom(14);
	    setLocation(place.geometry.location, 'place_changed', function(){
	    	setZoneMarkers(formattedAdd);
	    });
	    circle.setCenter(place.geometry.location);
	    circle.setRadius($('#locationRadius').val()*1000);
	});
		
	marker.addListener('dragend', function(){
	    map.setCenter(marker.getPosition());
	    setLocation(marker.getPosition(), 'dragend', function(){
	    	setZoneMarkers(formattedAdd);
	    });
	    circle.setCenter(marker.getPosition());
	});

	$("#locationRadius").change(function(){
		circle.setRadius($('#locationRadius').val()*1000);
		setZoneMarkers();
	});
	
	var circle = new google.maps.Circle({
        strokeColor: '#4988fd',
        strokeOpacity: 1,
        strokeWeight: 2,
        fillColor: '#FF0000',
        fillOpacity: 0,
        map: map,
        center: myLatLng,
        radius: 0
    });
    
	function setZoneMarkers(formattedAdd){
		if(formattedAdd){
			var location = formattedAdd;
		}else{
			var location = $("#locationSearchInput").val();
		}
		var lat = $("#latitude").val();
		var lng = $("#longitude").val();
		var radius = $('#locationRadius').val();
		var actionUrl = $('#locationSearchForm').attr("action");
		$('#generic-message').html('');

		// Clear Markers
		zoneMarkers.forEach(function(marker) {
			marker.setMap(null);
		});
		zoneMarkers = [];

		$.get(actionUrl, {location: location, lat: lat, lng: lng, radius: radius}, function(data){
			//var json = $.parseJSON(data);
			var json = data;
			if(json.status=="success"){
				var i = m = 1;
				if($(".destination-zones").length){
					$(".destination-zones").remove();
				}
				var zoneHTML = '<div class="destination-zones">'+
									'<h3>Zona seleccionada en el mapa:</h3>'+
									'<div class="zones">';

				$.each(json.zones, function(){
					markerZones = new google.maps.Marker({
			        	position: new google.maps.LatLng(this.lat, this.lng),
			        	map: map,
			        	icon: zoneMarkerImage,
			      	});
					
					var activeZone = "";
			      	if(m==1){
						markerZones.setIcon(activeZoneMarker);
						var activeZone = "active";
					}m++;

			      	google.maps.event.addListener(markerZones, 'click', (function(markerZones, i) {
			        	return function() {
			        		$(".destination-zones .zone").removeClass("active");
	        				$(".destination-zones .zone:nth-child("+i+")").addClass("active");

	        				if($(window).width() > 767){
						        $(".destination-zones").scrollTop(390);
		        				var scrollPos = $(".destination-zones .zone:nth-child("+i+")").offset().top - 324;
		        				$('.destination-zones').animate({
						            scrollTop: scrollPos
						        }, 400);
						    }else{
						    	var scrollPos = $("body .zone:nth-child("+i+")").offset().top - 53;
		        				window.scrollTo(0,scrollPos);
						    }
			        		for(var j = 0; j < zoneMarkers.length; j++){
						    	zoneMarkers[j].setIcon(zoneMarkerImage);
						    }
						    markerZones.setIcon(activeZoneMarker);
			        	}
			      	})(markerZones, i));
			      	i++;
			      	zoneMarkers.push(markerZones);
			      	if (this.showZoneInfo != undefined && this.showZoneInfo == true) {
			      		zoneHTML = zoneHTML.concat('<div class="zone '+activeZone+'">'+
								'<div class="id">'+this.id+'</div>'+
								'<div class="name">'+this.name+' <a href="javascript:void(0);" onclick="showZoneMoreInfo('+this.id+');">More Info</a></div>'+
								'<div class="location-avail-cars clearfix">'+
								 	'<div class="location">'+this.regionComuna+'</div>'+
									'<div class="avail-cars"><i class="fa fa-circle '+this.spaceStatus+'"></i> <span class="avail">'+this.availSpace+'</span> / <span class="total">'+this.totalSpace+'</span></div>'+
								'</div>'+
								'<div class="infra">');
			      	} else {
			      		zoneHTML = zoneHTML.concat('<div class="zone '+activeZone+'">'+
								'<div class="id">'+this.id+'</div>'+
								'<div class="name">'+this.name+'</div>'+
								'<div class="location-avail-cars clearfix">'+
								 	'<div class="location">'+this.regionComuna+'</div>'+
									'<div class="avail-cars"><i class="fa fa-circle '+this.spaceStatus+'"></i> <span class="avail">'+this.availSpace+'</span> / <span class="total">'+this.totalSpace+'</span></div>'+
								'</div>'+
								'<div class="infra">');
			      	}			      	
					if(this.fuel==true){
						zoneHTML = zoneHTML.concat('<img src="/static/img/fuel-icon.png">');
					}
					if(this.charging==true){
						zoneHTML = zoneHTML.concat('<img src="/static/img/electricity-icon.png">');
					}
					zoneHTML = zoneHTML.concat('</div><a href="javascript:void(0);" data-zoneid="'+this.id+'" onclick="reserveParking(this);" class="btn btn-secondary book-parking-btn">Reservar estacionamiento</a></div>');

				});
				zoneHTML = zoneHTML.concat('</div></div>');
				$(".location-map").append(zoneHTML);
			} else {
				if(json.status=="failure" && typeof(json.message)!="undefined"){
					if($(".destination-zones").length){
						$(".destination-zones").remove();
					}
					var zoneHTML = '<div class="zone-and-cars">'+
										'<div class="zone-car-error">'+
											'<i class="fa fa-warning"></i><span>'+ json.message +'</span>'+
										'</div>'+	
									'</div>';
					$(".location-map").append(zoneHTML);
				}
			}
		});

	}
}


/* Show Zone Map */
function initShowZoneMap(){
	var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	var myLatLng = new google.maps.LatLng(lat, lng);
	var marker = "https://www.myrove.com/img/source-marker.png";

	var map = new google.maps.Map(document.getElementById('showZoneMap'), {
		center: myLatLng,
		zoom: 14,
		streetViewControl: true,
		mapTypeControl: true,
		scrollwheel: true,
		zoomControl: true,
		draggable: true
	});

	var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    draggable: false
	});

	// Define the LatLng coordinates for the polygon's path.
    var zoneCoords = getZoneCords();

    // Construct the polygon.
    var zoneCoordsPolygon = new google.maps.Polygon({
      	paths: zoneCoords,
      	strokeColor: '#FF0000',
      	strokeOpacity: 0.8,
      	strokeWeight: 2,
      	fillColor: '#FF0000',
      	fillOpacity: 0.35
    });
    zoneCoordsPolygon.setMap(map);
}

/* Create Zone Map */
var drawingManager;
function initCreateZoneMap(){
	var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	var myLatLng = new google.maps.LatLng(lat, lng);

	var map = new google.maps.Map(document.getElementById('createZoneMap'), {
		center: myLatLng,
		zoom: 15,
		streetViewControl: false,
		mapTypeControl: false,
		scrollwheel: false,
		zoomControl: true,
		draggable: true
	});

	var drawingManager = new google.maps.drawing.DrawingManager({
      	drawingMode: google.maps.drawing.OverlayType.POLYGON,
      	drawingControl: false,
      	drawingControlOptions: {
        	position: google.maps.ControlPosition.TOP_CENTER,
        	drawingModes: ['polygon']
      	},
      	circleOptions: {
        	fillColor: '#ffff00',
        	fillOpacity: 1,
        	strokeWeight: 5,
        	clickable: false,
        	editable: true,
        	zIndex: 1
      	}
    });
    drawingManager.setMap(map);

    google.maps.event.addListener(drawingManager, 'polygoncomplete', function(polygon) {
	    drawingManager.setDrawingMode(null);
	    var arr=[];
	    polygon.getPath().forEach(function(latLng, i){
	    	arr.push({lat: latLng.lat(), lng: latLng.lng()});
	    });
	    $("#zoneCords").val(JSON.stringify(arr));
	});

    var allZonesDiv = document.createElement('div');
    var allZones = new getAllZones(allZonesDiv, map);

    allZones.index = 1;
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(allZonesDiv);
}

/* Get Car Location */
$(function(){
	if($("#carLocationMap").length){
		initCarLocationMap();
	}
});

/* Get Car Location With Zones*/
$(function(){
    if($("#carLocationMapZones").length){
        getAllZones();
    }
});

/* Initialize Car Location Map */
function initCarLocationMap(){
	var actionUrl = $('#get-vehicle-location').attr("action");
	$.get(actionUrl, function(data){
		var json = data;
		if(json.status=="success"){
			var myLatLng = new google.maps.LatLng(json.lat, json.lng);
			var marker = "https://gowgo.awto.cl/static/img/car-location-marker.png";

			var map = new google.maps.Map(document.getElementById('carLocationMap'), {
				center: myLatLng,
				zoom: 15,
				streetViewControl: true,
				mapTypeControl: true,
				scrollwheel: true,
				zoomControl: true,
				draggable: true
			});

			var marker = new google.maps.Marker({
			    position: myLatLng,
			    map: map,
			    draggable: false,
			    icon: marker
			});
			if (typeof(json.updatedDate) != "undefined" && json.updatedDate != "") {
				$('#location-map-date').html(json.updatedDate);
			}
		}
	});
}

/* Change Row Status Form */
$("#upcusstatus").click(function(){
	$this = $(this);
	var userId = $this.closest("form").find(".row-uq-id").val();
	var status = $this.closest("form").find(".radio:checked").val();
	console.log(userId);
	console.log("status "+status);
	$('#updateStatusProfileId').val(userId);
	$('#updatedStatus').val(status);
    $this.closest(".box").hide();

	 
});


/* Range Datepickers */
$('.date-range').datepicker({
	format: "dd/mm/yyyy",
	language: "es",
	startDate: '-1y',
	inputs: $('.input-date')
});

/* Show the Second Datepicker on Select of the First Datepicker */
$('#fromDate').datepicker({
}).on('changeDate', function(){
	$('#fromDate').datepicker("hide");
$('#toDate').prop('disabled', false);
$('#toDate').datepicker('show');
});

/* Promotion Date Type */
$("#promoDateType").change(function(){
	var type = $("#promoDateType option:selected").data("type");
	$('#promotionDateType').attr('style','display:none');
	if(type=="RANGE"){
		$(".promo-date-range").show();
		$(".promo-days-time").show();
		$(".promo-date-range .input-date").prop("disabled", false);
	}else{
		$(".promo-date-range").hide();
		$(".promo-days-time").hide();
		
		$(".promo-date-range .input-date").prop("disabled", true);
	}
});

/* Promotion Amount Type */
$(".promo-amt-type #flatAmt").click(function(){
	$("#promoAmount").prop("placeholder", "Enter Amount");
});

$(".promo-amt-type #percentageAmt").click(function(){
	$("#promoAmount").prop("placeholder", "Enter Percentage");
});

/* Create Segments */
$(function(){
	if($(".list-segments").length){
		$(".list-segments .item").each(function(){
			var value = $(this).text().toLowerCase();
			$(this).attr("data-value", value);
		});
	}
});

$(document).on("click", ".list-segments .item:not(.active)", function(){
	$(this).addClass("active");
});


$(document).on("click", ".list-segments .active", function(){
	$(this).removeClass("active");
});

$(document).on("click", "#addListItem", function(){
	$(".list-left .active").appendTo(".list-right").removeClass("active");
});

$(document).on("click", "#removeListItem", function(){
	$(".list-right .active").appendTo(".list-left").removeClass("active");
});


/* Create Goup of Items Modal */
$(document).on("click", ".list-segments .item:not(.active)", function(){
	$(this).addClass("active");
});

$(document).on("click", ".list-segments .active", function(){
	$(this).removeClass("active");
});

$(document).on("click", ".add-list-item", function(){
	$(this).closest(".create-group").find(".list-left .active").appendTo($(this).closest(".create-group").find(".list-right")).removeClass("active");
});

$(document).on("click", ".remove-list-item", function(){
	$(this).closest(".create-group").find(".list-right .active").appendTo($(this).closest(".create-group").find(".list-left")).removeClass("active");
});

$(document).on("keyup", ".filter-left-list", function(){
	if($(this).val().length > 0){
		$(this).closest(".create-group").find(".filter-left").addClass("active");
		var keyword = $(this).val();
		$(this).closest(".create-group").find(".list-left .item").hide();
		$(this).closest(".create-group").find('.list-left .item[data-value*="'+keyword+'"]').css('display', 'block');
		$(this).closest(".create-group").find('.list-left .item[data-email*="'+keyword+'"]').css('display', 'block');
	}else{
		$(this).closest(".create-group").find(".filter-left").removeClass("active");
		$(this).closest(".create-group").find('.list-left .item').css('display', 'block');
	}
});

//Function Changed Begin
$(document).on("keyup", ".filter-right-list", function(){
	var keyword = $(this).val().trim();
	 if(keyword.length > 0){
		  	$(this).closest(".create-group").find(".filter-right").addClass("active");
		  	$(this).closest(".create-group").find(".list-right .item").hide();
		 	$(this).closest(".create-group").find('.list-right .item:contains("'+keyword+'")').css('display', 'block');
		  	$(this).closest(".create-group").find('.list-right .item[data-value*="'+keyword+'"]').css('display', 'block');
		  	$(this).closest(".create-group").find('.list-right .item[data-email="'+keyword+'"]').css('display', 'block');
		 }else{
		    $(this).closest(".create-group").find(".filter-right").removeClass("active");
  			$(this).closest(".create-group").find('.list-right .item').show();
		 }
});

function clearSearchFilter($this){
	$this.closest(".list-filter").find(".form-control").val("");
	$this.closest(".list-filter").find(".list-filter").removeClass("active");
	if($this.closest(".list-filter").hasClass("filter-left")){
		console.log("aswwd");
		$this.closest(".create-group").find(".list-left .item").show();
		$this.closest(".create-group").find(".list-left .item:gt(19)").hide();
	}
	if($this.closest(".list-filter").hasClass("filter-right")){
		$this.closest(".create-group").find(".list-right .item").show();
	}
}
// Function Changed Ends

$(document).on("click", ".create-group .fa-times", function(){
	clearSearchFilter($(this));
});

/*Select Vehicle Segment*/

function getSelectedVehicleSegments(){
	var selectedItems = [];
	$("#modalAddVehicleSegments .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedVehicleSegmentItems").val(selectedItems.toString());
}

$(document).on("click", "#getSelectedVehicleSegmentsList", function(){
	getSelectedVehicleSegments();
	clearSearchFilter($(this));
	$("#modalAddVehicleSegments").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Selected Segments</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddVehicleSegments .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedVehicleSegmentsTable").html(output);
	if(!$("#modalAddVehicleSegments .list-right .item").length){
		$("#selectedVehicleSegmentsTable").empty();
	}
});

$(document).on("click", "#selectedVehicleSegmentsTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddVehicleSegments .list-right .item[data-id="'+id+'"]').appendTo("#modalAddVehicleSegments .list-left");
	$(this).closest(".t-row").remove();
	getSelectedSegments();
	if(!$("#modalAddSegments .list-right .item").length){
		$("#selectedVehicleSegmentsTable").empty();
	}
});


/* Select Segments */
function getSelectedSegments(){
	var selectedItems = [];
	$("#modalAddSegments .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedSegmentItems").val(selectedItems.toString());
	if($("#selectedSegmentItems").val() == ""){
        document.getElementById('submitPromotionBtn').disabled = true;
    }else{
        document.getElementById('submitPromotionBtn').disabled = false;
    }
}

$(document).on("click", "#getSelectedSegmentsList", function(){
	getSelectedSegments();
	clearSearchFilter($(this));
	$("#modalAddSegments").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Selected Segments</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddSegments .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedSegmentsTable").html(output);
	if(!$("#modalAddSegments .list-right .item").length){
		$("#selectedSegmentsTable").empty();
	}
});

$(document).on("click", "#selectedSegmentsTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddSegments .list-right .item[data-id="'+id+'"]').appendTo("#modalAddSegments .list-left");
	$(this).closest(".t-row").remove();
	getSelectedSegments();
	if(!$("#modalAddSegments .list-right .item").length){
		$("#selectedSegmentsTable").empty();
	}
});



$(document).on("keyup", "#filterLeftList", function(){
	if($(this).val().length > 0){
		$(".create-segment .filter-left").addClass("active");
		var keyword = $(this).val();
		$('.create-segment .list-left .item').hide();
		$('.create-segment .list-left .item:contains("'+keyword+'")').show();
	}else{
		$(".create-segment .filter-left").removeClass("active");
		$('.create-segment .list-left .item').show();
	}
});

$(document).on("click", ".create-segment .fa-times", function(){
	$("#filterLeftList").val("");
	$(".create-segment .filter-left").removeClass("active");
	$('.create-segment .list-left .item').show();
});


/* Select Zones */
function getSelectedZones(){
	var selectedItems = [];
	$("#modalAddZones .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedZoneItems").val(selectedItems.toString());
}

$(document).on("click", "#getSelectedZonesList", function(){
	getSelectedZones();
	clearSearchFilter($(this));
	$("#modalAddZones").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Selected Zones</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddZones .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedZonesTable").html(output);
	if(!$("#modalAddZones .list-right .item").length){
		$("#selectedZonesTable").empty();
	}
});

$(document).on("click", "#selectedZonesTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddZones .list-right .item[data-id="'+id+'"]').appendTo("#modalAddZones .list-left");
	$(this).closest(".t-row").remove();
	getSelectedZones();
	if(!$("#modalAddZones .list-right .item").length){
		$("#selectedZonesTable").empty();
	}
});

/* Select Users */
function getSelectedUsers(){
	var selectedItems = [];
	$("#modalAddUsers .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedUserItems").val(selectedItems.toString());
}

$(document).on("click", "#getSelectedUsersList", function(){
	getSelectedUsers();
	clearSearchFilter($(this));
	$("#modalAddUsers").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Selected Zones</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddUsers .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedUsersTable").html(output);
	if(!$("#modalAddUsers .list-right .item").length){
		$("#selectedUsersTable").empty();
	}
});

$(document).on("click", "#selectedUsersTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddUsers .list-right .item[data-id="'+id+'"]').appendTo("#modalAddUsers .list-left");
	$(this).closest(".t-row").remove();
	getSelectedUsers();
	if(!$("#modalAddUsers .list-right .item").length){
		$("#selectedUsersTable").empty();
	}
});


/* Select Users */
function getSelectedVehicles(){
	var selectedItems = [];
	$("#modalAddVehicles .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedVehicleItems").val(selectedItems.toString());
}

$(document).on("click", "#getSelectedVehiclesList", function(){
	getSelectedVehicles();
	clearSearchFilter($(this));
	$("#modalAddVehicles").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Vehicle</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddVehicles .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedVehiclesTable").html(output);
	if(!$("#modalAddVehicles .list-right .item").length){
		$("#selectedVehiclesTable").empty();
	}
});

$(document).on("click", "#selectedVehiclesTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddVehicles .list-right .item[data-id="'+id+'"]').appendTo("#modalAddVehicles .list-left");
	$(this).closest(".t-row").remove();
	getSelectedVehicles();
	if(!$("#modalAddVehicles .list-right .item").length){
		$("#selectedVehiclesTable").empty();
	}
});

/* Select MemberShip */
function getSelectedMemberShips(){
	var selectedItems = [];
	$("#modalAddMemberships .list-right .item").each(function(){
		selectedItems.push($(this).data("id"));
	});
	$("#selectedMemberShipItems").val(selectedItems.toString());
}

$(document).on("click", "#getSelectedMemberShipList", function(){
	getSelectedMemberShips();
	clearSearchFilter($(this));
	$("#modalAddMemberships").modal("hide");
	var output = '<div class="thead">'+
					'<div class="t-row">'+
						'<div class="th">Selected MemberShip</div>'+
						'<div class="th"></div>'+
					'</div>'+
				'</div>'+
				'<div class="tbody">';
				
	$("#modalAddMemberships .list-right .item").each(function(){
		output = output.concat('<div class="t-row">'+
						'<div>'+$(this).text()+'</div>'+
						'<div><a href="javascript:;" class="remove-item" data-id="'+$(this).data("id")+'"><i class="fa fa-trash"></i></a></div>'+
					'</div>');
	});
	output = output.concat('</div>');
	$("#selectedMemberShipsTable").html(output);
	if(!$("#modalAddMemberships .list-right .item").length){
		$("#selectedMemberShipsTable").empty();
	}
});

$(document).on("click", "#selectedMemberShipsTable .remove-item", function(){
	var id = $(this).data("id");
	$('#modalAddMemberships .list-right .item[data-id="'+id+'"]').appendTo("#modalAddMemberships .list-left");
	$(this).closest(".t-row").remove();
	getSelectedMemberShips();
	if(!$("#modalAddMemberships .list-right .item").length){
		$("#selectedMemberShipsTable").empty();
	}
});


$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
$('input:radio[name="residence"]').change(function() {
  if ($(this).is(':checked') && $(this).val() == 'Foreign') {
    	$('.passport-no').show();
    	$('#rutNo').prop('disabled', 'disabled');
    	$('#passportNo').prop('disabled', false);
    	$('.rut-no').closest('div').addClass('hide');
    	$('.id-card').hide();
    	$('.id-card #iDFront, .id-card #iDBack').prop('disabled', 'disabled');
    	$('#rutNo').val('');
    	validrut = true;
  } else {
	    $('.passport-no').hide();
	    $('.rut-no').closest('div').removeClass('hide');
	    $('#passportNo').prop('disabled', 'disabled');
	    $('#rutNo').prop('disabled', false);
	    $('.id-card #iDFront, .id-card #iDBack').prop('disabled', false)
	    $('.id-card').show();
	    $('#passportNo').val('');	  

  	}
  //enableSubmit($(this));
});

//Hamburger Menu
$(window).bind('load', function() {
 if ($(window).width() < 767) {
  $('.mobile-icon a').on('click', function(){
      if($('.sidebar').is(':visible')){
          $('.sidebar').fadeOut();
      }else{
          $('.sidebar').fadeIn();
      }
  });
  $('.content-card').click(function() {
      $('.sidebar').fadeOut();
  });
 }
});

$(function(){
	$('.edit-amt a').click(function(){
		$('.amount-form').show();
		$('.edit-amt').hide();
	})
	$('.amount-form button').click(function(){
		$('.amount-form').hide();
		$('.edit-amt').show();
	})
})

$('.filter-mobile').on('click', function(){
	$('.filter-Menu').show();
});

$(".filter-back-btn").on('click', function(){
	$(".filter-Menu").hide();
});

$('.filter-modal').click(function(){
	$('#filterModal').modal('toggle');
    $('.thead .dropdown-box').each(function(){
       $('.thead .box').appendTo("#filterModal .modal-body");
       $('.thead .box').show();
    })
 })
 
 
$(function(){
 function mobileCollapse() {
     if ($(window).width() < 767) {
         $('.table-zonas-details .t-row').find('i.success').closest('.t-row').appendTo('.collapse-available .tbody');
         $('.table-zonas-details .t-row').find('i.warning').closest('.t-row').appendTo('.collapse-reserve .tbody');
         $('.table-zonas-details .t-row').find('i.danger').closest('.t-row').appendTo('.collapse-blocked .tbody');
     }
 }
 mobileCollapse();
 $(window).on('load', mobileCollapse);
});	

$('.multiselect').multiselect();
$('.multiselect-disabled').multiselect('disable');
/* Validate Form */
$(".form").validate();