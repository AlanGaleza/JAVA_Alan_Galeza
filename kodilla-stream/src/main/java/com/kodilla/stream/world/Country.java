package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final String countryName;
    private final BigDecimal countryPopulation;


    public Country(final String countryName, final BigDecimal countryPopulation) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }

    public BigDecimal getPeopleQuantity() {
        return countryPopulation;
    }

    public String getCountryName() {
        return countryName;
    }
}
