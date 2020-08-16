package com.uttara.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        System.out.println("in CS->no arg constr");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in CS->doGet()");
		process(request,response);
		
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in CS->process()");
		
		Model model = new Model();
		String uri = request.getRequestURI();
		System.out.println("in CS->process() uri = "+uri);
		
		// if request is coming for /openRegisterView.do, 
		// fwd to Register.jsp
		RequestDispatcher rd;
		if(uri.contains("/openRegisterView"))
		{
			rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		
		// if request is coming for /openLoginView.do, 
		// fwd to Login.jsp
		if(uri.contains("/openLoginView"))
		{
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
		if(uri.contains("/register"))
		{
			/*
			 * 1) pull bean from request scope
			 * 2) pass bean to Model method
			 * 3) accept return msg from model
			 * 4) if success, forward to Success.jsp
			 * 5) if failure, forward to Register.jsp
			 */
			
			RegBean rb = (RegBean) request.getAttribute("reg");
			System.out.println("in CS->process-> if block for register bean = "+rb);
			
			String result = model.register(rb);
			if(result.equals(Constants.SUCCESS))
			{
				//forward to Success.jsp
				request.setAttribute("msg", "Your registration has succeeded! Congratulations!");
				rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else
			{
				//forward to Register.jsp
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in CS->doPost()");
		process(request,response);
	}

}
