<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Update Page</title>
    <link rel="stylesheet" href="abc3.css">
    <style>
        
        #searchdata {
            width: 90%;
            border-collapse: collapse;
            margin-top: 20px;
            border: 1px solid #ddd;
          box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
        }
        
        #searchdata th {
            color:black;
            padding: 12px;
            text-align: left;
            font-size: 20px;
            width:300px;
            border-bottom: 2px solid #ddd;
        }

        #searchdata td {
            padding: 12px;
            text-align: left;
            width:200px;
            border-bottom: 1px solid #ddd;
            font-size: 18px;
            color: #333;
            background-color: lightgoldenrodyellow;
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

/*        #searchdata tr th, #searchdata tr td {
            border-right: 1px solid #ddd;
        }*/

/*        #searchdata tr th:last-child, #searchdata tr td:last-child {
            border-right: none;
        }*/

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
            margin-top: 20px;
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
        
        
        
    function validateMarks() {
    let valid = true;
    let errorMessages = [];

    // Fetch all the input fields that contain marks
    let marksFields = document.querySelectorAll('input[name$="_marks"]');
    
    marksFields.forEach(function (field) {
        let marks = parseInt(field.value);
        let subjectName = field.name.replace("_marks", ""); // Extract the subject name

        // Check if the field is empty or non-numeric
        if (isNaN(marks)) {
            errorMessages.push(`${subjectName}: Marks must be a valid number.`);
            valid = false;
        } else if (marks < 0 || marks > 100) {
            // Check if the marks are outside the range of 0-100
            errorMessages.push(`${subjectName}: Marks must be between 0 and 100.`);
            valid = false;
        }
    });

    // If there are errors, show them using SweetAlert
    if (!valid) {
        Swal.fire({
            icon: 'error',
            title: 'Invalid Marks',
            html: errorMessages.join('<br>'), // Display all error messages in the alert
            timer: 5000,
            showConfirmButton: true
        });
    }

    return valid; // Return false if the validation fails
}

    </script>
</head>
<body>
    <div id="mymenu">
        <% String userRole = (String) session.getAttribute("role"); %>
        <ul>

        <% if ("Admin".equals(userRole)) { %>
        <li class="left-item"><span class="heading-text">Update Student Data</span></li>
            <li class="right-item"><a href="Admin.html">Home</a></li>
        <% } else if ("Teacher".equals(userRole)) { %>
        <li class="left-item"><span class="heading-text">Update Student Marks</span></li>
            <li class="right-item"><a href="Teacher.html">Home</a></li>
        <% }%>

        <li class="right-item"><a href="Logout">Logout</a></li>
    </ul>
    </div>

    <div id="mytable">
        <center>
            <form action="Update.jsp" method="get">
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
                <table cellpadding="17">
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
              
        // Get parameters from the request
        String rollNo = request.getParameter("u1");
        String dataType = request.getParameter("dataType");
        
        if (rollNo != null && !rollNo.trim().isEmpty()) {
            try {
                // Database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false", "root", "Root");
                Statement st = con.createStatement();

                // Fetch student details
                String studentQuery = "SELECT * FROM studentsdata WHERE roll_no='" + rollNo + "'";
                ResultSet studentRs = st.executeQuery(studentQuery);

                if (studentRs.next()) {
                    String studentClass = studentRs.getString("class");

                    // Handle Admin access for both data types (Student Data or Marks)
                    if ("Admin".equals(userRole) && "studentData".equals(dataType)) {
                            // Display student details
                            %>
                            <div>
                                <center>
                <form action="UpdateServlet" method="post" >
                                        <table id="searchdata">
                                            <caption>Student Data</caption>
                                            <tr>
                                                <th>Roll No :</th>
                                                <td><input type="text" name="roll_no" value="<%= studentRs.getString("roll_no") %>" readonly></td>
                                            </tr>
                                            <tr>
                                                <th>Name :</th>
                                                <td><input type="text" name="name" value="<%= studentRs.getString("name") %>"></td>
                                            </tr>
                                            <tr>
                                                <th>Class :</th>
                                                <td><input type="text" name="class" value="<%= studentRs.getString("class") %>"></td>
                                            </tr>
                                            <tr>
                                                <th>DOB :</th>
                                                <td><input type="date" name="dob" value="<%= studentRs.getString("dob") %>"></td>
                                            </tr>
                                            <tr>
                                                <th>Address :</th>
                                                <td><input type="text" name="address" value="<%= studentRs.getString("address") %>"></td>
                                            </tr>
                                            <tr>
                                                <th>Parent Contact :</th>
                                                <td><input type="text" name="parent_contact" value="<%= studentRs.getString("parent_contact") %>"></td>
                                            </tr>
                                            <tr>
                                                <th>Admission Date :</th>
                                                <td><input type="date" name="admission_date" value="<%= studentRs.getString("admission_date") %>" readonly></td>
                                            </tr>
                                        </table>
                                        <input type="submit" value="Update Data" name="b1" class="update-btn" style="margin-top: 20px;">
                                    </form>
                                </center>
                            </div>
                            <%
                        } else if ("studentMarks".equals(dataType)  || "Teacher".equals(userRole)) {
                            // Query for student marks depending on class
                            String marksQuery = "SELECT * FROM studentsmarks WHERE roll_no='" + rollNo + "'";
                            ResultSet marksRs = st.executeQuery(marksQuery);

                            if (marksRs.next()) {
                                %>
                                <div>
                                    <center>
                                        <form action="UpdateServlet" method="post" onsubmit="return validateMarks();">
                                            <table id="searchdata">
                                                <caption>Student Marks</caption>
                                                <tr>
                                                    <th>Roll No :</th>
                                                    <td><input type="text" name="roll_no" value="<%= marksRs.getString("roll_no") %>" readonly></td>
                                                </tr>
                                                <tr>
                                                    <th>Student Name :</th>
                                                    <td><input type="text" name="student_name" value="<%= marksRs.getString("student_name") %>" readonly></td>
                                                </tr>
                                                <tr>
                                                    <th>Class :</th>
                                                    <td><input type="text" name="class" value="<%= studentClass %>" readonly></td>
                                                </tr>
                                                <!-- Subject marks based on class (10th or 12th) -->
                                                <%
                                                    if ("10th".equals(studentClass)||"10".equals(studentClass)) { 
                                                %>
                                                <tr>
                                                    <th>English Marks :</th>
                                                    <td><input type="text" name="english_marks" value="<%= marksRs.getString("english_marks") %>" ></td>
                                                </tr>
                                                <tr>
                                                <th>Math Marks :</th>
                                                    <td><input type="text" name="math_marks" value="<%= marksRs.getString("math_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Hindi Marks :</th>
                                                    <td><input type="text" name="hindi_marks" value="<%= marksRs.getString("hindi_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Social Science Marks :</th>
                                                    <td><input type="text" name="social_science_marks" value="<%= marksRs.getString("social_science_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Science Marks :</th>
                                                   <td><input type="text" name="science_marks" value="<%= marksRs.getString("science_marks") %>"></td>
                                                </tr>
                                                <% } else if ("12th".equals(studentClass)||"12".equals(studentClass)) { %>
                                                <tr>
                                                    <th>English Marks :</th>
                                                    <td><input type="text" name="english_marks" value="<%= marksRs.getString("english_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Math Marks :</th>
                                                    <td><input type="text" name="math_marks" value="<%= marksRs.getString("math_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Physics Marks :</th>
                                                    <td><input type="text" name="physics_marks" value="<%= marksRs.getString("physics_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Chemistry Marks :</th>
                                                    <td><input type="text" name="chemistry_marks" value="<%= marksRs.getString("chemistry_marks") %>"></td>
                                                </tr>
                                                <tr>
                                                    <th>Physical Education Marks :</th>
                                                    <td><input type="text" name="physical_education_marks" value="<%= marksRs.getString("physical_education_marks") %>"></td>
                                                </tr>
                                                <% } %>
                                            </table>
                                            <input type="submit" value="Update Marks" name="b2"  class="update-btn" style="margin-top: 20px;">
                                        </form>
                                    </center>
                                </div>
                                <%
                            } else {
                                out.println("<script>showAlert('error', 'Error', 'Marks not found for the entered roll number.');</script>");
                            }
                        }
                    } 
                         else {
                            out.println("<script>showAlert('error', 'Error', 'Student Data not found for the entered roll number.');</script>");
                        }
                                            %>
                                        
                            <%
                    
                 

                studentRs.close();
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<script>showAlert('error', 'Error', 'An error occurred while retrieving student details.');</script>");
            }
        }
    %>
        <% 
        String message1 = (String) request.getAttribute("messageData");
        String message2 = (String) request.getAttribute("messageMark");
        String error = (String) request.getAttribute("error");

//
//        // Clear the session attributes to prevent repeated messages
//        session.removeAttribute("messageData");
//        session.removeAttribute("messageMark");
//        session.removeAttribute("error");

        if (message1 != null) {
            out.println("<script>showAlert('success','Successfully','Student Data Updated !!');</script>");
        }
        if (message2 != null) {
            out.println("<script>showAlert('success','Successfully','Student Marks Updated !!');</script>");
        }
       
    if (error != null && !error.isEmpty()) {
        out.println("<script>");
        out.println("showAlert('error', 'Error!', '" + error.replace("'", "\\'") + "');");
        out.println("</script>");
    }
%>

    

        
</body>
</html>