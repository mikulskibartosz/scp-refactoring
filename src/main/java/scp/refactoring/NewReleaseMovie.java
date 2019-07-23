package scp.refactoring;

class NewReleaseMovie extends Movie {

    NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    double getChargeFor(int numberOfDays) {
        return numberOfDays * 3;
    }

    @Override
    int getFrequentRenterPoints() {
        return 2;
    }
}
