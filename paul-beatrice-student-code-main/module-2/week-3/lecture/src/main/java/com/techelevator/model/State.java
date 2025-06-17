package com.techelevator.model;

import java.math.BigDecimal;

public class State {

    private String stateAbbreviation;
    private String stateName;           //if your application calls for it you can widdle this down if it does not need your columns
    private BigDecimal salesTax;

    public State(String stateAbbreviation, String stateName) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
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
