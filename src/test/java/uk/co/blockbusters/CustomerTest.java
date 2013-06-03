package uk.co.blockbusters;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer theDon;

    private Movie godfather = new Movie("Godfather", Movie.REGULAR);

    private Rental godfatherOneDay = new Rental(godfather, 1);
    private Rental godfatherThreeDays = new Rental(godfather, 3);
    private Rental godfatherFourDays = new Rental(godfather, 4);

    private Movie dumbo = new Movie("Dumbo", Movie.CHILDRENS);

    private Rental dumboOneDay = new Rental(dumbo, 1);
    private Rental dumboFourDays = new Rental(dumbo, 4);
    private Rental dumboFiveDays = new Rental(dumbo, 5);

    private Map<String, Object> rentals;

    @Before
    public void setup() {
        theDon = new Customer("Don Corleone");
        rentals = new HashMap<String, Object>();

        rentals.put("title", godfather.getTitle());
        rentals.put("rentalCost", 3.5);
    }

    @Test
    public void checkStatementForRegularMovieForOneDay() {
        theDon.addRental(godfatherOneDay);
        int renterPoints = 1;
        double totalAmount = 2;
        double costOfMovieRental = 2;

        assertStatementContains(
                godfather, renterPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementForRegularMovieForThreeDays() {
        theDon.addRental(godfatherThreeDays);
        int renterPoints = 1;
        double totalAmount = 3.5;
        double costOfMovieRental = 3.5;

        assertStatementContains(
                godfather, renterPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementForRegularMovieForFourDays() {
        theDon.addRental(godfatherFourDays);
        int renterPoints = 1;
        double totalAmount = 5;
        double costOfMovieRental = 5;

        assertStatementContains(
                godfather, renterPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementForChildrensMovieForOneDay() {
        theDon.addRental(dumboOneDay);
        int renterPoints = 1;
        double totalAmount = 1.5;
        double costOfMovieRental = 1.5;

        assertStatementContains(
                dumbo, renterPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementForChildrensMovieForFourDays() {
        theDon.addRental(dumboFourDays);
        int renterPoints = 1;
        double totalAmount = 3;
        double costOfMovieRental = 3;

        assertStatementContains(
                dumbo, renterPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementForChildrensMovieForFiveDays() {
        theDon.addRental(dumboFiveDays);
        int renderPoints = 1;
        double totalAmount = 4.5;
        double costOfMovieRental = 4.5;

        assertStatementContains(
                dumbo, renderPoints, totalAmount, costOfMovieRental);
    }

    @Test
    public void checkStatementIncreasesRenterPointsIfTwoFilmsAreRented() {
        theDon.addRental(godfatherOneDay);



        theDon.addRental(dumboOneDay);
        int renterPoints = 2;
        double totalAmount = 3.5;
        double costOfMovieRental = 3.5;

        assertStatementContains()
    }

    private void assertStatementContains(Movie movie, int expectedRenterPoints, double totalAmount, double costOfMovieRental) {
        String expectedStatement = buildStatement(theDon, movie,
                totalAmount, expectedRenterPoints, costOfMovieRental);
        String statement = theDon.statement();
        assertEquals(expectedStatement, statement);
    }

    private String buildStatement(
            Customer customer, Movie movie,
            double totalAmount, int frequentRenterPoints,
            double costOfMovieRental) {
        return "Rental Record for " + customer.getName() + "\n" +
                "\t" + movie.getTitle() + "\t" + costOfMovieRental + "\n" +
                "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points";
    }
}