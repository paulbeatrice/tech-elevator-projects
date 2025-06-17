package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Package;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcPackageDao implements PackageDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPackageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        String getAllPackagesQuery = "SELECT * FROM packages ORDER BY name";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(getAllPackagesQuery);
            while (results.next()) {
                packages.add(mapRowToPackage(results));
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving packages", e);
        }
        return packages;
    }

    @Override
    public Package getPackageById(int packageId) {
        Package packageObject = null;
        String getPackageIdQuery = "SELECT * FROM packages WHERE package_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(getPackageIdQuery, packageId);
            if (results.next()) {
                packageObject = mapRowToPackage(results);
            }
        } catch (Exception e) {
            throw new DaoException("Error when retrieving package with ID: " + packageId, e);
        }
        return packageObject;

    }

    @Override
    public Package createPackage(Package newPackage) {
        String createPackageQuery = "INSERT INTO packages(name, description, price) VALUES (?, ?, ?) RETURNING package_id";

        try {
            int newId = jdbcTemplate.queryForObject(createPackageQuery, Integer.class, newPackage.getName(), newPackage.getDescription(), newPackage.getPrice());
            return getPackageById(newId);
        } catch (Exception e) {
            throw new DaoException("Error when trying to create package", e);
        }
    }

    @Override
    public boolean updatePackage(Package updatedPackage) {
        String updatePackageQuery = "UPDATE packages SET name = ?, description = ?, price = ? WHERE package_id = ?";

        try {
            int rowsUpdated = jdbcTemplate.update(updatePackageQuery, updatedPackage.getName(), updatedPackage.getDescription(), updatedPackage.getPrice(),
                    updatedPackage.getPackageId());
            return rowsUpdated > 0;
        } catch (Exception e) {
            throw new DaoException("Error when updating package with ID: " + updatedPackage.getPackageId(), e);
        }
    }

    @Override
    public boolean deletePackage(int packageId) {
        String deletePackageQuery = "DELETE FROM packages WHERE package_id = ?";

        try {
            int rowsDeleted = jdbcTemplate.update(deletePackageQuery, packageId);
            return rowsDeleted > 0;
        } catch (Exception e) {
            throw new DaoException("Error when deleting package with ID: " + packageId, e);
        }
    }

    private Package mapRowToPackage(SqlRowSet rs) {
        Package packageObject = new Package();
        packageObject.setPackageId(rs.getInt("package_id"));
        packageObject.setName(rs.getString("name"));
        packageObject.setDescription(rs.getString("description"));
        packageObject.setPrice(rs.getBigDecimal("price"));
        return packageObject;
    }

}
