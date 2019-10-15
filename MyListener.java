import java.sql.*;
import javax.servlet.*;

public class MyListener implements ServletContextListener
{
private Connection conn;
public void contextInitialized (ServletContextEvent e)
{
	ServletContext ct = e.getServletContext();
   	try
 	{
	   
	   String drivername = ct.getInitParameter("drivername");
	   Class.forName(drivername);
	   System.out.println("driver loaded!");
	   String connurl = ct.getInitParameter("connurl");
	   String dbusername = ct.getInitParameter("dbusername");
	   String dbpassword = ct.getInitParameter("dbpassword");
	   conn = DriverManager.getConnection(connurl,dbusername,dbpassword);
	
	}
	catch(Exception ex)
	{
	   System.out.println("Problem in contextInitialized : "+ex);
	}
	finally
	{
	   System.out.println("Connection object send...");	
	   ct.setAttribute("conn",conn); 		   
	}

}

public void contextDestroyed (ServletContextEvent e)
{
	try{
	   conn.close();
	}
	catch(SQLException ex)
	{
	    System.out.println("Some error occured in contextDestroy : "+ex);
	}

}
}