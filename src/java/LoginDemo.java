import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginDemo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String username = request.getParameter("u1").trim();
        String password = request.getParameter("u2").trim();
        String role = request.getParameter("role").trim();

        out.println("<html>");
        out.println("<body>");

        try {
            // Load the JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            String query = "";

            // Role-based query to the relevant table
            if (role.equals("Admin")) {
    query = "SELECT * FROM regisadmin WHERE BINARY username=? AND BINARY password=?";
} else if (role.equals("Teacher")) {
    query = "SELECT * FROM registeachers WHERE BINARY username=? AND BINARY password=?";
} else if (role.equals("Student")) {
    query = "SELECT * FROM regisstudents WHERE BINARY username=? AND BINARY password=?";
}


            // Prepare statement to avoid SQL injection
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // User found, set session and redirect based on role
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                if ("Teacher".equals(role)) {
                    // Fetch the Employee ID from the registeachers table
                    String employeeId = rs.getString("employeeId");
                    // Store the Employee ID in the session
                    session.setAttribute("employeeId", employeeId);

                    response.sendRedirect("Teacher.html");
                } else if ("Admin".equals(role)) {
                    response.sendRedirect("Admin.html");
                } else if ("Student".equals(role)) {
                    response.sendRedirect("Student.html");
                }
            } else {
                // Send error message back to login page
                request.setAttribute("errorMessage", "Incorrect username or password.");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response); // Forward with error message
            }

            con.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
