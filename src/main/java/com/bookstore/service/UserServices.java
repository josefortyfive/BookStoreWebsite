package com.bookstore.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;

import java.io.IOException;
import java.util.List;

public class UserServices {

	private EntityManager entityManager;
	private UserDAO userDAO;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
	}
	
	public void listUser()throws ServletException, IOException {
		listUser(null);
	}
	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();
		
		request.setAttribute("listUsers", listUsers);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage= "user_list.jsp";
		RequestDispatcher requestDispacher = request.getRequestDispatcher(listPage);
		
		requestDispacher.forward(request, response);
		
	}
	
}
