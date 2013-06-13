package uk.co.blockbusters.movie;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    public double getRentalCost() {
        return 0;
    }

    public double getRollingRentalCost() {
        return 3;
    }

    public int getInitialRentalLimit() {
        return 0;
    }
}
