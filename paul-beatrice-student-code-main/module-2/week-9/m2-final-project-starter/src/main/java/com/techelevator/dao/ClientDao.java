package com.techelevator.dao;


import com.techelevator.model.Client;
import java.util.List;

public interface ClientDao {
    List<Client> getAllClients();
    Client getClientById(int clientId);
    Client createClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(int clientId);
}
