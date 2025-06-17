package com.lendingcatalog;

import java.math.BigDecimal;

public interface Expense {
    BigDecimal calculateCharge (long durationInHours);


    String generateInvoice(String customerName, long durationInHours);

    BigDecimal getTotalCost(int hours, boolean overnight);

    void generateInvoice(String customerName, BigDecimal totalCost);

    void generateInvoice(String customerName, Vehicle vehicle, BigDecimal totalCost);
}
