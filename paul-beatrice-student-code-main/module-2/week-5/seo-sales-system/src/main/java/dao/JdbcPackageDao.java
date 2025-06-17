package dao;

import config.DatabaseConnection;
import model.Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPackageDao implements PackageDao {

    private static final String CONNECTION_URL = "jdbc:postgres://localhost:5432/seo_ecommerce_db";

    @Override
    public List<Package> getPackages() {
        List<Package> packages = new ArrayList<>();
        String sql = "SELECT * FROM Packages";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Package packageObj = new Package(
                        resultSet.getInt("package_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBigDecimal("price")
                );
                packages.add(packageObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }

    @Override
    public Package getPackageById(int packageId) {
        String sql = "SELECT * FROM Packages WHERE package_id = ?";
        Package packageObj = null;

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, packageId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new  Package(
                        resultSet.getInt("package_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBigDecimal("price")
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return packageObj;
    }

    @Override
    public void createPackage(Package packageObj) {
        String sqlInsert = "INSERT INTO Packages (name, description, price) VALUES (?, ?, ?)";
        String sqlSelectId = "SELECT package_id FROM Packages WHERE name = ? AND description = ? AND price = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
            PreparedStatement selectStatement = connection.prepareStatement(sqlSelectId)) {

           insertStatement.setString(1, packageObj.getName());
           insertStatement.setString(2, packageObj.getDescription());
           insertStatement.setBigDecimal(3, packageObj.getPrice());
           insertStatement.executeUpdate();

           selectStatement.setString(1, packageObj.getName());
           selectStatement.setString(2, packageObj.getDescription());
           selectStatement.setBigDecimal(3, packageObj.getPrice());

           ResultSet resultSet = selectStatement.executeQuery();
           if (resultSet.next()) {
               packageObj.setPackageId(resultSet.getInt("package_id"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePackage(Package packageObj) {
        String sql = "UPDATE Packages SET name = ?, description = ?, price = ? WHERE package_id = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, packageObj.getName());
            preparedStatement.setString(2, packageObj.getDescription());
            preparedStatement.setBigDecimal(3, packageObj.getPrice());
            preparedStatement.setInt(4, packageObj.getPackageId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePackage(int packageId) {
        String query = "DELETE FROM Packages WHERE package_id = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, "postgres", "postgres1");
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, packageId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
