import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class GotoServlet extends HttpServlet
{
   
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
	String str = req.getParameter("goto");
	if (str.equalsIgnoreCase("Facebook") )
		resp.sendRedirect("https://www.facebook.com");
	else if(str.equalsIgnoreCase("Youtube") )
		resp.sendRedirect("https://www.youtube.com");	
	else if(str.equalsIgnoreCase("Twitter") )
		resp.sendRedirect("https://www.Twitter.com"); 
	else if(str.equalsIgnoreCase("Google") )
		resp.sendRedirect("https://www.Google.com");
   }
}
		
	    