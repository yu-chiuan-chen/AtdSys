$(function() {
	$("#btnLogin").click(function() {
		$.ajax({
			url : "js/Common/login.action", // 存取Json的網址
//			url : "user/loginAction.action", // 存取Json的網址
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {
				emp_no : $("#emp_no").val(),
				psw : $("#psw").val()
			},
//			contentType : "application/json",
			success : function(data) {
				if (data.status.match('success')) {
					$('#form1').submit();
				} else {
					$("#loginError").text('密碼錯誤!');
				}

			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});

	});
});

// window.onload = init;
