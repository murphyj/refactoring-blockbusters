package uk.co.blockbusters;

import uk.co.blockbusters.movie.NewReleaseMovie;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> rentals = this.rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            double rentalCost = 0;
            Rental rental = (Rental) rentals.next();

            rentalCost = rental.getCharge();

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rentalCost) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCost()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while(iterator.hasNext()) {
            Rental rental = iterator.next();
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    private double getTotalCost() {
        double totalCost = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            totalCost += rental.getCharge();
        }
        return totalCost;
    }

}
