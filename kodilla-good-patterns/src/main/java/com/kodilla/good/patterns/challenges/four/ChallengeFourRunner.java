package com.kodilla.good.patterns.challenges.four;

public class ChallengeFourRunner {
    public static void main(String[] args) {

        FlightSearchService websiteSearchService = new StreamBasedFlightSearch();

        websiteSearchService.giveFlightsArrivingTo("Warszawa");
        websiteSearchService.giveFlightsDeparturingFrom("Rzeszów");
        websiteSearchService.giveTransferFlightsFromThroughTo("Warszawa", "Kraków", "Berlin");
    }
}
