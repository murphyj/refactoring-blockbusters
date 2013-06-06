package uk.co.blockbusters;

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
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (getDaysRented() > 2) {
                    rentalPrice += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (getDaysRented() > 3) {
                    rentalPrice += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return rentalPrice;
    }
}
