import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/InsertAdminServlet")
public class InsertAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("class");
        String name = request.getParameter("name");
        String rollNo = request.getParameter("roll_no");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String parentContact = request.getParameter("parent_contact");
        String admissionDate = request.getParameter("admission_date");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            // Check if the roll_no and class combination already exists
            String checkSql = "SELECT * FROM studentsdata WHERE roll_no = ? AND class = ?";
            stmt = conn.prepareStatement(checkSql);
            stmt.setString(1, rollNo);
            stmt.setString(2, className);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Roll number already exists in the same class
                response.sendRedirect("InsertAdmin.jsp?status=duplicate"); // Redirect to avoid duplicate alerts
            } else {
                // Insert query if roll number and class combination is unique
                String insertSql = "INSERT INTO studentsdata (class, name, roll_no, dob, address, parent_contact, admission_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(insertSql);
                stmt.setString(1, className);
                stmt.setString(2, name);
                stmt.setString(3, rollNo);
                stmt.setString(4, dob);
                stmt.setString(5, address);
                stmt.setString(6, parentContact);
                stmt.setString(7, admissionDate);

                stmt.executeUpdate();
                response.sendRedirect("InsertAdmin.jsp?status=success"); // Redirect to avoid duplicate alerts
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("InsertAdmin.jsp?status=error"); // Redirect on error
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
