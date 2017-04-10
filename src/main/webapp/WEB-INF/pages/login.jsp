<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Service API</title>
</head>
<body>
	<div class="col-md-4 col-md-offset-4">
	<form method="POST" action="login" role="login" id="frmLogin">
		<div class="form-group">
  			<input type="text" id="username" name = "username" required class="form-control" />
  		</div>
  		<div class="form-group">  		
  			<input type="text" id="password" name = "password" required class="form-control" />
  		</div>
  		<div class="form-group">
  			<button type = "submit" class="form-control">Login</button>
  		</div>
  	</form>
	</div>	
  	<script src="${pageContext.request.contextPath}/resources/static/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			 $("#frmLogin").submit(function(e){
				e.preventDefault();
				$.ajax({
					url:"${pageContext.request.contextPath}/login",
					type:"POST",
					data:$("#frmLogin").serialize(),
					success:function(data){
						if(data == "User account is locked"){
	  	            		alert(data);
	  	            	}else if(data == "User is disabled"){
	  	            		alert(data);
	  	            	}else if(data == "Bad credentials"){
	  	            		alert(data);
	  	            	}else{
	  	            		console.log(data);	  	  
	  	            		location.href = "${pageContext.request.contextPath}/"+data;
	  	            	}
					},
					error:function(err){
						console.log(err);
					}
				});
			}); 
		});
	</script>
</body>
</html>