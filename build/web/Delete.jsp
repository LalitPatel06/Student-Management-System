<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Delete Page</title>
    <link rel="stylesheet" href="abc3.css">
    <style>
        #searchdata {
            width: 50%;
            border-collapse: collapse;
            margin-top: 20px;
            border: 1px solid #ddd;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            /*font-family: Arial, sans-serif;*/
        }
        
        #searchdata th {
            /*background-color: #4CAF50;*/
            color:black;
            padding: 12px;
            text-align: left;
            font-size: 20px;
            border-bottom: 2px solid #ddd;
        }

        #searchdata td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 18px;
            color: #333;
            background-color:lightgoldenrodyellow;
        }

        #searchdata tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        #searchdata tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        #searchdata tr:hover {
            background-color: #e9e9e9;
            transition: background-color 0.3s ease;
        }

        #searchdata tr th, #searchdata tr td {
            border-right: 1px solid #ddd;
        }

        #searchdata tr th:last-child, #searchdata tr td:last-child {
            border-right: none;
        }

        #searchdata caption {
            font-size: 26px;
            font-weight: bold;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
            color: darkblue;
            padding: 10px;
        }
        
        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 10vh;
            margin-top:20px;
        }

        .search-box {
            position: relative;
            width: 400px;
        }

        .search-box input[type="text"] {
            width: 100%;
            padding: 10px 20px;
            border-radius: 50px;
            border: 1px solid #ccc;
            outline: none;
            font-size: 16px;
        }

        .search-box input[type="text"]::placeholder {
            color: #999;
        }

        .search-box button {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            background-color: transparent;
            border: none;
            cursor: pointer;
            outline: none;
        }

        .search-box button img {
            width: 20px;
            height: 20px;
        }
        
         /* CSS for delete button */
        .delete-btn {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for delete button */
        .delete-btn:hover {
            background-color: darkred;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        
      function confirmDelete(rollNo, buttonName) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            // Send AJAX request to delete the data
            $.ajax({
                url: 'DeleteServlet',
                type: 'GET',
                data: { rollNo: rollNo, [buttonName]: 'Delete' },  // Pass roll number and button name
                success: function(response) {
                    // Based on the response, show the success or failure SweetAlert
                    const urlParams = new URLSearchParams(response);  // Parse the query string in the response
                    const status = urlParams.get('status');
                    const entity = urlParams.get('entity');

                    if (status === 'success') {
                        Swal.fire({
                            icon: 'success',
                            title: 'Deleted!',
                            text: 'Student ' + (entity === 'data' ? 'data' : 'marks') + ' has been deleted successfully.',
                            confirmButtonText: 'OK'
                        }).then(() => {
                            window.location.href = 'Delete.jsp';  // Redirect after showing the alert
                        });
                    } else if (status === 'failure') {
                        Swal.fire({
                            icon: 'error',
                            title: 'Failed!',
                            text: 'No student found with the given Roll No.',
                            confirmButtonText: 'OK'
                        });
                    } else if (status === 'error') {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error!',
                            text: 'An error occurred while deleting the record.',
                            confirmButtonText: 'OK'
                        });
                    } else if (status === 'invalid') {
                        Swal.fire({
                            icon: 'warning',
                            title: 'Invalid!',
                            text: 'Please enter a valid Roll No.',
                            confirmButtonText: 'OK'
                        });
                    }
                }
            });
        }
    });
}



        
        function showAlert(icon, title, text) {
            Swal.fire({
                icon: icon,
                title: title,
                text: text,
                timer: 3000,
                showConfirmButton: true
            });
        }
    </script>
</head>
<body>
    <div id="mymenu">
        <% String userRole = (String) session.getAttribute("role"); %>
        <ul>
        <li class="left-item"><span class="heading-text">Delete Students</span></li>

        <% if ("Admin".equals(userRole)) { %>
            <li class="right-item"><a href="Admin.html">Home</a></li>
        <% } else if ("Teacher".equals(userRole)) { %>
            <li class="right-item"><a href="Teacher.html">Home</a></li>
        <% } %>

        <li class="right-item"><a href="Logout">Logout</a></li>
    </ul>
    </div>

    <div id="mytable">
        <center>
            <form action="Delete.jsp" method="get">
<label style="margin-top: 30px; font-weight: bold; text-shadow: 1px 1px 1px gray; color: blue; font-size: 40px;">Search Marks</label>
                 <div class="search-container">
        <div class="search-box">
                <input type="text" name="u1" placeholder="Enter Roll NO..">
                <button type="submit">
                    <img src="image/SearchLogo.png" alt="Search">
                </button>
            
        </div>
    </div>
                    <%
                        // Check the user role and display fields accordingly
                        if ("Admin".equals(userRole)) {
                    %>
                <table   cellpadding="17">
                    
                    <tr style="text-align: center;">
    <td style="text-align: center;">
        <div style="display: inline-block;">
            <input type="radio" id="studentData" name="dataType" value="studentData" required>
            <label for="studentData" style="font-size: 18px; font-weight: bold; margin-right: 20px;">Student Data</label>
            
            <input type="radio" id="studentMarks" name="dataType" value="studentMarks" required>
            <label for="studentMarks" style="font-size: 18px; font-weight: bold;">Student Marks</label>
        </div>
    </td>
</tr>

                    
                </table>
                    <%
                        } 
                    %>
            </form>
        </center>
    </div>

    <%
        String rollNo = request.getParameter("u1"); // Get the input value
        String dataType = request.getParameter("dataType"); // Get the selected data type
          String studentClass="";
        if (rollNo != null && !rollNo.trim().isEmpty()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false", "root", "Root");
                Statement st = con.createStatement();

                        if ("Admin".equals(userRole)&&"studentData".equals(dataType)){
                // Get student details
                String studentQuery = "SELECT * FROM studentsdata WHERE roll_no='" + rollNo + "'";
                ResultSet studentRs = st.executeQuery(studentQuery);

                if (studentRs.next()) {
                     studentClass = studentRs.getString("class");

                    
                        // Handle Admin search for both data types
                            // Display student details
                            %>
                            <div>
                                <center>
                                    <table  id="searchdata" >
                                        <caption>Student Data </caption>
                                        <tr>
                                            <th>Roll No :</th>
                                            <td><%= studentRs.getString("roll_no") %></td>
                                        </tr>
                                        <tr>
                                            <th >Name :</th>
                                            <td><%= studentRs.getString("name") %></td>
                                        </tr>
                                        <tr>
                                            <th >Class :</th>
                                            <td><%= studentRs.getString("class") %></td>
                                        </tr>
                                        <tr>
                                            <th >DOB :</th>
                                            <td><%= studentRs.getString("dob") %></td>
                                        </tr>
                                        <tr>
                                            <th >Address :</th>
                                            <td><%= studentRs.getString("address") %></td>
                                        </tr>
                                        <tr>
                                            <th >Parent Contact :</th>
                                            <td><%= studentRs.getString("parent_contact") %></td>
                                        </tr>
                                        <tr>
                                            <th >Admission Date :</th>
                                            <td><%= studentRs.getString("admission_date") %></td>
                                        </tr>
                      
                                    </table>
        <div style="text-align: center; margin-top: 15px;">
<!-- For deleting student data -->
<input type="button" value="Delete" name="b1" class="delete-btn" 
    onclick="confirmDelete('<%= studentRs.getString("roll_no") %>', 'b1')">
</div>     
                            </center>
                            </div>
                            <%
                        } 
                         else {
                    %>
                    <script>
                        showAlert('error', 'Oops...', 'Student not found with the given Roll No.');
                    </script>
                    <%
                }
                        }
                    
                    if ("studentMarks".equals(dataType) || "Teacher".equals(userRole) ) {
                            // Query for student marks depending on class (10th or 12th)
                            String marksQuery = "SELECT * FROM studentsmarks WHERE roll_no='" + rollNo + "'";
                            ResultSet marksRs = st.executeQuery(marksQuery);

                            if (marksRs.next()) {
                                              studentClass = marksRs.getString("class");
                                %>
                                <div>
                                    <center>
                                        <table id="searchdata" >
                                            <caption>Student Marks</caption>
                                            <tr>
                                                <th>Roll No :</th>
                                                <td><%= marksRs.getString("roll_no") %></td>
                                            </tr>
                                            <tr>
                                                <th >Name :</th>
                                                <td><%= marksRs.getString("student_name") %></td>
                                            </tr>
                                            <tr>
                           <th colspan="2" style="text-align: center; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4); background-color: lightpink; color: darkblue;">
                          Subject Marks
                           </th>
                             </tr>
                                            <%
                                                // Dynamically display subjects based on class
                                                if ("10th".equals(studentClass) || "10".equals(studentClass)) {
                                                    %>
                                                    <tr><th>English:</th><td><%= marksRs.getString("english_marks") %></td></tr>
                                                    <tr><th>Hindi:</th><td><%= marksRs.getString("hindi_marks") %></td></tr>
                                                    <tr><th>Maths:</th><td><%= marksRs.getString("math_marks") %></td></tr>
                                                    <tr><th>Science:</th><td><%= marksRs.getString("science_marks") %></td></tr>
                                                    <tr><th>Social Science:</th><td><%= marksRs.getString("social_science_marks") %></td></tr>
                                                    <%
                                                } else if ("12th".equals(studentClass)||"12".equals(studentClass)) {
                                                    %>
                                                    <tr><th>English:</th><td><%= marksRs.getString("english_marks") %></td></tr>
                                                    <tr><th>Maths:</th><td><%= marksRs.getString("math_marks") %></td></tr>
                                                    <tr><th>Physics:</th><td><%= marksRs.getString("physics_marks") %></td></tr>
                                                    <tr><th>Chemistry:</th><td><%= marksRs.getString("chemistry_marks") %></td></tr>
                                                    <tr><th>Physical Education:</th><td><%= marksRs.getString("physical_education_marks") %></td></tr>
                                                    <%
                                                }
                                            %>
                                        </table>
        <div style="text-align: center; margin-top: 15px;">
    <!-- For deleting student marks -->
<input type="button" value="Delete" name="b2" class="delete-btn" 
    onclick="confirmDelete('<%= marksRs.getString("roll_no") %>', 'b2')">
</div>                          

                                    </center>
                                </div>
                                <%
                            } 
                    else {
                                %>
                                <script>
                                    showAlert('error', 'Oops...', 'Marks not found for the given Roll No.');
                                </script>
                                <%
                            }
                    }
                    }
                
             catch (Exception e) {
                e.printStackTrace();
                %>
                <script>
                    showAlert('error', 'Error!', 'An error occurred while processing your request.');
                </script>
                <%
            }
        }
    %>
</body>

</html>
