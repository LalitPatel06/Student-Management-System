package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Login Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"> <!-- Font Awesome -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"abc.css\"> <!-- Link to external CSS file -->\n");
      out.write("    <!-- SweetAlert CDN -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("     <div id=\"mymenu\">\n");
      out.write("        <ul>\n");
      out.write("            <li class=\"left-item\">Student Management System</li>\n");
      out.write("            <li>Home</li>\n");
      out.write("            <li><a href=\"Login.jsp\">Login</a></li>\n");
      out.write("            <li><a href=\"r1.jsp\">Registration</a></li>\n");
      out.write("            <li>About</li>\n");
      out.write("            <li>Contact</li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div id=\"login-container\">\n");
      out.write("        <form action=\"LoginDemo\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("        <h1>Login</h1>\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("                <label for=\"username\">Username:</label>\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"u1\" required>\n");
      out.write("                <i class=\"fa fa-user icon\"></i> <!-- User Icon -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("                <label for=\"password\">Password:</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"u2\" required>\n");
      out.write("                <i class=\"fa fa-lock icon\"></i> <!-- Lock Icon -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("                <label for=\"role\">Select Role:</label>\n");
      out.write("                <select id=\"role\" name=\"role\" required>\n");
      out.write("                    <option value=\"\" disabled selected>Select your role</option>\n");
      out.write("                    <option value=\"Admin\">Admin</option>\n");
      out.write("                    <option value=\"Teacher\">Teacher</option>\n");
      out.write("                    <option value=\"Student\">Student</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" value=\"Login\" class=\"B\">\n");
      out.write("            <div style=\"text-align: center;\">\n");
      out.write("                <a href=\"Login.jsp\" style=\"color: blue; text-decoration: none;\">Don't have an account? Register here</a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <p class=\"error-message\" id=\"error-message\"></p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Function to validate form before submission\n");
      out.write("        function validateForm() {\n");
      out.write("            const username = document.getElementById(\"username\").value;\n");
      out.write("            const password = document.getElementById(\"password\").value;\n");
      out.write("            const role = document.getElementById(\"role\").value;\n");
      out.write("            const errorMessage = document.getElementById(\"error-message\");\n");
      out.write("\n");
      out.write("            if (username === \"\" || password === \"\" || role === \"\") {\n");
      out.write("                errorMessage.textContent = \"All fields are required.\";\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        // SweetAlert for login failure\n");
      out.write("        window.onload = function() {\n");
      out.write("            const errorMessage = '");
      out.print( request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" );
      out.write("'; \n");
      out.write("            // Ensure the error message is properly handled in JSP\n");
      out.write("            \n");
      out.write("            if (errorMessage !== \"\") {\n");
      out.write("                Swal.fire({\n");
      out.write("                    icon: 'error',\n");
      out.write("                    title: 'Login Failed',\n");
      out.write("                    text: errorMessage,\n");
      out.write("                    confirmButtonColor: '#3085d6',\n");
      out.write("                    confirmButtonText: 'OK'\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("        \n");
      out.write("    </script>\n");
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
