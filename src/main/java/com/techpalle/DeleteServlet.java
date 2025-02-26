package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get book ID from request
        String bookId = request.getParameter("id");
        
        if (bookId == null || bookId.isEmpty()) {
            out.println("<script>alert('Invalid Book ID!'); window.location='BookList';</script>");
            return;
        }

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2002/db", "root", "root");

            // SQL Delete Query
            String query = "DELETE FROM book WHERE bid = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(bookId));

            // Execute Update
            int deleted = ps.executeUpdate();

            if (deleted > 0) {
                out.println("<script>alert('Book Deleted Successfully!'); window.location='BookList';</script>");
            } else {
                out.println("<script>alert('Deletion Failed!'); window.location='BookList';</script>");
            }

            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            out.println("<p style='color:red;'>MySQL Driver not found!</p>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Database error!</p>");
            e.printStackTrace();
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
