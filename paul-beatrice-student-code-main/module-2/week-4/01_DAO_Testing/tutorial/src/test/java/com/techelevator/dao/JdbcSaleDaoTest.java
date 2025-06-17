package com.techelevator.dao;

import com.techelevator.model.Sale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class JdbcSaleDaoTest extends BaseDaoTest {

    // Step One: Add constants for Madge

   private static final int MADGE_CUSTOMER_ID = 3;
   private static final int MADGE_FIRST_SALE_ID = 5;

    // Step Two: Add constants for customer without sale and non-existent customer
    private static final int CUSTOMER_WITHOUT_SALES_ID = 5;
    private static final int NON_EXISTENT_CUSTOMER_ID = 7;

    private JdbcSaleDao jdbcSaleDao;

    @BeforeEach
    public void setup() {

        // Arrange - new instance of JdbcSaleDao before each and every test
        jdbcSaleDao = new JdbcSaleDao(dataSource);
    }

    @Test
    public void getSaleById_returns_correct_sale() {

        // Step One: Replace fail("Test not implemented.")

        //Arrange - create an instance of Madge's First Sale Object
        Sale madgeFirstSale = mapValuesToSale(MADGE_FIRST_SALE_ID, new BigDecimal("23.98"), true, MADGE_CUSTOMER_ID);

        //ACT - Retrieve Madge's First Sale
        Sale sale = jdbcSaleDao.getSaleById(MADGE_FIRST_SALE_ID);

        //ASSERT - retrieved sale IS NOT NULL and matches expected sale
        assertNotNull(sale, "getSaleById(" + MADGE_FIRST_SALE_ID + ") returned null");
        assertSalesMatch(madgeFirstSale, sale, "getSaleById(" + madgeFirstSale + ") returned wrong or partial data");
    }

    @Test
    public void getSalesByCustomerId_with_valid_id_returns_correct_sales() {

        // Step Two: Replace fail("Test not implemented.")

        //Act - retrieve sales for madge
        List<Sale> sales = jdbcSaleDao.getSalesByCustomerId(MADGE_CUSTOMER_ID);

        //Assert - Madge has two existing sales
        assertEquals(2, sales.size(), "getSalesByCustomerId(" + MADGE_CUSTOMER_ID + ") returned wrong number of sales");

        //Act - retrieve sales for customer with no sales
        sales = jdbcSaleDao.getSalesByCustomerId(CUSTOMER_WITHOUT_SALES_ID);

        //Assert - Customer with no sales has 0 sales
        assertEquals(0, sales.size(), "getSalesByCustomerId(" + CUSTOMER_WITHOUT_SALES_ID + ") without sales returned wrong number of sales");

        //Act - retrieve sales for Non Existent Customer Id
        sales = jdbcSaleDao.getSalesByCustomerId(NON_EXISTENT_CUSTOMER_ID);

        //Assert - list of sales is expected to be empty for a customer that does not exist
        assertEquals(0, sales.size(), "getSalesByCustomerId(" + NON_EXISTENT_CUSTOMER_ID + ") returned the wrong number of sales");

    }

    @Test
    public void createSale_creates_sale() {

        // Step Three: Replace fail("Test not implemented.")

        //Arrange- Instantiate a new Sale Object for Madge

        Sale newSale = new Sale();
        newSale.setTotal(new BigDecimal("34.56"));
        newSale.setDelivery(true);
        newSale.setCustomerId(MADGE_CUSTOMER_ID);

        //Act - create a sale from instantiated sale object
        Sale createdSale = jdbcSaleDao.createSale(newSale);

        // retrieve newly created sale
        int newId = createdSale.getSaleId();
        Sale retrievedSale = jdbcSaleDao.getSaleById(newId);

        //Assert - created Sale is correct
        assertNotEquals(0, createdSale.getSaleId(), "saleId not set when created, remained 0");
        assertEquals(createdSale.getTotal(), retrievedSale.getTotal());
        assertEquals(createdSale.isDelivery(), retrievedSale.isDelivery());
        assertEquals(createdSale.getCustomerId(), retrievedSale.getCustomerId());
    }

    @Test
    public void updateSale_updates_sale() {

        // Step Four: Replace fail("Test not implemented.")

        //Arrange - retrieve Madge's first sale and change values
        Sale saleToUpdate = jdbcSaleDao.getSaleById(MADGE_FIRST_SALE_ID);
        saleToUpdate.setTotal(new BigDecimal("89.32"));
        saleToUpdate.setDelivery(false);

        //Act - update existing sale with changed values and re-retrieve
        Sale updatedSale = jdbcSaleDao.updateSale(saleToUpdate);
        Sale retrivedSale = jdbcSaleDao.getSaleById(MADGE_FIRST_SALE_ID);

        //Assert - Sale has been updated correctly
        assertSalesMatch(updatedSale, retrivedSale, "Updated Madge's first sale and returned wrong or partial data");
    }

    @Test
    public void deleteSaleById_deletes_sale() {

        // Step Five: Replace fail("Test not implemented.")

        //Act delete existing first sale for Madge
        int rowsAffected = jdbcSaleDao.deleteSaleById(MADGE_FIRST_SALE_ID);

        //Assert - Madge's first sale should be deleted
        assertEquals(1, rowsAffected, "Sale not deleted");
        Sale retrievedSale = jdbcSaleDao.getSaleById(MADGE_FIRST_SALE_ID);
        assertNull(retrievedSale, "Deleted Sale can still be retrieved");
    }

    // Convenience method in lieu of a Sale constructor with all the fields as parameters.
    // Similar to mapRowToSale() in JdbcSaleDao.
    private static Sale mapValuesToSale(int saleId, BigDecimal total, boolean delivery, Integer customerId) {

        Sale sale = new Sale();
        sale.setSaleId(saleId);
        sale.setTotal(total);
        sale.setDelivery(delivery);
        sale.setCustomerId(customerId);
        return sale;
    }

    private void assertSalesMatch(Sale expected, Sale actual, String message) {

        assertEquals(expected.getSaleId(), actual.getSaleId(), message);
        assertEquals(expected.getTotal(), actual.getTotal(), message);
        assertEquals(expected.isDelivery(), actual.isDelivery(), message);
        assertEquals(expected.getCustomerId(), actual.getCustomerId(), message);
    }
}
