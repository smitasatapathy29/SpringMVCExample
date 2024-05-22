<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Details</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #c1cdf5;
}

.button-container {
	position: fixed;
	bottom: 20px;
	right: 20px;
	z-index: 9999;
}

.btn[type="submit"] {
	background-color: #87CEEB; /* Sky blue color */
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	font-weight: bold;
	transition: background-color 0.3s ease;
}

.btn[type="submit"]:hover {
	background-color: #5F9EA0; /* Lighter shade of sky blue */
} 
/* Ensure it's above other elements */
/* Styling for the button */
</style>
</head>
<body>
	<form>
		<h1>Student Details</h1>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Father's Name</th>
					<th>Mother's Name</th>
					<th>Mobile Number</th>
					<th>Address</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty students}">
						<c:forEach items="${students}" var="student">
							<tr>
								<td><c:out value="${student.id}" /></td>
								<td><c:out value="${student.name}" /></td>
								<td><c:out value="${student.email}" /></td>
								<td><c:out value="${student.gender}" /></td>
								<td><c:out value="${student.fatherName}" /></td>
								<td><c:out value="${student.motherName}" /></td>
								<td><c:out value="${student.mobile}" /></td>
								<td><c:out value="${student.address}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">No students found</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<br> <br>
		<!-- Button Container -->
	</form>
	<div class="btn">
		<form action="getpdf" method=get>
			<button type="submit">Download PDF</button>

		</form>
	</div>

</body>
</html>
