

<!DOCTYPE html>
<html lang="en">

<head>

<title>Welcome</title>
<style>
.w3-allerta {
	font-family: "Allerta Stencil", Sans-serif;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<script type="text/javascript" src="/js/courses.js"></script>
<script type="text/javascript" src="/js/students.js"></script>
<script type="text/javascript" src="/js/mentors.js"></script>

<link type="text/css" rel="stylesheet" href="css/style.css"/>

</head>
<div>
	<h3 class="w3-center w3-allerta w3-xxlarge">New Java Application</h3>
	<hr>
	<hr>
</div>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Home</a> 
				<a id="getCourse"onClick="getCourse()" class="list-item">Courses</a> 
				<a id="getMentor" onClick="getMentor()" class="list-item">Mentors</a>
				<a id="getStudent" onClick="getStudent()" class="list-item">Students</a>
			</div>
			<div id="result"></div>
		</div>
	</nav>

</body>

</html>