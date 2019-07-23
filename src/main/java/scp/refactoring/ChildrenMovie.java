package scp.refactoring;

class ChildrenMovie extends Movie {

    ChildrenMovie(String title) {
        super(title);
    }

    @Override
    double getChargeFor(int numberOfDays) {
        double amount = 1.5;
        if (numberOfDays > 3)
            amount += (numberOfDays - 3) * 1.5;
        return amount;
    }

    @Override
    int getFrequentRenterPoints() {
        return 1;
    }
}
