package com.techpalle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/registrationbook")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Read data from the form
		
		 		String bname=request.getParameter("bookName");
		 		String bedition=request.getParameter("bookEdition");
		 		String price=request.getParameter("bookPrice");
		 		int bprice=Integer.parseInt(price);
		 		
	   // Step 2: JDBC Connection for inserting into table "book"
		 		
		 		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2002/db","root","root");
					String query="insert into book(bname,bedition,bprice) values (?,?,?)";
					PreparedStatement s=con.prepareStatement(query);
					s.setString(1, bname);
					s.setString(2, bedition);
					s.setInt(3, bprice);
					
					s.executeUpdate();
					System.out.println("Inserted");
					s.close();
					con.close();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	}

}
