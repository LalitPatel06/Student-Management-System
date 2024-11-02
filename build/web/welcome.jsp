<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Student Management System</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            color: #333;
        }

        header {
            background-color: #2c3e50;
            color: #ecf0f1;
            padding: 20px;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 36px;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
            text-align: center;
        }

        .welcome-message {
            margin-bottom: 40px;
        }

        .welcome-message h2 {
            font-size: 32px;
            color: #34495e;
        }

        .welcome-message p {
            font-size: 18px;
            color: #7f8c8d;
        }

        .role {
            background-color: #ffffff;
            border-radius: 10px;
            padding: 30px;
            margin: 20px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .role:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
        }

        h3 {
            font-size: 24px;
            color: #2c3e50;
            margin-bottom: 15px;
        }

        .role p {
            font-size: 16px;
            color: #7f8c8d;
        }

        nav a {
            display: inline-block;
            margin: 10px 20px;
            padding: 12px 30px;
            border-radius: 5px;
            background-color: #27ae60;
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        nav a:hover {
            background-color: #1e8449;
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: #2c3e50;
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .role {
                margin: 20px auto;
            }
        }

        @media (max-width: 480px) {
            header h1 {
                font-size: 28px;
            }

            .welcome-message h2 {
                font-size: 24px;
            }

            nav a {
                padding: 10px 20px;
                margin: 5px;
            }
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Student Management System</h1>
    </header>

    <div class="container">
        <div class="welcome-message">
            <h2>Manage Student Records Efficiently</h2>
            <p>Select your role below to get started:</p>
        </div>

        <!-- Role Options -->
        <div class="role">
            <h3>Admin</h3>
            <p>Administer student data and manage teacher accounts.</p>
            <nav>
                <a href="Login.jsp">Login</a>
                <a href="r1.html">Sign Up</a>
            </nav>
        </div>

        <div class="role">
            <h3>Teacher</h3>
            <p>Input student marks and view student records.</p>
            <nav>
                <a href="Login.jsp">Login</a>
                <a href="r1.html">Sign Up</a>
            </nav>
        </div>

        <div class="role">
            <h3>Student</h3>
            <p>Access your records and view your grades.</p>
            <nav>
                <a href="Login.jsp">Login</a>
                <a href="r1.html">Sign Up</a>
            </nav>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Student Management System. All Rights Reserved.</p>
    </footer>
</body>
</html>
