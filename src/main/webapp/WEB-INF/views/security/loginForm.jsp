<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>gomoku login</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


</head>
<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether-theme-arrows-dark.css"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>


	<script>
	$(document).ready(function(){
		$("#btn-signup").click(function(){
			
			var username = $("#signup-username").val();
			var password = $("#signup-password").val();
			var pw_confirm = $("#signup-pw-confirm").val();

			if($.trim(username).length <= 0 || $.trim(password).length <= 0 || $.trim(pw_confirm).length <= 0){
					alert("Fill in all fields");
			}else if(password != pw_confirm){
					alert("password unmatched");
			}else{
					$.ajax({
							url : "/myGomoku/signup",
							contentType : "application/json",
							dataType : 'json',
							method : "get",
							data : {username:username, password:password},
							cache : false,
							success : function(data){
								$('.signup-status').html(data);
							}	
					});
			}				

		});
		
		
	});
	
	
	
	</script>
	

	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Gomoku Login</div>

			<div class="panel-body">
				<form name="loginForm"
					action="<c:url value="j_spring_security_check"/>" method="POST">
					<!-- ==============login.php ========================== -->
					<div>

						<label>Username : &nbsp</label><input type="text"
							name="j_username" id="login-username" placeholder="username"><br />
						<label>Password : &nbsp</label><input type="password"
							name="j_password" id="login-password" placeholder="password"><br />
						<div class="login-status"></div>
					</div>
					<div class="panel-footer">
						<input type="button" data-toggle="modal" data-target="#signup"
							value="Sign up" /> <input type="submit" value="LOGIN">
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="signup">

		<div class="modal-dialog">
			<div class="modal-content">
				

				<form name="signupForm" action="/signup" method="POST">
					<!-- ==============signup.php ========================== -->
					<div class="modal-body">
						<label>Username : &nbsp</label><input type="text" name="username"
							id="signup-username" placeholder="username"><br /> <label>Password
							: &nbsp</label><input type="password" name="password"
							id="signup-password" placeholder="password"><br /> <label>PW
							Confirm : &nbsp</label><input type="password" name="pw_confirm"
							id="signup-pw-confirm" placeholder="password confirm"><br />
						<div class="signup-status"></div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btn-signup" class="btn btn-default">Signup</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>

			<div class="modal-header">Sign Up</div></div>

		</div>
	</div>
</body>
</html>