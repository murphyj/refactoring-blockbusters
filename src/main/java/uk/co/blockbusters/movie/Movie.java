package uk.co.blockbusters.movie;

public abstract class Movie {

    private String title;

    public Movie (String title) {
        this.title = title;
    }

    public abstract double getPriceCode();

    public String getTitle() {
        return title;
    }
}