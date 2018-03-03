package com.kodilla.good.patterns.challenges.Flight;

import com.kodilla.good.patterns.challenges.Flight.repository.DestinationRepository;
import com.kodilla.good.patterns.challenges.Flight.repository.DestinationRepositoryImpl;
import com.kodilla.good.patterns.challenges.Flight.model.City;
import com.kodilla.good.patterns.challenges.Flight.serwices.SearchFlightConnectionsService;

public class Application {

    public static void main(String args[]) {

    City gdansk = new City("Gdansk", 1);
    City warsaw = new City("Warsaw", 2);
    City szymany = new City("Szymany", 3);
    City modlin = new City("Modlin", 4);

    DestinationRepository flightDB = new DestinationRepositoryImpl();

    SearchFlightConnectionsService searchFlightConnectionsService = new SearchFlightConnectionsService(flightDB);

    searchFlightConnectionsService.directConnectionFromCitySearcher(warsaw);
    searchFlightConnectionsService.directConnectionToCitySearcher(modlin);
    searchFlightConnectionsService.connectionWithChangeCitySearcher(gdansk, szymany);

    }
}
