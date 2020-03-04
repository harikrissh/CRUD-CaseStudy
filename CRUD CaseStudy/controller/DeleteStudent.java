package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.JdbcConnection;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String delete=request.getParameter("studentName");
		
		try{
			Connection con=JdbcConnection.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Student");
			
			List<String> l=new ArrayList<String>();
			while(rs.next()){
				l.add(rs.getString("StudentName"));
			}
			if(!l.contains(delete))
				out.print(delete+" is not available in database.");
			
			else{
				PreparedStatement ps=con.prepareStatement("delete from Student where StudentName=?");

				ps.setString(1, delete);
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("/DeleteStudent.jsp");
				rd.include(request, response);
			}
			
			out.print("<br/><br/><a href=\"./CRUDStudent.html\">Back</a>");
			con.close();
		}catch(Exception e){
			out.println(e);
		}
		
	}

}
