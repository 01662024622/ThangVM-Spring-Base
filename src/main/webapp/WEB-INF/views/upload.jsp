<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>List student from database</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>BirthOfDate</th>
					<th>Gender</th>
				</tr>
			</thead>
			<tbody>
				<input type="hidden" id="flag">

			</tbody>
		</table>
	</div>

</body>
<script type="text/javascript">
$.ajax({
	type : 'GET',
	url : 'students',
	dataType : 'json',
	success : function(response) {
		for (var i = 0; i < response.length; i++) {
			var html = '<tr>'+
	        '<td>'+response[i].id+'</td>'+
	        '<td>'+response[i].name+'</td>'+
	        '<td>'+response[i].birthOfDate+'</td>'
	        if (response[i].gender==0) {
	        	html+='<td>Nam</td>'+'</tr>';
			}else html+='<td>Nữ</td>'+'</tr>';
			$("#flag").after(html);
		}
		
	},
	error : function() {
	},
});
</script>
</html>
