package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {


	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT + " WHERE d.department_id=?";
	try {
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			return mapRowToDepartment(results);
		} else {
			throw new DaoException("Department with ID " + id + " was not found.");
		}
	}catch (DataAccessException e) {
		throw new DaoException("Unable to retrieve department with ID " + id + ". Database may be unreachable.", e);
	}

	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
			if (departments.isEmpty()) {
				throw new DaoException("No departments found in the database.");
			}
		}catch (DataAccessException e) {
			throw new DaoException("Unable to retrieve departments. Database may be unreachable.", e);
		}
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		String sql = "INSERT INTO department (name) VALUES (?) RETURNING department_id";
		try {


			int newId = jdbcTemplate.queryForObject(sql, Integer.class, department.getName());
			department.setId(newId);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to create department. Database may be unreachable or data may be invalid.", e);
		}

		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql = "UPDATE department SET name = ? WHERE department_id = ?";
		try {
			int rowsAffected = jdbcTemplate.update(sql, department.getName(), department.getId());

			if (rowsAffected == 0) {
				throw new DaoException("No Department found with ID " + department.getId() + " to update.");
			}

		} catch (DataAccessException e) {
			throw new DaoException("Failed to update department with ID " + department.getId() + ". Possible data violation.", e);
		}
		return department;
	}

	@Override
	public int deleteDepartmentById(int id) {
		String deleteEmployeesSql = "DELETE FROM employee WHERE department_id = ?";
		String deleteDepartmentsSql = "DELETE FROM department WHERE department_id = ?";

		try {

			jdbcTemplate.update(deleteEmployeesSql, id);

			int rowsAffected = jdbcTemplate.update(deleteDepartmentsSql, id);

			if (rowsAffected == 0) {
				throw new DaoException("No department found with ID " + id + " to delete.");
			}
			return rowsAffected;
		} catch (DataAccessException e) {
			throw new DaoException("Failed to delete department with ID " + id + ". Ensure no employees are assigned to it.", e);
		}
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
