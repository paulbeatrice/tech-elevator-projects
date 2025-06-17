package com.techelevator.dao;

import com.techelevator.model.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcPackageDaoTest {

    private JdbcPackageDao packageDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/m2_final_project_test",
                "postgres",
                "postgres1",
                true
        );

        jdbcTemplate = new JdbcTemplate(dataSource);
        packageDao = new JdbcPackageDao(jdbcTemplate);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void getAllPackages_returnsCorrectListSize() {
        List<Package> packages = packageDao.getAllPackages();
        assertFalse(packages.isEmpty());
    }

    @Test
    void getPackageById_returnsCorrectPackage() {
        Package pkg = packageDao.getPackageById(1);
        assertNotNull(pkg);
        assertEquals("Basic SEO Test Package", pkg.getName());

    }

    @Test
    void createPackage_savesAndReturnsPackage() {
        Package newPackage = new Package();
        newPackage.setName("Test Seo Package");
        newPackage.setDescription("This is a test Package Description. Not one for sale.");
        newPackage.setPrice(BigDecimal.valueOf(3500.00));

        Package createdTestPackage = packageDao.createPackage(newPackage);
        assertNotNull(createdTestPackage);
        assertEquals("Test Seo Package", createdTestPackage.getName());
    }

    @Test
    void updatePackage_updatesPackageInfo() {
        Package updatedPkg = packageDao.getPackageById(1);
        updatedPkg.setName("Updated Test Package");

        boolean isUpdated = packageDao.updatePackage(updatedPkg);
        assertTrue(isUpdated);

        Package updatedPackage = packageDao.getPackageById(1);
        assertEquals("Updated Test Package", updatedPackage.getName());
    }

    @Test
    void deletePackage_removesPackage() {
        boolean deleted = packageDao.deletePackage(1);
        assertTrue(deleted);

        Package deletedpkg = packageDao.getPackageById(1);
        assertNull(deletedpkg);
    }
}
