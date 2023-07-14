package com.YaminGym.FitnessCenter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YaminGym.FitnessCenter.db.DB;
import com.YaminGym.FitnessCenter.model.Batch;

/**
 * Servlet implementation class BatchServlet
 */
@WebServlet({ "/BatchServlet", "/Batch" })
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public BatchServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		ArrayList<Batch> result = db.getAllBatches();
		StringBuffer buffer = new StringBuffer();
		
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("Hello");
		if(result.size()>0) {
			buffer.append("<h3>Batches Found.</h3>");
		}
		else {
			buffer.append("<h3>No Batches Found.</h3>");
		}
		out.print(buffer.toString());
		out.print("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
