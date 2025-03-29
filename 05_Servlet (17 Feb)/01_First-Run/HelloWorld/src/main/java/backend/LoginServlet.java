package backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");      
	    PrintWriter pwriter = response.getWriter();    
	    pwriter.println("<html><body>");
	    pwriter.println("<h2>hi hello welcome!!!!</h2>");
	    pwriter.println("</body></html>");
	}
}