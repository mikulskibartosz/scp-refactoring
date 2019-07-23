package scp.refactoring;

class RegularMovie extends Movie {

    RegularMovie(String title) {
        super(title);
    }

    @Override
    double getChargeFor(int numberOfDays) {
        double amount = 2;
        if (numberOfDays > 2)
            amount += (numberOfDays - 2) * 1.5;
        return amount;
    }

    @Override
    int getFrequentRenterPoints() {
        return 1;
    }
}
