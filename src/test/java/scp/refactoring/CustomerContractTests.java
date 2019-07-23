package scp.refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerContractTests {
    private final String CUSTOMER_NAME = "Johnny the Bug";
    private final Rental childrenMovieRental = new Rental(new Movie("Harry Potter and NullPointerException", Movie.CHILDREN), 2);
    private final Rental childrenMovieLongRental = new Rental(new Movie("The Lord of the StackTrace", Movie.CHILDREN), 4);

    private final Rental newReleaseRental = new Rental(new Movie("The Silence of the Lambdas", Movie.NEW_RELEASE), 3);

    private final Rental regularMovieRental = new Rental(new Movie("Once Upon a Time in the JVM", Movie.REGULAR), 1);
    private final Rental regularMovieLongRental = new Rental(new Movie("The walking OutOfMemoryError", Movie.REGULAR), 3);

    @Test
    public void returnStatementOfACustomerWithoutRentals() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithOneRegularMovie() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(regularMovieRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tOnce Upon a Time in the JVM\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithOneChildrenMovie() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(childrenMovieRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tHarry Potter and NullPointerException\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithOneNewReleaseMovie() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(newReleaseRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tThe Silence of the Lambdas\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithLongRentalOfOneChildrenMovie() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(childrenMovieLongRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tThe Lord of the StackTrace\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithLongRentalOfOneRegularMovie() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(regularMovieLongRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tThe walking OutOfMemoryError\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void returnStatementWithAllAvailableMovies() {
        //given
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(childrenMovieRental);
        customer.addRental(childrenMovieLongRental);
        customer.addRental(newReleaseRental);
        customer.addRental(regularMovieRental);
        customer.addRental(regularMovieLongRental);

        //when
        String statement = customer.statement();

        //then
        assertEquals("Rental record for Johnny the Bug\n" +
                "\tHarry Potter and NullPointerException\t1.5\n" +
                "\tThe Lord of the StackTrace\t3.0\n" +
                "\tThe Silence of the Lambdas\t9.0\n" +
                "\tOnce Upon a Time in the JVM\t2.0\n" +
                "\tThe walking OutOfMemoryError\t3.5\n" +
                "Amount owed is 19.0\n" +
                "You earned 6 frequent renter points", statement);
    }
}
