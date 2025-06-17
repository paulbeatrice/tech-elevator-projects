package com.techelevator.dao;

import com.techelevator.model.Agency;

public interface AgencyDao {

    // RETRIEVE
    Agency getAgencyById(int agencyId);

    // CREATE
    Agency addAgency(Agency newAgency);

    // UPDATE
    int updateAgency(Agency changedAgency);

    // DELETE
    int removeAgency(int agencyPrimaryKey);
}
