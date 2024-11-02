<%@ page import="java.sql.*" %>
<%
    String rollNo = request.getParameter("roll_no");
    String studentName = "";

    if (rollNo != null && !rollNo.trim().isEmpty()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

            String query = "SELECT name FROM studentsdata WHERE roll_no = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, rollNo);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                studentName = rs.getString("name");
            }

            con.close();
        } catch (Exception e) {
            out.print("Error: " + e.getMessage());
        }
    }

    out.print(studentName); // Only return the name
%>
