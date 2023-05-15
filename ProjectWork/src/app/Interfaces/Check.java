package app.Interfaces;

public interface Check {
    boolean dotOrComma(String text);

    boolean minus(String text);

    boolean isANumberInTheRangeCurrencyIndex(byte number);

    boolean demoIsANumberInTheRangeCurrencyIndex(byte number);

    boolean thisZero(String str);

    boolean thisNumber(String text);

    boolean goOut(String text);

    boolean lessThanAThousand(long number);
}
