package com.FitnessCenter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.FitnessCenter.db.DB;

/**
 * Servlet implementation class DeleteBatchServlet
 */
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		
		int id =Integer.parseInt(request.getParameter("batchId"));
		
		DB db = new DB();
		db.createConnection();
		
		int result = db.deleteBatch(id);
		db.closeConnection();
		
		if(result>0) {
			out.print("<h3>Batch Deleted Successfully</h3>");
		}
		else{
			out.print("<h3>Not Able to Delete.. Please try again later.</h3>");
		}
		out.print("<a href='index.html'>Home</a>");
		out.print("</center>");
		
	}

}
