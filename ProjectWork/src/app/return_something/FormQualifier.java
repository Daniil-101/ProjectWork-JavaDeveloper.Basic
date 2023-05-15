package app.return_something;

import app.Interfaces.Identifier;

public class FormQualifier implements Identifier {

    private Separation separation;

    public FormQualifier(Separation separation) {
        this.separation = separation;
    }

    public byte getDeterminantOfTheWordForm(byte number) {
        byte degreeForm = 0;
        byte units = separation.thirdNumberOfThreeDigitSegment(number);
        if (units == 0 || units >= 5 || (number > 10 && number < 19)) degreeForm = 2;
        else if (units > 1 && units < 5) degreeForm = 1;
        else if (units == 1) degreeForm = 0;
        return degreeForm;
    }
}
