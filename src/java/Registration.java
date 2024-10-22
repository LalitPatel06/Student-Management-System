import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve the common fields
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String contact = request.getParameter("contact").trim();
        String password = request.getParameter("password").trim();  /*admin password */
        String role = request.getParameter("role").trim();
        String employeeId ="";
        if (role.equals("Teacher"))
        {
              employeeId = request.getParameter("employeeId").trim();
        }
        
        Connection con = null;
        Statement stmt = null;

        try {
            // Load the JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            // Create a Statement object
            stmt = con.createStatement();

            // Insert into RegisAdmin table for Admin role
            String query = "INSERT INTO regisadmin (username, email, contact, password, role, employeeId) VALUES ('"
                    + username + "', '"
                    + email + "', '"
                    + contact + "', '"
                    + password + "', '"
                    + role + "', '"
                    + employeeId +"')";
            int result = stmt.executeUpdate(query);

            // Insert role-specific data
            if (role.equals("Admin")) {
                // Admin-specific handling
                System.out.println("Role: " + role + " registration successful. Redirecting to login.");
                response.sendRedirect("r1.html");
            } else if (role.equals("Teacher")) {
                // Teacher-specific fields
                String department = request.getParameter("department").trim();
                String subject = request.getParameter("subjectTaught").trim();
                String passwordTeacher = request.getParameter("passwordTeacher").trim();

                query = "INSERT INTO registeachers (username, employeeId, department, subject, password) VALUES ('"
                        + username + "', '"
                        + employeeId + "', '"
                        + department + "', '"
                        + subject + "', '"
                        + passwordTeacher + "')";
               int result1= stmt.executeUpdate(query);
                response.sendRedirect("r1.html");

            } else if (role.equals("Student")) {
                // Student-specific fields
               
                String dob = request.getParameter("dob").trim();
                String passwordStudent = request.getParameter("passwordStudent").trim();

                
                query = "INSERT INTO regisstudents (username, dob, password) VALUES ('"
                        + username + "', '"
                        + dob + "', '"
                        + passwordStudent + "')";
                int result2=stmt.executeUpdate(query);
                response.sendRedirect("r1.html");
            }

        }  catch (SQLException e) {
            String errorMessage = e.getMessage();
            // Redirect to registration page with an error message
            response.sendRedirect("r1.html?error=" + errorMessage);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            // Redirect to registration page with an error message
            response.sendRedirect("r1.html?error=" + errorMessage);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            out.close();
        }
    }
}
