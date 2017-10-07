package CARSPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public test() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int one = 5;
		int two =6;
		
		int sum = one + two;
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		
		out.println("sum of " +one+" and "+two+ " is " +sum);
		
		request.setAttribute("oneLable", one);
		request.setAttribute("twoLable", two);
		request.setAttribute("sumLable", sum);
		request.getRequestDispatcher( "test2.jsp" ).forward( request, response );
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
