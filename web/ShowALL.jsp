<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Students Marks and Data</title>
    <link rel="stylesheet" href="abc.css">
    <style>
        select, input[type="submit"] {
            padding: 10px;
            margin-right: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        #showdata {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            border:2px solid black;
        }
        #showdata th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        #showdata th {
            background-color: lightskyblue;
            color: yellow;
            border-bottom: 1px solid black;
        }
        #showdata tr:hover {
            background-color: #f1f1f1;
        }
    </style>
        <script>
        // JavaScript to validate the form before submission
        function validateForm() {
            var classField = document.getElementById("class").value;
            var viewField = document.getElementById("view").value;

            // Check if both fields are selected
            if (classField === "" || viewField === "") {
                alert("Please select both Class and View options.");
                return false; // Prevent form submission
            }
            return true; // Allow form submission
        }
    </script>
</head>
<body>
    <div id="mymenu">
        <ul>
            <li class="left-item"><span class="heading-text">Students Data and Marks</span></li>
            <li class="right-item"><a href="Admin.html">Admin Dashboard</a></li>
            <li class="right-item"><a href="Logout">Logout</a></li>
        </ul>
    </div>

    <div id="mytable2">
        <center>
            <h2>Admin Options</h2>
            <!-- Dropdown for class selection and options for viewing -->
            <form method="post" action="ShowALL" onsubmit="return validateForm()">
                <label for="class">Select Class:</label>
                <select name="class" id="class">
                    <option value="">-- Select Class --</option>
                    <option value="10th">10th</option>
                    <option value="12th">12th</option>
                </select>

                <label for="view">View:</label>
                <select name="view" id="view">
                    <option value="">-- Select View --</option>
                    <option value="Student Data">Student Data</option>
                    <option value="Student Marks">Student Marks</option>
                </select>

                <input type="submit" value="View" class="B">
            </form>

<%
    // Retrieve the selected class and view option from the session
    String selectedClass = (String) session.getAttribute("selectedClass");
    String viewOption = (String) session.getAttribute("viewOption");

    if (selectedClass != null && viewOption != null) {
        // Display data for the selected class and view option
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            if (viewOption.equals("Student Data")) {
%>
                <h2>Student Data List for <%= selectedClass %></h2>
                <table id="showdata">
                    <tr>
                        <th>ID</th>
                        <th>Class</th>
                        <th>Name</th>
                        <th>Roll No</th>
                        <th>Date of Birth</th>
                        <th>Address</th>
                        <th>Parent Contact</th>
                        <th>Admission Date</th>
                    </tr>
<%
                String query = "SELECT * FROM studentsdata WHERE class = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, selectedClass);
                rs = ps.executeQuery();

                while (rs.next()) {
%>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("class") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("roll_no") %></td>
                        <td><%= rs.getDate("dob") %></td>
                        <td><%= rs.getString("address") %></td>
                        <td><%= rs.getString("parent_contact") %></td>
                        <td><%= rs.getDate("admission_date") %></td>
                    </tr>
<%
                }
%>
                </table>
<%
            } else if (viewOption.equals("Student Marks")) {
%>
                <h2>Student Marks List for <%= selectedClass %></h2>
                <table id="showdata">
                    <tr>
                        <th>Roll No</th>
                        <th>Name</th>
                        <th>Class</th>
                        <% if (selectedClass.equals("10th")|| selectedClass.equals("10")) { %>
                            <th>English</th>
                            <th>Math</th>
                            <th>Hindi</th>
                            <th>Science</th>
                            <th>Social Science</th>
                        <% } else if (selectedClass.equals("12th")||selectedClass.equals("12")) { %>
                            <th>English</th>
                            <th>Math</th>
                            <th>Physics</th>
                            <th>Chemistry</th>
                            <th>Physical Education</th>
                        <% } %>
                    </tr>
<%
                String marksQuery = "SELECT * FROM studentsmarks WHERE class = ?";
                ps = con.prepareStatement(marksQuery);
                ps.setString(1, selectedClass);
                rs = ps.executeQuery();

                while (rs.next()) {
%>
                    <tr>
                        <td><%= rs.getString("roll_no") %></td>
                        <td><%= rs.getString("student_name") %></td>
                        <td><%= rs.getString("class") %></td>
                        <% if (selectedClass.equals("10th") || selectedClass.equals("10")) { %>
                            <td><%= rs.getInt("english_marks") %></td>
                            <td><%= rs.getInt("math_marks") %></td>
                            <td><%= rs.getInt("hindi_marks") %></td>
                            <td><%= rs.getInt("science_marks") %></td>
                            <td><%= rs.getInt("social_science_marks") %></td>
                        <% } else if (selectedClass.equals("12th")||selectedClass.equals("12")) { %>
                            <td><%= rs.getInt("english_marks") %></td>
                            <td><%= rs.getInt("math_marks") %></td>
                            <td><%= rs.getInt("physics_marks") %></td>
                            <td><%= rs.getInt("chemistry_marks") %></td>
                            <td><%= rs.getInt("physical_education_marks") %></td>
                        <% } %>
                    </tr>
<%
                }
%>
                </table>
<%
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
%>
        </center>
    </div>
</body>
</html>
