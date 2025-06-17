package dao;

import java.util.List;
import model.Package;

public interface PackageDao {
    List<Package> getPackages();
    Package getPackageById(int packageId);
    void createPackage(Package packageObj);
    void updatePackage(Package packageObj);
    void deletePackage(int packageId);
}
