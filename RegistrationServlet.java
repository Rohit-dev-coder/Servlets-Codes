import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegistrationServlet extends HttpServlet
{
   private Connection conn;
   private PreparedStatement ps;

   public void init() throws ServletException
   {
	try
 	{
	   Class.forName("oracle.jdbc.OracleDriver");
	   System.out.println("driver loaded!");
	   conn = DriverManager.getConnection("jdbc:oracle:thin:@//pc:1521/xe","advjava","student");
	   ps = conn.prepareStatement("insert into users values(?,?,?)");
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
	pw.println("<html><head><title>Register Page</title></head><body>");
	String userid = req.getParameter("user");
	String username = req.getParameter("name");
	String password = req.getParameter("password");
	if (userid.equalsIgnoreCase(""))
		pw.println("<h2>UserId Required</h2><br>");
	else if (username.equalsIgnoreCase(""))
		pw.println("<h2>Username Required</h2><br>");
	else if (password.equalsIgnoreCase(""))
		pw.println("<h2>password Required</h2><br>");
	else
	{
		try
	{
	    ps.setString(1,userid);
	    ps.setString(2,password);
	    ps.setString(3,username);
	    int ans = ps.executeUpdate();
	    if(ans>0)
	    {
		pw.println("<h2>Hello "+username+", Registered Successfully!</h2>");
	    }
	    else
	    {
		pw.println("<h2>Registration not done! Try later</h2>");
		pw.println("<a href = 'register.html'>Register Here !</a>");
	    }
	}
	catch(SQLException ex)
	{
	   System.out.println("Some error occured in doPost : "+ex);
	   pw.println("<h2>OOPs! Server is experincing some issue, Please come back Later.</h2>");
	}
}
	pw.println("</body></html>");
	pw.close();
   }
   public void destroy()
   {
	try{
	   conn.close();
	}
	catch(SQLException ex)
	{
	    System.out.println("Some error occured in doPost : "+ex);
	}
   }
}
		
	    
