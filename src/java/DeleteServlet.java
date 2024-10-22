import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("Login.jsp");
            return; // Exit to avoid further errors
        }

        String userRole = (String) session.getAttribute("role");  
        String username = (String) session.getAttribute("username");  
        String employeeId = (String) session.getAttribute("employeeId");
        String operationType = "Delete Marks";
        String operationType2 = "Delete Data";
        
        String rollNo = request.getParameter("rollNo");
        String buttonData = request.getParameter("b1");
        String buttonMarks = request.getParameter("b2");

        response.setContentType("text/html");

        if (rollNo != null && !rollNo.trim().isEmpty()) {
            String deleteSQL = "";

            if (buttonData != null && buttonData.equals("Delete")) {
                deleteSQL = "DELETE FROM studentsdata WHERE roll_no = ?";
            } else if (buttonMarks != null && buttonMarks.equals("Delete")) {
                deleteSQL = "DELETE FROM studentsmarks WHERE roll_no = ?";
            }

            if (!deleteSQL.isEmpty()) {
                Connection con = null; // Initialize connection variable
                PreparedStatement pstmt = null; // Initialize prepared statement variable

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false", "root", "Root");
                    pstmt = con.prepareStatement(deleteSQL);
                    pstmt.setString(1, rollNo);
                    
                    int rowsAffected = pstmt.executeUpdate();

                    // Log the operation after deletion
                    String logOperationSQL = "INSERT INTO operationtrack (roll_no, operation, operation_by) VALUES (?, ?, ?)";
PreparedStatement logStmt = con.prepareStatement(logOperationSQL);
logStmt.setString(1, rollNo);

if ("Teacher".equals(userRole)) {
    // Concatenate employeeId and username with a separator (e.g., "-")
    String operationBy = employeeId + " - " + username; // Example: "EMP123 - JohnDoe"
    
    logStmt.setString(2, operationType);
    logStmt.setString(3, operationBy); // Store both employeeId and username
}

                    else
                    {
                    logStmt.setString(2, operationType2);
                          logStmt.setString(3, userRole);
                    }
                    logStmt.executeUpdate(); // Execute the logging statement
                    logStmt.close(); // Close the log statement

                    if (rowsAffected > 0) {
                        response.getWriter().write("status=success&entity=" + (buttonData != null ? "data" : "marks"));
                    } else {
                        response.getWriter().write("status=failure");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.getWriter().write("status=error");
                } finally {
                    if (pstmt != null) {
                        try {
                            pstmt.close(); // Close the prepared statement
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (con != null) {
                        try {
                            con.close(); // Close the connection
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            response.getWriter().write("status=invalid");
        }
    }
}
