package dao;

import model.Package;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class JdbcPackageDaoTest {
    private JdbcPackageDao packageDao;

    @BeforeEach
    void setUp() {
        packageDao = new JdbcPackageDao();
    }

    @Test
    void testCreatePackage() {
        Package packageObj = new Package(0, "Starter SEO Package", "This package is designed for small businesses and includes keyword research, on-page SEO optimization, local SEO setup (i.e, google business listing, yelp, trip advisor, etc.) and also includes basic analytics reporting. It is a perfect fit for businesses looking to establish an online presence in their local market.", new BigDecimal("500.00"));
        packageDao.createPackage(packageObj);

        List<Package> packages = packageDao.getPackages();
        boolean packageExists = false;
        for (Package p : packages) {
            if (p.getName().equals("Starter SEO Package")) {
                packageExists = true;
                break;
            }
        }
        assertTrue(packageExists, "The package 'Starter SEO Package' should exist.");
    }
    @Test
    void testDeletePackage() {
        Package packageObj = new Package(0, "Starter SEO Package", "This package is designed for small businesses and includes keyword research, on-page SEO optimization, local SEO setup (i.e, google business listing, yelp, trip advisor, etc.) and also includes basic analytics reporting. It is a perfect fit for businesses looking to establish an online presence in their local market.", new BigDecimal("500.00"));
        packageDao.createPackage(packageObj);

        List<Package> packages = packageDao.getPackages();
        Package createdPackage = null;
        for (Package p : packages) {
            if (p.getName().equals("Starter SEO Package")) {
                createdPackage = p;
                break;
            }
        }
        assertNotNull(createdPackage, "The Package we are trying to delete should exist.");

        packageDao.deletePackage(createdPackage.getPackageId());

        Package deletedPackage = packageDao.getPackageById(createdPackage.getPackageId());
        assertNull(deletedPackage, "The package should no longer exist after being deleted.");

    }
}
