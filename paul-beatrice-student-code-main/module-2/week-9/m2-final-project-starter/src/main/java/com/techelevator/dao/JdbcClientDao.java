package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClientDao implements ClientDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getAllClients() {
      List<Client> clientList = new ArrayList<>();
      String selectAllClients = "SELECT * FROM clients ORDER BY name";

      try {
          SqlRowSet results = jdbcTemplate.queryForRowSet(selectAllClients);
          while (results.next()) {
              clientList.add(mapRowToClient(results));
          }
      } catch (Exception e) {
          throw new DaoException("Error when retrieving list of clients", e);
      }
        return clientList;
    }

    @Override
    public Client getClientById(int clientId) {
        Client client = null;
        String selectClientBydId = "SELECT * FROM clients WHERE client_id = ?";

        try {
            SqlRowSet resultSet = jdbcTemplate.queryForRowSet(selectClientBydId, clientId);
            if (resultSet.next()) {
                client = mapRowToClient(resultSet);
            }
        } catch (Exception e) {
            throw new DaoException("Error when retrieving client with ID", e);
        }
        return client;
    }

    @Override
    public Client createClient(Client client) {
        String createClientQuery = "INSERT INTO clients (name, email, phone) VALUES (?, ?, ? ) RETURNING client_id";

        try {
            int newClientId = jdbcTemplate.queryForObject(createClientQuery, Integer.class, client.getName(), client.getEmail(), client.getPhone());
            return getClientById(newClientId);
        } catch (Exception e) {
            throw new DaoException("Error when trying to create client", e);
        }
    }

    @Override
    public boolean updateClient(Client client) {
        String updateClientQuery = "UPDATE clients SET name = ?, email = ?, phone = ? WHERE client_id = ?";

       try {
           int rowsAffected =  jdbcTemplate.update(updateClientQuery,
                   client.getName(),
                    client.getEmail(),
                    client.getPhone(),
                    client.getClientId()
           );
            return rowsAffected > 0;
       } catch (Exception e) {
           throw new DaoException("Error when updating client with ID: " + client.getClientId(), e);
       }
    }

    @Override
    public boolean deleteClient(int clientId) {
        String deleteClient = "DELETE FROM clients WHERE client_id = ?";

        try {
            int rowsDeleted = jdbcTemplate.update(deleteClient, clientId);
            return rowsDeleted > 0;
        } catch (Exception e) {
            throw new DaoException("Error deleting client with ID: " + clientId, e);
        }
    }

    private Client mapRowToClient(SqlRowSet resultSet) throws SQLException {
        Client mappedClient = new Client();
        mappedClient.setClientId(resultSet.getInt("client_id"));
        mappedClient.setName(resultSet.getString("name"));
        mappedClient.setEmail(resultSet.getString("email"));
        mappedClient.setPhone(resultSet.getString("phone"));
        mappedClient.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return mappedClient;
    }

}



