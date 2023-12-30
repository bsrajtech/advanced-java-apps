<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Register Form</title>
</head>

<body> 

	<h1>Register Form</h1>

	<form action="./register" method="post">
		<label>Username</label> &nbsp; <input type="text" name="username" /> 
		<%= request.getAttribute("register.username") %> 
		<br><br>
		
		<label>Password</label> &nbsp; <input type="password" name="secretkey1" /> 
		<%= request.getAttribute("register.secretkey1") %>
		<br><br>

		<label>Retype Password</label> &nbsp; <input type="password" name="secretkey2" /> 
		<%= request.getAttribute("register.secretkey2") %>
		<br><br>

		<label>Date of birth</label> &nbsp; <input type="date" name="dob" /> 
		<%= request.getAttribute("register.dob") %>
		<br><br>

<label>Gender</label> &nbsp;
<select id="gender" name="gender">
  <option value="male">male</option>
  <option value="female">female</option>
  <option value="other">other</option>
</select> <br><br>

 <input list="courselist" name="course">
  <datalist id="courselist">
    <option value="Java FullStack">
    <option value="Python FullStack">
    <option value="UI FullStack">
    <option value="Database">
    <option value="DevOps">
  </datalist><br><br>
  
        
        <button type="submit">Register</button>        
        
	</form>

<%= request.getAttribute("register.message") %>


</body> 

</html> 

