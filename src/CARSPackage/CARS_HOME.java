package CARSPackage;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FrontPage")
public class CARS_HOME extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CARS_HOME() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		//this is the initiate method. We set up two test parameter here. 
				
		int int1 = 123;		
		String string1 = "this is a test for Jiajun";
	

		
		getServletContext().setAttribute("testInt", int1);   // this line puts the two test variables onto the "Application Scope"
		getServletContext().setAttribute("testString", string1);   //it's like a remote storage place that stores our data
																	//note that the first parameter "testInt" is the identifier for the second parameter in the Application Scope
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int testInt = (int) getServletContext().getAttribute("testInt");		//this line is to get the two test variables back from the Application Scope
		String testString = (String) getServletContext().getAttribute("testString");   // note that we just need to get the identifier "testInt" 
					
		
		request.setAttribute("intJSP", testInt);		// this line is to pass the test variables to the JSP page. 
		request.setAttribute("stringJSP", testString);  //first 
		
		
		request.getRequestDispatcher( "CARS_FrontPage.jsp" ).forward( request, response );
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
