package CARSPackage;

import java.io.IOException;
import java.io.PrintWriter;
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

import classes.classes;

/**
 * Servlet implementation class AddClass
 */
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddClass() {
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
		
		request.getRequestDispatcher( "AddClassPage.jsp" ).forward( request, response );
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		String section_ID = request.getParameter("section_ID");
		String className = request.getParameter("className");
		String teacher = request.getParameter("teacher");
		boolean exists = false;
		
		if (section_ID != null){   //how come still goes through if nothing input
		
			Connection c = null;
			
			try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";
	
	            String SQLusername = "cs3337stu06";
	            String SQLpassword = "M06G!Nq9";
	
	            c = DriverManager.getConnection( url, SQLusername,
	                SQLpassword );
	            Statement stmt = c.createStatement();
	            
	            
	            ResultSet rs = stmt.executeQuery( "show tables;" );
	
	            while( rs.next() )
	            {
	                String tableName = rs.getString("Tables_in_cs3337stu06");
	                if (tableName.equals(section_ID)){
	                	exists = true;
	                	break;
	                }
	               
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
		
			
			if (exists){
				String errorMsg = "Class already exists";				
				out.println(errorMsg);
			}else{
				
				//Connection c = null;
				
				try
		        {
		            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";
		
		            String SQLusername = "cs3337stu06";
		            String SQLpassword = "M06G!Nq9";
		
		            c = DriverManager.getConnection( url, SQLusername,
		                SQLpassword );
		            Statement stmt = c.createStatement();
		            
		            stmt.executeUpdate("create table "+section_ID+" (id	integer auto_increment primary key, student_ID	varchar(255));");
		            stmt.executeUpdate("insert into classes (section_ID, className, teacher) values ('"+section_ID+"','"+className+"','"+teacher+"');");
	                           
		            
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
				
				out.println("Finished Adding");
				out.println("<br><a href='UserPortal'>Done</a>");
				
			}
		
		
		}else{
			
			String errorMsg = "Please fill in the boxes";			
			
			out.println(errorMsg);
			
		}
	}

}
