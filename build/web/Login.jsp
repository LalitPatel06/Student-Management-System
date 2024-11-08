<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!-- Font Awesome -->
    <link rel="stylesheet" href="abc.css"> <!-- Link to external CSS file -->
    <!-- SweetAlert CDN -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
     <div id="mymenu">
        <ul>
            <li class="left-item">Student Management System</li>
            <li>Home</li>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="r1.html">Registration</a></li>
            <li>About</li>
            <li>Contact</li>
        </ul>
    </div>
    
    <div id="login-container">
        <form action="LoginDemo" method="post" onsubmit="return validateForm()">
        <h1>Login</h1>
            <div class="input-container">
                <label for="username">Username:</label>
                <input type="text" id="username" name="u1" required>
                <i class="fa fa-user icon"></i> <!-- User Icon -->
            </div>
            <div class="input-container">
                <label for="password">Password:</label>
                <input type="password" id="password" name="u2" required>
                <i class="fa fa-lock icon"></i> <!-- Lock Icon -->
            </div>
            <div class="input-container">
                <label for="role">Select Role:</label>
                <select id="role" name="role" required>
                    <option value="" disabled selected>Select your role</option>
                    <option value="Admin">Admin</option>
                    <option value="Teacher">Teacher</option>
                    <option value="Student">Student</option>
                </select>
            </div>
            <input type="submit" value="Login" class="B">
            <div style="text-align: center;">
                <a href="Login.jsp" style="color: blue; text-decoration: none;">Don't have an account? Register here</a>
            </div>
        </form>
        <p class="error-message" id="error-message"></p>
    </div>

    <script>
        // Function to validate form before submission
        function validateForm() {
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            const role = document.getElementById("role").value;
            const errorMessage = document.getElementById("error-message");

            if (username === "" || password === "" || role === "") {
                errorMessage.textContent = "All fields are required.";
                return false;
            }

            return true;
        }
      
        // SweetAlert for login failure
        window.onload = function() {
            const errorMessage = '<%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>'; 
            // Ensure the error message is properly handled in JSP
            
            if (errorMessage !== "") {
                Swal.fire({
                    icon: 'error',
                    title: 'Login Failed',
                    text: errorMessage,
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: 'OK'
                });
            }
        };
        
    </script>
</body>
</html>
