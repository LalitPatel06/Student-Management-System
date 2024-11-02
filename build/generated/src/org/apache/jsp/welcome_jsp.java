package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("    <title>Welcome to Student Management System</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background-color: #f0f2f5;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color: #2c3e50;\n");
      out.write("            color: #ecf0f1;\n");
      out.write("            padding: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header h1 {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 36px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            width: 90%;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin: 40px auto;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .welcome-message {\n");
      out.write("            margin-bottom: 40px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .welcome-message h2 {\n");
      out.write("            font-size: 32px;\n");
      out.write("            color: #34495e;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .welcome-message p {\n");
      out.write("            font-size: 18px;\n");
      out.write("            color: #7f8c8d;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .role {\n");
      out.write("            background-color: #ffffff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 30px;\n");
      out.write("            margin: 20px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\n");
      out.write("            transition: transform 0.3s ease, box-shadow 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .role:hover {\n");
      out.write("            transform: translateY(-10px);\n");
      out.write("            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h3 {\n");
      out.write("            font-size: 24px;\n");
      out.write("            color: #2c3e50;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .role p {\n");
      out.write("            font-size: 16px;\n");
      out.write("            color: #7f8c8d;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a {\n");
      out.write("            display: inline-block;\n");
      out.write("            margin: 10px 20px;\n");
      out.write("            padding: 12px 30px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            background-color: #27ae60;\n");
      out.write("            color: #fff;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a:hover {\n");
      out.write("            background-color: #1e8449;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        footer {\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #2c3e50;\n");
      out.write("            color: white;\n");
      out.write("            position: relative;\n");
      out.write("            bottom: 0;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Responsive design */\n");
      out.write("        @media (max-width: 768px) {\n");
      out.write("            .role {\n");
      out.write("                margin: 20px auto;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @media (max-width: 480px) {\n");
      out.write("            header h1 {\n");
      out.write("                font-size: 28px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .welcome-message h2 {\n");
      out.write("                font-size: 24px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            nav a {\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                margin: 5px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Welcome to the Student Management System</h1>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"welcome-message\">\n");
      out.write("            <h2>Manage Student Records Efficiently</h2>\n");
      out.write("            <p>Select your role below to get started:</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Role Options -->\n");
      out.write("        <div class=\"role\">\n");
      out.write("            <h3>Admin</h3>\n");
      out.write("            <p>Administer student data and manage teacher accounts.</p>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"Login.jsp\">Login</a>\n");
      out.write("                <a href=\"r1.html\">Sign Up</a>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"role\">\n");
      out.write("            <h3>Teacher</h3>\n");
      out.write("            <p>Input student marks and view student records.</p>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"Login.jsp\">Login</a>\n");
      out.write("                <a href=\"r1.html\">Sign Up</a>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"role\">\n");
      out.write("            <h3>Student</h3>\n");
      out.write("            <p>Access your records and view your grades.</p>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"Login.jsp\">Login</a>\n");
      out.write("                <a href=\"r1.html\">Sign Up</a>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Student Management System. All Rights Reserved.</p>\n");
      out.write("    </footer>\n");
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
