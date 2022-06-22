package dev.iriarte.controllers;
import dev.iriarte.models.Account;
import dev.iriarte.services.AccountService;

import java.util.List;

import io.javalin.http.Context;

public class AccountController {
	
		private static AccountService as = new AccountService();
		
		public static void createAccount(Context ctx) {
			
			int clientId = Integer.parseInt(ctx.pathParam("id"));
			
			Account accountFromRequestBody = ctx.bodyAsClass(Account.class);
			
			as.createAccount(accountFromRequestBody, clientId);
			ctx.status(201);
		}
		
		public static void getAccountbyId(Context ctx) {
			
			int clientId = Integer.parseInt(ctx.pathParam("id"));
			int accountId = Integer.parseInt(ctx.pathParam("accountId"));
			
			Account a = null;
			
			try {
				a = as.getAccountbyId(accountId, clientId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (a != null) {
				ctx.status(200);
				ctx.json(a);
				} else {
					ctx.status(404);
				}
		}
		
		public static void getAccounts(Context ctx) {
			
			int clientId = Integer.parseInt(ctx.pathParam("id"));
			
			List<Account> a = null;
			
			try {
				a = as.getAccounts(clientId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (a == null) {
				ctx.status(404);
				} else {
					ctx.status(200);
					ctx.json(a);
				}
		}
		
		public static void updateAccount(Context ctx) {
			
			int accountId = Integer.parseInt(ctx.pathParam("accountId"));
			int clientId = Integer.parseInt(ctx.pathParam("id"));
			
			Account aChanged = ctx.bodyAsClass(Account.class);
			
			try {
				as.updateAccount(aChanged, accountId, clientId);
				ctx.status(200);
			} catch (Exception e) {
				ctx.status(404);
			}
			
	
		}
		
		public static void deleteAccount(Context ctx) {
			
			int accountId = Integer.parseInt(ctx.pathParam("accountId"));
			
			ctx.status(205);
			as.deleteAccount(accountId);
		}

}