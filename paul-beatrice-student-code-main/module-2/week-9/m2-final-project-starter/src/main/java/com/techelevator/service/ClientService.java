package com.techelevator.service;

import com.techelevator.dao.JdbcClientDao;
import com.techelevator.model.Client;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    private final JdbcClientDao clientDao;

    public ClientService(JdbcClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public Client getClientById(int clientId) {
        return clientDao.getClientById(clientId);
    }

    public Client createClient(Client client) {
        if (client.getName() == null || client.getEmail() == null || client.getPhone() == null) {
            throw new IllegalArgumentException("Client information cannot be null.");
        }
        return clientDao.createClient(client);
    }

    public boolean updateClient(Client client) {
        if (client.getClientId() <= 0) {
            throw new IllegalArgumentException("Invalid client ID.");
        }
        return clientDao.updateClient(client);
    }

    public boolean deleteClient(int clientId) {
        if (clientId <= 0) {
            throw new IllegalArgumentException("Invalid client ID.");
        }
        return clientDao.deleteClient(clientId);
    }
}
