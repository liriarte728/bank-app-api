package dev.iriarte.services;

import java.util.List;

import dev.iriarte.models.User;
import dev.iriarte.repositories.UserDAO;

public class UserService {
	
	
	private static UserDAO userDao;
	
	public UserService(UserDAO userDao) {
		
		UserService.userDao = userDao;
	}
	
	
	//login
	public User login(String username, String password) {
		
		User u = userDao.getUserByUsername(username);
		
		if (u.getPassword().equals(password)) {
			return u;
		}
		return null;
	}
	
	public User updatePassword(int id, String password) {
		// check user exists
		return userDao.updateUserPassword(id, password);
	}
	
	// create user
	public User createUser(User u) {
		User createdUser = userDao.createUser(u);
		return createdUser;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(int id) throws Exception {
		// this is where we can put business logic 
		User u = userDao.getUserById(id);
		
		if (u == null) {
			throw new Exception("User not found");
		}
		
		return u;
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	public void updateUser(User uChanged) {
		userDao.updateUser(uChanged);
	}


	

}