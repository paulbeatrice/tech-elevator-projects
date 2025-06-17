package service;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.dao.JdbcPackageDao;
import com.techelevator.model.Package;
import com.techelevator.service.OrderService;
import com.techelevator.service.PackageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PackageServiceTest {
    private PackageService packageService;
    private JdbcPackageDao packageDao;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/m2_final_project_test",
                "postgres",
                "postgres1",
                true
        );

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        packageDao = new JdbcPackageDao(jdbcTemplate);
        packageService = new PackageService(packageDao);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void getAllPackages_returnsListOfPackages() {
        List<Package> packages = packageService.getAllPackages();
        assertNotNull(packages);
        assertEquals(2, packages.size());
    }

    @Test
    void getPackageById_returnsCorrectPackage() {
        Package pkg = packageService.getPackageById(1);
        assertNotNull(pkg);
        assertEquals("Basic SEO Test Package", pkg.getName());
    }

    @Test
    void createPackage_savesNewPackage() {
        Package newPackage = new Package();
        newPackage.setName("Premium SEO Package");
        newPackage.setDescription("Package that offers advanced SEO strategies");
        newPackage.setPrice(BigDecimal.valueOf(3200.00));

        Package savedPackage = packageService.createPackage(newPackage);
        assertNotNull(savedPackage);
        assertEquals("Premium SEO Package", savedPackage.getName());

    }

    @Test
    void updatePackage_updatesPackageCorrectly() {
        Package pkg = packageService.getPackageById(1);
        assertNotNull(pkg);

        pkg.setName("Updated SEO Package Name");
        boolean updated = packageService.updatePackage(pkg);
        assertTrue(updated);

        Package updatedPackage = packageService.getPackageById(1);
        assertEquals("Updated SEO Package Name", updatedPackage.getName());
    }

    @Test
    void deletePackage_removesPackage() {
        boolean deletedPkg = packageService.deletePackage(1);
        assertTrue(deletedPkg);

        Package deletedPackage = packageService.getPackageById(1);
        assertNull(deletedPackage);
    }
}
