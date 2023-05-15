package app.return_something;

import app.Interfaces.Check;
import app.print.Request;

public class CheckUp implements Check {
    private Request request;

    public CheckUp(Request request) {
        this.request = request;
    }

    public boolean dotOrComma(String text) {
        boolean resultOfChecking = false;
        for (byte i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.') {
                resultOfChecking = true;
                break;
            }
            if (ch == ',') {
                resultOfChecking = true;
                break;
            }
        }
        return resultOfChecking;
    }

    public boolean minus(String text) {
        boolean resultOfChecking = false;
        char ch = text.charAt(0);
        if (ch == '-') {
            resultOfChecking = true;
        }
        return resultOfChecking;
    }

    public boolean isANumberInTheRangeCurrencyIndex(byte number) {
        boolean resultOfChecking = true;
        if (number < 1 || number > request.getArrayLengthSelectCurrency() - 1) {
            resultOfChecking = false;
        }
        return resultOfChecking;
    }

    public boolean demoIsANumberInTheRangeCurrencyIndex(byte number) {
        boolean resultOfChecking = true;
        if (number != 1) {
            resultOfChecking = false;
        }
        return resultOfChecking;
    }

    public boolean thisZero(String str) {
        boolean resultOfChecking = true;
        for (byte i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '0') {
                resultOfChecking = false;
                break;
            }
        }
        return resultOfChecking;
    }

    public boolean thisNumber(String text) {
        boolean resultOfChecking = true;
        for (byte i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isDigit(ch)) {
                resultOfChecking = false;
                break;
            }
        }
        return resultOfChecking;
    }

    public boolean goOut(String text) {
        boolean resultOfChecking = false;
        if (text.equals("exit")) {
            resultOfChecking = true;
        }
        return resultOfChecking;
    }

    public boolean lessThanAThousand(long number) {
        boolean resultOfChecking = false;
        if (number < 1000) {
            resultOfChecking = true;
        }
        return resultOfChecking;
    }
}
