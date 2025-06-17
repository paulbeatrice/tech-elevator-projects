package service;

import com.techelevator.dao.JdbcClientDao;
import com.techelevator.model.Client;
import com.techelevator.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {

    private ClientService clientService;
    private JdbcClientDao clientDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/m2_final_project_test",
                "postgres",
                "postgres1",
                true
        );

        jdbcTemplate = new JdbcTemplate(dataSource);
        clientDao = new JdbcClientDao(jdbcTemplate);
        clientService = new ClientService(clientDao);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void getAllClients_returnsCorrectClient() {
        List<Client> clients = clientService.getAllClients();
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
    }

    @Test
    void getClientById_returnsCorrectClient() {
        Client client = clientService.getClientById(1);
        assertNotNull(client);
        assertEquals("Joe Bob Client Example", client.getName());
    }

    @Test
    void createClient_savesNewClient() {
        Client newClient = new Client();
        newClient.setName("Joe Test Client");
        newClient.setEmail("joetestclient@gmail.com");
        newClient.setPhone("723-999-3456");

        Client savedClient = clientService.createClient(newClient);
        assertNotNull(savedClient);
        assertEquals("Joe Test Client", savedClient.getName());

    }

    @Test
    void updateClient_updatesClientInfo() {
        Client client = clientService.getClientById(1);
        assertNotNull(client);
        client.setName("Updated Test Client Name");

        boolean updated = clientService.updateClient(client);
        assertTrue(updated);

        Client updatedClient = clientService.getClientById(1);
        assertEquals("Updated Test Client Name", updatedClient.getName());
    }

    @Test
    void deleteClient_removesClient() {
        boolean isDeleted = clientService.deleteClient(1);
        assertTrue(isDeleted);
        assertNull(clientService.getClientById(1));
    }
}
