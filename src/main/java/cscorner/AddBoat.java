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
public class AddBoat extends HttpServlet{
	
	public void service(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		String name =req.getParameter("name");
		String color =req.getParameter("color");
		String id=req.getParameter("id");

		
		PrintWriter out=res.getWriter();
		
		
		out.println("<h1 class= "+"'"+"header"+"'"+">Output of Boat Table</h1>");
		out.println("<link rel=\"stylesheet\" href=\"styles1.css\">");
		
		
		
		
		
		try {
			try {
				Class.forName ("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
			Statement st=con.createStatement();
			
			String stmt2="select * from boats;";;
			if (id=="") {
			String stmt ="select max(bid) as maxi from boats";
			ResultSet rs=st.executeQuery(stmt);
			int bid = 0;
			while (rs.next()) {
				bid =rs.getInt("maxi");
			}
			
			bid++;
			out.println("<p>add option selected........,</p>");
			
			String stmt1="insert into boats values("+bid+","+"'"+ name +"'"+","+"'"+color+"'"+")";  
			
			
			st.execute(stmt1);
			}else {
				
				out.println("remove option selected..........");
				String stmt1="delete from boats where bid ="+id;  
				
				st.execute(stmt1);
			}
			ResultSet rs1=st.executeQuery(stmt2);
			out.println("<table style=\"width:100%\">\r\n"
					+ "<tr>\r\n"
					+ "  <th>BID</th>\r\n"
					+ "  <th>BOAT_NAME</th>\r\n"
					+ "  <th>BOAT_COLOR</th>\r\n"
					+ "</tr>\r\n");
			while(rs1.next()) {
				out.println("<tr>\r\n"
						+ "  <td>"+rs1.getObject(1)+"</td>\r\n"
						+ "  <td>"+rs1.getObject(2)+"</td>\r\n"
						+ "  <td>"+rs1.getObject(3)+"</td>\r\n"
						+ "</tr>\r\n");
			}
			out.println("</table>");
			con.close();
			out.println("<p>query executed......</p>");
			}catch(SQLException e) {
				out.println("<p>error................................................,</p>");
				e.printStackTrace();
			}
			}
	}
	

