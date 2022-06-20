package dev.iriarte.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.iriarte.models.User;
import dev.iriarte.repositories.UserDAO;

@ExtendWith(MockitoExtension.class) // use to be @RunWith in JUnit 4
public class UserServiceTests {
	
	// an instance of the class that we are testing - a REAL instance
	@InjectMocks
	private static UserService userService;
	
	// since we want to test only the functionality of the UserService class
	// we will Mock any dependencies that class relies on
	@Mock
	private static UserDAO mockUserDao;
	
//	@BeforeAll
//	public static void setUp() {
//		userService = new UserService();
//		
//		// this is just a dummy instance that has no actual functionality.
//		mockUserDao = mock(UserDAO.class);
//	}
	
	@Test
	public void should_ReturnAllUsers() {
		// given - 3 users in DB
		List<User> usersMock = new ArrayList<>();
		usersMock.add(new User(1, "Manny", "Mock", "user", "pass"));
		usersMock.add(new User(2, "Debbie", "Mock", "user", "pass"));
		usersMock.add(new User(3, "Gigi", "Mock", "user", "pass"));
		
		// when - UserService's getAllUsers method is called
		when(mockUserDao.getAllUsers()).thenReturn(usersMock);
		
		// then - it should return all users
		assertEquals(usersMock, userService.getAllUsers());
		
	}
	
	// login Test

}