package uk.co.blockbusters.movie;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    public double getPriceCode() {
        return 3;
    }
}
