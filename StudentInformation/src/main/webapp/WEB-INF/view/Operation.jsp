<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CRUD Operations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            margin-top: 0;
            color: #333;
        }
        .btn {
            display: inline-block;
            padding: 25px 60px;
            background-color: #1434A4;
            color: white;
            text-align: center;
            font-size: 24px;
            cursor: pointer;
            border-radius: 12px;
            border: none;
            transition: background-color 0.3s;
            margin: 15px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #49494d;
            color: white;
        }
    </style>
</head>
<body>
	<div class="container">
        <h2>CRUD Operations</h2>

        <form action="form" method="post">
            <button class="btn" type="submit">Insert</button>
        </form>

        <form action="delete" method="post">
            <button class="btn" type="submit">Delete</button>
        </form>

        <form action="show" method="post">
            <button class="btn" type="submit">Show All</button>
        </form>

        <form action="update" method="post">
            <button class="btn" type="submit">Update</button>
        </form>
    </div>
	</form>
</body>
</html>
    