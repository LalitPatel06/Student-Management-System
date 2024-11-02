package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ShowALL_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>View Students Marks and Data</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"abc.css\">\n");
      out.write("    <style>\n");
      out.write("        select, input[type=\"submit\"] {\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-right: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }\n");
      out.write("        #showdata {\n");
      out.write("            width: 80%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            border:2px solid black;\n");
      out.write("        }\n");
      out.write("        #showdata th, td {\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: left;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("        #showdata th {\n");
      out.write("            background-color: lightskyblue;\n");
      out.write("            color: yellow;\n");
      out.write("            border-bottom: 1px solid black;\n");
      out.write("        }\n");
      out.write("        #showdata tr:hover {\n");
      out.write("            background-color: #f1f1f1;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("        <script>\n");
      out.write("        // JavaScript to validate the form before submission\n");
      out.write("        function validateForm() {\n");
      out.write("            var classField = document.getElementById(\"class\").value;\n");
      out.write("            var viewField = document.getElementById(\"view\").value;\n");
      out.write("\n");
      out.write("            // Check if both fields are selected\n");
      out.write("            if (classField === \"\" || viewField === \"\") {\n");
      out.write("                alert(\"Please select both Class and View options.\");\n");
      out.write("                return false; // Prevent form submission\n");
      out.write("            }\n");
      out.write("            return true; // Allow form submission\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"mymenu\">\n");
      out.write("        <ul>\n");
      out.write("            <li class=\"left-item\"><span class=\"heading-text\">Students Data and Marks</span></li>\n");
      out.write("            <li class=\"right-item\"><a href=\"Admin.html\">Admin Dashboard</a></li>\n");
      out.write("            <li class=\"right-item\"><a href=\"LogoutDemo\">Logout</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"mytable2\">\n");
      out.write("        <center>\n");
      out.write("            <h2>Admin Options</h2>\n");
      out.write("            <!-- Dropdown for class selection and options for viewing -->\n");
      out.write("            <form method=\"post\" action=\"ShowALL\" onsubmit=\"return validateForm()\">\n");
      out.write("                <label for=\"class\">Select Class:</label>\n");
      out.write("                <select name=\"class\" id=\"class\">\n");
      out.write("                    <option value=\"\">-- Select Class --</option>\n");
      out.write("                    <option value=\"10th\">10th</option>\n");
      out.write("                    <option value=\"12th\">12th</option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <label for=\"view\">View:</label>\n");
      out.write("                <select name=\"view\" id=\"view\">\n");
      out.write("                    <option value=\"\">-- Select View --</option>\n");
      out.write("                    <option value=\"Student Data\">Student Data</option>\n");
      out.write("                    <option value=\"Student Marks\">Student Marks</option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"View\" class=\"B\">\n");
      out.write("            </form>\n");
      out.write("\n");

    // Retrieve the selected class and view option from the session
    String selectedClass = (String) session.getAttribute("selectedClass");
    String viewOption = (String) session.getAttribute("viewOption");

    if (selectedClass != null && viewOption != null) {
        // Display data for the selected class and view option
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            if (viewOption.equals("Student Data")) {

      out.write("\n");
      out.write("                <h2>Student Data List for ");
      out.print( selectedClass );
      out.write("</h2>\n");
      out.write("                <table id=\"showdata\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Class</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Roll No</th>\n");
      out.write("                        <th>Date of Birth</th>\n");
      out.write("                        <th>Address</th>\n");
      out.write("                        <th>Parent Contact</th>\n");
      out.write("                        <th>Admission Date</th>\n");
      out.write("                    </tr>\n");

                String query = "SELECT * FROM studentsdata WHERE class = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, selectedClass);
                rs = ps.executeQuery();

                while (rs.next()) {

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( rs.getInt("id") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("class") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("name") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("roll_no") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getDate("dob") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("address") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("parent_contact") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getDate("admission_date") );
      out.write("</td>\n");
      out.write("                    </tr>\n");

                }

      out.write("\n");
      out.write("                </table>\n");

            } else if (viewOption.equals("Student Marks")) {

      out.write("\n");
      out.write("                <h2>Student Marks List for ");
      out.print( selectedClass );
      out.write("</h2>\n");
      out.write("                <table id=\"showdata\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Roll No</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Class</th>\n");
      out.write("                        ");
 if (selectedClass.equals("10th")) { 
      out.write("\n");
      out.write("                            <th>English</th>\n");
      out.write("                            <th>Math</th>\n");
      out.write("                            <th>Hindi</th>\n");
      out.write("                            <th>Science</th>\n");
      out.write("                            <th>Social Science</th>\n");
      out.write("                        ");
 } else if (selectedClass.equals("12th")) { 
      out.write("\n");
      out.write("                            <th>English</th>\n");
      out.write("                            <th>Math</th>\n");
      out.write("                            <th>Physics</th>\n");
      out.write("                            <th>Chemistry</th>\n");
      out.write("                            <th>Physical Education</th>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tr>\n");

                String marksQuery = "SELECT * FROM studentsmarks WHERE class = ?";
                ps = con.prepareStatement(marksQuery);
                ps.setString(1, selectedClass);
                rs = ps.executeQuery();

                while (rs.next()) {

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( rs.getString("roll_no") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("student_name") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("class") );
      out.write("</td>\n");
      out.write("                        ");
 if (selectedClass.equals("10th")) { 
      out.write("\n");
      out.write("                            <td>");
      out.print( rs.getInt("english_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("math_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("hindi_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("science_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("social_science_marks") );
      out.write("</td>\n");
      out.write("                        ");
 } else if (selectedClass.equals("12th")) { 
      out.write("\n");
      out.write("                            <td>");
      out.print( rs.getInt("english_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("math_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("physics_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("chemistry_marks") );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getInt("physical_education_marks") );
      out.write("</td>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tr>\n");

                }

      out.write("\n");
      out.write("                </table>\n");

            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

      out.write("\n");
      out.write("        </center>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
