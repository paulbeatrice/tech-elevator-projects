package com.techelevator.dao;

import com.techelevator.model.Agency;
import io.jsonwebtoken.lang.Assert;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAgencyDaoTest extends BaseDaoTest {

    private AgencyDao sut;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.sut = new JdbcAgencyDao(jdbcTemplate);
    }

    // Test Create
    @Test
    public void create_new_agency() {
        // ARRANGE
        int invalidId = -1;
        Agency newAgency = new Agency(invalidId, "Tom's New Agency", "987 Main St",  "Don't be a jerk");

        // ACT
        Agency agencyReturnedFromMethod = sut.addAgency(newAgency);

        // ASSERT
        Assertions.assertNotNull(agencyReturnedFromMethod);
        Assertions.assertNotEquals(agencyReturnedFromMethod.getAgencyId(), invalidId);
        /* Same idea in sample code: */ Assertions.assertTrue(agencyReturnedFromMethod.getAgencyId() > 0);

        Assertions.assertEquals(newAgency.getAgencyName(), agencyReturnedFromMethod.getAgencyName());
        Assertions.assertEquals(newAgency.getAddress(), agencyReturnedFromMethod.getAddress());
        Assertions.assertEquals(newAgency.getAgencyPolicy(), agencyReturnedFromMethod.getAgencyPolicy());
//        assertAgenciesMatch();
    }



    // Test Update
    @Test
    public void update_agency_actually_updates_agency() {
        // ARRANGE
        Agency before = sut.getAgencyById(1);
        // 'Agency-1', '123 Main St', 'of truth'

        before.setAgencyName("YOU GOT HACKED");
        before.setAddress("404 Not Found Street");
        before.setAgencyPolicy("These guys are too young for Depeche Mode");

        // ACT
        int rowsAffected = sut.updateAgency(before);
        Assertions.assertEquals(1, rowsAffected);

        Agency after = sut.getAgencyById(1);

        // ASSERT

        Assertions.assertEquals(before.getAgencyId(), after.getAgencyId());
        Assertions.assertEquals(before.getAgencyName(), after.getAgencyName());
        Assertions.assertEquals(before.getAddress(), after.getAddress());
        Assertions.assertEquals(before.getAgencyPolicy(), after.getAgencyPolicy());


    }

    // Test Remove
    @Test
    public void remove_agency_actually_works() {
        // ARRANGE
        Agency found = sut.getAgencyById(3);

        // ACT
        int before = sut.removeAgency(3);
        int after = sut.removeAgency(3);

        // ASSERT
        Assertions.assertEquals(1, before);
        Assertions.assertEquals(0, after);

    }


}
