package scp.refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    String getMovieTitle() {
        return this.movie.getTitle();
    }

    double getCharge() {
        return this.movie.getChargeFor(this.daysRented);
    }

    int getFrequentRenterPoints() {
        return this.movie.getFrequentRenterPoints();
    }
}