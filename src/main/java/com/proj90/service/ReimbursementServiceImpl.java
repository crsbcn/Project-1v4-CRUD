package com.proj90.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj90.dao.ReimbursementDao;
import com.proj90.dao.ReimbursementDaoImpl;
import com.proj90.model.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	private final ReimbursementDao dao = new ReimbursementDaoImpl();
	
	@Override
	public List<Reimbursement> getAllReimbursementsByUsername(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		System.out.println(username + " attempting access all todos");
		return dao.getAllReimbursementsByUsername(username);
	}

	@Override
	public void createTodo(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		final String title = (String) request.getParameter("title");
		final String description = (String) request.getParameter("description");
		Reimbursement todo = dao.createReimb(new Reimbursement(0, title, description), username);
			try {
				if (todo == null) {
					request.getRequestDispatcher("/home.jsp?error").forward(request, response);
				} else {
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				}
				
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
	}

}
