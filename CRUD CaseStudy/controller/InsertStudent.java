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

@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("studentName");
		String dept=request.getParameter("studentDept");
		
		try{
			Connection con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Student(StudentName, StudentDept) values(?, ?)");
			
			ps.setString(1, name);
			ps.setString(2, dept);
			int rowInserted=ps.executeUpdate();	
			if(rowInserted>0){
				RequestDispatcher rd=request.getRequestDispatcher("/InsertStudent.jsp");
				rd.include(request, response);
			}
			out.print("<br/><br/><a href=\"./CRUDStudent.html\">Back</a>");
			con.close();
		}catch(Exception e){
			out.println(e);
		}
	}

}
