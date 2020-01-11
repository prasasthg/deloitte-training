package com.deloitte;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/WebAppServlet")
public class WebAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init called");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy called");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get called");
		String path=request.getServletPath();
		System.out.println("path: "+ path);
		
			String name = request.getParameter("tname");
			String designation = request.getParameter("tdesig");
			
			System.out.println(name);
			request.setAttribute("usertype", name);
			request.setAttribute("usertypex", designation);
			
			String displayPage = "Details.jsp";
			request.getRequestDispatcher(displayPage).forward(request, response);
			}
	
//	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post called");
		
		doGet(request, response);
	}

}
