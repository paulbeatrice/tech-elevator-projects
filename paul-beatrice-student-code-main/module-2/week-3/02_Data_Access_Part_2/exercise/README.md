# Data access part 2 exercise

For this exercise, you'll be responsible for implementing the data access objects for a CLI application that manages information for employees, departments, and projects. The purpose of this exercise is to practice writing application code that interacts with a database.

## Learning objectives

After completing this exercise, you'll understand:

* How to add custom exception handling to data access methods.
* How to execute SQL statements that insert new data.
* How to execute SQL statements that update existing data. 
* How to execute SQL statements that delete data.

## Evaluation criteria and functional requirements

Your code will be evaluated based on the following criteria:

* The project must not have any build errors.
* The unit tests pass as expected.
* Code is clean, concise, and readable.

You may use the provided CLI application to test your code. However, your goal is to make sure the tests pass.

## Getting started

1. In the `database` folder, there's an `EmployeeProjects.sql` SQL script that drops and recreates the tables and data in the `EmployeeProjects` database. You can run that script to create a copy of the database to reference while working. Be aware, however, that the tests don't use that database. The tests use a temporary database with the same structure. You'll find the SQL for that temporary database in `src/test/resources/test-data.sql`.
    > Refer to the [Database setup](https://lms.techelevator.com/content_link/gitlab.com/te-curriculum/intro-to-tools-lms/postgresql/03-database-setup.md) lesson in the Intro to Tools unit for PostgreSQL if you need instructions on setting up the database.
2. Open the exercise project in IntelliJ.
3. Run all the tests and note that they all fail.

## Step One: Explore starting code and database schema

Before you begin, review the provided classes in the `model` and `dao` packages.

You'll write your code to complete the data access methods in the `JdbcDepartmentDao`, `JdbcProjectDao`, and `JdbcEmployeeDao` classes.

Since this exercise focuses on modifying data in the database, the get methods are provided for each of these classes.

You should also familiarize yourself with the database schema either by looking at the database in pgAdmin or the `database/EmployeeProjects.sql` script.

## Step Two: Implement custom exception handling for get methods

While the provided get methods select data from the database, they don't account for any exceptions that may occur when working with DAOs. 

It's up to you to modify these methods to throw the provided DAO exception. 

After you complete this step, the tests `department_dao_get_methods_throw_dao_exception`, `employee_dao_get_methods_throw_dao_exception`, and `project_dao_get_methods_throw_dao_exception` pass.

## Step Three: Implement the `JdbcDepartmentDao` methods

Complete the data access methods in `JdbcDepartmentDao`. Refer to the documentation comments in the `DepartmentDao` interface for the expected input and result of each method.

You can remove any existing `return` statement in the method when you start working on it.

Be sure to include exception handling in your implementation to handle situations like an invalid connection string so that the test `project_dao_insert_update_delete_methods_throw_dao_exception` passes.

After you complete this step, the tests in `JdbcDepartmentDaoTest` pass.

## Step Four: Implement the `JdbcProjectDao` methods

Complete the data access methods in `JdbcProjectDao`. Refer to the documentation comments in the `ProjectDao` interface for the expected input and result of each method.

You can remove any existing `return` statement in the method when you start working on it.

Be sure to include exception handling in your implementation to handle situations like an invalid connection string so that the test `project_dao_insert_update_delete_methods_throw_dao_exception` passes.

After you complete this step, the tests in `JdbcProjectDaoTest` pass.

## Step Five: Implement the `JdbcEmployeeDao` methods

Complete the data access methods in `JdbcEmployeeDao`. Refer to the documentation comments in the `EmployeeDao` interface for the expected input and result of each method.

You can remove any existing `return` statement in the method when you start working on it.

Be sure to include exception handling in your implementation to handle situations like an invalid connection string so that the test `employee_dao_insert_update_delete_methods_throw_dao_exception` passes.

After you complete this step, the tests in `JdbcEmployeeDaoTest` pass.
