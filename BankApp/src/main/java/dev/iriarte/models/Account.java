package dev.iriarte.models;

public class Account {
	
		private int accountId;
		private int balance;
		private boolean checkings;
		private int clientId;
		
		
		public Account() {
			super();
		}
		
		public Account(int accountId, int balance, boolean checkings, int clientId) {
			
			this.accountId = accountId;
			this.balance = balance;
			this.checkings = checkings;
			this.clientId = clientId;
		}
	
		public int getClientId() {
			
			return clientId;
		}
	
		public void setClientId(int clientId) {
			
			this.clientId = clientId;
		}
	
		public int getId() {
			
			return accountId;
		}
	
		public void setId(int accountId) {
			
			this.accountId = accountId;
		}
	
		public double getBalance() {
			
			return balance;
		}
	
		public void setBalance(int balance) {
			
			this.balance = balance;
		}
	
		public boolean getCheckings() {
			
			return checkings;
		}
	
		public void setChecking(boolean checkings) {
			
			this.checkings = checkings;
		}
	
		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", balance=" + balance + ", checkings=" + checkings + ", clientId=" + clientId + "]";
		}
	
	
}