package com.kodilla.good.patterns.challenges.four;

public class StreamBasedFlightSearch implements FlightSearchService {

    @Override
    public void giveFlightsArrivingTo(String arrivalCity) {

        System.out.println("Flights arriving to " + arrivalCity);
        FlightsDatabase.ALL_AVAIABALE_FLIGHTS.stream()
                .filter(e->e.getArrivalCity().equals(arrivalCity))
                .forEach(System.out::println);
    }

    @Override
    public void giveFlightsDeparturingFrom(String departureCity) {

        System.out.println("Flights departing from " + departureCity);
        FlightsDatabase.ALL_AVAIABALE_FLIGHTS.stream()
                .filter(e->e.getDepartureCity().equals(departureCity))
                .forEach(System.out::println);
    }

    @Override
    public void giveTransferFlightsFromThroughTo(String departureCity, String transferCity, String arrivalCity) {

        System.out.println("Transfer flights from " + departureCity + " to " + arrivalCity + " through " + transferCity);
        FlightsDatabase.ALL_AVAIABALE_FLIGHTS.stream()
                .filter(e->e.getDepartureCity().equals(departureCity))
                .filter(e->e.getArrivalCity().equals(transferCity))
                .forEach(System.out::println);

        FlightsDatabase.ALL_AVAIABALE_FLIGHTS.stream()
                .filter(e->e.getDepartureCity().equals(transferCity))
                .filter(e->e.getArrivalCity().equals(arrivalCity))
                .forEach(System.out::println);
    }
}
