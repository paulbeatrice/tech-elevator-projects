package dao;

import java.util.List;
import model.Client;


public interface ClientDao {
    List<Client> getClients();
    Client getClientById(int clientId);
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClient(int clientId);
}
