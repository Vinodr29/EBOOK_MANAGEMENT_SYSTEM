package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/BookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	//Method 1
		
//      response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2002/db","root","root");
//			String query="select * from book";
//			PreparedStatement s=con.prepareStatement(query);
//			ResultSet rs=s.executeQuery();
//			
//			out.print("<table border='2'>");
//			out.println("<tr><th>BookId</th><th>BookName</th><th>BookEdition</th><th>BookPrice</th><th>Edit</th><th>Delete</th>");
//			   
//					while(rs.next()) {
//						out.println("<tr><td>"+rs.getInt("bid")+"</td>");
//						out.println("<td>"+rs.getString("bname")+"</td>");
//						out.println("<td>"+rs.getString("bedition")+"</td>");
//						out.println("<td>"+rs.getInt("bprice")+"</td>");
//						out.println("<td> <a href='edit'>Edit</a></td>");
//						out.println("<td><a href='delete'>Delete</a></td></tr>");
//					}
//			
//			
//			out.print("</table>");
//			
//			
//			
//			s.close();
//			con.close();
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
		
		//Method 2
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2002/db", "root", "root");
		    
		    String query = "SELECT * FROM book";
		    PreparedStatement s = con.prepareStatement(query);
		    ResultSet rs = s.executeQuery();
		    
		    out.println("<html><head><title>Book List</title>");
		    out.println("<style>");
		    out.println("table { width: 80%; border-collapse: collapse; margin: 20px auto; font-size: 18px; }");
		    out.println("th, td { padding: 10px; border: 1px solid black; text-align: center; }");
		    out.println("th { background-color: #007bff; color: white; }");
		    out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
		    out.println("a { text-decoration: none; padding: 5px 10px; color: white; border-radius: 5px; }");
		    out.println(".edit { background-color: #28a745; }");
		    out.println(".delete { background-color: #dc3545; }");
		    out.println("</style></head><body>");
		    
		    out.println("<h1 style='text-align:center;'>Book List</h1>");
		    out.print("<table>");
		    out.println("<tr><th>Book ID</th><th>Book Name</th><th>Book Edition</th><th>Book Price</th><th>Edit</th><th>Delete</th></tr>");

		    while (rs.next()) {
		        int bookId = rs.getInt("bid");
		        out.println("<tr>");
		        out.println("<td>" + bookId + "</td>");
		        out.println("<td>" + rs.getString("bname") + "</td>");
		        out.println("<td>" + rs.getString("bedition") + "</td>");
		        out.println("<td>" + rs.getInt("bprice") + "</td>");
		        out.println("<td><a class='edit' href='edit.jsp?id=" + bookId + "'>Edit</a></td>");
		        out.println("<td><a class='delete' href='delete?id=" + bookId + "'>Delete</a></td>");
		        out.println("</tr>");
		    }

		    out.print("</table>");
		    out.println("</body></html>");

		    rs.close();
		    s.close();
		    con.close();
		} catch (ClassNotFoundException e) {
		    out.println("<p style='color:red; text-align:center;'>MySQL Driver not found!</p>");
		    e.printStackTrace();
		} catch (SQLException e) {
		    out.println("<p style='color:red; text-align:center;'>Database connection error!</p>");
		    e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
