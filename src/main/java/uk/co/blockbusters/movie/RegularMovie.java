package uk.co.blockbusters.movie;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    public double getPriceCode() {
        return 2;
    }
}
