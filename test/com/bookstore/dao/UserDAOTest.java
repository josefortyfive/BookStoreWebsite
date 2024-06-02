package com.bookstore.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO();
	}


	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("john3@gmail.com");
		user1.setFullName("John Smith");
		user1.setPassword("password1");

		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO.close();
	}

}
