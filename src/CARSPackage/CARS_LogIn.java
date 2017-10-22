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



/**
 * Servlet implementation class CARS_LogIn
 */
@WebServlet("/CARS_LogIn")
public class CARS_LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CARS_LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();		
//		session.invalidate();		
		request.getRequestDispatcher( "dummy_LogInPage.jsp" ).forward( request, response );
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
		
		
		//getServletContext().setAttribute("time", classStartTime);
		
		
		response.sendRedirect("CARS_StudentList?time="+classStartTime);

		
	}

}
