<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #2c3f82;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #1a2653;
        }
    </style>
</head>
<body>
    <div class="container">   
        <h1>Update Student Details</h1>
        <form action="updateStudent" method="post">
        	<label for= "id" >Id</label>
        	<input type="text" id = "id" name= "id" readonly value ='<c:out value ="${id}"></c:out>'>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value ='<c:out value ="${student.name}"></c:out>' required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value ='<c:out value ="${student.email}"></c:out>' required>
            
            <label for="gender">Gender:</label>
			<select id="gender" name="gender" required>
  			 <option value="">Select Gender</option>
   			 <c:if test="${student.gender == 'male'}">
       		 <option value="male" selected>Male</option>
   			</c:if>
   			<c:if test="${student.gender == 'female'}">
       		<option value="female" selected>Female</option>
    		</c:if>
   			 <c:if test="${student.gender == 'other'}">
        	<option value="other" selected>Other</option>
    		</c:if>
			</select>
            <label for="fatherName">Father's Name:</label>
            <input type="text" id="fatherName" name="fatherName" value ='<c:out value ="${student.fatherName}"></c:out>' required>
            
            <label for="motherName">Mother's Name:</label>
            <input type="text" id="motherName" name="motherName" value ='<c:out value ="${student.motherName}"></c:out>' required>
            
            <label for="mobile">Mobile Number:</label>
            <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" value ='<c:out value ="${student.mobile}"></c:out>' required>
            
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="5" cols="50" required>value ='<c:out value ="${student.address}"></c:out>'</textarea>
            
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
