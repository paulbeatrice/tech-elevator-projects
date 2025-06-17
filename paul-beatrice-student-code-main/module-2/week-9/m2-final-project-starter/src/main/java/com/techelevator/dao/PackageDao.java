package com.techelevator.dao;

import com.techelevator.model.Package;
import java.util.List;

public interface PackageDao {
    List<Package> getAllPackages();
    Package getPackageById(int packageId);
    Package createPackage(Package newPackage);
    boolean updatePackage(Package updatedPackage);
    boolean deletePackage(int packageId);

}
