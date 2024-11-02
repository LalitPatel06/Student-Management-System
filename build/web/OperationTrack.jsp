<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Operation Track</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
<h2>Operation Track</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Roll No</th>
        <th>Operation</th>
        <th>Operation By</th>
        <th>Operation Time</th>
    </tr>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalit4?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM operationtrack";
        rs = stmt.executeQuery(sql);

        // Process the result set
        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("roll_no") %></td>
        <td><%= rs.getString("operation") %></td>
        <td><%= rs.getString("operation_by") %></td>
        <td><%= rs.getTimestamp("operation_at") %></td>
    </tr>
<%
        }
    } catch (SQLException e) {
        // Handle SQL exceptions
        out.println("<tr><td colspan='5'>Error retrieving data: " + e.getMessage() + "</td></tr>");
    } finally {
        // Clean up resources in the finally block to ensure they are closed
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            out.println("Error closing resources: " + e.getMessage());
        }
    }
%>
</table>
</body>
</html>
