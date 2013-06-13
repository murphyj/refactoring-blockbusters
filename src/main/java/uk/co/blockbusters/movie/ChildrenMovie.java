package uk.co.blockbusters.movie;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    public double getRentalCost() {
        return 1.5;
    }

    public double getRollingRentalCost() {
        return 1.5;
    }

    public int getInitialRentalLimit() {
        return 3;
    }
}
