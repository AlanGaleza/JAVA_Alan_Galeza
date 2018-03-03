package com.kodilla.good.patterns.challenges.Flight.repository;

import com.kodilla.good.patterns.challenges.Flight.model.City;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DestinationRepository {

    Map<City, Set<City>> createConnection();
}
