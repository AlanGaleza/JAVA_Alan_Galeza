package com.kodilla.good.patterns.challenges.Flight.repository;

import com.kodilla.good.patterns.challenges.Flight.model.City;

import java.util.*;

public class DestinationRepositoryImpl implements DestinationRepository {

    public Map<City, Set<City>> createConnection() {

        City gdansk = new City("Gdansk", 1);
        City warsaw = new City("Warsaw", 2);
        City szymany = new City("Szymany", 3);
        City modlin = new City("Modlin", 4);
        City kielce = new City("Kielce", 5);

        Set<City> gdanskConnection = new HashSet<>();
        Set<City> warsawConnection = new HashSet<>();
        Set<City> szymanyConnection = new HashSet<>();
        Set<City> modlinConnection = new HashSet<>();
        Set<City> kielceConnection = new HashSet<>();

        Map<City, Set<City>> destinationMap = new HashMap<>();

        gdanskConnection.add(warsaw);
        gdanskConnection.add(szymany);
        gdanskConnection.add(kielce);

        warsawConnection.add(gdansk);
        warsawConnection.add(szymany);
        warsawConnection.add(modlin);

        szymanyConnection.add(modlin);

        modlinConnection.add(gdansk);
        modlinConnection.add(warsaw);

        kielceConnection.add(modlin);

        destinationMap.put(gdansk, gdanskConnection);
        destinationMap.put(warsaw, warsawConnection);
        destinationMap.put(szymany, szymanyConnection);
        destinationMap.put(modlin, modlinConnection);
        destinationMap.put(kielce, kielceConnection);

        return new HashMap<>(destinationMap);
    }
}

