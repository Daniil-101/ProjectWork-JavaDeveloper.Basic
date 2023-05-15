package app.return_something;

import app.Interfaces.SeparationInterface;

public class Separation implements SeparationInterface {

    private int[] arrayThreeDigitSegment;

    public Separation() {
        this.arrayThreeDigitSegment = new int[6];
    }

    public int[] getArrayThreeDigitSegment() {
        return arrayThreeDigitSegment;
    }

    public int getTheLastThreeDigits(long number) {
        return (int) (number %= 1000);
    }

    public int[] divideANumberIntoAThreeDigitSegment(long number) {
        for (int i = arrayThreeDigitSegment.length - 1; i >= 0; i--) {
            long x = number % 1000;
            number /= 1000;
            arrayThreeDigitSegment[i] = (int) x;
        }
        return arrayThreeDigitSegment;
    }

    public byte firstNumberOfThreeDigitSegment(int threeDigitSegment) {
        return (byte) (threeDigitSegment / 100);
    }

    public byte secondNumberOfThreeDigitSegment(int threeDigitSegment) {
        return (byte) (threeDigitSegment % 100 / 10);
    }

    public byte thirdNumberOfThreeDigitSegment(int threeDigitSegment) {
        return (byte) (threeDigitSegment % 10);
    }

    public byte secondAndThirdNumberOfThreeDigitSegment(int threeDigitSegment) {
        return (byte) (threeDigitSegment % 100);
    }

    public String getTwoDecimalPlacesAfterTheDecimalPoint(String number) {
        String[] str = number.split(",");
        String truncated = String.format("%." + 2 + "s", str[1]);
        if (truncated.length() < 2) {
            truncated += "0";
        }
        return truncated;
    }

    public String extractingAnInteger(String number) {
        String[] str = number.split(",");
        if (str[0].equals("")) {
            str[0] = "0";
        }
        return str[0];
    }
}
