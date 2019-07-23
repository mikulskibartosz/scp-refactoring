package scp.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        StringBuilder result = new StringBuilder(String.format("Rental record for %s\n", getName()));
        for (Rental rental : rentals) {
            result.append(String.format("\t%s\t%s\n", rental.getMovieTitle(), String.valueOf(rental.getCharge())));
        }

        result.append(String.format("Amount owed is %s\n", String.valueOf(getTotalCharge())));
        result.append(String.format("You earned %s frequent renter points", String.valueOf(getTotalFrequentRenterPoints())));

        return result.toString();
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}