package com.kodilla.good.patterns.challenges.four;

public interface FlightSearchService {
    void giveFlightsArrivingTo(String arrivalCity);
    void giveFlightsDeparturingFrom(String departureCity);
    void giveTransferFlightsFromThroughTo (String departureCity, String transferCity, String arrivalCity);
}
