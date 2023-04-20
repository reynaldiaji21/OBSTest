<title>Login Page</title>
</head>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {

		$('#formLogin').validate({
			rules : {
				uname : {
					required : true,
				},
				password : {
					required : true,
				}
			},
			messages : {
				uname : {
					required : "Field Username Required",
				},
				password : {
					required : "Field Password Required",
				}
			}
		});

		if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
			$("#loginError").empty();
		}
	});
</script>
<body>

	<div align=left>
		<h3>Login Page</h3>
	</div>
	<div>
		<form method="get" action="Login" id="formLogin">
			<table cellpadding="5" cellspacing="5" class='loginTable'>

				<tr>
					<td>User ID</td>
					<td><input id="name" type="text" name="uname"
						style="width: 100px;"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="pass" type="password" name="password"
						style="width: 100px;"></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="btn_click" type="submit" value="Login"
						name="click" style="width: 105px;"></td>
				</tr>
				<div>
			</table>
			<span id="loginError" style="color: red;">${error}</span>
		</form>
	</div>

</body>
</html>