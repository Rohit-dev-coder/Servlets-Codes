import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class ClientDetail extends HttpServlet
{
  public void deGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.println("<html>");
	pw.println("<head><title>Client Detail Servlet</title>");
	pw.println("<body>");
	String name = req.getParameter("username");
	String gender = req.getParameter("gender");
	String hobbies[] = req.getParameterValues("hobbies");
	pw.println("<p>Your Name is "+name+".<br>");
	pw.println("<p>Your Gender is "+gender+".<br>");
	pw.println("<p><b>Your Hobbies are :<b><br>");
	for(String s: hobbies)
		pw.println(s+"<br>");


	pw.println("</body>");
	pw.println("</html>");
   }
}