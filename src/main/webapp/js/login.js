$(function() {
	init();
});

function init(){
	// Setting focus
	$('input[name="account"]').focus();

	// Setting width of the alert box
	var alert = $('.alert');
	var formWidth = $('.bootstrap-admin-login-form').innerWidth();
	var alertPadding = parseInt($('.alert').css('padding'));

	if (isNaN(alertPadding)) {
		alertPadding = parseInt($(alert).css('padding-left'));
	}

	$('.alert').width(formWidth - 2 * alertPadding);
}

function doLogin(){
	var account = $('#account').val();
	var password = $('#password').val();
	$.ajax({
		type:"POST",
		url:"/eur-admin/j_spring_security_check",
		data:{account:account,password:password},
		dataType:"json",
		async:false,
		success:function(authResult){
			if(authResult.code == 1){
				loginSuccess(authResult);
			}else{
				loginFail();
			}
		}
	});
}

function loginSuccess(authResult){
	localStorage.menuJsonObject = JSON.stringify(authResult.menuJsonObject);
	delete authResult.menuJsonObject;
	$.cookie('accountInfo', JSON.stringify(authResult), {path:'eur-web'});
	window.location.href = "/eur-web/page/index.html";
	return;
}

function loginFail(){
	
}