package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT +
				" WHERE p.project_id=?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}

		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Project projectResult = mapRowToProject(results);
			allProjects.add(projectResult);
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES (?, ?, ?) RETURNING project_id";

		try {
			int newId = jdbcTemplate.queryForObject(sql, Integer.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());

			newProject.setId(newId);
			return newProject;
		} catch (DataAccessException e) {
			throw new DaoException("Unable to create project. Database maybe unreachable.", e);
		}
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";

		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (DataAccessException e) {
			throw new DaoException("Failed to link employee ID " + employeeId + " to project ID " + projectId, e);
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";

		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (DataAccessException e) {
			throw new DaoException("Failed to link employee ID " + employeeId + " to project ID " + projectId, e);
		}

	}

	@Override
	public Project updateProject(Project project) {
		String sql = "UPDATE project SET name = ?, from_date = ?, to_date = ? WHERE project_id = ?";

		try {
			int rowsAffected = jdbcTemplate.update(sql,
					project.getName(), project.getFromDate(), project.getToDate(), project.getId());

			if (rowsAffected == 0) {
				throw new DaoException("No project found with ID " + project.getId() + " to update.");
			}
			return project;
		} catch (DataAccessException e) {
			throw new DaoException("Failed to update project with ID " + project.getId(), e);
		}
	}
	@Override
	public int deleteProjectById(int projectId) {
		String sql = "DELETE FROM project WHERE project_id = ?";

		try {
			int rowsAffected = jdbcTemplate.update(sql, projectId);
			if (rowsAffected == 0) {
				throw new DaoException("No project found with ID " + projectId + " to delete.");
			}
			return rowsAffected;
		} catch (DataAccessException e) {
			throw new DaoException("Failed to delete project with ID " + projectId + " to delete.");
		}
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
