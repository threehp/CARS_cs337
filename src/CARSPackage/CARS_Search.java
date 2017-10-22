package CARSPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import classes.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CARS_Search
 */
@WebServlet("/CARS_Search")
public class CARS_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CARS_Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search_input = request.getParameter("search_input");                      //get card_ID from Home page input
		
		String search_type = request.getParameter("search_type");                       // get search type from Home page input
				
		int index = -1;
		String name = null;
		String student_ID = null;
		String card_ID = null;
				
		List<students> StudentList = new ArrayList<students>();
		
		//initialize connection to MySQL database
		Connection c = null;
		
		try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";

            String username = "cs3337stu06";
            String password = "M06G!Nq9";

            c = DriverManager.getConnection( url, username,
                password );
            Statement stmt = c.createStatement();
            
            
            ResultSet rs = stmt.executeQuery( "select * from students where "+search_type+" = '" + search_input + "'; " );

            while( rs.next() )
            {
                index = rs.getInt("id");
                name = rs.getString("name");
                student_ID = rs.getString("student_ID");     
                card_ID = rs.getString("card_ID");
                          
                StudentList.add(new students(index,name,student_ID,card_ID));            	
            }
            
            
            if (index != -1){       //update entryTime on database
            	
            	stmt.executeUpdate("update students set entryTime = sysdate() where id = " +index + ";");
            	
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
	
		
		if (index==-1){        // index  ==-1 means no data found above, so give error message
			
			String error = "Data not found. Please re-swipe or manually enter your student ID number.";
			
			request.setAttribute("error_message",error);			
			request.getRequestDispatcher( "CARS_FrontPage.jsp" ).forward( request, response );
		}else {
			
			request.setAttribute("StudentList",StudentList );						
			request.getRequestDispatcher( "dummy_SearchPage.jsp" ).forward( request, response );
			
		}
		
		
			
		
		
		
		
		
	}

}
