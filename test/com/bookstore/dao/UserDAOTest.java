package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.RollbackException;

public class UserDAOTest {
	private static UserDAO userDAO;
	private static EntityManager entityManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO(entityManager);
	}


	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("");
		user1.setFullName("");
		user1.setPassword("");

		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
		
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
	}

	@Test
	public void testUpdateUsers() {
		Users user1 = new Users();
		user1.setUserId(1);
		user1.setEmail("edmar@java.net");
		user1.setFullName("Edmar Canin");
		user1.setPassword("mysecret");
		
		user1 = userDAO.update(user1);
		String expected = "mysecret";
		String actual = user1.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		
		Users user1 = userDAO.get(userId);
		
		if(user1 != null) {
			System.out.println(user1.getEmail());
			System.out.println(user1.getFullName());
		}
	
		assertNotNull(user1);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user1 = userDAO.get(userId);
		
		assertNull(user1);
	}
	@Test
	public void testDeleteUsers() {
		Integer userId = 3;
		userDAO.delete(userId);
		
		Users user1 = userDAO.get(userId);
		assertNull(user1);
	}
	
	
	@Test(expected = RollbackException.class)
	public void testDeleteNonExistUsers() {
		Integer user1 = 55;
		userDAO.delete(user1);
		
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for(Users user : listUsers) {
			System.out.println("Email Address: "+user.getEmail());
			System.out.println("Full Name: "+user.getFullName());
		}
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCountAll() {
		long totalUsers = userDAO.count();
		
		System.out.println(totalUsers);
		assertEquals(3, totalUsers);
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	
}
