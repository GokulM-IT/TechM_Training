package backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ownServlet
 */
@WebServlet("/HandsOn")
public class HandsOn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandsOn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
		        htmlRespone += "Your password is: " + password + "</h2></html>";    
		          writer.println(htmlRespone);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//			String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
//		
//		PrintWriter writer = response.getWriter();
//		String htmlRespone = "<html>";
//		        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
//		        htmlRespone += "Your password is: " + password + "</h2></html>";    
//		          writer.println(htmlRespone);
//		//doGet(request, response);
//	}

}
