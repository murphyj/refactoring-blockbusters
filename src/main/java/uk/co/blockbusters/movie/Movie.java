package uk.co.blockbusters.movie;

public abstract class Movie {

    private String title;

    public Movie (String title) {
        this.title = title;
    }

    public abstract double getRentalCost();

    public abstract int getInitialRentalLimit();

    public abstract double getRollingRentalCost();

    public String getTitle() {
        return title;
    }
}