package com.kodilla.exception.test3;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private Map<String, Boolean> flightMap = new HashMap<>();

    public FlightFinder() {

        flightMap.put("Warsaw", Boolean.TRUE);
        flightMap.put("Berlin", Boolean.TRUE);
        flightMap.put("Rome", Boolean.TRUE);
        flightMap.put("Stockholm", Boolean.TRUE);
        flightMap.put("Madrid", Boolean.TRUE);
        flightMap.put("London", Boolean.FALSE);
    }

    public Flight findFlight(Flight flightToFind) throws RouteNotFoundException {

        if((flightMap.containsKey(flightToFind.getArrivalAirport())) == false) {
            throw new RouteNotFoundException("We're sorry, this destination is not available");
        }

        if (flightMap.get(flightToFind.getArrivalAirport()).equals(Boolean.FALSE)) {

            throw new RouteNotFoundException("We're sorry, this destination is not available");
        }

        return flightToFind;
    }
}
