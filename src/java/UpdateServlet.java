import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Don't forget to import ResultSet
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
    response.sendRedirect("Login.jsp");
    return; // Exit to avoid further errors
}

        String userRole = (String) session.getAttribute("role");  
        String username = (String) session.getAttribute("username");  
        String employeeId = (String) session.getAttribute("employeeId");

        String bdata=request.getParameter("b1");
        String bmark=request.getParameter("b2");
        
        String rollNo = request.getParameter("roll_no");
        String studentName = request.getParameter("name");
        String studentName2 = request.getParameter("student_name");
        String className = request.getParameter("class");

        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String parentContact = request.getParameter("parent_contact");
        String admissionDate = request.getParameter("admission_date");

        // Marks parameters
        String englishMarks = request.getParameter("english_marks");
        String mathMarks = request.getParameter("math_marks");
        String hindiMarks = request.getParameter("hindi_marks");
        String scienceMarks = request.getParameter("science_marks");
        String socialScienceMarks = request.getParameter("social_science_marks");
        String physicsMarks = request.getParameter("physics_marks");
        String chemistryMarks = request.getParameter("chemistry_marks");
        String physicalEducationMarks = request.getParameter("physical_education_marks");



        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            if(bdata!=null)
            {
            // Update student data if the user is an admin
            if ("Admin".equals(userRole)) {
                String updateStudentDataSQL = "UPDATE studentsdata SET class=?, name=?, dob=?, address=?, parent_contact=?, admission_date=? WHERE roll_no=?";
                pstmt = conn.prepareStatement(updateStudentDataSQL);
                pstmt.setString(1, className);
                pstmt.setString(2, studentName);
                pstmt.setString(3, dob);
                pstmt.setString(4, address);
                pstmt.setString(5, parentContact);
                pstmt.setString(6, admissionDate);
                pstmt.setString(7, rollNo);
                pstmt.executeUpdate();
                
                  // Log the operation
                logOperation(conn, rollNo, "Update Data", employeeId, username, userRole);

                
                // Success message
            request.setAttribute("messageData", "Update successful!");
            request.getRequestDispatcher("Update.jsp").forward(request, response);
            }
            }
       if(bmark!=null)
       {
            // Step 1: Retrieve the class of the student based on roll_no
            String getClassSQL = "SELECT class FROM studentsmarks WHERE roll_no = ?";
            pstmt = conn.prepareStatement(getClassSQL);
            pstmt.setString(1, rollNo);
            ResultSet rs = pstmt.executeQuery();

            // No need to redeclare className here
            if (rs.next()) {
                className = rs.getString("class");
            }

            // Step 2: Update marks based on the class (10th or 12th)
           if ("12th".equalsIgnoreCase(className)||"12".equalsIgnoreCase(className)) {
    String updateMarksSQL12th = "UPDATE studentsmarks SET student_name=?, class=?, "
            + "english_marks=?, math_marks=?, physics_marks=?, chemistry_marks=?, "
            + "physical_education_marks=? WHERE roll_no=?";
    pstmt = conn.prepareStatement(updateMarksSQL12th);
    pstmt.setString(1, studentName2);
    pstmt.setString(2, className);
    pstmt.setString(3, (englishMarks.isEmpty() ? null : englishMarks));
    pstmt.setString(4, (mathMarks.isEmpty() ? null : mathMarks));
    pstmt.setString(5, (physicsMarks.isEmpty() ? null : physicsMarks));
    pstmt.setString(6, (chemistryMarks.isEmpty() ? null : chemistryMarks));
    pstmt.setString(7, (physicalEducationMarks.isEmpty() ? null : physicalEducationMarks));
    pstmt.setString(8, rollNo);
    pstmt.executeUpdate();
    
    logOperation(conn, rollNo, "Update Marks", employeeId, username, userRole);
    
    request.setAttribute("messageMark", "Update successful!");
    request.getRequestDispatcher("Update.jsp").forward(request, response);
}

            else if ("10th".equalsIgnoreCase(className)||"10".equalsIgnoreCase(className)) {
                // Update 10th class marks
                String updateMarksSQL10th = "UPDATE studentsmarks SET student_name=?, class=?, "
                        + "english_marks=?, math_marks=?, hindi_marks=?, science_marks=?, "
                        + "social_science_marks=? WHERE roll_no=?";
                pstmt = conn.prepareStatement(updateMarksSQL10th);
                pstmt.setString(1, studentName2);
                pstmt.setString(2, className);
                pstmt.setString(3, (englishMarks.isEmpty() ? null : englishMarks));
                pstmt.setString(4, (mathMarks.isEmpty() ? null : mathMarks));
                pstmt.setString(5, (hindiMarks.isEmpty() ? null : hindiMarks));
                pstmt.setString(6, (scienceMarks.isEmpty() ? null : scienceMarks));
                pstmt.setString(7, (socialScienceMarks.isEmpty() ? null : socialScienceMarks));
                pstmt.setString(8, rollNo);
                pstmt.executeUpdate();
                
                                    // Log the operation
                    logOperation(conn, rollNo, "Update Marks", employeeId, username, userRole);

                
                // Success message
            request.setAttribute("messageMark", "Update successful!");
            request.getRequestDispatcher("Update.jsp").forward(request, response);
            } 
       }
        } catch (Exception e) {
    e.printStackTrace(); // This prints the stack trace to the server logs
    // Capture the error message
    String errorMessage = e.getMessage();
    // Set the error message in the request
    request.setAttribute("error", "Update failed: " + errorMessage);
    request.getRequestDispatcher("Update.jsp").forward(request, response);
}
finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
// Method to log the operation
    private void logOperation(Connection con, String rollNo, String operationType, String employeeId, String username, String userRole) throws Exception {
        String logOperationSQL = "INSERT INTO operationtrack (roll_no, operation, operation_by) VALUES (?, ?, ?)";
        PreparedStatement logStmt = con.prepareStatement(logOperationSQL);
        logStmt.setString(1, rollNo);

        if ("Teacher".equals(userRole)) {
            String operationBy = employeeId + " - " + username;
            logStmt.setString(2, operationType);
            logStmt.setString(3, operationBy);
        } else {
            logStmt.setString(2, operationType);
            logStmt.setString(3, userRole);
        }

        logStmt.executeUpdate();
        logStmt.close();
    }
}