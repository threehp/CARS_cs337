package CARSPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.students;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
				
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();		
		session.invalidate();		
		request.getRequestDispatcher( "LoginPage.jsp" ).forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean pass = false;
		
		Connection c = null;
		
		try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";

            String SQLusername = "cs3337stu06";
            String SQLpassword = "M06G!Nq9";

            c = DriverManager.getConnection( url, SQLusername,
                SQLpassword );
            Statement stmt = c.createStatement();
            
            
            ResultSet rs = stmt.executeQuery( "select * from teachers where username = '"+username+"' and password = '"+password+"'; " );

            while( rs.next() )
            {
                pass = true;                
            }
                     
            
            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
		finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	
		
		if (pass){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);          //initiate session 
		
			response.sendRedirect("UserPortal");			
		}else{
			String errorMsg = "Log in falied. Username and password combo dose not match record.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher( "LoginPage.jsp" ).forward( request, response );
		}
				
	}

}
