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

import classes.students;


@WebServlet("/CARS_StudentList")
public class CARS_StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CARS_StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//String classStartTime = (String)getServletContext().getAttribute("time");
		String classStartTime = (String)request.getParameter("time");
		
		//String section_ID = (String)getServletContext().getAttribute("section_ID");
		String section_ID = (String)request.getParameter("sectionID");
				
		List<students> StudentList = new ArrayList<students>();		
	

		Connection c = null;
		
		try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu06";

            String username = "cs3337stu06";
            String password = "M06G!Nq9";

            c = DriverManager.getConnection( url, username,
                password );
            Statement stmt = c.createStatement();
            
            
            //ResultSet rs = stmt.executeQuery( "select * from students where entryTime > '" + classStartTime + "'; " );
            ResultSet rs = stmt.executeQuery( "select * from students s, "+section_ID+" c  wh"
            		+ "ere s.entryTime > '" + classStartTime + "' AND s.student_ID = c.student_ID; " );
            
         
            
            while( rs.next() )
            {
                int index = rs.getInt("id");
                String name = rs.getString("name");
                String student_ID = rs.getString("student_ID");     
                String card_ID = rs.getString("card_ID");
                String entryTime = rs.getString("entryTime");
                          
                StudentList.add(new students(index,name,student_ID,card_ID,entryTime));            	
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
		
		
		request.setAttribute("StudentList", StudentList);	
		request.setAttribute("time", classStartTime);
		
		request.getRequestDispatcher("dummy_StudentListPage.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
