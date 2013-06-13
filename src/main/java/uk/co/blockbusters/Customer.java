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
        double totalCost = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            double rentalCost = 0;
            Rental rental = (Rental) rentals.next();

            rentalCost = rental.getCharge();

            // add frequent renter points
            frequentRenterPoints += rental.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rentalCost) + "\n";
            totalCost += rentalCost;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalCost) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        if ((rental.getMovie() instanceof NewReleaseMovie) &&
             rental.getDaysRented() > 1) {
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }

}
