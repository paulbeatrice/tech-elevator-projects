package com.techelevator.model;

import java.math.BigDecimal;

public class State {

    private String stateAbbreviation;
    private String stateName;
    private BigDecimal salesTax;

    public State(String stateAbbreviation, String stateName, BigDecimal salesTax) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        this.salesTax = salesTax;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateAbbreviation='" + stateAbbreviation + '\'' +
                ", stateName='" + stateName + '\'' +
                ", salesTax=" + salesTax +
                '}';
    }
}
