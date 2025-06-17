package com.techelevator.dao;

import com.techelevator.model.dto.ContactSubmission;
import java.util.List;
public interface ContactSubmissionDao {
    void save(ContactSubmission submission);
    List<ContactSubmission> getAll();
}
