<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Search Page</title>
    <link rel="stylesheet" href="abc.css">
    <style>
        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 50px;
        }

        .search-box {
            display: flex;
            width: 500px;
            border: 2px solid #ccc;
            border-radius: 50px;
            overflow: hidden;
            align-items: center;
            position: relative;
        }

        .search-box input[type="text"] {
            border: none;
            padding: 10px 15px;
            width: 100%;
            font-size: 18px;
            outline: none;
        }

        .search-box img {
            width: 40px;
            height: 40px;
            margin-right: 10px;
            cursor: pointer;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        function showAlert(icon, title, text) {
            Swal.fire({
                icon: icon,
                title: title,
                text: text,
                timer: 3000,
                showConfirmButton: true
            });
        }

        // Form submission when clicking the search icon
        function submitForm() {
            var rollNoInput = document.querySelector("input[name='u1']");
            if (rollNoInput && rollNoInput.value.trim() !== "") {
                document.querySelector(".search-box").submit(); // Submitting the form
            } else {
                showAlert('error', 'Error', 'Please enter a roll number');
            }
        }
    </script>
</head>
<body>
    <div id="mymenu">
        <ul>
            <li class="left-item"><span class="heading-text">Search Student Data</span></li>
            <li class="right-item"><a href="Home.jsp">Home</a></li>
            <li class="right-item"><a href="LogoutDemo">Logout</a></li>
        </ul>
    </div>

    <div class="search-container">
        <!-- Search form -->
        <form action="Search.jsp" method="get" class="search-box">
            <input type="text" name="u1" placeholder="Enter Roll No." required>
            <!-- Use button instead of img for better form submission -->
            <button type="button" onclick="submitForm()">
                <img src="image/SearchLogo.png" alt="Search Icon">
            </button>
        </form>
    </div>

    <%
        // Fetch user role from session
        String role = (String) session.getAttribute("role");
        if (role == null) {
            role = "Student"; // Simulated role (use actual login in production)
        }

        String rollNo = request.getParameter("u1");
        String searchType = request.getParameter("searchType");

        // For Admin role, provide option to choose between student data or marks
        if ("Admin".equals(role)) {
            if (searchType == null && rollNo != null && !rollNo.trim().isEmpty()) {
                %>
                <div class="search-container">
                    <form method="get">
                        <label>Select search type:</label>
                        <select name="searchType">
                            <option value="studentsdata">Student Data</option>
                            <option value="studentsmarks">Student Marks</option>
                        </select>
                        <input type="hidden" name="u1" value="<%= rollNo %>">
                        <button type="submit">Submit</button>
                    </form>
                </div>
                <%
            }
        }

        if (rollNo != null && !rollNo.trim().isEmpty() && (searchType != null || !"Admin".equals(role))) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false", "root", "Root");
                Statement st = con.createStatement();

                // Construct query based on role and searchType
                String query = "";
                if ("Admin".equals(role) && "studentsdata".equals(searchType)) {
                    query = "SELECT * FROM studentsdata WHERE roll_no='" + rollNo + "'";
                } else if ("Admin".equals(role) || "Teacher".equals(role) || "Student".equals(role)) {
                    query = "SELECT * FROM studentsmarks WHERE roll_no='" + rollNo + "'";
                }

                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    %>
                    <div>
                        <center>
                            <table border="1" cellpadding="10">
                                <tr bgcolor='yellow' style='font-size:30px;color:blue'>
                                    <th colspan="2"><%= ("studentsdata".equals(searchType) ? "Student Data" : "Student Marks") %></th>
                                </tr>
                                <tr>
                                    <th align="left" style='font-size:25px;color:orange'>Roll No :</th>
                                    <td><%= rs.getString("roll_no") %></td>
                                </tr>
                                <tr>
                                    <th align="left" style='font-size:25px;color:orange'>Name :</th>
                                    <td><%= rs.getString("student_name") %></td>
                                </tr>
                                <% if ("studentsdata".equals(searchType)) { %>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>Class :</th>
                                        <td><%= rs.getString("class") %></td>
                                    </tr>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>DOB :</th>
                                        <td><%= rs.getDate("dob") %></td>
                                    </tr>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>Address :</th>
                                        <td><%= rs.getString("address") %></td>
                                    </tr>
                                <% } else { %>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>Physics Marks :</th>
                                        <td><%= rs.getInt("physics") %></td>
                                    </tr>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>Chemistry Marks :</th>
                                        <td><%= rs.getInt("chemistry") %></td>
                                    </tr>
                                    <tr>
                                        <th align="left" style='font-size:25px;color:orange'>Maths Marks :</th>
                                        <td><%= rs.getInt("maths") %></td>
                                    </tr>
                                <% } %>
                            </table>
                        </center>
                    </div>
                    <%
                } else {
                    %>
                    <script>
                        showAlert('error', 'Oops...', 'Student Roll No not found!');
                    </script>
                    <%
                }
                con.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    %>
</body>
</html>
