package com.kodilla.good.patterns.challenges.Flight.serwices;

import com.kodilla.good.patterns.challenges.Flight.repository.DestinationRepository;
import com.kodilla.good.patterns.challenges.Flight.model.City;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchFlightConnectionsService {

    private final DestinationRepository destinationRepository;

    public SearchFlightConnectionsService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public void directConnectionFromCitySearcher(City city) {

        Map<City, Set<City>> DB = destinationRepository.createConnection();

        if (DB.containsKey(city)) {

            List <String> fromCity = DB.get(city).stream()
                    .map(City::getName)
                    .collect(Collectors.toList());

            System.out.println("Flight connections available from: " + city.getName() + " to: " + fromCity.toString());

        } else {

            System.out.println("Something went wrong");

        }
    }

    public void directConnectionToCitySearcher(City city) {

        Map<City, Set<City>> DB = destinationRepository.createConnection();

        if (DB.containsKey(city)) {

            List<String> toCity = DB.entrySet().stream()
                    .filter(n -> n.getValue().contains(city))
                    .map(n -> n.getKey().getName())
                    .collect(Collectors.toList());

            System.out.println("Flight connections available to " + city.getName() + " from: " + toCity.toString());

        } else {

            System.out.println("Something went wrong");

        }
    }

    public void connectionWithChangeCitySearcher(City fromCity, City toCity) {

        Map<City, Set<City>> DB = destinationRepository.createConnection();;

        if (DB.containsKey(fromCity) && DB.containsKey(toCity)) {

            Set<City> changeCity = DB.entrySet().stream()
                    .filter(n -> n.getValue().contains((toCity)))
                    .map(n -> n.getKey())
                    .collect(Collectors.toSet());

           Set<String> throughCity = DB.get(fromCity).stream()
                   .filter(n -> changeCity.contains(n))
                   .map(n -> n.getName())
                   .collect(Collectors.toSet());

            System.out.println("Flight connections available from: " + fromCity.getName() + " to: " + toCity.getName() + " through: " +  throughCity.toString());

        } else {

            System.out.println("Connection unavailable");

        }
    }
}
