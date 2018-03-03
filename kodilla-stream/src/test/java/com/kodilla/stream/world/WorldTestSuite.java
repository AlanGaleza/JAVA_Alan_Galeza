package com.kodilla.stream.world;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("10"));
        Country australia = new Country("Australia", new BigDecimal("200"));
        Country russia = new Country("Russia", new BigDecimal("3000"));

        Continent continentEurope = new Continent("Europe");
        Continent continentAustralia = new Continent("Australia");
        Continent continentAsia = new Continent("Asia");

        World worldContinents = new World();
        worldContinents.addContinent(continentEurope);
        worldContinents.addContinent(continentAustralia);
        worldContinents.addContinent(continentAsia);

        continentEurope.addCountryToContinent(poland);
        continentAustralia.addCountryToContinent(australia);
        continentAsia.addCountryToContinent(russia);

        //When
        BigDecimal result = worldContinents.getPeopleQuantity();
        BigDecimal expected = new BigDecimal(3210);

        //Then
        assertThat(result).isEqualTo(expected);
        assertThat(continentEurope.getCountryList().contains(continentEurope));
        assertThat(worldContinents.getContinentList()).contains(continentEurope);
    }
}
