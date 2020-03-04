package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.JdbcConnection;

/**
 * Servlet implementation class ReadStudent
 */
@WebServlet("/ReadStudent")
public class ReadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try{
			Connection con=JdbcConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Student");
			while(rs.next()){
				out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				out.print("<br/>");
			}
			
			out.print("<br/><a href=\"./CRUDStudent.html\">Back</a>");
			con.close();
		}catch(Exception e){
			out.println(e);
		}
	}
}
