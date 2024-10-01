import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowALL")
public class ShowALL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the selected class and view option from the request
        String selectedClass = request.getParameter("class");
        String viewOption = request.getParameter("view");

        // Store the selected class and view option in the session
        HttpSession session = request.getSession();
        session.setAttribute("selectedClass", selectedClass);
        session.setAttribute("viewOption", viewOption);

        // Redirect to the JSP page
        response.sendRedirect("ShowALL.jsp"); // Prevents form resubmission
    }
}
