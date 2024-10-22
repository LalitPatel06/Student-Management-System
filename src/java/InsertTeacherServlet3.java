import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;



@WebServlet("/InsertTeacherServlet3")
public class InsertTeacherServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//        // Retrieve session object
//        HttpSession session = request.getSession();
//        String employeeId = (String) session.getAttribute("employeeId");

 HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("Login.jsp");
            return; // Exit to avoid further errors
        }

        String userRole = (String) session.getAttribute("role");  
        String username = (String) session.getAttribute("username");  
        String employeeId = (String) session.getAttribute("employeeId");
                String operationType = "Insert Marks";

        // Retrieve form data
        String classSelection = request.getParameter("class");
        String rollNo = request.getParameter("roll_no");
        String studentName = request.getParameter("student_name");
        int englishMarks = Integer.parseInt(request.getParameter("english_marks"));
        int mathMarks = Integer.parseInt(request.getParameter("math_marks"));

        // Initialize variables for optional subjects
        Integer hindiMarks = null, scienceMarks = null, socialScienceMarks = null;
        Integer physicsMarks = null, chemistryMarks = null, physicalEducationMarks = null;

        // For 10th class
        if (classSelection.equals("10th")||classSelection.equals("10")) {
            hindiMarks = Integer.parseInt(request.getParameter("hindi_marks"));
            scienceMarks = Integer.parseInt(request.getParameter("science_marks"));
            socialScienceMarks = Integer.parseInt(request.getParameter("social_science_marks"));
        } 
        // For 12th class
        else if (classSelection.equals("12th") || classSelection.equals("12")) {
            physicsMarks = Integer.parseInt(request.getParameter("physics_marks"));
            chemistryMarks = Integer.parseInt(request.getParameter("chemistry_marks"));
            physicalEducationMarks = Integer.parseInt(request.getParameter("physical_education_marks"));
        }

      // Database connection and insertion
Connection conn = null;
PreparedStatement pstmt = null;
PreparedStatement logPstmt = null; // Separate PreparedStatement for operation track
try {
    // Load JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Connect to MySQL database
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

    // Prepare the SQL insert statement with optional marks
    String sql = "INSERT INTO studentsmarks (roll_no, student_name, class, english_marks, math_marks, "
        + "hindi_marks, science_marks, social_science_marks, "
        + "physics_marks, chemistry_marks, physical_education_marks, inserted_by) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, rollNo);
    pstmt.setString(2, studentName);
    pstmt.setString(3, classSelection);
    pstmt.setInt(4, englishMarks);  // English marks are always required
    pstmt.setInt(5, mathMarks);     // Math marks are always required

    // Handle optional subjects for class 10th
    if (classSelection.equals("10th") || classSelection.equals("10")) {
        pstmt.setObject(6, hindiMarks);
        pstmt.setObject(7, scienceMarks);
        pstmt.setObject(8, socialScienceMarks);
        pstmt.setNull(9, java.sql.Types.INTEGER);  // Physics Marks
        pstmt.setNull(10, java.sql.Types.INTEGER); // Chemistry Marks
        pstmt.setNull(11, java.sql.Types.INTEGER); // Physical Education Marks
        pstmt.setObject(12, employeeId);  // Inserted by (employeeId)
    } 
    // Handle optional subjects for class 12th
    else if (classSelection.equals("12th") || classSelection.equals("12")) {
        pstmt.setNull(6, java.sql.Types.INTEGER);  // Hindi Marks
        pstmt.setNull(7, java.sql.Types.INTEGER);  // Science Marks
        pstmt.setNull(8, java.sql.Types.INTEGER);  // Social Science Marks
        pstmt.setObject(9, physicsMarks);
        pstmt.setObject(10, chemistryMarks);
        pstmt.setObject(11, physicalEducationMarks);
        pstmt.setObject(12, employeeId);  // Inserted by (employeeId)
    }

    // Execute the insert for students marks
    int rowsInserted = pstmt.executeUpdate();

    if (rowsInserted > 0) {
        // If marks were successfully inserted, log the operation
        String logOperationSQL = "INSERT INTO operationtrack (roll_no, operation, operation_by) VALUES (?, ?, ?)";
        logPstmt = conn.prepareStatement(logOperationSQL);
        logPstmt.setString(1, rollNo);
        
        // Concatenate employeeId and username
        String operationBy = employeeId + " - " + username; 
        logPstmt.setString(2, operationType);
        logPstmt.setString(3, operationBy);
        
        // Execute the log insertion
        int logRowsInserted = logPstmt.executeUpdate();

        if (logRowsInserted > 0) {
            // Both insertions succeeded
            response.sendRedirect("InsertTeacher.jsp?status=success");
        } else {
            // Log insertion failed
            response.sendRedirect("InsertTeacher.jsp?status=error&msg=LogInsertionFailed");
        }
    } else {
        // Marks insertion failed
        response.sendRedirect("InsertTeacher.jsp?status=error&msg=MarksInsertionFailed");
    }
} catch (Exception e) {
    e.printStackTrace();
    try {
        String encodedMsg = URLEncoder.encode(e.getMessage(), "UTF-8");
        response.sendRedirect("InsertTeacher.jsp?status=error&msg=" + encodedMsg);
    } catch (UnsupportedEncodingException ue) {
        ue.printStackTrace();
        response.sendRedirect("InsertTeacher.jsp?status=error&msg=EncodingError");
    }
} finally {
    try {
        if (pstmt != null) pstmt.close();
        if (logPstmt != null) logPstmt.close(); // Close the log PreparedStatement
        if (conn != null) conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }
}
