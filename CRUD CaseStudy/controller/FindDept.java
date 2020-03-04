package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.JdbcConnection;

@WebServlet("/FindDept")
public class FindDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("studentName");
		String dept="not available";
		try{
			Connection con=JdbcConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Student");
			while(rs.next()){
				if(rs.getString("StudentName").equals(name))
				dept=rs.getString("StudentDept");
			}
			RequestDispatcher rd=request.getRequestDispatcher("/FindDept.jsp");
			request.setAttribute("dept", dept);
			rd.include(request, response);
			out.print("<br/><a href=\"./CRUDStudent.html\">Back</a>");
			con.close();
		}catch(Exception e){
			out.println(e);
		}
	}

}
