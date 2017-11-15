package CARSPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.classes;

/**
 * Servlet implementation class UserPortal
 */
@WebServlet("/UserPortal")
public class UserPortal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserPortal() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
					
		if (username!=null){
			
			
			
			List<classes> Classes = new ArrayList<>();
			
			Connection c = null;
			
			try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";

	            String SQLusername = "cs3337stu06";
	            String SQLpassword = "M06G!Nq9";

	            c = DriverManager.getConnection( url, SQLusername,
	                SQLpassword );
	            Statement stmt = c.createStatement();
	            
	            
	            ResultSet rs = stmt.executeQuery( "select * from classes where teacher = '"+ username +"' " );

	            while( rs.next() )
	            {
	                int id = rs.getInt("id");
	                String section_ID = rs.getString("section_ID");
	                String className = rs.getString("className");
	                String teacher 	= rs.getString("teacher");
	                
	                Classes.add(new classes (id, section_ID, className, teacher));
	               
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
			
			
			
			request.setAttribute("ClassList", Classes);
			request.getRequestDispatcher( "UserPortal.jsp" ).forward( request, response );
			
			
			
		}else{
			
			response.sendRedirect("CARS");
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String month = (String)request.getParameter("month");
		if (month.length()==1) month="0"+month;
		String day = (String)request.getParameter("day");
		if (day.length()==1) day="0"+day;
		String hour = (String)request.getParameter("hour");
		if (hour.length()==1) hour="0"+hour;
		String min = (String)request.getParameter("min");
		if (min.length()==1) min="0"+min;
			
		String classStartTime = "2017-"+ month + "-" + day + " " + hour + ":" + min;
			
		String section_ID = request.getParameter("section_ID");
		
		
		getServletContext().setAttribute("time", classStartTime);
		getServletContext().setAttribute("section_ID", section_ID);
			
		response.sendRedirect("CARS_StudentList?time="+classStartTime+"&sectionID="+section_ID);	
		//response.sendRedirect("CARS_StudentList");
	}

}
