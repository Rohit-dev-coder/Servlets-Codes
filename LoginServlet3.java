import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet3 extends HttpServlet
{
   private PreparedStatement ps;

   public void init() throws ServletException
   {
	try
 	{
	   ServletContext ct = getServletContext();
	   Connection conn = (Connection)ct.getAttribute("conn");
	   if (conn == null)
		throw new Exception();

	   ServletConfig cfg = getServletConfig();
	   String qry = cfg.getInitParameter("sqlquery");
	   ps = conn.prepareStatement(qry);
	   System.out.println("Query Set!");
	}
	catch(Exception ex)
	{
	   System.out.println("Problem in init: "+ex);
	   ServletException se = new ServletException();
	   throw se;
	}
   }
   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.println("<html><head><title>Home page</title></head><body>");
	String userid = req.getParameter("username");
	String password = req.getParameter("password");
	try
	{
	    ps.setString(1,userid);
	    ps.setString(2,password);
	    ResultSet rs = ps.executeQuery();
	    if(rs.next())
	    {
		String username = rs.getString(1);
		pw.println("<h2>Hello "+username+", Welcome to our site!</h2>");
	    }
	    else
	    {
		pw.println("<h2>Sorry invalid userid/password.!</h2>");
		pw.println("<a href = 'register.html'>Register Here !</a>");
	    }
	}
	catch(SQLException ex)
	{
	   System.out.println("Some error occured in doPost : "+ex);
	   pw.println("<h2>OOPs! Server is experincing some issue, Please come back Later.</h2>");
	}
	pw.println("</body></html>");
	pw.close();
   }
  
}
		
	    