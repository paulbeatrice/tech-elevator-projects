package com.techelevator.dao;

import com.techelevator.model.dto.ContactSubmission;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcContactSubmissionDao implements ContactSubmissionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcContactSubmissionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(ContactSubmission submission) {
        String sql = """
                INSERT INTO contact_submissions
                (name, email, phone, business_name, business_website, social_platform, social_link, message)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

            jdbcTemplate.update(sql,
                    submission.getName(),
                    submission.getEmail(),
                    submission.getPhone(),
                    submission.getBusinessName(),
                    submission.getBusinessWebsite(),
                    submission.getSocialPlatform(),
                    submission.getSocialLink(),
                    submission.getMessage()
            );
    }

    @Override
    public List<ContactSubmission> getAll() {
        String sql = "SELECT * FROM contact_submissions ORDER BY submitted_at DESC;";
        return jdbcTemplate.query(sql, this::mapRowToSubmission);
    }
    private ContactSubmission mapRowToSubmission(ResultSet rs, int rowNum) throws SQLException {
        ContactSubmission cs = new ContactSubmission();
        cs.setId(rs.getInt("id"));
        cs.setName(rs.getString("name"));
        cs.setEmail(rs.getString("email"));
        cs.setPhone(rs.getString("phone"));
        cs.setBusinessName(rs.getString("business_name"));
        cs.setBusinessWebsite(rs.getString("business_website"));
        cs.setSocialPlatform(rs.getString("social_platform"));
        cs.setSocialLink(rs.getString("social_link"));
        cs.setMessage(rs.getString("message"));
        cs.setSubmittedAt(rs.getTimestamp("submitted_at").toLocalDateTime());
        return cs;
    }
}
