package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.JdbcConnection;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String oldName=request.getParameter("oldName");
		String newName=request.getParameter("studentName");
		
		try{
			Connection con=JdbcConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("update Student set StudentName=? where StudentName=?");

			ps.setString(1, newName);
			ps.setString(2, oldName);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("/UpdateStudent.jsp");
			rd.include(request, response);
			
			out.print("<br/><br/><a href=\"./CRUDStudent.html\">Back</a>");
			con.close();
		}catch(Exception e){
			out.println(e);
		}
	}

}
