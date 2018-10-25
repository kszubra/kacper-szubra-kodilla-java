package com.kodilla.exception.test3;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args) {

        FlightFinder flightfinder = new FlightFinder();
        Flight toWarsaw = new Flight("Madrid", "Warsaw");
        Flight toLondon = new Flight("Warsaw", "London");
        Flight toMoscow = new Flight("Warsaw", "Moscow");

        System.out.println("This one should work: ");
        try {
            String departureAirportToWarsaw = flightfinder.findFlight(toWarsaw).getDepartureAirport();
            System.out.println("You can depart to Warsaw from: " + departureAirportToWarsaw);

        }catch(RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for using our airlines.");
        }

        System.out.println("\n\r This one shouldn't: ");

        try {
            String departureAirportToLondon = flightfinder.findFlight(toLondon).getDepartureAirport();
            System.out.println("You can depart to Warsaw from: " + departureAirportToLondon);

        }catch(RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for using our airlines.");
        }

        System.out.println("\n\r This one shouldn't: ");

        try {
            String departureAirportToMoscow = flightfinder.findFlight(toMoscow).getDepartureAirport();
            System.out.println("You can depart to Warsaw from: " + departureAirportToMoscow);

        }catch(RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for using our airlines.");
        }




    }
}
