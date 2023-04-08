package cscorner;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Removesailors extends HttpServlet{
	
	public void service(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		PrintWriter out=res.getWriter();
		
		
		out.println("id is "+ id );
		
		
		
		
		
		try {
			try {
				Class.forName ("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("sid of sailor"+id);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
			Statement st=con.createStatement();
			String stmt ="select sname from sailors where sid ="+id;
			ResultSet rs=st.executeQuery(stmt);
			while (rs.next()) {
				out.println(rs.getInt("sname"));
			}
			String stmt1="delete from sailors where sid="+id;  
			
			st.execute(stmt1);
			
			con.close();
			out.println("query executed......");
			}catch(SQLException e) {
				out.println("error.................................................................................");
				e.printStackTrace();
			}
	}
	
}


