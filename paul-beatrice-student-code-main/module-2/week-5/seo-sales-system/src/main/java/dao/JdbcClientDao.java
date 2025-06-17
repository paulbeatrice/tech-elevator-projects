package dao;

import config.DatabaseConnection;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcClientDao implements ClientDao {
    private final Connection connection;

    public JdbcClientDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Clients";
        try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                clients.add(mapRowToClient(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Error when retrieving clients: " + e.getMessage());
        }
        return clients;
    }

    @Override
    public Client getClientById(int clientId) {
        String sql = "SELECT * FROM Clients WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return mapRowToClient(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Error when retrieving client: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void createClient(Client client) {
        String sql = "INSERT INTO Clients (name, email, phone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating client: " + e.getMessage());
        }

    }

    @Override
    public void updateClient(Client client) {
        String sql = "UPDATE Clients SET name = ?, email = ?, phone = ? WHERE client_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPhone());
            statement.setInt(4, client.getClientId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error update client: " + e.getMessage());
        }
    }

    @Override
    public void deleteClient(int ClientId) {
        String sql = "DELETE FROM Clients WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ClientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error when deleting client: " + e.getMessage());
        }
    }

    private Client mapRowToClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setClientId(resultSet.getInt("client_id"));
        client.setName(resultSet.getString("name"));
        client.setEmail(resultSet.getString("email"));
        client.setPhone(resultSet.getString("phone"));
        client.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return client;
    }

}
