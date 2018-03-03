package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {
    private final Set<Country> CountryList = new HashSet<>();
    private final String continentName;

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public void addCountryToContinent(Country country) {
        CountryList.add(country);
    }

    public Set<Country> getCountryList() {
        return CountryList;
    }
}
