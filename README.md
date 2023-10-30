# BankApp

## Overview
BankApp is a web application developed in Java, designed to manage Users and their associated Bank Accounts. It uses the Javalin framework to expose a RESTful API and follows the MVC architecture. The project's structure is organized into Controllers, Models, Repositories, and Services.

## Architecture

### Models
- **User**: Represents the user entity with attributes such as ID, name, password, etc.
- **Account**: Represents the bank account entity linked to a user, including attributes like balance, account number, etc.

### Controllers
- **UserController**: Manages the incoming HTTP requests related to users and dispatches responses. Handles CRUD operations for users.
- **AccountController**: Manages requests related to bank accounts of users.

### Repositories
- **UserDAO**: Data Access Object for User. It abstracts the data access logic.
- **AccountDAO**: Data Access Object for Account. Facilitates CRUD operations specific to bank accounts.

### Services
- **UserService**: Contains the business logic for users. Interacts with the UserDAO to fetch or persist data.
- **AccountService**: Contains the business logic for accounts. Interacts with the AccountDAO to manage account-specific data.

### Testing
- **TestService**: Uses JUnit for unit testing and Mockito for mocking dependencies. Ensures that the application's logic behaves as expected and that edge cases are handled appropriately.

## Features
- CRUD operations for Users.
- CRUD operations for Accounts linked to Users.
- Modular architecture following the MVC pattern.
- Error and Exception handling.
- Comprehensive unit testing using JUnit and Mockito.

## Endpoints
- **Users**:
  - `GET` `/users`: Fetch all users.
  - `POST` `/users`: Create a new user.
  - `GET` `/users/{id}`: Fetch user by ID.
  - `PUT` `/users/{id}`: Update user details.
  - `PATCH` `/users/{id}`: Update user password.
  - `DELETE` `/users/{id}`: Delete user by ID.
  
- **Accounts** (associated with a User):
  - `GET` `/users/{id}/accounts`: Fetch all accounts of a user.
  - `POST` `/users/{id}/accounts`: Create a new account for a user.
  - `GET` `/users/{id}/accounts/{accountId}`: Fetch specific account by ID.
  - `PUT` `/users/{id}/accounts/{accountId}`: Update specific account details.
  - `DELETE` `/users/{id}/accounts/{accountId}`: Delete specific account by ID.

## Error Handling
- The application has provisions for exception handling. Any unhandled exception will result in a `404 - client not found` response.
- Specific error messages and status codes are designed to guide the client about the nature of the error.


