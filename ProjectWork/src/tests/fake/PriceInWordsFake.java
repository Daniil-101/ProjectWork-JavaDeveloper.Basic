package tests.fake;

import app.Interfaces.IOService;
import app.PriceInWords;
import app.currency.Currency;
import app.currency.Ruble;
import app.return_something.*;
import tests.fake.RequestFake;
import tests.fake.UserErrorFake;
import app.input_output.IOStreamsService;
import tests.spies.IOStreamServiceSpies;

public class PriceInWordsFake extends PriceInWords {
    public String resultOfChecking = "";

    private IOService ioStreamServiceStub;
    private IOStreamsService ioStreamService;
    private IOStreamServiceSpies ioStreamServiceSpies;
    private NumberInWords numberInWords;
    private Currency ruble;
    private RequestFake requestFake;
    private Separation separation;
    private Transformation transformation;
    private CheckUp checkUp;
    private UserErrorFake userErrorFake;

    public PriceInWordsFake(IOService ioStreamServiceStub) {
        super();
        this.ioStreamService = new IOStreamsService(System.out, System.in);
        this.ioStreamServiceSpies = new IOStreamServiceSpies();
        this.ioStreamServiceStub = ioStreamServiceStub;
        this.requestFake = new RequestFake(ioStreamServiceSpies);
        this.separation = new Separation();
        this.transformation = new Transformation();
        this.checkUp = new CheckUp(requestFake);
        FormQualifier formQualifier = new FormQualifier(separation);
        this.ruble = new Ruble(separation, formQualifier);
        this.userErrorFake = new UserErrorFake(ioStreamServiceSpies);
        this.numberInWords = new NumberInWords(ioStreamService, separation, checkUp, formQualifier);
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

            requestFake.printEnterANumberOrExit();
            resultOfChecking += ioStreamServiceSpies.resultOfChecking;
            String inputUser = ioStreamServiceStub.inputString().replaceAll(" ", "");

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
                ioStreamServiceSpies.outputStringWithWrap("ноль");
                resultOfChecking += ioStreamServiceSpies.resultOfChecking;
            }else if (checkUp.thisNumber(wholePart) && checkUp.thisNumber(twoDecimalPlaces) && wholePart.length() < 19) {
                theIntegerPartOfNumber = transformation.stringToNumberLong(wholePart);
                fractionalPartOfANumber = transformation.stringToNumberByte(twoDecimalPlaces);

                while (true) {
                    requestFake.printSelectCurrency();
                    resultOfChecking = ioStreamServiceSpies.resultOfChecking;
                    String index = ioStreamServiceStub.inputString().replaceAll(" ", "");

                    if (index.equals("")) {
                        userErrorFake.printIncorrectInput();
                        resultOfChecking += ioStreamServiceSpies.resultOfChecking;
                    }

                    else if (checkUp.thisNumber(index) && index.length() < 2) {
                        currencyIndex = transformation.stringToNumberByte(index);

                        if (checkUp.demoIsANumberInTheRangeCurrencyIndex(currencyIndex)) {

                            if(theIntegerPartOfNumber == 0)  number = "ноль";
                            else number = numberInWords.run(theIntegerPartOfNumber);

                            ioStreamServiceSpies.outputString("%s %s %s %s %s", minus, number,
                                    ruble.showCurrency(currencyIndex, theIntegerPartOfNumber),
                                    fractionalPartOfANumber, ruble.showCurrency((byte) 0, fractionalPartOfANumber));
                            resultOfChecking += ioStreamServiceSpies.resultOfChecking;
                            break;
                        } else {
                            userErrorFake.printThisFeatureIsStillUnderDevelopment();
                            resultOfChecking += ioStreamServiceSpies.resultOfChecking;
                        }
                    } else {
                        userErrorFake.printIncorrectInput();
                        resultOfChecking += ioStreamServiceSpies.resultOfChecking;
                    }
                }
            }else {
                userErrorFake.printIncorrectInput();
                resultOfChecking += ioStreamServiceSpies.resultOfChecking;
            }
        }
    }
}
