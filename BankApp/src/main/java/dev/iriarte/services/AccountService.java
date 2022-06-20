package dev.iriarte.services;
import dev.iriarte.models.Account;
import dev.iriarte.repositories.AccountDAO;

import java.util.List;


public class AccountService {
	
		private static AccountDAO accountDao = new AccountDAO();
		
		public Account createAccount(Account a, int clientId) {
			
			Account createdAccount = accountDao.createAccount(a);
			
			return createdAccount;
		}
		
		public Account getAccountbyId(int accountId, int clientId) throws Exception {
			
			Account a = accountDao.getAccountbyId(accountId, clientId);
			
			if (a == null) {
				throw new Exception("Account not found");
			}
			
			return a;
			
		}
		
		public List<Account> getAccounts(int clientId) throws Exception {
			
			List<Account> a = accountDao.getAccounts(clientId);
			
			if (a == null) {
				throw new Exception("Accounts not found");
			}
	
	
			return a;
		}
		
		public void updateAccount(Account aChanged, int accountId, int clientId) {
			
			accountDao.updateAccount(aChanged);
		}	
		
		public void deleteAccount(int accountId) {
			
			accountDao.deleteAccount(accountId);
		}

}