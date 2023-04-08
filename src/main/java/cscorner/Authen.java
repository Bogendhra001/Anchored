package cscorner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authen extends  HttpServlet{
	int flag=0;
	public void service(HttpServletRequest req ,HttpServletResponse res)throws IOException{
		res.setContentType("text/html");
		String user=req.getParameter("usern");
		String pwd=req.getParameter("pwd");
		PrintWriter out=res.getWriter();
		if (user.equals("admin") && pwd.equals("admin")) {
			this.flag=1;
			res.sendRedirect(req.getContextPath() + "/Main.jsp");
		}else {
			out.println("invalid credentials");
		}
	}

}
