import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DateTime extends GenericServlet
{

public void service( ServletRequest req, ServletResponse resp) throws ServletException, IOException
{
resp.setContentType("text/html");
PrintWriter pw = resp.getWriter();
Date d = new Date();
pw.println("<html><head><title>Date And Time </title></head>");
pw.println("<body>"+d+"</body></html>");
pw.close();
}
}
