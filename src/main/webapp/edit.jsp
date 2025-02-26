<%@ page import="java.sql.*" %>
<%
    String bookId = request.getParameter("id");
    if (bookId == null || bookId.isEmpty()) {
        response.sendRedirect("BookList");
    }

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2002/db", "root", "root");

    String query = "SELECT * FROM book WHERE bid = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, Integer.parseInt(bookId));
    ResultSet rs = ps.executeQuery();

    String name = "", edition = "";
    int price = 0;

    if (rs.next()) {
        name = rs.getString("bname");
        edition = rs.getString("bedition");
        price = rs.getInt("bprice");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 50px;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }
        input {
            padding: 10px;
            margin: 10px;
            width: 90%;
        }
        button {
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Edit Book</h2>
    <form action="edit" method="post">
        <input type="hidden" name="bookId" value="<%= bookId %>" />
        <input type="text" name="bookName" value="<%= name %>" required /><br>
        <input type="text" name="bookEdition" value="<%= edition %>" required /><br>
        <input type="number" name="bookPrice" value="<%= price %>" required /><br>
        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>

<%
    rs.close();
    ps.close();
    con.close();
%>
