package com.proj90.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj90.model.Reimbursement;

public interface ReimbursementService {

	// GET ALL, for when a GET REQUEST is sent to /todos
	List<Reimbursement> getAllReimbursementsByUsername(HttpServletRequest request, HttpServletResponse response);
	
	// CREATE, for when a POST REQUEST is sent to /todos
	void createTodo(HttpServletRequest request, HttpServletResponse response);
}
