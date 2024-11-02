package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Search Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"abc3.css\">\n");
      out.write("    <style>\n");
      out.write("        #searchdata {\n");
      out.write("            width: 50%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);\n");
      out.write("            /*font-family: Arial, sans-serif;*/\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #searchdata th {\n");
      out.write("            /*background-color: #4CAF50;*/\n");
      out.write("            color:black;\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: left;\n");
      out.write("            font-size: 20px;\n");
      out.write("            border-bottom: 2px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata td {\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: left;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("            font-size: 18px;\n");
      out.write("            color: #333;\n");
      out.write("            background-color:lightgoldenrodyellow;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata tr:nth-child(even) {\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata tr:nth-child(odd) {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata tr:hover {\n");
      out.write("            background-color: #e9e9e9;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata tr th, #searchdata tr td {\n");
      out.write("            border-right: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata tr th:last-child, #searchdata tr td:last-child {\n");
      out.write("            border-right: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #searchdata caption {\n");
      out.write("            font-size: 26px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);\n");
      out.write("            color: darkblue;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .search-container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 10vh;\n");
      out.write("            margin-top:20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .search-box {\n");
      out.write("            position: relative;\n");
      out.write("            width: 400px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .search-box input[type=\"text\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 50px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            outline: none;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .search-box input[type=\"text\"]::placeholder {\n");
      out.write("            color: #999;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .search-box button {\n");
      out.write("            position: absolute;\n");
      out.write("            right: 10px;\n");
      out.write("            top: 50%;\n");
      out.write("            transform: translateY(-50%);\n");
      out.write("            background-color: transparent;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            outline: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .search-box button img {\n");
      out.write("            width: 20px;\n");
      out.write("            height: 20px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("    <script>\n");
      out.write("        function showAlert(icon, title, text) {\n");
      out.write("            Swal.fire({\n");
      out.write("                icon: icon,\n");
      out.write("                title: title,\n");
      out.write("                text: text,\n");
      out.write("                timer: 3000,\n");
      out.write("                showConfirmButton: true\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"mymenu\">\n");
      out.write("        ");
 String userRole = (String) session.getAttribute("role"); 
      out.write("\n");
      out.write("        <ul>\n");
      out.write("        <li class=\"left-item\"><span class=\"heading-text\">Search Student Data</span></li>\n");
      out.write("\n");
      out.write("        ");
 if ("Admin".equals(userRole)) { 
      out.write("\n");
      out.write("            <li class=\"right-item\"><a href=\"Admin.html\">Home</a></li>\n");
      out.write("        ");
 } else if ("Teacher".equals(userRole)) { 
      out.write("\n");
      out.write("            <li class=\"right-item\"><a href=\"Teacher.html\">Home</a></li>\n");
      out.write("        ");
 } else if ("Student".equals(userRole)) { 
      out.write("\n");
      out.write("            <li class=\"right-item\"><a href=\"Student.html\">Home</a></li>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <li class=\"right-item\"><a href=\"Logout\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"mytable\">\n");
      out.write("        <center>\n");
      out.write("            <form action=\"Search.jsp\" method=\"get\">\n");
      out.write("<label style=\"margin-top: 30px; font-weight: bold; text-shadow: 1px 1px 1px gray; color: blue; font-size: 40px;\">Search Marks</label>\n");
      out.write("                 <div class=\"search-container\">\n");
      out.write("        <div class=\"search-box\">\n");
      out.write("                <input type=\"text\" name=\"u1\" placeholder=\"Enter Roll NO..\">\n");
      out.write("                <button type=\"submit\">\n");
      out.write("                    <img src=\"image/SearchLogo.png\" alt=\"Search\">\n");
      out.write("                </button>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("                    ");

                        // Check the user role and display fields accordingly
                        if ("Admin".equals(userRole)) {
                    
      out.write("\n");
      out.write("                <table   cellpadding=\"17\">\n");
      out.write("                    \n");
      out.write("                    <tr style=\"text-align: center;\">\n");
      out.write("    <td style=\"text-align: center;\">\n");
      out.write("        <div style=\"display: inline-block;\">\n");
      out.write("            <input type=\"radio\" id=\"studentData\" name=\"dataType\" value=\"studentData\" required>\n");
      out.write("            <label for=\"studentData\" style=\"font-size: 18px; font-weight: bold; margin-right: 20px;\">Student Data</label>\n");
      out.write("            \n");
      out.write("            <input type=\"radio\" id=\"studentMarks\" name=\"dataType\" value=\"studentMarks\" required>\n");
      out.write("            <label for=\"studentMarks\" style=\"font-size: 18px; font-weight: bold;\">Student Marks</label>\n");
      out.write("        </div>\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </table>\n");
      out.write("                    ");

                        } 
                    
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </center>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");

        String rollNo = request.getParameter("u1"); // Get the input value
        String dataType = request.getParameter("dataType"); // Get the selected data type
        
        if (rollNo != null && !rollNo.trim().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///lalit4?useSSL=false", "root", "Root");
                Statement st = con.createStatement();

                // Get student details
                String studentQuery = "SELECT * FROM studentsdata WHERE roll_no='" + rollNo + "'";
                ResultSet studentRs = st.executeQuery(studentQuery);

                if (studentRs.next()) {
                    String studentClass = studentRs.getString("class");

                    if ("Admin".equals(userRole)) {
                        // Handle Admin search for both data types
                        if ("studentData".equals(dataType)) {
                            // Display student details
                            
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <center>\n");
      out.write("                                    <table  id=\"searchdata\" >\n");
      out.write("                                        <caption>Student Data </caption>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Roll No :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("roll_no") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Name :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("name") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Class :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("class") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >DOB :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("dob") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Address :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("address") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Parent Contact :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("parent_contact") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Admission Date :</th>\n");
      out.write("                                            <td>");
      out.print( studentRs.getString("admission_date") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </center>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                        } else if ("studentMarks".equals(dataType)) {
                            // Query for student marks depending on class (10th or 12th)
                            String marksQuery = "SELECT * FROM studentsmarks WHERE roll_no='" + rollNo + "'";
                            ResultSet marksRs = st.executeQuery(marksQuery);

                            if (marksRs.next()) {
                                
      out.write("\n");
      out.write("                                <div>\n");
      out.write("                                    <center>\n");
      out.write("                                        <table id=\"searchdata\" >\n");
      out.write("                                            <caption>Student Marks</caption>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Roll No :</th>\n");
      out.write("                                                <td>");
      out.print( marksRs.getString("roll_no") );
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th >Name :</th>\n");
      out.write("                                                <td>");
      out.print( marksRs.getString("student_name") );
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                           <th colspan=\"2\" style=\"text-align: center; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4); background-color: lightpink; color: darkblue;\">\n");
      out.write("                          Subject Marks\n");
      out.write("                           </th>\n");
      out.write("                             </tr>\n");
      out.write("                                            ");

                                                // Dynamically display subjects based on class
                                                if ("10th".equals(studentClass)) {
                                                    
      out.write("\n");
      out.write("                                                    <tr><th>English:</th><td>");
      out.print( marksRs.getString("english_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Hindi:</th><td>");
      out.print( marksRs.getString("hindi_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Maths:</th><td>");
      out.print( marksRs.getString("math_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Science:</th><td>");
      out.print( marksRs.getString("science_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Social Science:</th><td>");
      out.print( marksRs.getString("social_science_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    ");

                                                } else if ("12th".equals(studentClass)) {
                                                    
      out.write("\n");
      out.write("                                                    <tr><th>English:</th><td>");
      out.print( marksRs.getString("english_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Maths:</th><td>");
      out.print( marksRs.getString("math_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Physics:</th><td>");
      out.print( marksRs.getString("physics_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Chemistry:</th><td>");
      out.print( marksRs.getString("chemistry_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    <tr><th>Physical Education:</th><td>");
      out.print( marksRs.getString("physical_education_marks") );
      out.write("</td></tr>\n");
      out.write("                                                    ");

                                                }
                                            
      out.write("\n");
      out.write("                                        </table>\n");
      out.write("                                    </center>\n");
      out.write("                                </div>\n");
      out.write("                                ");

                            } else {
                                
      out.write("\n");
      out.write("                                <script>\n");
      out.write("                                    showAlert('error', 'Oops...', 'Marks not found for the given Roll No.');\n");
      out.write("                                </script>\n");
      out.write("                                ");

                            }
                        }
                    } else if ("Teacher".equals(userRole) || "Student".equals(userRole)) {
                        // Allow only marks viewing
                        String marksQuery = "SELECT * FROM studentsmarks WHERE roll_no='" + rollNo + "'";
                        ResultSet marksRs = st.executeQuery(marksQuery);

                        if (marksRs.next()) {
                            
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <center>\n");
      out.write("                                    <table id=\"searchdata\" >\n");
      out.write("                                        <caption>Student Marks</caption>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Roll No :</th>\n");
      out.write("                                            <td>");
      out.print( marksRs.getString("roll_no") );
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th >Name :</th>\n");
      out.write("                                            <td>");
      out.print( marksRs.getString("student_name") );
      out.write("</td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("    <tr>\n");
      out.write("    <th colspan=\"2\" style=\"text-align: center; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4); background-color: lightpink; color: darkblue;\">\n");
      out.write("        Subject Marks\n");
      out.write("    </th>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("                                        ");

                                            // Dynamically display subjects based on class
                                            if ("10th".equals(studentClass)) {
                                                
      out.write("\n");
      out.write("                                                <tr><th>English:</th><td>");
      out.print( marksRs.getString("english_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Hindi:</th><td>");
      out.print( marksRs.getString("hindi_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Maths:</th><td>");
      out.print( marksRs.getString("math_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Science:</th><td>");
      out.print( marksRs.getString("science_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Social Science:</th><td>");
      out.print( marksRs.getString("social_science_marks") );
      out.write("</td></tr>\n");
      out.write("                                                ");

                                            } else if ("12th".equals(studentClass)) {
                                                
      out.write("\n");
      out.write("                                                <tr><th>English:</th><td>");
      out.print( marksRs.getString("english_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Maths:</th><td>");
      out.print( marksRs.getString("math_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Physics:</th><td>");
      out.print( marksRs.getString("physics_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Chemistry:</th><td>");
      out.print( marksRs.getString("chemistry_marks") );
      out.write("</td></tr>\n");
      out.write("                                                <tr><th>Physical Education:</th><td>");
      out.print( marksRs.getString("physical_education_marks") );
      out.write("</td></tr>\n");
      out.write("                                                ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </center>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                        } else {
                            
      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                showAlert('error', 'Oops...', 'Marks not found for the given Roll No.');\n");
      out.write("                            </script>\n");
      out.write("                            ");

                        }
                    } else {
                        
      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            showAlert('error', 'Oops...', 'Invalid Role!');\n");
      out.write("                        </script>\n");
      out.write("                        ");

                    }
                } else {
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        showAlert('error', 'Oops...', 'Student not found with the given Roll No.');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                }
            } catch (Exception e) {
                e.printStackTrace();
                
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    showAlert('error', 'Error!', 'An error occurred while processing your request.');\n");
      out.write("                </script>\n");
      out.write("                ");

            }
        }
    
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
