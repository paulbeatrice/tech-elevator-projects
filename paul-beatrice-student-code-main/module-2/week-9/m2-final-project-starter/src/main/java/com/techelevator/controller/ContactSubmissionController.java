package com.techelevator.controller;

import com.techelevator.dao.ContactSubmissionDao;
import com.techelevator.model.dto.ContactSubmission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-submissions")
public class ContactSubmissionController {
    private final ContactSubmissionDao dao;

    public ContactSubmissionController(ContactSubmissionDao dao) {
        this.dao = dao;
    }

    // POST : Save new contact submission (for frontend public form)
    @PostMapping
    public ResponseEntity<Void> submit(@RequestBody ContactSubmission submission) {
        dao.save(submission);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // GET: Return all contact submissions (for Admin Dashboard only)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactSubmission> getAll() {
        return dao.getAll();
    }
}
