<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        header {
            background-color: #2c3f82;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        header h1 {
            margin: 0;
        }

        img {
            max-width: 100%;
            height: auto;
            display: block;
            margin: 20px auto;
        }

        section {
            padding: 20px;
            margin: 20px;
            background-color: #fff;
            border-radius: 5px;
        }

        h2 {
            color: #333;
        }

        p {
            color: #555;
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #2c3f82;
            color: #fff;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        footer p {
            margin: 0;
            color: white;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
        img{
        width: 100%; 
        display: block;
        height:auto;
        
        }
        .navbar {
  overflow: hidden;
  background-color: #2c3f82;
}

/* Style the links inside the navigation bar */
.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}

/* Change the color of links on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}
        
    </style>

</head>
<body>

    <header>
    <div class="navbar">
  <a href="#">Home</a>
  <a href="about">About</a>
  <a href="operation">Operations</a>
  
</div>
        <h1>Welcome to Our School</h1>
    </header>
    <img src="https://t3.ftcdn.net/jpg/06/33/31/94/360_F_633319415_FKHh9omrarIEJYOJrmv8EdBWlhQpY9NT.jpg" alt="School Image">
    <section>
        <h2>About Us</h2>
        <p>Welcome to our school! We strive to provide quality education and a nurturing environment for our students.</p>
    </section>
    <footer>
        <p>&copy; 2024 Our School</p>
    </footer>
</body>
</html>