<!DOCTYPE html>
<html>
<head>
    <title>Admin - Insert Student</title>
    <link rel="stylesheet" href="abc.css">
    
    <!-- Include SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- JavaScript to handle roll number logic -->
    <script type="text/javascript">
        let rollNoPrefix = "";

        function autoFillRollNo() {
            const classSelect = document.getElementById("class");
            const rollNoInput = document.getElementById("roll_no");
            const selectedClass = classSelect.value;

            // Set the roll number prefix based on the selected class
            if (selectedClass === "10th") {
                rollNoPrefix = "10";
            } else if (selectedClass === "12th") {
                rollNoPrefix = "12";
            } else {
                rollNoPrefix = "";
            }

            // Set the roll number field with prefix
            rollNoInput.value = rollNoPrefix; // Set prefix as initial value
            rollNoInput.readOnly = false; // Allow user input for the entire roll number
            rollNoInput.focus(); // Set focus to roll number input
            rollNoInput.setAttribute("maxlength", "5"); // Set max length for the entire roll number
        }

        function validateRollNo() {
            const rollNoInput = document.getElementById("roll_no");
            const rollNoValue = rollNoInput.value;
            const rollNoLength = rollNoValue.length;

            // Ensure the roll number is between 4-6 characters long
            if (rollNoLength < 4 || rollNoLength > 5) {
                rollNoInput.setCustomValidity("Roll number must be 4 to 6 characters long.");
                return false; // Prevent form submission
            } else {
                rollNoInput.setCustomValidity(""); // Clear validation errors
                return true; // Allow form submission
            }
        }

        // Validate form before submission
        function validateForm() {
            const isRollNoValid = validateRollNo();

            if (!isRollNoValid) {
                Swal.fire({
                    icon: 'error',
                    title: 'Invalid Roll Number',
                    text: 'Please ensure the roll number is 4 to 5 characters long.',
                    confirmButtonText: 'OK'
                });
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }

        // Show SweetAlert when data is successfully inserted
        function showSuccessAlert() {
            Swal.fire({
                icon: 'success',
                title: 'Success!',
                text: 'Student data has been successfully inserted into the database.',
                confirmButtonText: 'OK'
            });
        }

        // Show SweetAlert when there is a duplicate roll number
        function showDuplicateAlert() {
            Swal.fire({
                icon: 'error',
                title: 'Error!',
                text: 'Duplicate roll number. Please enter a unique roll number.',
                confirmButtonText: 'OK'
            });
        }
    </script>
</head>
<body>

    <!-- Navigation Menu -->
    <div id="mymenu">
        <ul>
            <li class="left-item">Student Data Insert</li>
            <li><a href="Admin.html">Home</a></li>
            <li><a href="Search.html">Search</a></li>
            <li><a href="ShowALL.html">View Student</a></li>
            <li><a href="Update.html">Update</a></li>
            <li><a href="Delete.html">Delete</a></li>
            <li><a href="Logout">LogOut</a></li>
        </ul>
    </div>

    <h2>Admin - Insert Student Data</h2>
    <div id="mytable">
        <form action="InsertAdminServlet" method="post" onsubmit="return validateForm()">
            <label for="class">Class:</label>
            <select id="class" name="class" onchange="autoFillRollNo()">
                <option value="">Select Class</option>
                <option value="10th">10th</option>
                <option value="12th">12th</option>
            </select>

            <label for="name">Student Name:</label>
            <input type="text" id="name" name="name" required minlength="3">

            <label for="roll_no">Roll Number:</label>
            <input type="text" id="roll_no" name="roll_no" required minlength="4" maxlength="6" oninput="validateRollNo()" placeholder="XXXX or XXXXX">

            <label for="section">Section:</label>
            <select id="section" name="section">
                <option value="A">A</option>
                <option value="B">B</option>
            </select>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>

            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="4" required></textarea>

            <label for="parent_contact">Parent Contact:</label>
            <input type="text" id="parent_contact" name="parent_contact" required pattern="\d{10}" title="Please enter a 10-digit mobile number">

            <label for="admission_date">Admission Date:</label>
            <input type="date" id="admission_date" name="admission_date" required>

            <input type="submit" class="B" value="Insert Student">
        </form>
    </div>

   <%
String status = request.getParameter("status");
if ("success".equals(status)) {
%>
<script type="text/javascript">
    showSuccessAlert(); // Show success SweetAlert
    // Remove the 'status' parameter from the URL to prevent the alert from reappearing on page refresh
    window.history.replaceState(null, null, window.location.pathname);
</script>
<%
} else if ("duplicate".equals(status)) {
%>
<script type="text/javascript">
    showDuplicateAlert(); // Show duplicate roll number SweetAlert
    // Remove the 'status' parameter from the URL
    window.history.replaceState(null, null, window.location.pathname);
</script>
<%
} else if ("error".equals(status)) {
%>
<script type="text/javascript">
    Swal.fire({
        icon: 'error',
        title: 'Error!',
        text: 'There was an error inserting the student data. Please try again.',
        confirmButtonText: 'OK'
    });
    // Remove the 'status' parameter from the URL
    window.history.replaceState(null, null, window.location.pathname);
</script>
<%
}
%>


</body>
</html> 
