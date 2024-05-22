<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page isELIgnored="false" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Details Form</title>
<style>
/* Style the page layout */
.container {
  max-width: 700px;
  margin: auto;
  padding: 20px;
}

/* Style the form */
.student-form {
  background-color: #c1cdf5;
  padding: 20px;
  border-radius: 5px;
}

/* Style the form elements */
.student-form label {
  font-weight: bold;
}

.student-form input[type="text"],
.student-form input[type="email"],
.student-form input[type="tel"],
.student-form select {
  width: 95%;
  padding: 10px;
  margin: 5px 0 20px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.student-form input[type="submit"] {
  background-color: #2c3f82;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.student-form input[type="submit"]:hover {
  background-color: black;
}
</style>
</head>
<body>
	<c:choose>
    <c:when test="${id ne null and id
    
    
     ne 0}">
        <c:if test="${successmsg ne null and not empty successmsg}">
            <script>
                alert("${successmsg}");
            </script>
        </c:if>
    </c:when>
    <c:otherwise>
        <c:if test="${failuremsg ne null and not empty failuremsg}">
            <script>
                alert("${failuremsg}");
            </script>
        </c:if>
    </c:otherwise>
</c:choose>
	<br>
	

<div class="container">
  <h1>Student Details Form</h1>
  <div class="student-form">
    <form action="insert" method="post">
      <label for="name">Name:</label><br>
      <input type="text" id="name" name="name" required>

      <label for="email">Email:</label><br>
      <input type="email" id="email" name="email" required>
		
      <label for="gender">Gender:</label><br>
      <select id="gender" name="gender" required>
        <option value="">Select Gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
      </select>
		<br>

      <br>
      <label for="fatherName">Father's Name:</label>
      <input type="text" id="fatherName" name="fatherName" required>

      <label for="motherName">Mother's Name:</label>
      <input type="text" id="motherName" name="motherName" required>
		<br>
      <label for="mobile">Mobile Number:</label>
      <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" required>
      <br>
      <label for="address">Address:</label><br>
      <textarea id="address" name="address" rows="5" cols="85"></textarea>
      
      <br><br>

      <input type="submit" value="Submit">
    </form>
  </div>
</div>

</body>
</html>
    