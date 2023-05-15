package app.Interfaces;

public interface SeparationInterface {

    int[] getArrayThreeDigitSegment();
    int getTheLastThreeDigits(long number);
    int[] divideANumberIntoAThreeDigitSegment(long number);
    byte firstNumberOfThreeDigitSegment(int threeDigitSegment);
    byte secondNumberOfThreeDigitSegment(int threeDigitSegment);
    byte thirdNumberOfThreeDigitSegment(int threeDigitSegment);
    byte secondAndThirdNumberOfThreeDigitSegment(int threeDigitSegment);
    String getTwoDecimalPlacesAfterTheDecimalPoint(String number);
    String extractingAnInteger(String number);
}
