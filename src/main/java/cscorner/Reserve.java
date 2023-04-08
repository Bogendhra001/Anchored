package cscorner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

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
public class Reserve extends HttpServlet{
	
	public void service(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		int sid=Integer.parseInt(req.getParameter("sid"));
		int bid=Integer.parseInt(req.getParameter("bid"));
		
		PrintWriter out=res.getWriter();
		
		
		out.println("<h1 class= "+"'"+"header"+"'"+">Output of Reserves Table</h1>");
		out.println("<link rel=\"stylesheet\" href=\"styles1.css\">");
		
		
		try {
			try {
				Class.forName ("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("bid"+bid +"sid"+sid);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
			Statement st=con.createStatement();
			
			
			String stmt2="select * from reserves;";
			
			String stmt1="insert into reserves values("+sid+","+bid+","+"'"+java.time.LocalDate.now()+"'"+")";  
			
			
			st.execute(stmt1);	
			
			
			ResultSet rs1=st.executeQuery(stmt2);
			out.println("<table style=\"width:100%\">\r\n"
					+ "<tr>\r\n"
					+ "  <th>SID</th>\r\n"
					+ "  <th>BID</th>\r\n"
					+ "  <th>DAY</th>\r\n"
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
			out.println("<p>query executed......,</p>");
			}catch(SQLException e) {
				out.println("<p>error....................................................,</p>");
				e.printStackTrace();
			}
			} 
	
	}
	

