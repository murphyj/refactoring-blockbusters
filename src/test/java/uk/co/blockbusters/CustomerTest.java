package uk.co.blockbusters;

import org.junit.Before;
import org.junit.Test;
import uk.co.blockbusters.movie.ChildrenMovie;
import uk.co.blockbusters.movie.Movie;
import uk.co.blockbusters.movie.NewReleaseMovie;
import uk.co.blockbusters.movie.RegularMovie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer theDon;

    private Movie godfather = new RegularMovie("Godfather: Part One");

    private Rental godfatherOneDay = new Rental(godfather, 1);
    private Rental godfatherThreeDays = new Rental(godfather, 3);
    private Rental godfatherFourDays = new Rental(godfather, 4);

    private Movie dumbo = new ChildrenMovie("Dumbo");

    private Rental dumboOneDay = new Rental(dumbo, 1);
    private Rental dumboFourDays = new Rental(dumbo, 4);
    private Rental dumboFiveDays = new Rental(dumbo, 5);

    private Movie starTrek = new NewReleaseMovie("Star Trek: Into the Darkness");

    private Rental starTrekTwoDays = new Rental(starTrek, 2);

    private Map<String, HashMap<String, Object>> rentals;
    private HashMap<String, HashMap<String, Object>> godfatherOneDayRental;
    private HashMap<String, HashMap<String, Object>> godfatherThreeDayRental;
    private HashMap<String,HashMap<String,Object>> godfatherFourDayRental;

    private HashMap<String, HashMap<String, Object>> dumboOneDayRental;
    private HashMap<String, HashMap<String, Object>> dumboFourDayRental;
    private HashMap<String, HashMap<String, Object>> dumboFiveDayRental;

    private HashMap<String, HashMap<String,Object>> twoFilmRentals;

    private HashMap<String, HashMap<String, Object>> newReleaseRental;

    @Before
    public void setup() {
        theDon = new Customer("Don Corleone");

        godfatherOneDayRental = singleRental(godfather, 2);
        godfatherThreeDayRental = singleRental(godfather, 3.5);
        godfatherFourDayRental = singleRental(godfather, 5);

        dumboOneDayRental = singleRental(dumbo, 1.5);
        dumboFourDayRental = singleRental(dumbo, 3);
        dumboFiveDayRental = singleRental(dumbo, 4.5);

        newReleaseRental = singleRental(starTrek, 6);

        twoFilmRentals = new HashMap<String, HashMap<String, Object>>() {
            {
                put("Godfather: Part One",
                    new HashMap<String, Object>() {{
                        put("movie", godfather);
                        put("cost", 2.0);
                    }});
                put("Dumbo",
                    new HashMap<String, Object>() {{
                        put("movie", dumbo);
                        put("cost", 1.5);
                    }});
            }
        };
    }

    private HashMap<String, HashMap<String, Object>> singleRental(
            final Movie movie, final double cost) {
        return new HashMap<String, HashMap<String, Object>>() {
            {
                put(movie.getTitle(),
                    new HashMap<String, Object>() {{
                        put("movie", movie);
                        put("cost", cost);
                    }}
                );
            }
        };
    }

    @Test
    public void checkStatementForRegularMovieForOneDay() {
        theDon.addRental(godfatherOneDay);
        int renterPoints = 1;
        double totalAmount = 2;

        assertStatementContains(godfatherOneDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementForRegularMovieForThreeDays() {
        theDon.addRental(godfatherThreeDays);
        int renterPoints = 1;
        double totalAmount = 3.5;

        assertStatementContains(godfatherThreeDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementForRegularMovieForFourDays() {
        theDon.addRental(godfatherFourDays);
        int renterPoints = 1;
        double totalAmount = 5;

        assertStatementContains(godfatherFourDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementForChildrensMovieForOneDay() {
        theDon.addRental(dumboOneDay);
        int renterPoints = 1;
        double totalAmount = 1.5;

        assertStatementContains(dumboOneDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementForChildrensMovieForFourDays() {
        theDon.addRental(dumboFourDays);
        int renterPoints = 1;
        double totalAmount = 3;

        assertStatementContains(dumboFourDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementForChildrensMovieForFiveDays() {
        theDon.addRental(dumboFiveDays);
        int renterPoints = 1;
        double totalAmount = 4.5;

        assertStatementContains(dumboFiveDayRental, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementIncreasesRenterPointsIfTwoFilmsAreRented() {
        theDon.addRental(godfatherOneDay);
        theDon.addRental(dumboOneDay);
        int renterPoints = 2;
        double totalAmount = 3.5;

        assertStatementContains(twoFilmRentals, renterPoints, totalAmount);
    }

    @Test
    public void checkStatementIncreasesRenterPointsForTwoDayNewReleaseRental() {
        theDon.addRental(starTrekTwoDays);
        int renterPoints = 2;
        double totalAmount = 6.0;
        assertStatementContains(newReleaseRental, renterPoints, totalAmount);
    }

    private void assertStatementContains(
        Map<String, HashMap<String, Object>> rentals,
        int expectedRenterPoints, double totalAmount) {
        String expectedStatement = buildStatement(
                theDon, rentals, totalAmount, expectedRenterPoints);
        String statement = theDon.statement();
        assertEquals(expectedStatement, statement);
    }

    private String buildStatement(
            Customer customer, Map<String, HashMap<String, Object>> rentals,
            double totalAmount, int frequentRenterPoints) {
        String statement = "Rental Record for " + customer.getName() + "\n";

        Iterator it = rentals.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            HashMap<String, Object> rental = (HashMap<String, Object>) pairs.getValue();
            statement += "\t" + ((Movie) rental.get("movie")).getTitle() + "\t" + rental.get("cost") + "\n";
            it.remove();
        }

        statement += "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points";
        return statement;
    }
}