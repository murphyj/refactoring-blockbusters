package uk.co.blockbusters.movie;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    public double getRentalCost() {
        return 2;
    }

    public double getRollingRentalCost() {
        return 1.5;
    }

    public int getInitialRentalLimit() {
        return 2;
    }
}
