package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Search extends HttpServlet {
	
	public void service(HttpServletRequest req ,HttpServletResponse res)throws IOException{
		String noquery =req.getParameter("searchBar");
		PrintWriter out=res.getWriter();
		
		
		out.println("<h1 class= "+"'"+"header"+"'"+">Output of Search</h1>");
		out.println("<link rel=\"stylesheet\" href=\"styles1.css\">");
		
		try {
		try {
			Class.forName ("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		String stmt1;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
		out.println("<p>Connection establishment successful.......</p>");
		Statement st=con.createStatement();
		
		String stmt="SELECT SAILORS.SID AS 'SAILOR ID', \r\n"
				+ "SAILORS.SNAME AS 'SAILOR NAME', \r\n"
				+ "SAILORS.AGE AS 'SAILOR AGE', \r\n"
				+ "SAILORS.RATING AS 'SAILOR RATING', \r\n"
				+ "RESERVES.BID AS 'RESERVED BOAT', \r\n"
				+ "BOATS.BNAME AS 'BOAT NAME', \r\n"
				+ "BOATS.COLOR AS 'BOAT COLOR', \r\n"
				+ "RESERVES.DAY\r\n"
				+ "FROM RESERVES\r\n"
				+ "INNER JOIN BOATS ON RESERVES.BID=BOATS.BID\r\n"
				+ "INNER JOIN SAILORS ON RESERVES.SID=SAILORS.SID ";
		String[] str = noquery.split(",",6 );
		String arr[]= {"SAILOR ID","SAILOR NAME","SAILOR AGE","SAILOR RATING","RESERVED BOAT","BOAT NAME","BOAT COLOR","DAY"};
		ArrayList<String>  sid=new ArrayList<String>();
		ArrayList<String>  sname=new ArrayList<String>();
		ArrayList<String>  sage=new ArrayList<String>();
		ArrayList<String>  rating=new ArrayList<String>();
		ArrayList<String>  bid=new ArrayList<String>();
		ArrayList<String>  bname=new ArrayList<String>();
		ArrayList<String>  color=new ArrayList<String>();
		ArrayList<String>  day=new ArrayList<String>();
		ArrayList<String>  ar=new ArrayList<String>();
		for (String i:str) {
			ar.add(i);
		}
		ResultSet rs = st.executeQuery( stmt+";" );
		String s="WHERE ";
		rs.next();
		while(rs.next())
		{
			sid.add(rs.getString(arr[0]));
			sname.add(rs.getString(arr[1]));
			sage.add(rs.getString(arr[2]));
			rating.add(rs.getString(arr[3]));
			bid.add(rs.getString(arr[4]));
			bname.add(rs.getString(arr[5]));
			color.add(rs.getString(arr[6]));
			day.add(rs.getString(arr[7]));
		}
		for (String i:ar) {
			if (sid.contains(i)) {
				s=s+"sailors.sid= "+i;
			}
			else if(sname.contains(i)){
				s=s+"sailors.sname= "+"'" + i + "'";
			}
			else if(sage.contains(i)){
				s=s+"sailors.age= "+i;
			}
			else if(rating.contains(i)){
				s=s+"rating= "+i;
			}
			else if(bid.contains(i)){
				s=s+"reserves.bid= "+i;
			}
			else if(bname.contains(i)){
				s=s+"boats.bname= "+"'" + i + "'";
			}
			else if(color.contains(i)){
				s=s+"boats.color= "+"'" + i + "'";
			}
			else if(day.contains(i)){
				s=s+"reserves.day= "+"'" + i + "'";
			}
			else {
				out.println("invalid attribute value"+i);
			}
			s+=" and ";
		}
		int l=s.length();
		String Final=stmt+s.substring(0,l-5)+" ;";
		ResultSet rs1=st.executeQuery(Final);
		out.println("<table style=\"width:100%\">\r\n"
				+ "<tr>\r\n"
				+ "  <th>"+arr[0]+"</th>\r\n"
				+ "  <th>"+arr[1]+"</th>\r\n"
				+ "  <th>"+arr[2]+"</th>\r\n"
				+ "  <th>"+arr[3]+"</th>\r\n"
				+ "  <th>"+arr[4]+"</th>\r\n"
				+ "  <th>"+arr[5]+"</th>\r\n"
				+ "  <th>"+arr[6]+"</th>\r\n"
				+ "  <th>"+arr[7]+"</th>\r\n"
				+ "</tr>\r\n");
		while(rs1.next()) {
			out.println("<tr>\r\n"
					+ "  <td>"+rs1.getObject(1)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(2)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(3)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(4)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(5)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(6)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(7)+"</td>\r\n"
					+ "  <td>"+rs1.getObject(8)+"</td>\r\n"
					+ "</tr>\r\n");
		}
		out.println("</table>");
		con.close();
		out.println("<p>query executed......</p>");
		}catch(SQLException e) {
			out.println("<p>error..............................................................................,</p>");
			e.printStackTrace();
		}
		
		
	}
		
}



//<table style="width:100%">
//<tr>
//  <th>Company</th>
//  <th>Contact</th>
//  <th>Country</th>
//</tr>
//<tr>
//  <td>Alfreds Futterkiste</td>
//  <td>Maria Anders</td>
//  <td>Germany</td>
//</tr>
//<tr>
//  <td>Centro comercial Moctezuma</td>
//  <td>Francisco Chang</td>
//  <td>Mexico</td>
//</tr>
//</table>



//rs1.getObject(1)+" "+rs1.getObject(2)+" "+rs1.getObject(3)+" "+rs1.getObject(4)+" "+rs1.getObject(5)+" "+rs1.getObject(6)+" "+rs1.getObject(7)+" "+rs1.getObject(8)