package com.kodilla.good.patterns.challenges.Flight.model;

import java.util.Objects;

public class City {

    private final String name;
    private final long cityID;

    public City(String name, long cityID) {
        this.name = name;
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public long getCityID() {
        return cityID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityID == city.cityID &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, cityID);
    }
}
