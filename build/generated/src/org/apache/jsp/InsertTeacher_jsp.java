package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InsertTeacher_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Teacher - Insert Student Marks</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"abc.css\">\n");
      out.write("\n");
      out.write("    <!-- Include SweetAlert2 for alerts -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function updateSubjectFields() {\n");
      out.write("            const classSelection = document.getElementById(\"class\").value;\n");
      out.write("            const subjectFieldsDiv = document.getElementById(\"subject_fields\");\n");
      out.write("\n");
      out.write("            subjectFieldsDiv.innerHTML = ''; // Clear any existing subject fields\n");
      out.write("\n");
      out.write("            if (classSelection === \"10th\") {\n");
      out.write("                subjectFieldsDiv.innerHTML = `\n");
      out.write("                    <label for=\"english_marks\">English Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"english_marks\" name=\"english_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"hindi_marks\">Hindi Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"hindi_marks\" name=\"hindi_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"math_marks\">Mathematics Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"math_marks\" name=\"math_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"science_marks\">Science Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"science_marks\" name=\"science_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"social_science_marks\">Social Science Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"social_science_marks\" name=\"social_science_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                `;\n");
      out.write("            } else if (classSelection === \"12th\") {\n");
      out.write("                subjectFieldsDiv.innerHTML = `\n");
      out.write("                    <label for=\"english_marks\">English Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"english_marks\" name=\"english_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"physics_marks\">Physics Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"physics_marks\" name=\"physics_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"chemistry_marks\">Chemistry Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"chemistry_marks\" name=\"chemistry_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"math_marks\">Math Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"math_marks\" name=\"math_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                    <label for=\"physical_education_marks\">Physical Education Marks:</label>\n");
      out.write("                    <input type=\"number\" id=\"physical_education_marks\" name=\"physical_education_marks\" required min=\"0\" max=\"100\">\n");
      out.write("                `;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function fetchStudentName() {\n");
      out.write("            var rollNo = document.getElementById(\"roll_no\").value;\n");
      out.write("            var classSelection = document.getElementById(\"class\").value;\n");
      out.write("\n");
      out.write("            if (rollNo === \"\" || classSelection === \"\") {\n");
      out.write("                Swal.fire({\n");
      out.write("                    icon: 'error',\n");
      out.write("                    title: 'Error!',\n");
      out.write("                    text: 'Please select a class and enter a roll number before fetching the student name.',\n");
      out.write("                    confirmButtonText: 'OK'\n");
      out.write("                });\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var xhr = new XMLHttpRequest();\n");
      out.write("            xhr.open(\"GET\", \"FetchStudentName.jsp?roll_no=\" + rollNo + \"&class=\" + classSelection, true);  // Ensure \"class\" is passed as a parameter\n");
      out.write("            xhr.onreadystatechange = function () {\n");
      out.write("                if (xhr.readyState == 4 && xhr.status == 200) {\n");
      out.write("                    var response = xhr.responseText.trim();\n");
      out.write("                    if (response !== \"\") {\n");
      out.write("                        document.getElementById(\"student_name\").value = response;\n");
      out.write("                    } else {\n");
      out.write("                        document.getElementById(\"student_name\").value = \"\";\n");
      out.write("                        Swal.fire({\n");
      out.write("                            icon: 'error',\n");
      out.write("                            title: 'Error!',\n");
      out.write("                            text: 'Roll number not found in the selected class.',\n");
      out.write("                            confirmButtonText: 'OK'\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xhr.send();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function validateForm() {\n");
      out.write("            const rollNo = document.getElementById(\"roll_no\").value;\n");
      out.write("            const studentName = document.getElementById(\"student_name\").value;\n");
      out.write("            const classSelection = document.getElementById(\"class\").value;\n");
      out.write("\n");
      out.write("            if (rollNo === \"\" || studentName === \"\" || classSelection === \"\") {\n");
      out.write("                Swal.fire({\n");
      out.write("                    icon: 'error',\n");
      out.write("                    title: 'Error!',\n");
      out.write("                    text: 'Please ensure all fields are filled in correctly.',\n");
      out.write("                    confirmButtonText: 'OK'\n");
      out.write("                });\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Navigation Menu -->\n");
      out.write("    <div id=\"mymenu\">\n");
      out.write("        <ul>\n");
      out.write("            <li class=\"left-item\">Insert Student Marks</li>\n");
      out.write("            <li><a href=\"Teacher.html\">Home</a></li>\n");
      out.write("            <li><a href=\"SearchMarks.html\">Search Marks</a></li>\n");
      out.write("            <li><a href=\"Logout\">LogOut</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h2>Teacher - Insert Student Marks</h2>\n");
      out.write("\n");
      out.write("    <div id=\"mytable\">\n");
      out.write("        <form action=\"InsertTeacherServlet3\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("            <label for=\"class\">Class:</label>\n");
      out.write("            <select id=\"class\" name=\"class\" required onchange=\"updateSubjectFields()\">\n");
      out.write("                <option value=\"\">Select Class</option>\n");
      out.write("                <option value=\"10th\">10th</option>\n");
      out.write("                <option value=\"12th\">12th</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <label for=\"roll_no\">Roll Number:</label>\n");
      out.write("            <input type=\"text\" id=\"roll_no\" name=\"roll_no\" required minlength=\"4\" maxlength=\"6\" onblur=\"fetchStudentName()\">\n");
      out.write("\n");
      out.write("            <label for=\"student_name\">Student Name:</label>\n");
      out.write("            <input type=\"text\" id=\"student_name\" name=\"student_name\" readonly>\n");
      out.write("\n");
      out.write("            <h3>Enter Marks</h3>\n");
      out.write("            <div id=\"subject_fields\">\n");
      out.write("                <!-- Subject fields will be populated here based on the selected class -->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Insert Marks\" class=\"B\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("    ");

    String status = request.getParameter("status");
String msg = request.getParameter("msg");
if (msg != null) {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    Swal.fire({\n");
      out.write("        icon: 'error',\n");
      out.write("        title: 'Error!',\n");
      out.write("        text: '");
      out.print( msg );
      out.write("',\n");
      out.write("        confirmButtonText: 'OK'\n");
      out.write("    });\n");
      out.write("</script>\n");

}

    if ("success".equals(status)) {
    
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        Swal.fire({\n");
      out.write("            icon: 'success',\n");
      out.write("            title: 'Success!',\n");
      out.write("            text: 'Marks have been successfully inserted.',\n");
      out.write("            confirmButtonText: 'OK'\n");
      out.write("        });\n");
      out.write("        window.history.replaceState(null, null, window.location.pathname); // Remove status from URL\n");
      out.write("    </script>\n");
      out.write("    ");

    } else if (msg != null) {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    Swal.fire({\n");
      out.write("        icon: 'error',\n");
      out.write("        title: 'Error!',\n");
      out.write("        text: '");
      out.print( msg );
      out.write("',\n");
      out.write("        confirmButtonText: 'OK'\n");
      out.write("    });\n");
      out.write("</script>\n");

}
    
      out.write("\n");
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
