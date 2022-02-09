package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBConnection;
import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/product";
		String username="root";
		String password="Simplilearn";
		PrintWriter out=response.getWriter();
		String pid=request.getParameter("productid");
		out.println("<h1><font face = \"WildWest\" size = \"6\"; font color = \"LightCoral\"> Welcome User </font></h1>");
		
		//out.print("<html><body>");
		try {
			DBConnection connection= new DBConnection(url, username, password);
			Connection connection1=connection.getConnection();
			PreparedStatement stmt=connection1.prepareStatement("select * from products where productid=?");
			stmt.setString(1, pid);
			ResultSet query=stmt.executeQuery();
			while(query.next()) {
				out.println("<table>");
				out.println("<style> body {\n"
						+ "  background-image: url('https://disrv.com/wp-content/uploads/2016/02/Technology-Background-Image.jpg');\n"
						+ "  background-repeat: no-repeat;\n"
						+ "  background-attachment: fixed;\n"
						+ "  background-size: cover;\n"
						+ "} table,tr,td{border:3px solid Green; padding:13px;})</style>");
				out.println("<tr>");
				out.println("<th>Product Id</th>");
				out.println("<td>"+query.getInt(1)+"</td>");
				
				out.println("<th>Product code</th>");
				out.println("<td>"+query.getString(2)+"</td>");
				
				out.println("<th>Product name</th>");
				out.println("<td>"+query.getString(3)+"</td>");
				
				out.println("<th>Product quantity</th>");
				out.println("<td>"+query.getString(4)+"</td>");
				
				out.println("<th>Product Price</th>");
				out.println("<td>"+query.getString(5)+"</td>");
				
				out.println("</tr>");
				
				out.println("</table>");
				out.println("</body></html>");
				stmt.close();
				connection.closeConnection();
				connection.closeConnection();
				
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
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
