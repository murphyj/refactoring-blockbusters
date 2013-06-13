package uk.co.blockbusters;

import uk.co.blockbusters.movie.Movie;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double rentalPrice = 0;
        rentalPrice += getMovie().getRentalCost();
        if (getDaysRented() > getMovie().getInitialRentalLimit()) {
            rentalPrice += (getDaysRented() - getMovie().getInitialRentalLimit()) * getMovie().getRollingRentalCost();
        }
        return rentalPrice;
    }
}
