package scp.refactoring;

public abstract class Movie {

    public static Movie childrenMovie(String title) {
        return new ChildrenMovie(title);
    }

    public static Movie regularMovie(String title) {
        return new RegularMovie(title);
    }

    public static Movie newRelease(String title) {
        return new NewReleaseMovie(title);
    }

    private String title;

    Movie(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract double getChargeFor(int numberOfDays);

    abstract int getFrequentRenterPoints();
}