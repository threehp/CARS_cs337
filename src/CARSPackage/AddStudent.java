package CARSPackage;

import java.io.IOException;
import java.io.PrintWriter;
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

import classes.classes;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorMsg = request.getParameter("errorMsg");
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
            
            
            ResultSet rs = stmt.executeQuery( "select * from classes; " );

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
		request.setAttribute("errorMsg", errorMsg);
		request.setAttribute("ClassList", Classes);
		request.getRequestDispatcher( "AddStudentPage.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		String studentName = request.getParameter("studentName");
		String card_ID = request.getParameter("card_ID");
		String student_ID = request.getParameter("student_ID");
		
		String [] section_ID = request.getParameterValues("section_ID");
		
		boolean onList = false;
		
		if (section_ID !=null){
		
			
			
			
		Connection c = null;
		
		try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";

            String SQLusername = "cs3337stu06";
            String SQLpassword = "M06G!Nq9";

            c = DriverManager.getConnection( url, SQLusername,
                SQLpassword );
            Statement stmt = c.createStatement();
            
            
            ResultSet rs = stmt.executeQuery( "select * from students where student_ID = '"+ student_ID +"'; " );

            while( rs.next() )
            {
            	
            	onList= true;               
            }
                     
            if (onList ==false){
            	
            	stmt.executeUpdate("insert into students (name, student_ID, card_ID) value ('"+studentName+"','"+student_ID+"', '"+card_ID+"');");            	
            	
            }
            
            for (int i=0 ;  i<section_ID.length; i++){
            	stmt.executeUpdate("insert into "+section_ID[i]+" (student_ID) value ('"+student_ID+"');");
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
		
		out.println("Student added to class");
		out.println("<br><a href='UserPortal'>Done</a>");
		
		
			
		}else{
						
			String errorMsg = "Need to add the student to at least one class";			
			
			out.println(errorMsg);
			
		}
		
		
	}

}
