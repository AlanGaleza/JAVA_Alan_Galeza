package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {

    public static void main(String args[])  {
        Flight flight = new Flight("Warsaw", "Szymany");
        FlightSearcher flightSearcher = new FlightSearcher();

        try {
            flightSearcher.findFlight(flight);

        } catch (RouteNotFoundException e) {
            System.out.println("Catch " + e);
        }

        System.out.println("Processing other logic!");

    }
}
