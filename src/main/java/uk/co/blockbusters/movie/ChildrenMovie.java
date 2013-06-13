package uk.co.blockbusters.movie;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    public double getPriceCode() {
        return 1.5;
    }
}
