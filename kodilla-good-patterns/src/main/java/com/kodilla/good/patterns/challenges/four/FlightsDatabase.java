package com.kodilla.good.patterns.challenges.four;

import java.time.LocalTime;
import java.util.HashSet;

public class FlightsDatabase {
    public static final  HashSet<Flight> ALL_AVAIABALE_FLIGHTS = new HashSet<Flight>() {
        private static final long serialVersionUID = -8930430687646920037L;
        {
            add(new Flight("Warszawa", LocalTime.of(10,05), "Kraków", LocalTime.of(11,10), "LO234"));
            add(new Flight("Warszawa", LocalTime.of(11,12), "Gdańsk", LocalTime.of(12,30), "LO435"));
            add(new Flight("Warszawa", LocalTime.of(12,25), "Rzeszów", LocalTime.of(13,10), "LO666"));
            add(new Flight("Warszawa", LocalTime.of(13,55), "Berlin", LocalTime.of(16,00), "LO832"));

            add(new Flight("Kraków", LocalTime.of(11,05), "Warszawa", LocalTime.of(13,10), "LO534"));
            add(new Flight("Kraków", LocalTime.of(11,15), "Gdańsk", LocalTime.of(13,30), "LO853"));
            add(new Flight("Kraków", LocalTime.of(12,25), "Rzeszów", LocalTime.of(13,55), "LO902"));
            add(new Flight("Kraków", LocalTime.of(13,38), "Berlin", LocalTime.of(16,10), "LO114"));

            add(new Flight("Gdańsk", LocalTime.of(14,11), "Warszawa", LocalTime.of(15,10), "LO367"));
            add(new Flight("Gdańsk", LocalTime.of(16,55), "Kraków", LocalTime.of(18,48), "LO846"));
            add(new Flight("Gdańsk", LocalTime.of(17,05), "Rzeszów", LocalTime.of(18,12), "LO999"));
            add(new Flight("Gdańsk", LocalTime.of(18,20), "Berlin", LocalTime.of(20,25), "LO292"));

            add(new Flight("Rzeszów", LocalTime.of(14,18), "Warszawa", LocalTime.of(16,10), "LO988"));
            add(new Flight("Rzeszów", LocalTime.of(14,55), "Kraków", LocalTime.of(15,48), "LO924"));
            add(new Flight("Rzeszów", LocalTime.of(15,05), "Gdańsk", LocalTime.of(16,12), "LO785"));
            add(new Flight("Rzeszów", LocalTime.of(16,42), "Berlin", LocalTime.of(19,05), "LO223"));

        }
    };

}
