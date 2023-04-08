package cscorner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class mysqlcon {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WAD_DB","user","admin");
		
		
		
		Statement st=con.createStatement();
		
		String stmt="insert into sailors values(111,'Mark',20,50)";
		
		
		String stmt1="select * from sailors;";
		
		
		ResultSet rs=st.executeQuery(stmt1);
		
		while (rs.next()) {
			int sid=rs.getInt("sid");
			String sname=rs.getString("sname");
			System.out.println("sid = "+sid + " sname = "+sname);
		}
		
		con.close();
		System.out.println("query executed......");
	}

}
