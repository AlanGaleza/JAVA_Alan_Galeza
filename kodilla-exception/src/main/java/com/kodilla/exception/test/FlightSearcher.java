package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class FlightSearcher {

    private final Map<String, Boolean> airportMap;

    public FlightSearcher() {
        this.airportMap = new HashMap<>();
        airportMap.put("Warsaw", true);
        airportMap.put("Gdansk", false);
        airportMap.put("Szymany", true);
        //airportMap.put("Modlin", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {

        if (flight.getDepartureAirport().equals(flight.getArrivalAirport())) {

            System.out.println("Bad departure or arrival Airport");
            return;
        }

        List<String> tasks = airportMap.entrySet().stream()
                .filter(n -> n.getValue())
                .map(n -> n.getKey())
                .collect(toList());

        if (tasks.contains(flight.getDepartureAirport()) && tasks.contains(flight.getArrivalAirport())) {

            System.out.println("You r flying from: " + flight.getDepartureAirport() + " to: " + flight.getArrivalAirport());

        } else {

            throw new RouteNotFoundException("No Airport available");

        }
    }
}
