package dev.iriarte;

import dev.iriarte.controllers.AccountController;
import dev.iriarte.controllers.UserController;
import dev.iriarte.services.UserService;
import dev.iriarte.repositories.UserDAO;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;


import io.javalin.Javalin;

public class BankApp {
	
	public static void main(String[] args) {
		
		UserController uc = new UserController(new UserService(new UserDAO()));
		Javalin app = Javalin.create();
		
		app.start(8080);
		
		
		app.routes(() -> {
			path("/users", () -> { // http://localhost:8080/users
				get(uc::getAllUsers);
				post(uc::createNewUser);
				path("/{id}", () -> { // http://localhost:8080/users/1
					get(uc::getUserById);
					delete(uc::deleteUser);
					put(uc::updateUser); 
					patch(uc::updatePassword);
					path("/accounts", () -> {
						get(AccountController::getAccounts);
						post(AccountController::createAccount);
							path("/{accountId}", () -> {
								get(AccountController::getAccountbyId);
								put(AccountController::updateAccount);
								delete(AccountController::deleteAccount);
						});
					});
				});
			});
		});
		
		
	
		
		// Exception Mapping - best practice would be to use a more specific (or even custom) exception like a UserNotFoundException
		app.exception(Exception.class, (e, ctx) -> {
		    ctx.status(404);
		    ctx.result("client not found");
		});
		// Error Mapping
		//app.error(404, ctx -> { ctx.result("typed in the url wrong");});
		
		// Test Endpoints that won't be in the final application 
		app.get("/test", ctx -> {
			ctx.status(200);
			//String name = ctx.queryParam("name");
			ctx.result("Test successful");
		});
		
//		app.get("/{name}", ctx -> {
//			ctx.status(200);
//			String name = ctx.pathParam("name");
//			ctx.result("Hello, " + name);
//		});
		
	
		app.get("/bodystring",ctx -> {
			
			String body = ctx.body();
			System.out.println("Body: " + body);
			String[] split = body.split(":");
			 
			 for (String s : split) {
				 System.out.println(s);
			 }
			
		});
		
	}


}