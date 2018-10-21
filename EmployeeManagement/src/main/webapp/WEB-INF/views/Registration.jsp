<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Registration Page</title>


<style type="text/css">
body {
	font-family: 'Open Sans', sans-serif;
	/*  background:#3498db;*/
	margin: 0 auto 0 auto;
	width: 100%;
	text-align: center;
	margin: 20px 0px 20px 0px;
}

p {
	font-size: 12px;
	text-decoration: none;
	color: #ffffff;
}

h1 {
	font-size: 1.5em;
	color: #525252;
}

.box {
	background: white;
	width: 300px;
	border-radius: 6px;
	margin: 0 auto 0 auto;
	padding: 0px 0px 70px 0px;
	border: #2980b9 4px solid;
}

.email {
	background: #ecf0f1;
	border: #ccc 1px solid;
	border-bottom: #ccc 2px solid;
	padding: 8px;
	width: 250px;
	color: #AAAAAA;
	margin-top: 10px;
	font-size: 1em;
	border-radius: 4px;
}

.password {
	border-radius: 4px;
	background: #ecf0f1;
	border: #ccc 1px solid;
	padding: 8px;
	width: 250px;
	font-size: 1em;
}

.btn {
	background: #2ecc71;
	width: 125px;
	padding-top: 5px;
	padding-bottom: 5px;
	color: white;
	border-radius: 4px;
	border: #27ae60 1px solid;
	margin-top: 20px;
	margin-bottom: 20px;
	float: left;
	margin-left: 16px;
	font-weight: 800;
	font-size: 0.8em;
}

.btn:hover {
	background: #2CC06B;
}

#btn2 {
	float: left;
	background: #3498db;
	width: 125px;
	padding-top: 5px;
	padding-bottom: 5px;
	color: white;
	border-radius: 4px;
	border: #2980b9 1px solid;
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: 10px;
	font-weight: 800;
	font-size: 0.8em;
}

#btn2:hover {
	background: #3594D2;
}
</style>
</head>


<body>

	<link href="https://fonts.googleapis.com/css?family=Open+Sans:700,600"	rel="stylesheet" type="text/css" />

	<form method="post" action="signupserviceCreation" >
		<div class="box">
			<center>
				<h1>Registration</h1>

				<input type="text" name="firstName" placeholder="FirstName" class="email"
					required /> 
					<input type="text" name="lastName"placeholder="LastName" class="email" required />
					 <input	type="email" name="email" placeholder="email" class="email"
					required /> 
					<input type="text" name="contact" placeholder="contact"
					class="email" required /> <!-- <input type="date" name="dob" format=""
					placeholder="date of birth" class="email" required />  -->
				<!-- <textarea rows="5" style="width: 90%;" placeholder="address"
					name="address" required></textarea> -->
				<select type="text" name="gender" placeholder="contact"
					style="width: 90%;" required class="email">
					<option value="">gender</option>
					<option value="male">male</option>
					<option value="female">female</option>
				</select>
				<!--  <select type="text" name="role" style="width:90%;" placeholder="contact" required
               class="email">
               <option value="">role</option>
               <option value="owner">owner</option>
               <option value="consumer">consumer</option>
               </select> -->
				<input type="text" name="address.postalAddr" placeholder="postalAddr"
					required class="email" />
					
					 <input type="text" name="address.street" placeholder="street" required class="email" />
					
					 <input type="text"name="address.city" placeholder="city" required class="email" />
					
					 <input type="text" name="address.state" placeholder="state" required class="email" />
				    
				     <input type="text" name="address.pinCode" placeholder="pincode" required class="email" />
				     
				    
				    
					 <input type="submit" class="btn" value="Sign Up"/>
				<!-- End Btn -->

                           ${msg}
			</center>
		</div>
		<!-- End Box -->

	</form>	
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
		type="text/javascript"></script>



	<!--    <input type="file" name="profilepic"
					accept="image/*" class="email" required /> --> <!-- <script  src="js/index.js"></script> -->




</body>

</html>
