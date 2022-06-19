package dev.iriarte.controllers;

import java.util.List;

import dev.iriarte.models.User;
import dev.iriarte.services.UserService;

import io.javalin.http.Context;

public class UserController {
	
	private UserService us;
	
	public UserController(UserService us) {
		this.us = us;
	}

	public void getAllUsers(Context ctx) {
		ctx.status(200);
		List<User> users = us.getAllUsers();
		ctx.json(users);
	}
	
	public void createNewUser(Context ctx) {
		ctx.status(201);
		User userFromRequestBody = ctx.bodyAsClass(User.class);
		User u = us.createUser(userFromRequestBody); 
		ctx.json(u);
	}
	
	public void getUserById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = null;
		try {
			u = us.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			ctx.status(404);
		}
		
	}
	
	public void deleteUser(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		us.deleteUser(id);
	}
	
	public void updateUser(Context ctx) {
		User uChanged = ctx.bodyAsClass(User.class); //unmarshalling
		System.out.println("updateUser -= " + uChanged);
		us.updateUser(uChanged);
	}
	public void updatePassword(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = ctx.bodyAsClass(User.class); // {"password": "newPassword"}
		System.out.println(u.getPassword());
		us.updatePassword(id, u.getPassword());
	}
}