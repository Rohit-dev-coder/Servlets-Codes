import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class RenderServlet extends HttpServlet
{
   
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
	String str = req.getHeader("User-agent");
	if(str.indexOf("Chrome") != -1)
		resp.sendRedirect("https://www.google.com");
	else if(str.indexOf("Firefox")!= -1)
		resp.sendRedirect("https://www.mizilla.org");	
	else
		resp.sendRedirect("https://www.microsoft.com");	 
   }
}
		
	    