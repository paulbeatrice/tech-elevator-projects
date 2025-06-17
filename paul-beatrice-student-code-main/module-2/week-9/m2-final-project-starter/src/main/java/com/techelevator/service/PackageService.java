package com.techelevator.service;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.dao.JdbcPackageDao;
import com.techelevator.model.Package;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PackageService {

    private final JdbcPackageDao packageDao;

    public PackageService(JdbcPackageDao packageDao) {
        this.packageDao = packageDao;
    }

    public List<Package> getAllPackages() {
        return packageDao.getAllPackages();
    }

    public Package getPackageById(int packageId) {
        return packageDao.getPackageById(packageId);
    }

    public Package createPackage(Package newPackage) {
        if (newPackage == null || newPackage.getName() == null ||
                newPackage.getDescription() == null || newPackage.getPrice() == null) {
            throw new IllegalArgumentException("Package details must be valid.");
        }
        return packageDao.createPackage(newPackage);
    }

    public boolean updatePackage(Package updatedPackage) {
        if (updatedPackage.getPackageId() <= 0) {
            throw new IllegalArgumentException("Invalid Package Id.");
        }
        return packageDao.updatePackage(updatedPackage);
    }

    public boolean deletePackage(int packageId) {
        if (packageId <= 0) {
            throw new IllegalArgumentException("Invalid Package Id.");
        }
        return packageDao.deletePackage(packageId);
    }

}
