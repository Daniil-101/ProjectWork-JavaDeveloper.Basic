package app.currency;

import app.return_something.FormQualifier;
import app.return_something.Separation;


public class Dollar extends Currency {
    private Separation separation;
    private FormQualifier formQualifier;
    private String[][] dollar = {
            {"cent", "cents", "cents"},
            {"dollar", "dollars", "dollars"}};


    public Dollar(Separation separation, FormQualifier formQualifier) {
        this.separation = separation;
        this.formQualifier = formQualifier;
    }

    public String showCurrency(byte indexCurrency, long number) {
        int lastThreeDigits = separation.getTheLastThreeDigits(number);
        byte twoAndThree = separation.secondAndThirdNumberOfThreeDigitSegment(lastThreeDigits);
        byte formQualifier = this.formQualifier.getDeterminantOfTheWordForm(twoAndThree);
        return dollar[indexCurrency][formQualifier];
    }
}
