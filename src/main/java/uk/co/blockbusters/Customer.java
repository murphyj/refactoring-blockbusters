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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            frequentRenterPoints =
                    each.getFrequentRenterPoints(frequentRenterPoints);

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }
}
