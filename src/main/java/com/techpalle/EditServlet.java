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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get form data
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String bookEdition = request.getParameter("bookEdition");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to MySQL database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2002/db", "root", "root");
            
            // SQL Update Query
            String query = "UPDATE book SET bname = ?, bedition = ?, bprice = ? WHERE bid = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookName);
            ps.setString(2, bookEdition);
            ps.setInt(3, bookPrice);
            ps.setInt(4, bookId);
            
            // Execute Update
            int updated = ps.executeUpdate();
            
            if (updated > 0) {
                out.println("<script>alert('Book Updated Successfully!'); window.location='BookList';</script>");
            } else {
                out.println("<script>alert('Update Failed!'); window.history.back();</script>");
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
}
