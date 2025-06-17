package com.techelevator.controller;

import com.techelevator.dao.AgencyDao;
import com.techelevator.model.Agency;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@PreAuthorize("hasRole('ADMIN')")
@RestController
public class AgencyController {

    @Autowired
    private AgencyDao agencyDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/agencies")
    public Agency createAgency(@Valid @RequestBody Agency newAgencyObject) {
        return agencyDao.addAgency(newAgencyObject);
    }

    @PutMapping("/agencies/{agency_id}")
    public void updateAgency(@PathVariable("agency_id") int agencyId, @Valid @RequestBody Agency updatedAgency) {
        updatedAgency.setAgencyId(agencyId); // Path Variable overrides the data body (which is what the DAO trusts)
        int rowsAffected = agencyDao.updateAgency(updatedAgency);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/agencies/{agency_id}")
    public void removeAgency(@PathVariable("agency_id") int agencyId) {
        int rowsAffected = agencyDao.removeAgency(agencyId);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
