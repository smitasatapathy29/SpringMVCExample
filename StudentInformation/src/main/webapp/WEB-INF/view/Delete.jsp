<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-top: 0;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #2c3f82;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #d32f2f;
        }
        .message-box {
            background-color: black;
            color: white;
            padding: 10px;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>    
</head>
<body>
    <br>
    <div class="container">
        <form action="deletebyid" method="post">
            <label for="studentId">Enter Student ID:</label>
            <input type="text" id="studentId" name="id" placeholder="Enter Student ID" required>
            <input type="submit" value="Delete">
        </form>
        <center>
            <h3>
                <% 
                String message = (String) request.getAttribute("message");
                if (message != null) { 
                %>
                <div class="message-box">
                    <p><%= message %></p>
                </div>
                <% 
                } 
                %>
            </h3>
        </center>
    </div>
</body>
</html>
    