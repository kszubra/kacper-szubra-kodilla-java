package com.kodilla.good.patterns.challenges.four;

import java.time.LocalTime;
import java.util.Objects;

public class Flight {

    private String departureCity;
    private LocalTime departureTime;
    private String arrivalCity;
    private LocalTime arrivalTime;
    private String flightNumber;

    public Flight(String departureCity, LocalTime departureTime, String arrivalCity, LocalTime arrivalTime, String flightNumber) {
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", departureTime=" + departureTime.format(AirportTimeFormat.AIRPORT_TIME_FORMAT) +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", arrivalTime=" + arrivalTime.format(AirportTimeFormat.AIRPORT_TIME_FORMAT) +
                '}';
    }

    @Override
    public int hashCode() {
        return flightNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber);
    }
}
