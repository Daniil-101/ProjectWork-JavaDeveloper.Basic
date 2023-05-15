package app;

import app.currency.Currency;
import app.input_output.IOStreamsService;
import app.print.Request;
import app.print.UserError;
import app.return_something.CheckUp;
import app.return_something.NumberInWords;
import app.return_something.Separation;
import app.return_something.Transformation;

public class PriceInWords {
    private IOStreamsService ioStreamsService;
    private NumberInWords numberInWords;
    private Currency ruble;
    private Request request;
    private Separation separation;
    private Transformation transformation;
    private CheckUp checkUp;
    private UserError userError;

    public PriceInWords(){}

    public PriceInWords(IOStreamsService ioStreamsService, NumberInWords numberInWords,
                        Currency ruble, Request request, Separation separation, Transformation transformation, CheckUp checkUp, UserError userError) {
        this.ioStreamsService = ioStreamsService;
        this.numberInWords = numberInWords;
        this.ruble = ruble;
        this.request = request;
        this.separation = separation;
        this.transformation = transformation;
        this.checkUp = checkUp;
        this.userError = userError;
    }


    public void run() {
        long theIntegerPartOfNumber = 0;
        byte fractionalPartOfANumber = 0;
        byte currencyIndex = 0;
        String minus = "";
        String wholePart = "";
        String number = "";

        while (true) {
            String twoDecimalPlaces = "0";

            request.printEnterANumberOrExit();
            String inputUser = ioStreamsService.inputString().replaceAll(" ", "");

            if (checkUp.goOut(inputUser)) break;

            if (checkUp.minus(inputUser)) {
                minus = "минус";
                inputUser = transformation.removeTheFirstMinus(inputUser);
            }

            if (checkUp.dotOrComma(inputUser)) {
                inputUser = transformation.replaceDotWithComma(inputUser);
                wholePart = separation.extractingAnInteger(inputUser);
                twoDecimalPlaces = separation.getTwoDecimalPlacesAfterTheDecimalPoint(inputUser);
            }
            else wholePart = inputUser;

            if (checkUp.thisZero(wholePart) && checkUp.thisZero(twoDecimalPlaces) && !wholePart.equals("")) {
                ioStreamsService.outputStringWithWrap("ноль");
            } else if (checkUp.thisNumber(wholePart) && checkUp.thisNumber(twoDecimalPlaces) && wholePart.length() < 19) {
                theIntegerPartOfNumber = transformation.stringToNumberLong(wholePart);
                fractionalPartOfANumber = transformation.stringToNumberByte(twoDecimalPlaces);

                SelectCurrency(theIntegerPartOfNumber, fractionalPartOfANumber, minus);
            }else {
                userError.printIncorrectInput();
            }
        }
    }

    private void SelectCurrency(long theIntegerPartOfNumber, byte fractionalPartOfANumber, String minus) {
        byte currencyIndex;
        String number;
        while (true) {
            request.printSelectCurrency();
            String index = ioStreamsService.inputString().replaceAll(" ", "");

            if (index.equals("")) userError.printIncorrectInput();

            else if (checkUp.thisNumber(index) && index.length() < 2) {
                currencyIndex = transformation.stringToNumberByte(index);

                if (checkUp.demoIsANumberInTheRangeCurrencyIndex(currencyIndex)) {

                    if(theIntegerPartOfNumber == 0)  number = "ноль";
                    else number = numberInWords.run(theIntegerPartOfNumber);

                    ioStreamsService.outputString("%s %s %s %s %s", minus, number,
                            ruble.showCurrency(currencyIndex, theIntegerPartOfNumber),
                            fractionalPartOfANumber, ruble.showCurrency((byte) 0, fractionalPartOfANumber));
                    break;
                } else {
                    userError.printThisFeatureIsStillUnderDevelopment();
                }
            } else {
                userError.printIncorrectInput();
            }
        }
    }
}



