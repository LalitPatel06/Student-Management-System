<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher - Insert Student Marks</title>
    <link rel="stylesheet" href="abc.css">

    <!-- Include SweetAlert2 for alerts -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <script type="text/javascript">
        function updateSubjectFields() {
            const classSelection = document.getElementById("class").value;
            const subjectFieldsDiv = document.getElementById("subject_fields");

            subjectFieldsDiv.innerHTML = ''; // Clear any existing subject fields

            if (classSelection === "10th") {
                subjectFieldsDiv.innerHTML = `
                    <label for="english_marks">English Marks:</label>
                    <input type="number" id="english_marks" name="english_marks" required min="0" max="100">
                    <label for="hindi_marks">Hindi Marks:</label>
                    <input type="number" id="hindi_marks" name="hindi_marks" required min="0" max="100">
                    <label for="math_marks">Mathematics Marks:</label>
                    <input type="number" id="math_marks" name="math_marks" required min="0" max="100">
                    <label for="science_marks">Science Marks:</label>
                    <input type="number" id="science_marks" name="science_marks" required min="0" max="100">
                    <label for="social_science_marks">Social Science Marks:</label>
                    <input type="number" id="social_science_marks" name="social_science_marks" required min="0" max="100">
                `;
            } else if (classSelection === "12th") {
                subjectFieldsDiv.innerHTML = `
                    <label for="english_marks">English Marks:</label>
                    <input type="number" id="english_marks" name="english_marks" required min="0" max="100">
                    <label for="physics_marks">Physics Marks:</label>
                    <input type="number" id="physics_marks" name="physics_marks" required min="0" max="100">
                    <label for="chemistry_marks">Chemistry Marks:</label>
                    <input type="number" id="chemistry_marks" name="chemistry_marks" required min="0" max="100">
                    <label for="math_marks">Math Marks:</label>
                    <input type="number" id="math_marks" name="math_marks" required min="0" max="100">
                    <label for="physical_education_marks">Physical Education Marks:</label>
                    <input type="number" id="physical_education_marks" name="physical_education_marks" required min="0" max="100">
                `;
            }
        }

        function fetchStudentName() {
            var rollNo = document.getElementById("roll_no").value;
            var classSelection = document.getElementById("class").value;

            if (rollNo === "" || classSelection === "") {
                Swal.fire({
                    icon: 'error',
                    title: 'Error!',
                    text: 'Please select a class and enter a roll number before fetching the student name.',
                    confirmButtonText: 'OK'
                });
                return;
            }

            var xhr = new XMLHttpRequest();
            xhr.open("GET", "FetchStudentName.jsp?roll_no=" + rollNo + "&class=" + classSelection, true);  // Ensure "class" is passed as a parameter
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var response = xhr.responseText.trim();
                    if (response !== "") {
                        document.getElementById("student_name").value = response;
                    } else {
                        document.getElementById("student_name").value = "";
                        Swal.fire({
                            icon: 'error',
                            title: 'Error!',
                            text: 'Roll number not found in the selected class.',
                            confirmButtonText: 'OK'
                        });
                    }
                }
            };
            xhr.send();
        }

        function validateForm() {
            const rollNo = document.getElementById("roll_no").value;
            const studentName = document.getElementById("student_name").value;
            const classSelection = document.getElementById("class").value;

            if (rollNo === "" || studentName === "" || classSelection === "") {
                Swal.fire({
                    icon: 'error',
                    title: 'Error!',
                    text: 'Please ensure all fields are filled in correctly.',
                    confirmButtonText: 'OK'
                });
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <!-- Navigation Menu -->
    <div id="mymenu">
        <ul>
            <li class="left-item">Insert Student Marks</li>
            <li><a href="Teacher.html">Home</a></li>
            <li><a href="Logout">LogOut</a></li>
        </ul>
    </div>

    <h2>Teacher - Insert Student Marks</h2>

    <div id="mytable">
        <form action="InsertTeacherServlet3" method="post" onsubmit="return validateForm()">
            <label for="class">Class:</label>
            <select id="class" name="class" required onchange="updateSubjectFields()">
                <option value="">Select Class</option>
                <option value="10th">10th</option>
                <option value="12th">12th</option>
            </select>

            <label for="roll_no">Roll Number:</label>
            <input type="text" id="roll_no" name="roll_no" required minlength="4" maxlength="6" onblur="fetchStudentName()">

            <label for="student_name">Student Name:</label>
            <input type="text" id="student_name" name="student_name" readonly>

            <h3>Enter Marks</h3>
            <div id="subject_fields">
                <!-- Subject fields will be populated here based on the selected class -->
            </div>

            <input type="submit" value="Insert Marks" class="B">
        </form>
    </div>
        <%-- Handle success or error messages from the servlet --%>
    <%
    String status = request.getParameter("status");
String msg = request.getParameter("msg");
if (msg != null) {
%>
<script type="text/javascript">
    Swal.fire({
        icon: 'error',
        title: 'Error!',
        text: '<%= msg %>',
        confirmButtonText: 'OK'
    });
</script>
<%
}

    if ("success".equals(status)) {
    %>
    <script type="text/javascript">
        Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Marks have been successfully inserted.',
            confirmButtonText: 'OK'
        });
        window.history.replaceState(null, null, window.location.pathname); // Remove status from URL
    </script>
    <%
    } else if (msg != null) {
%>
<script type="text/javascript">
    Swal.fire({
        icon: 'error',
        title: 'Error!',
        text: '<%= msg %>',
        confirmButtonText: 'OK'
    });
</script>
<%
}
    %>
</body>
</html>
