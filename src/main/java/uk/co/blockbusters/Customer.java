package uk.co.blockbusters;

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
            Rental rental = rentals.next();

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        while (rentals.hasNext()) {
            Rental rental = rentals.next();
            total +=rental.getFrequentRenterPoints();
        }
        return total;
    }

    private double getTotalCharge() {
        double total = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        while (rentals.hasNext()) {
            Rental rental = rentals.next();
            total += rental.getCharge();
        }
        return total;
    }
}
