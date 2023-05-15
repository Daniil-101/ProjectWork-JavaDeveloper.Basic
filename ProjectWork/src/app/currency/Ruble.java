package app.currency;

import app.return_something.FormQualifier;
import app.return_something.Separation;

public class Ruble extends Currency {
    private Separation separation;
    private FormQualifier formQualifier;
    private String[][] ruble = {
            {"копейка", "копейки", "копеек"},
            {"рубль", "рубля", "рублей"}};

    public Ruble(Separation separation, FormQualifier formQualifier) {
        this.separation = separation;
        this.formQualifier = formQualifier;
    }

    @Override
    public String showCurrency(byte indexCurrency, long number) {
        int lastThreeDigits = separation.getTheLastThreeDigits(number);
        byte twoAndThree = separation.secondAndThirdNumberOfThreeDigitSegment(lastThreeDigits);
        byte formQualifier = this.formQualifier.getDeterminantOfTheWordForm(twoAndThree);
        return ruble[indexCurrency][formQualifier];
    }
}
