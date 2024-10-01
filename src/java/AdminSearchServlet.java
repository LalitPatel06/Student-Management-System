// AdminSearchServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdminSearchServlet")
public class AdminSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNo = request.getParameter("roll_no");
        String name = request.getParameter("name");
        String className = request.getParameter("class");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM studentsdata WHERE 1=1");
        if (rollNo != null && !rollNo.trim().isEmpty()) {
            queryBuilder.append(" AND roll_no LIKE ?");
        }
        if (name != null && !name.trim().isEmpty()) {
            queryBuilder.append(" AND name LIKE ?");
        }
        if (className != null && !className.trim().isEmpty()) {
            queryBuilder.append(" AND class = ?");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");
            stmt = conn.prepareStatement(queryBuilder.toString());

            int paramIndex = 1;
            if (rollNo != null && !rollNo.trim().isEmpty()) {
                stmt.setString(paramIndex++, "%" + rollNo + "%");
            }
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(paramIndex++, "%" + name + "%");
            }
            if (className != null && !className.trim().isEmpty()) {
                stmt.setString(paramIndex++, className);
            }

            rs = stmt.executeQuery();

            // Start HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Admin Search Results</title>");
            out.println("<link rel='stylesheet' href='abc2.css'><style>");
            out.println("table { width: 80%; margin: auto; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("</style></head><body>");
            out.println("<h2 style='text-align:center;'>Admin Search Results</h2>");

            if (!rs.isBeforeFirst()) { // Check if ResultSet is empty
                response.sendRedirect("Search.jsp?error=noResults");
                return;
            }

            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Roll No</th><th>Class</th><th>Date of Birth</th><th>Address</th><th>Parent Contact</th><th>Admission Date</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("roll_no") + "</td>");
                out.println("<td>" + rs.getString("class") + "</td>");
                out.println("<td>" + rs.getDate("dob") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("parent_contact") + "</td>");
                out.println("<td>" + rs.getDate("admission_date") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br><div style='text-align:center;'><a href='Search.jsp'>Back to Search</a></div>");
            out.println("</body></html>");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("Search.jsp?error=database");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.flush();
        out.close();
    }
}
