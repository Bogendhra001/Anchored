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
public class Addsailors extends HttpServlet {
	
	public void service(HttpServletRequest req ,HttpServletResponse res)throws IOException{
		String name =req.getParameter("name");
		String age=req.getParameter("age");
		String rating=req.getParameter("rating");
		String id=req.getParameter("id");
		PrintWriter out=res.getWriter();
		
		out.println("<h1 class= "+"'"+"header"+"'"+">Output of Sailors Table</h1>");
		out.println("<link rel=\"stylesheet\" href=\"styles1.css\">");
		
		
		
		
		try {
		try {
			Class.forName ("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String stmt1;
		String stmt2="select * from sailors";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
		out.println("<p>Connection establishment successful.......</p>");
		Statement st=con.createStatement();
		if (id=="") {
			String stmt ="select max(sid) as maxi from sailors";
			ResultSet rs=st.executeQuery(stmt);
			int sid = 0;
			while (rs.next()) {
				sid =rs.getInt("maxi");
			}
			sid++;
			
			stmt1="insert into sailors values("+sid+","+"'"+ name +"'"+","+ age +","+ rating +")";  
			out.println("<p>add option selected</p>");
		}else {
			stmt1="delete from sailors where sid="+id;
			out.println("<p>remove option selected</p>");
		}
		
		st.execute(stmt1);
		ResultSet rs1=st.executeQuery(stmt2);
		out.println("<table style=\"width:100%\">\r\n"
				+ "<tr>\r\n"
				+ "  <th>SID</th>\r\n"
				+ "  <th>NAME</th>\r\n"
				+ "  <th>AGE</th>\r\n"
				+ "  <th>RATING</th>\r\n"
				+ "</tr>\r\n");
		while(rs1.next()) {
			out.println("<tr>\r\n"
					+ "  <td>"+rs1.getObject(1)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(2)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(3)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(4)+"</td>\r\n"
					+ "</tr>\r\n");
		}
		out.println("</table>");
		con.close();
		out.println("<p>query executed......</p>");
		}catch(SQLException e) {
			out.println("error..............................................................................");
			e.printStackTrace();
		}
		
		
	}

	private int length(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
	
	


	

